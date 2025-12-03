package com.ceva.spring6;

import com.ceva.spring6.config.SimpleDataSourceCfg;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataSourceConfigTest {
    private static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfigTest.class);

    // Test la clase de configuracion SimpleDataSource
    private void testDataSource(DataSource dataSource) throws SQLException{
        // con el bean dataSource obtenido del contexto creamos una conexion.
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement("SELECT 1");
             var resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                int mockVal = resultSet.getInt("1");
                assertEquals(1, mockVal);
            }
        } catch (Exception e) {
            LOGGER.debug("Something unexpected happened.", e);
        }
    }

    /*
     * Probamos la clase SimpleDataSourceConfig.class
     */
    @Test
    public void testSimpleDataSource() throws SQLException {
        var ctx = new AnnotationConfigApplicationContext(SimpleDataSourceCfg.class);
        // obtenemos el bean dataSource del contexto
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();
    }
}
