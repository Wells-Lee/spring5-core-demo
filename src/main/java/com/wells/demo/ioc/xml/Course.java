package com.wells.demo.ioc.xml;

/**
 * Description 
 * Created by wells on 2020-07-19 09:05:53
 */

public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
