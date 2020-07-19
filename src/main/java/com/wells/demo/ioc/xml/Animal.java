package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description Bean声明周期
 * Created by wells on 2020-07-19 09:43:06
 */

public class Animal {
    private String aname;

    public Animal() {
        System.out.println("第一步: 使用无参构造方法创建对象实例");
    }

    public void setAname(String aname) {
        this.aname = aname;
        System.out.println("第二步: 通过set方法注入属性");
    }

    public void initMethod() {
        System.out.println("第四步: 执行初始化方法");
    }

    public void destroyMethod() {
        System.out.println("第七步: 执行销毁方法");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "aname='" + aname + '\'' +
                '}';
    }

    @Test
    public void testBeanLifeWithProcess() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-life.xml");
        Animal animal = applicationContext.getBean("animal", Animal.class);
        System.out.println("第六步: 使用bean实例对象");
        System.out.println(animal.toString());

        applicationContext.close();
    }
}
