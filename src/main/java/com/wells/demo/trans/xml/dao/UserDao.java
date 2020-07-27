package com.wells.demo.trans.xml.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Description 
 * Created by wells on 2020-07-23 10:14:00
 */

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void uptUser(String name, Double amount) {
        String sql = String.format("update user set amount = %s where name = '%s'", amount, name);
        jdbcTemplate.execute(sql);
    }
}
