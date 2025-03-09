package org.ceva.db;

import org.ceva.util.Ini;

import javax.sql.DataSource;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.System.Logger.Level;

public class CConnection implements Serializable, Cloneable {

    private static System.Logger logger = System.getLogger("org.ceva.db");


    private LocalDate propertiesLoaded;
    private static final String APP_PROPERTIES_FILE = "app.properties";
    private String[] m_info = new String[2];
    private String m_dbInfo = null;

    private Map<String, String> connectionMap;
    private String	dbName;
    private String	dbType;
    private String	dbPort;
    private String	dbHost;
    private String  dbUser;
    private String  dbPass;

    private Properties props;
    // Database connection
    private boolean m_okDB = false;

    private DataSource m_ds = null;
    // Database
    private GeneralDataBase m_db = null;
    private volatile static CConnection s_cs = null;

    public CConnection(){
        try{
            loadProperties();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public boolean isPostgreSQL(){
        return Database.DB_POSTGRESQL.equals(getDbType());
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName){
        this.dbName = dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser){
        this.dbUser = dbUser;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType){
        for(int i = 0; i < Database.DB_NAMES.length; i++){
            if(dbType.contains(Database.DB_NAMES[i])){
                this.dbType = dbType;
                m_okDB = false;
            }
        }
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass){
        this.dbPass = dbPass;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost){
        this.dbHost = dbHost;
    }

    public String getDbPort(){
        return dbPort;
    }

    public void setDbPort(String dbPort){
        this.dbPort = dbPort;
    }

    private boolean loadProperties() throws IOException {
        boolean loadOk = false;
        props = new Properties();
        URL propertyFile = CConnection.class.getResource(File.separator + APP_PROPERTIES_FILE);
        try {
            assert propertyFile != null;
            File propertyPath = Paths.get(propertyFile.toURI()).toFile();
            try(Reader in = Files.newBufferedReader(propertyPath.toPath())){
                props.load(in);
                setPropertiesLoaded(LocalDate.now());
                loadOk = true;
            }
        }
        catch (URISyntaxException e){
            e.printStackTrace();
        }
        return loadOk;
    }

    public LocalDate getPropertiesLoaded(){
        return  propertiesLoaded;
    }

    public void setPropertiesLoaded(LocalDate propertiesLoaded){
        this.propertiesLoaded = propertiesLoaded;
    }

    private Map<String, String> getConnectionMap(){
        String connStr = props.getProperty("Connection");
        if (connStr == null || connStr.isEmpty())
            return null;
        Pattern body = Pattern.compile("ATMConnection\\[(.*?)\\]");
        Matcher m = body.matcher(connStr);
        String[] params;
        String[] kv;
        if(m.matches()){
            params = m.group(1).split(",");
            connectionMap = new TreeMap<String, String>();
            for(int i = 0; i < params.length; i++){
                kv = params[i].split("=");
                if(kv.length == 2){
                    connectionMap.put(kv[0], kv[1]);
                }
            }
            return connectionMap;
        }
        return null;
    }


    public String getConnectionUrl() {
        String url = null;
        Map<String, String> connectionMap = getConnectionMap();
        if(connectionMap == null || connectionMap.isEmpty())
            return null;
        setDbHost(connectionMap.get("DBhost"));
        setDbPort(connectionMap.get("DBport"));
        setDbName(connectionMap.get("DBname"));
        setDbType(connectionMap.get("type"));
        setDbUser(connectionMap.get("UID"));
        setDbPass(connectionMap.get("PWD"));

        return url = "jdbc:postgresql://" + getDbHost() + ":" + getDbPort() + "/" +  getDbName();
    }

    private void setConnectionAttributes(){
        String url = null;
        Map<String, String> connectionMap = getConnectionMap();
        if(connectionMap != null){
            setDbHost(connectionMap.get("DBhost"));
            setDbPort(connectionMap.get("DBport"));
            setDbName(connectionMap.get("DBname"));
            setDbType(connectionMap.get("type"));
            setDbUser(connectionMap.get("UID"));
            setDbPass(connectionMap.get("PWD"));
        }

    }

    public synchronized static CConnection get(){
        if(s_cs == null){
            s_cs = new CConnection();
            s_cs.setConnectionAttributes();
        }
        return s_cs;
    }

    public static CConnection get(String dbType, String dbHost, String dbPort, String dbName){
        return get(dbType, dbHost, dbPort, dbName, null, null);
    }

    public static CConnection get(String dbType, String dbHost, String dbPort, String dbName, String dbUser, String dbPass){
        CConnection cc = new CConnection();
        cc.setDbType(dbType);
        cc.setDbHost(dbHost);
        cc.setDbPort(dbPort);
        cc.setDbName(dbName);

        if(dbUser != null)
            cc.setDbUser(dbUser);

        if(dbPass != null)
            cc.setDbPass(dbPass);

        return cc;
    }


    public Connection getConnection() {
        Connection conn = null;
        String url = getConnectionUrl();

        try{
            if(url == null)
                throw new Exception("Unknow database type");

            Class.forName("org.postgresql.Driver");

            Properties connPros = new Properties();
            connPros.setProperty("user", connectionMap.get("UID"));
            connPros.setProperty("password", connectionMap.get("PWD"));

            conn = DriverManager.getConnection(url, connPros);
        }
        catch (Exception ex){}
        return conn;
    }


    public boolean isPropertiesOk() {
        return getPropertiesLoaded() != null;
    }

    public static void verifyDBOk(){
        Ini.setClient(true);
        CConnection s_cc = CConnection.get();
        s_cc.setDataSource();
        try(Connection conn = s_cc.getConnection(false, 1);
            Statement stmt = conn.createStatement();){
            String query = "SELECT version, releaseno FROM system";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                System.out.println(" Verison No: " + rs.getString(1) + " Realease No: " + rs.getString(2));
            }
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public GeneralDataBase getDatabase(){
        // diferente driver
        if(m_db != null && !m_db.getName().equals(getDbType())){
            m_db = null;
        }

        if (m_db == null){
            try{
                m_db = Database.getDatabase(getDbType());
                if(m_db != null){
                    m_db.getDataSource(this);
                }
            }
            catch (NoClassDefFoundError ee){
                System.err.println("Environment Error - Check app.properties - " + ee);
                System.exit(1);
            }
            catch (Exception ee){
                logger.log(Level.ERROR,ee.toString());
            }
        }
        return m_db;
    }

    public boolean setDataSource(){
        if(m_ds == null && Ini.isClient()){
            GeneralDataBase getDB = getDatabase();
            if(getDB != null){
                m_ds = getDB.getDataSource(this);
            }
        }
        return m_ds != null;
    }

    public boolean setDataSource(DataSource ds){
        if(ds == null && m_db != null){
            getDatabase().close();
        }
        m_ds = ds;
        return m_ds != null;
    }

    public DataSource getDataSource(){
        return m_ds;
    }

    public boolean isDataSource(){
        return m_ds != null;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof CConnection){
            CConnection cc = (CConnection) o;
            if(cc.getDbHost().equals(dbHost) &&
                    cc.getDbPort().equals(dbPort) &&
                    cc.getDbName().equals(dbName) &&
                    cc.getDbType().equals(dbType) &&
                    cc.getDbUser().equals(dbUser) &&
                    cc.getDbPass().equals(dbPass)
            ){
                return true;
            }
        }
        return false;
    }

    public boolean isDatabaseOk(){
        return m_okDB;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder(m_info[0] != null ? m_info[1] : "");
        sb.append(" - ").append(m_info[1] != null ? m_info[1] : "").append("\n").append(getDatabase().toString());

        sb.append("\nDatabaseOk=").append(isDatabaseOk());
        return sb.toString();
    }

    public String getConnectionURL(){
        getDatabase();
        if(m_db != null){
            return m_db.getConnectionURL(this);
        }
        else{
            return "";
        }
    }

    public Connection getConnection(boolean autoCommit, int transactionIsolation){
        Connection conn = null;
        m_okDB = false;

        getDatabase();
        if(m_db == null){
            return null;
        }

        try {
            Exception ee = null;
            try {
                conn = m_db.getFromConnectionPoolShortRunning(this, autoCommit, transactionIsolation);
            }
            catch (Exception exception){
                logger.log(Level.ERROR, exception.getMessage());
                ee = exception;
            }
            if(conn != null) {
                if (conn.getTransactionIsolation() != transactionIsolation)
                    conn.setTransactionIsolation(transactionIsolation);

                if (conn.getAutoCommit() != autoCommit)
                    conn.setAutoCommit(autoCommit);
                m_okDB = true;
            }
        }
        catch (Exception ex){
            System.err.println(getConnectionUrl() + " - " + ex.getLocalizedMessage());
        }
        return conn;
    }

    public String getStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(dbHost)
                .append("-").append(dbName)
                .append("-").append(dbUser)
                .append("}");
        if(m_db != null){
            sb.append(m_db.getStatus());
        }
        return sb.toString();
    }

    public static String getTransactionIsolationInfo(int transactionIsolation)
    {
        if (transactionIsolation == Connection.TRANSACTION_NONE)
            return "NONE";
        if (transactionIsolation == Connection.TRANSACTION_READ_COMMITTED)
            return "READ_COMMITTED";
        if (transactionIsolation == Connection.TRANSACTION_READ_UNCOMMITTED)
            return "READ_UNCOMMITTED";
        if (transactionIsolation == Connection.TRANSACTION_REPEATABLE_READ)
            return "REPEATABLE_READ";
        if (transactionIsolation == Connection.TRANSACTION_READ_COMMITTED)
            return "SERIALIZABLE";
        return "<?" + transactionIsolation + "?>";
    }	//	getTransactionIsolationInfo

    // Get DB version info
    public String getDBInfo(){
        if(m_dbInfo != null)
            return m_dbInfo;

        StringBuilder sb = new StringBuilder();
        {
            try(Connection conn = getConnection(true, Connection.TRANSACTION_READ_COMMITTED);){
                if(conn != null){
                    DatabaseMetaData dbmt = conn.getMetaData();
                    sb.append(dbmt.getDatabaseProductVersion()).append(";").append(dbmt.getDriverVersion());
                    if(isDataSource())
                        sb.append("; DS:");
                    m_dbInfo = sb.toString();
                }
            }
            catch (Exception e){
                logger.log(Level.ERROR, ", ", e);
                sb.append(e.getLocalizedMessage());
            }
        }
        return sb.toString();
    }// getDBInfo

}
