package com.ceva.spring6.repo;

import com.ceva.spring6.record.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Spring bean singerRepo. Implementaciones del paquete repo
 */
@Repository("singerRepo")
public class SingerJdbcRepo implements SingerRepo{

    private static final Logger LOGGER = LoggerFactory.getLogger(SingerJdbcRepo.class);

    private DataSource dataSource;
    private SelectAllSingers selectAllSingers;
    private SelectSingerByFirstName selectSingerByFirstName;
    private UpdateSinger updateSinger;
    private InsertSinger insertSinger;


    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.selectAllSingers = new SelectAllSingers(dataSource);
        this.selectSingerByFirstName = new SelectSingerByFirstName(dataSource);
        this.updateSinger = new UpdateSinger(dataSource);
        this.insertSinger = new InsertSinger(dataSource);
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
        return selectSingerByFirstName.executeByNamedParam(Map.of("first_name", firstName));
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
        // keyHolder instance que contendra el id generado
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(
                Map.of("first_name", singer.firstName(),
                        "last_name", singer.lastName(),
                        "birth_date", singer.birthDate()), keyHolder
        );
        // insertado el registro obtenemos el id generado
        var generatedId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        LOGGER.info("New singer  {} {} inserted with id {}  ", singer.firstName(), singer.lastName(), generatedId);
    }

    @Override
    public void update(Singer singer) {
        updateSinger.updateByNamedParam(
                Map.of("first_name", singer.firstName(),
                        "last_name", singer.lastName(),
                        "birth_date", singer.birthDate(),
                        "id", singer.id())
        );
        LOGGER.info("Existing singer updated with id: " + singer.id());
    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }
}
