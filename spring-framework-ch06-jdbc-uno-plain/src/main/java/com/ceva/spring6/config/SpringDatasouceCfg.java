package com.ceva.spring6.config;

import com.ceva.spring6.JdbcSingerDao;
import com.ceva.spring6.dao.pojo.SingerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Import(BasicDataSourceCfg.class)
@Configuration
public class SpringDatasouceCfg {

    @Autowired
    DataSource dataSource;

    @Bean
    public SingerDAO singerDao(){
        JdbcSingerDao dao = new JdbcSingerDao();
        dao.setDataSource(dataSource);

        return dao;
    }
}
