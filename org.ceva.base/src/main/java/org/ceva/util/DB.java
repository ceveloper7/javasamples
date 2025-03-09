package org.ceva.util;

import static java.lang.System.Logger.Level.*;

import org.ceva.db.CConnection;
import org.ceva.db.Database;
import org.ceva.db.GeneralDataBase;

import java.sql.Connection;
import java.sql.SQLException;

public final class DB {
    private static final System.Logger logger = System.getLogger("org.ceva.util");

    public static CConnection s_cc = null;
    private static Object s_ccLock = new Object();

    // Set DB Connection
    public synchronized static void setDBTarget(CConnection cc){
        if(cc == null)
            throw new IllegalArgumentException("Connection is null");
        if(s_cc != null && s_cc.equals(cc))
            return;

        DB.closeDBTaget();

        synchronized (s_ccLock){
            s_cc = cc;
        }

        s_cc.setDataSource();

        if(logger.isLoggable(INFO)){
            logger.log(INFO, s_cc + " - DS= " + s_cc.isDataSource());
        }
    }

    // close DB Connection
    public static void closeDBTaget(){
        boolean closed = false;
        closed = s_cc == null ? true : s_cc.setDataSource(null);
        s_cc = null;

        if(closed)
            logger.log(INFO, "closed");
    }

    // get an Auto commit connection
    public static Connection getConnection(){
        return getConnection(true);
    }

    /**
     * Get auto or not auto commit connection from connection pool.<br/>
     * Usually you should use getConnection instead to get auto commit connection
     * and use Trx to works with not autoCommit connection.
     * @param autoCommit
     * @return {@link Connection}
     */
    public static Connection getConnection(boolean autoCommit){
        return createConnection(autoCommit, Connection.TRANSACTION_READ_COMMITTED);
    }

    /**
     *	Create new Connection.<br/>
     *  The connection must be closed explicitly by the application.
     *
     *  @param autoCommit auto commit
     *  @param trxLevel - Connection.TRANSACTION_READ_UNCOMMITTED, Connection.TRANSACTION_READ_COMMITTED, Connection.TRANSACTION_REPEATABLE_READ, or Connection.TRANSACTION_READ_COMMITTED.
     *  @return Connection connection
     */
    public static Connection createConnection(boolean autoCommit, int trxLevel) {
        Connection conn = s_cc.getConnection(autoCommit, trxLevel);
        if (conn == null)
            throw new IllegalStateException("DB.createConnection - @NoDBConnection@");

        try {
            if (conn != null && conn.getAutoCommit() != autoCommit)
                throw new IllegalStateException("Failed to set the requested auto commit mode on connection. [autoCommit=");
        } catch (SQLException ex) {
        }

        return conn;
    }

    // true, if connected to database
    public static boolean isConnected(){
        if(s_cc == null) return false;

        // get connection
        boolean success = false;
        try{
            Connection conn = getConnection();
            if(conn != null){
                conn.close();
                success = true;
            }
            else{
                success = false;
            }
        }
        catch (Exception e){
            success = false;
        }
        return success;
    }

    // get Database driver
    public GeneralDataBase getDatabase(){
        if(s_cc != null)
            return s_cc.getDatabase();
        logger.log(ERROR, "There is no Database connection");
        return null;
    }

    // Get Database adapter by URL String
    public GeneralDataBase getDatabaseFromURL(String url){
        return Database.getDatabaseFromURL(url);
    }

    // we have a PostgreSQL DB?
    public static boolean isPostgreSQL(){
        if(s_cc != null)
            return s_cc.isPostgreSQL();
        logger.log(ERROR, "There is no Database");
        return false;
    }

    // Get Database info
    public static String getDatabaseInfo(){
        if(s_cc != null)
            return s_cc.getDBInfo();
        return "There is no Database";
    }

    public static void main(String[] args) {
        Ini.setClient(true);
        DB.setDBTarget(CConnection.get());
        System.out.println(DB.isConnected());
    }
}
