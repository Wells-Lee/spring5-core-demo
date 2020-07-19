package com.wells.demo.ioc.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description 注入集合属性
 * Created by wells on 2020-07-19 08:54:15
 */

public class Student {
    private String[] course;

    private List<String> books;

    private Map<String, String> teachers;

    private List<Course> courseList;

    private List<String> friends;

    public void setCourse(String[] course) {
        this.course = course;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public void setTeachers(Map<String, String> teachers) {
        this.teachers = teachers;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + Arrays.toString(course) +
                ", books=" + books +
                ", teachers=" + teachers +
                ", courseList=" + courseList +
                ", friends=" + friends +
                '}';
    }

    @Test
    public void testWiredCollectionProp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student.toString());
    }
}
