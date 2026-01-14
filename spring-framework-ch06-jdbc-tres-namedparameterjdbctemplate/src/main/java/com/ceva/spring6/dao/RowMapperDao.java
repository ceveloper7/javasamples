package com.ceva.spring6.dao;

import com.ceva.spring6.QueryConstants;
import com.ceva.spring6.model.Album;
import com.ceva.spring6.records.Singer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RowMapperDao implements SingerDao{

    private NamedParameterJdbcTemplate namedTemplate;

    public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate){
        this.namedTemplate = namedTemplate;
    }

    @Override
    public String findNameById(Long id) {
        return namedTemplate
                .queryForObject("SELECT CONCAT(first_name, ' ', last_name) FROM singer WHERE id = :singerId", Map.of("singerId", id), String.class);
    }

    // Using Lambda para evitar la implementacion explicita de RowMapper<Singer>
    @Override
    public Set<Singer> findAll() {
        return new HashSet<Singer>(namedTemplate.query("SELECT * FROM singer", (rs, rowNum)-> {
            return new Singer(
                    rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("birth_date").toLocalDate(),
                    Set.of());
        }));
    }

    // Recuperando Objetos de dominio anidados con ResultSetExtractor
/*
    static class SingerWithAlbumExtractor implements ResultSetExtractor<Set<Singer>>{

        @Override
        public Set<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Singer> map = new HashMap<>();
            Singer singer;
            while (rs.next()){
                Long id = rs.getLong("id");
                singer = map.get(id);
                if(singer == null){
                    singer = new Singer(id,
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getDate("birth_date").toLocalDate(),
                            new HashSet<>());
                    map.put(id, singer);
                }
                var albumId = rs.getLong("album_id");
                if (albumId> 0){
                    Album album = new Album(albumId,
                            id,
                            rs.getString("title"),
                            rs.getDate("release_date").toLocalDate());
                    singer.albums().add(album);
                }
            }
            return new HashSet<>(map.values());
        }
    }
*/
    // left join -> recupera Singer con Album y tambien Singer sin album
    @Override
    public List<Singer> findAllWithAlbums() {
        //return new HashSet<>(namedTemplate.query(QueryConstants.ALL_JOIN_SELECT, new SingerWithAlbumExtractor()));
        return namedTemplate.query(QueryConstants.ALL_JOIN_SELECT, rs ->{
            Map<Long, Singer> map = new HashMap<>();
            Singer singer;
            while (rs.next()){
                Long id = rs.getLong("id");
                singer = map.get(id);
                if(singer == null){
                    singer = new Singer(id,
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getDate("birth_date").toLocalDate(),
                            new HashSet<>());
                    map.put(id, singer);
                }
                var albumId = rs.getLong("album_id");
                if (albumId> 0){
                    Album album = new Album(albumId,
                            id,
                            rs.getString("title"),
                            rs.getDate("release_date").toLocalDate());
                    singer.albums().add(album);
                }
            }
            return new ArrayList<>(map.values());
        });
    }


/**
    static class SingerMapper implements RowMapper<Singer> {

        @Override
        public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Singer(
                    rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("birth_date").toLocalDate(),
                    Set.of());
        }
    }
 */
}
