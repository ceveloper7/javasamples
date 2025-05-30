package org.ceva.base;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseInstance implements Serializable, Cloneable {

    private LocalDate propertiesLoaded;
    private static final String APP_PROPERTIES_FILE = "atm.properties";

    private Map<String, String> connectionMap;
    private String	dbName;
    private String	dbType;
    private String	dbPort;
    private String	dbHost;
    private String  dbUser;
    private String  dbPass;

    private Properties props;

    public DatabaseInstance(){
        try{
            loadProperties();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }


    public String getDbName() {
        return dbName;
    }


    public String getDbUser() {
        return dbUser;
    }


    public String getDbType() {
        return dbType;
    }


    public String getDbPass() {
        return dbPass;
    }


    public String getDbHost() {
        return dbHost;
    }


    public String getDbPort(){
        return dbPort;
    }

    private boolean loadProperties() throws IOException {
        boolean loadOk = false;
        props = new Properties();
        try(Reader in = Files.newBufferedReader(Path.of(APP_PROPERTIES_FILE))){
            props.load(in);
            setPropertiesLoaded(LocalDate.now());
            loadOk = true;
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
            for (String param : params) {
                kv = param.split("=");
                if (kv.length == 2) {
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
        dbHost = connectionMap.get("DBhost");
        dbPort = connectionMap.get("DBport");
        dbName = connectionMap.get("DBname");
        dbType = connectionMap.get("type");
        dbUser = connectionMap.get("UID");
        dbPass = connectionMap.get("PWD");

        return url = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" +  dbName;
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
        catch (Exception ex){
            System.err.println("Could not connect to Database" + ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        return conn;
    }


    public boolean isPropertiesOk() {
        return getPropertiesLoaded() != null;
    }

    public boolean checkDBOk(){
        if(getConnectionMap() != null && !getConnectionMap().isEmpty()){
            try(Connection conn = getConnection();
                Statement stmt = conn.createStatement())
            {
                String query = "SELECT version, releaseno FROM system";
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()){
                    System.out.println(" Verison No: " + rs.getString(1) + " Realease No: " + rs.getString(2));
                }
                rs.close();
                return true;
            }
            catch (Exception e){
                System.err.println("Problem with system table " + e.toString());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DatabaseInstance d = new DatabaseInstance();
        d.checkDBOk();
    }

}
