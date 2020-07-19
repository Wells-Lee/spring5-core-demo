package com.wells.demo.ioc.annotation;

import org.springframework.stereotype.Component;

/**
 * Description 
 * Created by wells on 2020-07-19 21:05:28
 */

@Component
public class UserDao {
    public void delUser(){
        System.out.println("del user in dao");
    }
}
