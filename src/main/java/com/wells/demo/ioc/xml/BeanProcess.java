package com.wells.demo.ioc.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Description Bean处理器，需要特别注意的是：这个处理器是对所有的bean生效；所以会出现有几个bean，就执行几次
 *
 * Spring底层对 BeanPostProcessor 的使用:
 *      bean赋值
 *      注入其他组件
 *      @Autowired: AutowiredAnnotationBeanPostProcessor
 *      生命周期注解功能: InitDestroyAnnotationBeanPostProcessor
 *      @Sync
 * 等功能都是通过 BeanPostProcessor 的实现类做的，可以通过debug看到
 *
 * Created by wells on 2020-07-19 09:58:12
 */

public class BeanProcess implements BeanPostProcessor {
    /**
     * 处理器前置方法
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第处理器前置方法");
        return bean;
    }

    /**
     * 处理器后缀方法
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("处理器后置方法");
        return bean;
    }
}
