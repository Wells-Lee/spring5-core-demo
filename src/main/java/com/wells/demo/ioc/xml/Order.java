package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description Bean实例生命周期
 * Created by wells on 2020-07-19 09:30:56
 */

public class Order {
    private String oname;

    public Order() {
        System.out.println("第一步: 通过无参构造方法创建bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步: 通过set方法注入属性");
    }

    /**
     * Bean初始化方法
     */
    public void initMethod() {
        System.out.println("第三步: 调用bean初始化方法");
    }

    /**
     * Bean销毁方法
     */
    public void destroyMethod() {
        System.out.println("第五步: 调用bean销毁方法");
    }

    @Override
    public String toString() {
        return "Order{" +
                "oname='" + oname + '\'' +
                '}';
    }

    @Test
    public void testBeanLife() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-life.xml");
        Order order = applicationContext.getBean("order", Order.class);
        System.out.println("第四步: 使用bean");
        System.out.println(order.toString());

        // 手动调用销毁bean实例
        applicationContext.close();
    }
}
