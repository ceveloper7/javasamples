package com.ceva.date4u.interfaces.shell;

import com.ceva.date4u.core.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;

/*
 * Componente que nos permite ejecutar comandos en el file system
 */
@ShellComponent
public class FsCommand {
    private final FileSystem fs;

    // constructor injection
    @Autowired
    public FsCommand(FileSystem fs){
        this.fs = fs;
    }

    @ShellMethod("Show free disk space")
    public String minimumFreeDiskSpace(){
        return DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + " GB";
    }
}
