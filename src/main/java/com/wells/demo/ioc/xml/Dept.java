package com.wells.demo.ioc.xml;

/**
 * Description 
 * Created by wells on 2020-07-18 23:19:14
 */

public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
