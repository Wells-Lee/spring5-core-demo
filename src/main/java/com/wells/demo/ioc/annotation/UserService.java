package com.wells.demo.ioc.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Description 通过四种注解方式创建对象实例: @Component、@Service、@Controller、@Respository
 * 默认的实例名为: 类名首字母小写；也可以自己指定，例如：@Service(value="")
 * Created by wells on 2020-07-19 20:44:31
 */

@Service

// 经常用于导入第三方jar包的组件，在 SpringBoot 中用的非常广泛
//@Import(DataSource.class)
public class UserService {
    /**
     * 自动装配的时候:
     * 1、先按照类型去找
     * 2、如果有多个相同类型的实例对象，再按照实例名字去找: 通过 @Service 注入的实例名为类名首字母小写，通过 @Bean 注入的实例名为方法名，也可以自己指定
     * 如果没有这个实例bean对象，那么会报错 beanNoDefine...，可以将 required 设置为false，在启动时不报错，但是万一用到也是会报错的；另外
     * 可以通过 @Primary 来指定优先加载那个对象实例
     */
//    @Autowired    // 根据类型进行注入引用类型
//    private UserDao userDao;

//    @Autowired
//    @Qualifier(value = "userDao")   // 根据名称进行注入引用类型，但是必须和Autowired一起使用
//    private UserDao userDao;

    //    @Resource   // 根据类型注入引用类型
    @Resource(name = "userDao")     // 根据名称进行注入引用类型
    private UserDao userDao;

    /**
     * value中除了可以直接写对应值之外，还可以写
     * ${}: 从环境变量中引入，环境变量中的值，可以通过 applicationContext.getEnvionment 得到的；   由此得出，consul 中的值全部放在了环境变量
     * SpEL: #{}
     */
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
