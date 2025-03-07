package com.ceva.db;

import java.sql.Connection;

public interface IDatabaseInstance {
    String getDbName();
    String getDbUser();
    String getDbType();
    String getDbPass();
    String getDbHost();
    String getDbPort();
    Connection getConnection() throws Exception;
    String getConnectionUrl();
    boolean isPropertiesOk();
}
