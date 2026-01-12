package com.ceva.spring6.app;

import com.ceva.spring6.config.RowMapperCfg;
import com.ceva.spring6.dao.SingerDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NamedParameterJdbcTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(NamedParameterJdbcTest.class);

    @Test
    public void testSpringJdbc(){
        var ctx = new AnnotationConfigApplicationContext(RowMapperCfg.class);
        var singerDao = ctx.getBean("singerDao", SingerDao.class);

        var singers = singerDao.findAll();
        Assert.assertEquals(3, singers.size());

        singers.forEach(singer -> LOGGER.info(singer.toString()));
        ctx.close();
    }
}
