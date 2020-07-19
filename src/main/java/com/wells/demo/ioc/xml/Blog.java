package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description 
 * Created by wells on 2020-07-19 10:19:12
 */

public class Blog {
    private String bname;

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bname='" + bname + '\'' +
                '}';
    }

    @Test
    public void testImportPorp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-import-prop.xml");
        Blog blog = applicationContext.getBean("blog", Blog.class);
        System.out.println(blog.toString());
    }
}
