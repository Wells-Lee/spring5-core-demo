package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description 通过ApplicationContext读取xml配置文件创建对象
 * Created by wells on 2020-07-18 08:26:41
 */

public class UserService {
    public void addUser() {
        System.out.println("add user");
    }

    /**
     * 通过无参构造方法创建对象
     */
    @Test
    public void createBeanByNonParamConstructor() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
    }
}
