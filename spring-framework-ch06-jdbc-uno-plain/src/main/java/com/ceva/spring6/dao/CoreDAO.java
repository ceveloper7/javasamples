package com.ceva.spring6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CoreDAO {
    default Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mariadb://localhost:3306/prospring6?useSSL=false", "barcvilla", "b4000$.");
        //return DriverManager.getConnection("jdbc:mysql://localhost:3306/prospring6?useSSL=false", "barcvilla", "b4000$.");
    }

    default void closeConnection(Connection connection) throws SQLException{
        if (connection == null)
            return;
        connection.close();
    }
}
