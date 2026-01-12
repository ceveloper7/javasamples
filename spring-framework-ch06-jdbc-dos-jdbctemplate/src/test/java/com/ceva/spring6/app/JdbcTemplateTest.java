package com.ceva.spring6.app;

import com.ceva.spring6.config.TestDbConfig;
import com.ceva.spring6.dao.SingerDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    @Test
    public void testSpringWithJdbc(){
        var ctx = new AnnotationConfigApplicationContext(TestDbConfig.class);
        var jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
        Assert.assertNotNull(jdbcTemplate);

        var singerDao = ctx.getBean("singerDao", SingerDao.class);
        Assert.assertEquals("Ben Barnes", singerDao.findNameById(2L));
        ctx.close();
    }
}
