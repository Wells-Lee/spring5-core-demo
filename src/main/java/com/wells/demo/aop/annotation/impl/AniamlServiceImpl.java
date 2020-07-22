package com.wells.demo.aop.annotation.impl;

import com.wells.demo.aop.annotation.AnimalService;
import com.wells.demo.aop.annotation.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Description SpringAOP 注解方式实现
 * Created by wells on 2020-07-22 09:52:50
 */

@Service(value = "animalServiceImpl")
public class AniamlServiceImpl implements AnimalService {
    public void eat() {
        System.out.println("animal eat in service");
    }

    @Test
    public void testAopByAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AnimalService animalService = applicationContext.getBean("animalServiceImpl", AnimalService.class);
        animalService.eat();
    }
}
