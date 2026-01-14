package com.ceva.spring6.dao;

import com.ceva.spring6.records.Singer;

import java.util.List;
import java.util.Set;

public interface SingerDao {
    String findNameById(Long id);
    Set<Singer> findAll();
    List<Singer> findAllWithAlbums();
    //Set<Singer> findAllWithAlbums();
}
