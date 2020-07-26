package com.wells.demo.trans.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Description 
 * Created by wells on 2020-07-23 09:57:46
 */

@Configuration
@ComponentScan(value = "com.wells.demo.trans")
public class JDBCConfig {

    @Value(value = "jdbc:mysql://localhost:3306/spring_db")
    private String url;

    @Value(value = "root")
    private String userName;

    @Value(value = "root1234!")
    private String passwd;

    @Value(value = "com.mysql.jdbc.Driver")
    private String driverName;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passwd);
        dataSource.setDriverClassName(driverName);
        return dataSource;
    }

    /**
     * 通过 @Bean 创建的对象实例，在方法参数上的对象实例默认从 Spring 容器中获取
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
