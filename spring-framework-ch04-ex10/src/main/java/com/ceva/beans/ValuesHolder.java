package com.ceva.beans;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Component
public class ValuesHolder {
    List<String> stringList;
    InputStream inputStream;

    public ValuesHolder(){
        this.stringList = List.of("Mayer", "Psihoza", "Mazikeen");
        try{
            this.inputStream = new FileInputStream(System.getProperty("user.home") + System.getProperty("file.separator") + "test.txt");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public List<String> getStringList() {
        return stringList;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
