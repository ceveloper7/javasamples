package com.ceva.date4u.core;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Clase con un constructor sin parametros, con @Component permitimos que spring sea quien cree una instancia de este clase cuando sea solicitado.
 */
@Service
public class FileSystem {
    // obtenemos Path de la carpeta fs en el home
    private final Path root = Paths.get(System.getProperty("user.home")).resolve("fs");

    public FileSystem(){
        // verificamos si existe el directorio fs en el home
        try{
            if(!Files.isDirectory(root)){
                // si no existe fs lo creamos
                Files.createDirectories(root);
            }
        }
        catch (IOException ex){
            throw new UncheckedIOException(ex);
        }
    }

    /*
     * return free bytes
     */
    public long getFreeDiskSpace() {
        return root.toFile().getFreeSpace();
    }

    /*
     * Cargamos un archivo
     * root esta compuesta por Path + fileName
     */
    public byte[] load( String filename ) {
        try { return Files.readAllBytes( root.resolve( filename ) ); }
        catch ( IOException e ) { throw new UncheckedIOException( e ); }
    }

    /*
     * Almacenamos un array de bytes
     */
    public void store( String filename, byte[] bytes ) {
        try { Files.write( root.resolve( filename ), bytes ); }
        catch ( IOException e ) { throw new UncheckedIOException( e ); }
    }
}
