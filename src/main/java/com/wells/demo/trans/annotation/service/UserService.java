package com.wells.demo.trans.annotation.service;

import com.wells.demo.trans.annotation.config.JDBCConfig;
import com.wells.demo.trans.annotation.dao.UserDao;
import com.wells.demo.trans.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description 通过注解方式实现Spring事务:
 * 1、创建 DataSource 对象实例
 * 2、创建 DataSourceTransactionManager(事务管理器) 对象实例
 * 3、创建 JDBCTemplate 对象实例
 * 4、在需要事务的方法上，增加事务注解： Transactional
 * Created by wells on 2020-07-23 10:13:53
 */

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void transferNormal() {
        User tom = new User("Tom", 18, 1000.0);
        User jerry = new User("Jerry", 20, 1000.0);

        // Tom 金额减100
        userDao.uptUser(tom.getName(), tom.getAmount() - 100);

        // Jerry 金额加100
        userDao.uptUser(jerry.getName(), jerry.getAmount() + 100);
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferExcp() {
        User tom = new User("Tom", 18, 1000.0);
        User jerry = new User("Jerry", 20, 1000.0);

        // Tom 金额减100
        userDao.uptUser(tom.getName(), tom.getAmount() - 100);

        int a = 5 / 0;

        // Jerry 金额加100
        userDao.uptUser(jerry.getName(), jerry.getAmount() + 100);
    }

    @Test
    public void transferAmount(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JDBCConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.transferNormal();
    }

    @Test
    public void testTransByXAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JDBCConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.transferExcp();
    }
}
