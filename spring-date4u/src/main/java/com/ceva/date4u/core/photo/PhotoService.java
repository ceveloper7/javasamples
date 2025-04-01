package com.ceva.date4u.core.photo;

import com.ceva.date4u.core.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.util.Optional;
import java.util.UUID;

/**
 * FileSystem <---- uses --- PhotoService --- uses ---> AwtBicubicThumbnail
 * PhotoService interactua con FileSystem service para leer una imagen y AwtBicubicThumbnail service para guardar un thumbnail de la imagen
 */
@Service
public class PhotoService {
    // 1st dependency
    private final FileSystem fs;

    //2nd dependency
    private final AwtBicubicThumbnail thumbnail;

    @Autowired
    public PhotoService(FileSystem fs, AwtBicubicThumbnail thumbnail){
        this.fs = fs;
        this.thumbnail = thumbnail;
    }

    /**
     * Read Images using FileSystem Service
     * @param name
     * @return
     */
    public Optional<byte[]> download(String name){
        try{
            return Optional.of(fs.load(name + ".jpg"));
        }
        catch (UncheckedIOException e){
            return Optional.empty();
        }
    }

    /**
     *
     * @param imagesBytes image to be saved
     * @return
     */
    public String upload(byte[] imagesBytes){
        String imageName = UUID.randomUUID().toString();
        // Primero: guardamos la imagen original
        fs.store(imageName + ".jpg", imagesBytes);
        // Segundo: guardamos la version thumbnail
        byte[] thumbnailBytes = thumbnail.createThumbnail(imagesBytes);
        fs.store(imageName + "-thumb.jpg", thumbnailBytes);
        return imageName;
    }
}
