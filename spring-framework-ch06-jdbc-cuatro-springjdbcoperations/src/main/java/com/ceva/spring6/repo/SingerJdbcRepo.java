package com.ceva.spring6.repo;

import com.ceva.spring6.record.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Spring bean singerRepo
 */
@Repository("singerRepo")
public class SingerJdbcRepo implements SingerRepo{

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerJdbcRepo.class);

    private DataSource dataSource;
    private SelectAllSingers selectAllSingers;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllSingers(dataSource);
    }

    public DataSource getDataSource(){
        return dataSource;
    }

    @Override
    public List<Singer> findAll() {
        return selectAllSingers.execute();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public Optional<String> findNameById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<String> findLastNameById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<String> findFirstNameById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        return List.of();
    }

    @Override
    public void insert(Singer singer) {

    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }
}
