package com.ceva.spring6;

import com.ceva.spring6.dao.pojo.SingerDAO;
import com.ceva.spring6.model.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

public class JdbcSingerDao implements SingerDAO, InitializingBean {

    private static Logger LOGGER = LoggerFactory.getLogger(JdbcSingerDao.class);
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }



    @Override
    public Set<Singer> findAll() {
        return Set.of();
    }

    @Override
    public Set<Singer> findByFirstName(String firstName) {
        return Set.of();
    }

    @Override
    public String findNameById(Long id) {
        var result = "";
        try(var connection = dataSource.getConnection();
            var statement = connection.prepareStatement("select first_name,last_name from singer where id =" + id);
            var resultSet = statement.executeQuery()){
            while(resultSet.next())
                return resultSet.getString("first_name") + " " + resultSet.getString("last_name");

        }catch(SQLException ex){
            LOGGER.error("Problem when executing SELECT! ", ex);
        }
        return result;
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
    public Singer insert(Singer singer) {
        return null;
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public Set<Singer> findAllWithAlbums() {
        return Set.of();
    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null)
            throw new BeanCreationException("Must set dataSource on SingerDAO");
    }
}
