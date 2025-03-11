package com.ceva.collectionInject;

import com.ceva.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

/*
 * El bean CollectingBean recibe la inyeccion de un bean de tipo List con objeto Song
 */
@Component
public class CollectingBean {
    /*
     * Spring intentara inyectar todos los bean de tipo Song en el ApplicationContext actual. Por lo tanto,
     * se inyectaran los bean song1 y song2 en el atributo songList, aunque esto puede ser lo que no deseamos.
     * Si queremos que el bean de tipo List<Song> declarado en el ProjectConfig sea inyectado en el atributo songList
     * degemos usar la anotacion @Qualifier
     */
    @Qualifier("list")
    @Autowired
    private List<Song> songList;

    public void printCollections(){
        songList.forEach((System.out::println));
    }
}
