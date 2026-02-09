package com.ceva.spring6.repo;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;
import static com.ceva.spring6.QueryConstants.INSERT_SINGER;
/**
 * Insert Singer and retrieving Generate Key
 * Page 308
 */
public class InsertSinger extends SqlUpdate {

    // DataSource injection
    public InsertSinger(DataSource dataSource){
        super(dataSource, INSERT_SINGER);
        super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("birth_date", Types.DATE));
        // declaramos la columna id
        super.setGeneratedKeysColumnNames("id");
        // recuperamos el id generado
        super.setReturnGeneratedKeys(true);
    }
}
