package com.wells.demo.trans.service;

import com.wells.demo.trans.config.JDBCConfig;
import com.wells.demo.trans.dao.UserDao;
import com.wells.demo.trans.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Description 
 * Created by wells on 2020-07-23 10:13:53
 */

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void transfer() {
        User tom = new User("Tom", 18, 1000.0);
        User jerry = new User("Jerry", 20, 1000.0);

        // Tom 金额减100
        userDao.uptUser(tom.getName(), tom.getAmount() - 100);

        // Jerry 金额加100
        userDao.uptUser(jerry.getName(), jerry.getAmount() + 100);
    }

    @Test
    public void transferAmount(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JDBCConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.transfer();
    }
}
