package com.ceva.spring6.repo;

import com.ceva.spring6.QueryConstants;
import com.ceva.spring6.record.Singer;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * MappingSqlQuery<T> allow us modeling query operations
 */
public class SelectAllSingers extends MappingSqlQuery<Singer> {

    public SelectAllSingers(DataSource dataSource){
        super(dataSource, QueryConstants.ALL_SELECT);
    }

    // Mapeamo el ResultSet
    @Override
    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Singer(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("birth_date").toLocalDate(),
                Set.of());
    }
}
