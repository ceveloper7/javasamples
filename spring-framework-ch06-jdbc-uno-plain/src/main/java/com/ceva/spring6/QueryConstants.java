package com.ceva.spring6;

public enum QueryConstants {
    ;

    public static final String ALL_SELECT = "select * from singer";
    public static final String SIMPLE_INSERT = "insert into singer (first_name, last_name, birth_date) values (?, ?, ?)";
    public static final String SIMPLE_DELETE = "delete from singer where id=?";
}
