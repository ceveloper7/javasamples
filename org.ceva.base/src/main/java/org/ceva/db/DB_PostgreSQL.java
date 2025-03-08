package org.ceva.db;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

public class DB_PostgreSQL implements GeneralDataBase{

    // Driver
    private org.postgresql.Driver s_driver = null;
    public static final String DRIVER = "org.postgresql.Driver";
    public static final int DEFAULT_PORT = 5432;

    // DataSource
    private volatile HikariDataSource m_ds;

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
    public String getConnectionURL(DatabaseInstance connection) {
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
}
