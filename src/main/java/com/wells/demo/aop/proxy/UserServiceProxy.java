package com.wells.demo.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Description 
 * Created by wells on 2020-07-21 09:53:05
 */

public class UserServiceProxy implements InvocationHandler {
    private Object obj;

    public UserServiceProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * @desc
     * @method invoke
     * @param proxy 代理的实现类
     * @param method 代理的方法
     * @param args 代理方法的参数
     * @return java.lang.Object
     * @date 2020-07-21 10:20:16
     * @author wells
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行之前: " + method.getName() + ", 参数: " + Arrays.toString(args));

        // 执行方法
        Object res = method.invoke(obj, args);

        System.out.println("方法执行之后: " + method.getName() + ", 结果: " + res);
        return res;
    }
}
