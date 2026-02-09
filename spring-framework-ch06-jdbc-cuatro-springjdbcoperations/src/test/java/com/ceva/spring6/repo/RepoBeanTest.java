package com.ceva.spring6.repo;

import com.ceva.spring6.config.BasicDataSourceCfg;
import com.ceva.spring6.record.Singer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    @Test
    public void testFindByNameWithMappingSqlQuery(){
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);
        assertNotNull(singerRepo);

        var singers = singerRepo.findByFirstName("Ben");
        assertEquals(1, singers.size());
        LOGGER.info("Result: {}", singers.getFirst());
        ctx.close();
    }

    @Test
    public void testUpdateWithSqlUpdate(){
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);
        assertNotNull(singerRepo);

        Singer singer = new Singer(1L, "John C.", "Mayer", LocalDate.of(1977,10,6),
                Set.of());
        singerRepo.update(singer);

        var singers = singerRepo.findByFirstName("John C.");
        assertEquals(1, singers.size());
        LOGGER.info("Result: {}", singers.get(0));
        ctx.close();
    }

    @Test
    public void testInsertWithSqlUpdate(){
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);
        assertNotNull(singerRepo);

        var singer = new Singer(null,"Ed","Sheeran", LocalDate.of(1991,2, 17),
                Set.of());
        singerRepo.insert(singer);

        var singers = singerRepo.findByFirstName("Ed");
        assertEquals(1, singers.size());
        LOGGER.info("Result: {}", singers.get(0));

        ctx.close();
    }
}
