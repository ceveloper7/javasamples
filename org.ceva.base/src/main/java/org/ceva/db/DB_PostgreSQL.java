package org.ceva.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.System.Logger.Level;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.ceva.util.Ini;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class DB_PostgreSQL implements GeneralDataBase{

    //private static System.Logger logger = System.getLogger("org.ceva.db");
    private static final Logger logger = LoggerFactory.getLogger(DB_PostgreSQL.class);

    // Driver
    private org.postgresql.Driver s_driver = null;
    public static final String DRIVER = "org.postgresql.Driver";
    public static final int DEFAULT_PORT = 5432;

    // DataSource
    private volatile HikariDataSource m_ds;

    /** Data Source	Long Running 	*/
    private DataSource datasourceLongRunning = null;
    /** Data Source	Short Running 	*/
    private DataSource datasourceShortRunning = null;

    private String m_userName = null;
    private String m_connectionUrl = null;
    // Cached Databasename
    private String m_dbName = null;

    @Override
    public String getName() {
        return Database.DB_POSTGRESQL;
    }

    @Override
    public String getDescription() {
        try{
            if(s_driver == null)
                getDriver();
        }
        catch (Exception ex){}

        if(s_driver != null){
            return s_driver.toString();
        }
        return "There is no Driver";
    }

    @Override
    public java.sql.Driver getDriver() throws SQLException {
        if(s_driver == null){
            s_driver = new org.postgresql.Driver();
            DriverManager.registerDriver(s_driver);
            DriverManager.setLoginTimeout(Database.CONNECTION_TIMEOUT);
        }
        return s_driver;
    }

    @Override
    public int getStandardPort() {
        return DEFAULT_PORT;
    }

    @Override
    public String getConnectionURL(ADConnection connection) {
        StringBuilder sb = new StringBuilder("jdbc:postgresql://")
                .append(connection.getDbHost())
                .append(":").append(connection.getDbPort())
                .append("/").append(connection.getDbName())
                .append("?encoding=UNICODE");
        return sb.toString();
    }

    @Override
    public String getConnectionURL(String dbHost, int dbPort, String dbName, String userName) {
        StringBuilder sb = new StringBuilder("jdbc:postgresql://")
                .append(dbHost)
                .append(":").append(dbPort)
                .append("/").append(dbName);
        return sb.toString();
    }

    @Override
    public String getConnectionURL(String connectionURL, String userName) {
        m_userName = userName;
        m_connectionUrl = connectionURL;
        return m_connectionUrl;
    }

    @Override
    public String getCatalog(){
        if(m_dbName != null || !m_dbName.isEmpty()){
            return m_dbName;
        }
        return null;
    }

    @Override
    public String getSchema(){
        return "MyApp";
    }

    @Override
    public boolean isSupportedBLOB(){
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("DB_PostgreSQL[");
        sb.append(m_connectionUrl);
        try
        {
            StringBuilder logBuffer = new StringBuilder();
            HikariPoolMXBean mxBean = m_ds.getHikariPoolMXBean();

            logBuffer.append("# Connections: ").append(mxBean.getTotalConnections());
            logBuffer.append(" , # Busy Connections: ").append(mxBean.getActiveConnections());
            logBuffer.append(" , # Idle Connections: ").append(mxBean.getIdleConnections());
            logBuffer.append(" , # Threads waiting on connection: ").append(mxBean.getThreadsAwaitingConnection());
        }
        catch (Exception e)
        {
            sb.append("=").append(e.getLocalizedMessage());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public DataSource getDataSource(ADConnection connection){
        if(datasourceLongRunning != null)
            return datasourceLongRunning;

        if(Ini.isClient()){
            logger.warn("Config Hikari Connection Pool Datasource");
            HikariConfig config = new HikariConfig();
            config.setDriverClassName(DRIVER);
            config.setJdbcUrl(getConnectionURL(connection));
            config.setUsername(connection.getDbUser());
            config.setPassword(connection.getDbPass());
            config.setIdleTimeout(0);
            config.setMinimumIdle(15);
            config.setMaximumPoolSize(150);
            config.setPoolName("MyAppDS");
            config.addDataSourceProperty("cachePrepStmts" , "true");
            config.addDataSourceProperty("prepStmtCacheSize" , "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
            datasourceLongRunning = new HikariDataSource(config);
        }
        return datasourceLongRunning;
    }

    public DataSource getDatasourceShortRunning(ADConnection connection){
        if(datasourceShortRunning != null)
            return datasourceShortRunning;

        if(Ini.isClient()){
            logger.warn("Config Hakari Connection Pool Short Running Datasource");
            HikariConfig config = new HikariConfig();
            config.setDriverClassName(DRIVER);
            config.setJdbcUrl(getConnectionURL(connection));
            config.setUsername(connection.getDbUser());
            config.setPassword(connection.getDbPass());
            config.addDataSourceProperty( "poolName" , "AdempiereSRDS" );
            config.addDataSourceProperty( "cachePrepStmts" , "true" );
            config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
            config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
            config.addDataSourceProperty( "idleTimeout" , "1200" );
            config.addDataSourceProperty("maximumPoolSize", "10");
            HikariDataSource cpds = new HikariDataSource(config);
            datasourceShortRunning = cpds;
            logger.warn("Starting Client Hikari Connection Pool");
        }
        return datasourceShortRunning;
    }

    @Override
    public Connection getFromConnectionPool(ADConnection connection,
                                            boolean autoCommit, int transactionIsolation) throws Exception{
        if(datasourceLongRunning == null){
            getDataSource(connection);
        }

        Connection localConnection = datasourceLongRunning.getConnection();
        if(localConnection != null){
            localConnection.setAutoCommit(autoCommit);
            localConnection.setTransactionIsolation(transactionIsolation);
        }
        return localConnection;
    }

    @Override
    public Connection getFromConnectionPoolShortRunning(ADConnection connection,
                                                        boolean autoCommit, int transactionIsolation) throws Exception{
        if(datasourceShortRunning == null){
            getDatasourceShortRunning(connection);
        }

        Connection localConnection = datasourceShortRunning.getConnection();
        if(localConnection != null){
            localConnection.setAutoCommit(autoCommit);
            localConnection.setTransactionIsolation(transactionIsolation);
        }
        return localConnection;
    }

    @Override
    public Connection getDriverConnection (ADConnection connection) throws SQLException{
        getDriver();
        return DriverManager.getConnection(getConnectionURL(connection), connection.getDbUser(), connection.getDbPass());
    }

    @Override
    public Connection getDriverConnection (String dbUrl, String dbUid, String dbPwd) throws SQLException{
        getDriver();
        return DriverManager.getConnection(dbUrl, dbUid, dbPwd);
    }

    @Override
    public String getStatus(){
        if(m_ds == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        try{
            HikariPoolMXBean mxBean = m_ds.getHikariPoolMXBean();

            sb.append("# Connections: ").append(mxBean.getTotalConnections());
            sb.append(" , # Busy Connections: ").append(mxBean.getActiveConnections());
            sb.append(" , # Idle Connections: ").append(mxBean.getIdleConnections());
            sb.append(" , # Threads waiting on connection: ").append(mxBean.getThreadsAwaitingConnection());
            sb.append(" , # Min Pool Size: ").append(m_ds.getMinimumIdle());
            sb.append(" , # Max Pool Size: ").append(m_ds.getMaximumPoolSize());
            //sb.append(" , # Open Transactions: ").append(Trx.getOpenTransactions().length);
        }
        catch (Exception e){
            System.err.println(sb.toString() + " - " + e.getMessage());
        }
        return sb.toString();
    }

    @Override
    public void close(){
        try{
            m_ds.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
