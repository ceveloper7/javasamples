package com.ceva.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager{
    private static final Logger logger = LoggerFactory.getLogger(FileManager.class);
    private Path file;

    public FileManager(){
        logger.info("Creating bean of type {}", FileManager.class);

        try{
            file = Files.createFile(Path.of("sample"));
        }
        catch (IOException e){
            logger.error("Could not create file");
        }
    }

    @PreDestroy
    public void preDestroy() throws Exception {
        logger.info("Calling preDestroy() method on bean of type {}", FileManager.class);
        if(file != null){
            Files.deleteIfExists(file);
        }
    }
}
