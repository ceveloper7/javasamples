package org.ceva.base;

import java.sql.Connection;
import java.sql.SQLException;

public class DB {
    private static DatabaseInstance s_cc = null;

    public static Connection createConnection(boolean autoCommit, int transactionLevel) {
        Connection conn = s_cc.getConnection();

        if (conn == null){
            throw new IllegalStateException("DB.createConnection - @NoDBConnection@");
        }

        try{
            if(conn != null && conn.getAutoCommit() != autoCommit){
                throw new IllegalStateException("");
            }
        }
        catch (SQLException ex){}
        return conn;
    }
}
