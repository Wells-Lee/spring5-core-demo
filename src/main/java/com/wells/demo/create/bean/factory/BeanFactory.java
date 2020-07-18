package com.wells.demo.create.bean.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description 
 * Created by wells on 2020-07-18 08:35:06
 */

public class BeanFactory {
    public static UserDao getUserDaoBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        return applicationContext.getBean("userDao", UserDao.class);
    }
}
