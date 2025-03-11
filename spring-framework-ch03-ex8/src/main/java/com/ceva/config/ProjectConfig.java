package com.ceva.config;

import com.ceva.model.Song;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.ceva.collectionInject"})
public class ProjectConfig {
    @Bean
    public List<Song> list(){
        return List.of(
                new Song("Not the end"),
                new Song("Rise Up")
        );
    }

    @Bean
    public Song song1(){
        return new Song("Here's to hoping");
    }

    @Bean
    public Song song2(){
        return new Song("Wishing the best for you");
    }
}
