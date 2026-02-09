package com.ceva.spring6.repo;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;

import java.sql.Types;

import static com.ceva.spring6.QueryConstants.UPDATE_SINGER;

/**
 * Personalizamos SqlUpdate con la clase UpdateSinger
 */
public class UpdateSinger extends SqlUpdate {

    public UpdateSinger(DataSource dataSource){
        super(dataSource, UPDATE_SINGER);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birth_date", Types.DATE));
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }
}
