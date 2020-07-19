package com.wells.demo.ioc.tradition;

/**
 * Description 传统方式: 通过 new 对象来调用，带来的问题：
 * 1、耦合高：如果userDao有了新的实现，需要修改所有调用userDao的地方；
 * 因此，为了降低耦合，所以需要工厂模式来做，而Spring恰恰用了：xml配置(注解)、工厂模式、反射来进行bean的创建
 * Created by wells on 2020-07-18 08:26:41
 */

public class UserService {
    public void delUser() {
        System.out.println("delete user");
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.delUser();
    }
}
