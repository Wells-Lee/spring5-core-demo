package com.wells.demo.aop.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Description 
 * Created by wells on 2020-07-21 09:52:33
 */

public class UserServiceImpl implements UserService {
    public void delUser() {
        System.out.println("del user");
    }

    @Test
    public void testJDKProxy() {
        Class[] interfaces = {UserService.class};

        UserServiceImpl userServiceImpl = new UserServiceImpl();

        /**
         * newProxyInstance有三个参数:
         * 1、类加载器
         * 2、代理方法所在类的实现接口，可以支持多个接口
         * 3、代理类: 需要将代理的对象传递过去
         */
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), interfaces,
                new UserServiceProxy(userServiceImpl));

        userService.delUser();
    }
}
