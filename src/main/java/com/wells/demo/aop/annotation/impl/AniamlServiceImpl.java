package com.wells.demo.aop.annotation.impl;

import com.wells.demo.aop.annotation.AnimalService;
import com.wells.demo.aop.annotation.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Description SpringAOP 注解方式实现
 * 1、导入aop依赖
 * 2、定义逻辑类
 * 3、定义切面类，通知方法：
 *      前置通知({@link org.aspectj.lang.annotation.Before})
 *      后置通知({@link org.aspectj.lang.annotation.After})
 *      返回通知({@link org.aspectj.lang.annotation.AfterReturning})
 *      异常通知({@link org.aspectj.lang.annotation.AfterThrowing})
 *      环绕通知({@link org.aspectj.lang.annotation.Around})
 * 4、配置切面点: 可以通过指定方法、类或者自定义注解、Spring原生注解
 * 5、配置打开aop: @EnableAspectJAutoProxy(proxyTargetClass = true): 这也是aop的入口
 *
 *
 * AOP原理: 注解({@link org.springframework.context.annotation.EnableAspectJAutoProxy})
 * 【看给容器中注册了什么组件，这个组件的作用是什么】
 * 1、EnableAspectJAutoProxy是什么？
 *      @Import(AspectJAutoProxyRegistrar.class): 利用 @Import 给容器中注入AspectJAutoProxyRegistrar属性
 *          internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 * 2、AnnotationAwareAspectJAutoProxyCreator
 *      -> AspectJAwareAdvisorAutoProxyCreator
 *          -> AbstractAdvisorAutoProxyCreator
 *              -> AbstractAutoProxyCreator implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *              关注后置处理器：在 bean 初始化前后做事情，自动创建 BeanFactory
 *
 *  AbstractAdvisorAutoProxyCreator.setBeanFactory -> initBeanFactory
 *  AnnotationAwareAspectJAutoProxyCreator.initBeanFactory
 *
 *
 * Created by wells on 2020-07-22 09:52:50
 */

@Service(value = "animalServiceImpl")
public class AniamlServiceImpl implements AnimalService {
    public void eat() {
        System.out.println("animal eat in service");
    }

    @Test
    public void testAopByAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AnimalService animalService = applicationContext.getBean("animalServiceImpl", AnimalService.class);
        animalService.eat();
    }
}
