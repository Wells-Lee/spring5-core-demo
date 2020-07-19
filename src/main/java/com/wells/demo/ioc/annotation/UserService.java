package com.wells.demo.ioc.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description 通过四种注解方式创建对象实例: @Component、@Service、@Controller、@Respository
 * 默认的实例名为: 类名首字母小写；也可以自己指定，例如：@Service(value="")
 * Created by wells on 2020-07-19 20:44:31
 */

@Service
public class UserService {
//    @Autowired    // 根据类型进行注入引用类型
//    private UserDao userDao;

//    @Autowired
//    @Qualifier(value = "userDao")   // 根据名称进行注入引用类型，但是必须和Autowired一起使用
//    private UserDao userDao;

    //    @Resource   // 根据类型注入引用类型
    @Resource(name = "userDao")     // 根据名称进行注入引用类型
    private UserDao userDao;

    @Value(value = "wells")     // 注入基础类型
    private String name;

    public void delUser() {
        System.out.println("del user in service");
        userDao.delUser();
    }

    @Test
    public void testAnnotationByXML() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("component-scan.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.delUser();
        System.out.println(userService.name);
    }

    @Test
    public void testAnnotationByConfiguration(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.delUser();
        System.out.println(userService.name);
    }
}
