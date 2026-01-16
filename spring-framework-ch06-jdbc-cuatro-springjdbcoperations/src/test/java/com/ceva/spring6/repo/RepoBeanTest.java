package com.ceva.spring6.repo;

import com.ceva.spring6.config.BasicDataSourceCfg;
import com.ceva.spring6.record.Singer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RepoBeanTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepoBeanTest.class);

    @Test
    public void testFindAllWithMappingSqlQuery(){
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);
        assertNotNull(singerRepo);

        List<Singer> singers = singerRepo.findAll();
        assertEquals(3, singers.size());
        singers.forEach(singer -> LOGGER.info(singer.toString()));
        ctx.close();
    }
}
