package com.wells.demo.ioc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Description 测试 ImportSelector
 * Created by wells on 2020-07-29 09:53:12
 */

@Import(BookDao.class)
public class BookService {
    @Test
    public void testImportSelector(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = applicationContext.getBean("bookDao", BookDao.class);
        bookDao.delBook();
    }
}
