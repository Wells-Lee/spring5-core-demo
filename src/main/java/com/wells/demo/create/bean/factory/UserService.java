package com.wells.demo.create.bean.factory;

/**
 * Description 通过工厂类读取xml配置文件创建Bean对象(工厂设计模式、XML【或者注解】、反射机制)
 * Created by wells on 2020-07-18 08:26:41
 */

public class UserService {
    public static void main(String[] args) {
        UserDao userDao = BeanFactory.getUserDaoBean();
        userDao.delUser();
    }
}
