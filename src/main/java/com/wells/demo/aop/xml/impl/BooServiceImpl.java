package com.wells.demo.aop.xml.impl;

import com.wells.demo.aop.xml.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description SpringAOP XML 方式实现
 * Created by wells on 2020-07-22 09:36:53
 */

public class BooServiceImpl implements BookService {
    public void delBook() {
        System.out.println("del book in service");
    }

    @Test
    public void testAopByXMl(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        bookService.delBook();
    }
}
