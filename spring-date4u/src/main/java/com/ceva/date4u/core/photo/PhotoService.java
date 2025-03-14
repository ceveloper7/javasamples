package com.ceva.date4u.core.photo;

import com.ceva.date4u.core.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.util.Optional;

@Service
public class PhotoService {
    private final FileSystem fs;

    @Autowired
    public PhotoService(FileSystem fs){
        this.fs = fs;
    }

    public Optional<byte[]> download(String name){
        try{
            return Optional.of(fs.load(name + ".jpg"));
        }
        catch (UncheckedIOException e){
            return Optional.empty();
        }
    }
}
