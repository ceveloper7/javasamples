package com.ceva.date4u.interfaces.shell;

import com.ceva.date4u.core.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PhotoCommands -- uses --> PhotoService
 */
@ShellComponent
public class PhotoCommands {
    private final PhotoService photoService;

    @Autowired
    public PhotoCommands(PhotoService photoService){
        this.photoService = photoService;
    }

    @ShellMethod("Show photo")
    public String showPhoto(String name){
        return photoService.download(name)
                .map(bytes -> {
                    try{
                        var image = ImageIO.read(new ByteArrayInputStream(bytes));
                        return "width: " + image.getWidth() + ", Height: " + image.getHeight();
                    }
                    catch (IOException e){
                        return "Unable to read image dimensions";
                    }
                }).orElse("Image not found ");
    }

    /**
     * Uploading images
     * @param fileName
     * @return
     * @throws IOException
     */
    @ShellMethod("Upload photo") // upload-photo
    public String uploadPhoto(String fileName) throws IOException{
        byte[] bytes = Files.readAllBytes(Paths.get(fileName));
        return "Uploaded " + photoService.upload(bytes);
    }
}
