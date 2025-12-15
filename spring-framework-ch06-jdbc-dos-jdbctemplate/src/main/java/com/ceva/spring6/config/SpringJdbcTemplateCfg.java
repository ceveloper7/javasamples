package com.ceva.spring6.config;

import com.ceva.spring6.dao.JdbcSingerDao;
import com.ceva.spring6.dao.SingerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Inicializando JdbcTemplate
 */
@Import(BasicDataSourceCfg.class)
@Configuration
public class SpringJdbcTemplateCfg {

    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public SingerDao singerDao(){
        JdbcSingerDao    dao = new JdbcSingerDao();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
