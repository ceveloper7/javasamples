package com.ceva.spring6.repo;

import com.ceva.spring6.QueryConstants;
import com.ceva.spring6.record.Singer;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Set;

/**
 * Class similar to SelectAllSingers
 */
public class SelectSingerByFirstName extends MappingSqlQuery<Singer> {

    public SelectSingerByFirstName(DataSource dataSource){
        super(dataSource, QueryConstants.FIND_BY_FIRST_NAME);
        // set a namedParameter first_name
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
    }

    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Singer(rs.getLong("id"),rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("birth_date").toLocalDate(),
                Set.of());
    }
}
