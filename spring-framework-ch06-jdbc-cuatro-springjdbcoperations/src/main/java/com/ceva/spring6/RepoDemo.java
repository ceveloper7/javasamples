package com.ceva.spring6;

import com.ceva.spring6.config.BasicDataSourceCfg;
import com.ceva.spring6.record.Singer;
import com.ceva.spring6.repo.SingerJdbcRepo;
import com.ceva.spring6.repo.SingerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RepoDemo {

    private static Logger LOGGER = LoggerFactory.getLogger(RepoDemo.class);

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class, SingerJdbcRepo.class);
        var singerRepo = ctx.getBean("singerRepo", SingerRepo.class);

        List<Singer> singers = singerRepo.findAll();
        singers.forEach(singer -> LOGGER.info(singer.toString()));
        ctx.close();
    }
}
