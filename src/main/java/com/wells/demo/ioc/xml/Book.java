package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description 通过set方法注入属性
 * Created by wells on 2020-07-18 22:08:35
 */

public class Book {
    private String bname;
    private String bauthor;
    private String addr;
    private String btime;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                '}';
    }

    public String printNull() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }


    public String printSpecialProperty(){
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", addr='" + addr + '\'' +
                ", btime='" + btime + '\'' +
                '}';
    }

    /**
     * 通过set方法注入属性
     */
    @Test
    public void testWiredPropertyBySetter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book.toString());
    }

    /**
     * 注入Null值属性
     */
    @Test
    public void testWiredNullBySetter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book.printNull());
    }

    /**
     * 注入特殊符号属性
     */
    @Test
    public void testWiredSpecialPropertyBySetter() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book.printSpecialProperty());
    }
}
