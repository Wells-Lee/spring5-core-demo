package com.wells.demo.trans.dao;

import com.wells.demo.trans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Description 
 * Created by wells on 2020-07-23 10:14:00
 */

@Service
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void uptUser(String name, Double amount) {
        String sql = String.format("update user set amount = %s where name = '%s'", amount, name);
        jdbcTemplate.execute(sql);
    }
}
