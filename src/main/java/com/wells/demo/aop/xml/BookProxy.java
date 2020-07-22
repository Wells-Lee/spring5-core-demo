package com.wells.demo.aop.xml;

/**
 * Description 
 * Created by wells on 2020-07-22 09:37:34
 */

public class BookProxy {
    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }
}
