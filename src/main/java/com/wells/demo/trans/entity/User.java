package com.wells.demo.trans.entity;

/**
 * Description 
 * Created by wells on 2020-07-23 10:14:40
 */

public class User {
    private String name;

    private Integer age;

    private Double amount;

    public User() {
    }

    public User(String name, Integer age, Double amount) {
        this.name = name;
        this.age = age;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
