package com.ceva.spring6.dao.pojo;

import com.ceva.spring6.QueryConstants;
import com.ceva.spring6.model.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class PlainSingerDAO implements SingerDAO{
    private static final Logger LOGGER = LoggerFactory.getLogger(PlainSingerDAO.class);
    @Override
    public Set<Singer> findAll() {
        Set<Singer> result = new HashSet<>();
        try (var connection = getConnection();
             var statement = connection.prepareStatement(QueryConstants.ALL_SELECT);
             var resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                var singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
                result.add(singer);
            }
        } catch (SQLException ex) {
            LOGGER.error("Problem when executing SELECT!",ex);
        }
        return result;
    }

    @Override
    public Set<Singer> findByFirstName(String firstName) {
        return Set.of();
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
    public Singer insert(Singer singer) {
        try ( var connection = getConnection()){
            var statement = connection.prepareStatement(QueryConstants.SIMPLE_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, java.sql.Date.valueOf(singer.getBirthDate()));
            statement.execute();
            var generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                singer.setId(generatedKeys.getLong(1));
            }
            return singer;
        } catch (SQLException ex) {
            LOGGER.error("Problem executing INSERT", ex);
        }
        return null;
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {
        try (var connection = getConnection();
             var statement = connection.prepareStatement(QueryConstants.SIMPLE_DELETE)) {
            statement.setLong(1, singerId);
            statement.execute();
        } catch (SQLException ex) {
            LOGGER.error("Problem executing DELETE", ex);
        }
    }

    @Override
    public Set<Singer> findAllWithAlbums() {
        return Set.of();
    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }
}
