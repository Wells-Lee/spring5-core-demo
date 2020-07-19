package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description FactoryBean
 * Created by wells on 2020-07-19 09:21:56
 */

public class MyBean implements FactoryBean<Course> {
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("大学英语");
        return course;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Course course = applicationContext.getBean("myBean", Course.class);
        System.out.println(course.toString());
    }
}
