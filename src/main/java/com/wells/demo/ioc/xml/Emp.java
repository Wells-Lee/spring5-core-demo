package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description
 * Created by wells on 2020-07-18 23:19:26
 */

public class Emp {
    private String ename;
    private String gender;

    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }

    /**
     * 通过外部创建方式注入bean属性
     */
    @Test
    public void testWiredOutterBeanBySet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Emp emp = applicationContext.getBean("empOut", Emp.class);
        System.out.println(emp.toString());
    }

    /**
     * 通过内部创建方式注入bean属性
     */
    @Test
    public void testWiredInBeanBySet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Emp emp = applicationContext.getBean("empIn", Emp.class);
        System.out.println(emp.toString());
    }

    @Test
    public void testWiredBeanLinePropOneBySet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Emp emp = applicationContext.getBean("empLinkOne", Emp.class);
        System.out.println(emp.toString());
    }

    @Test
    public void testWiredBeanLinePropTwoBySet() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Emp emp = applicationContext.getBean("empLinkTwo", Emp.class);
        System.out.println(emp.toString());
    }

    @Test
    public void testAutoWiredByNameInXML(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-auto-wired.xml");
        Emp emp = applicationContext.getBean("empByName", Emp.class);
        System.out.println(emp.toString());
    }

    @Test
    public void testAutoWiredByTypeInXML(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-auto-wired.xml");
        Emp emp = applicationContext.getBean("empByType", Emp.class);
        System.out.println(emp.toString());
    }
}
