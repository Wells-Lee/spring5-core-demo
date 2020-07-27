package com.wells.demo.trans.xml.service;

import com.wells.demo.trans.entity.User;
import com.wells.demo.trans.xml.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description 通过xml配置的方式实现事务，具体配置见: spring-trans.xml
 * Created by wells on 2020-07-23 10:13:53
 */

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void transferExcp() {
        User tom = new User("Tom", 18, 1000.0);
        User jerry = new User("Jerry", 20, 1000.0);

        // Tom 金额减100
        userDao.uptUser(tom.getName(), tom.getAmount() - 100);

        // 增加异常
        int a = 5 / 0;

        // Jerry 金额加100
        userDao.uptUser(jerry.getName(), jerry.getAmount() + 100);
    }

    @Test
    public void testTransByXML() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-trans.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.transferExcp();
    }
}
