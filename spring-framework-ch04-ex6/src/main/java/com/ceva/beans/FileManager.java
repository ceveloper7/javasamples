package com.ceva.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager implements DisposableBean {
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

    @Override
    public void destroy() throws Exception {
        logger.info("Calling destroy() method on bean of type {}", FileManager.class);
        if(file != null){
            Files.deleteIfExists(file);
        }
    }
}
