package com.ceva.spring6.dao;

import com.ceva.spring6.records.Singer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
