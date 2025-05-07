package com.example.weeklytaskdb1.Repository;

import com.example.weeklytaskdb1.model.Fruit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FruitFruitRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitFruitRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected static final RowMapper<Fruit> fruitRowMapper = (rs, rowNum) ->
            new Fruit(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("origin"),
                    rs.getString("color")
            );

    public List<Fruit> getAllFruits() {
        String sql = "select * from fruits";
        return jdbcTemplate.query(sql, fruitRowMapper);
    }
}