package com.wells.demo.ioc.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Description Bean处理器，需要特别注意的是：这个处理器是对所有的bean生效；所以会出现有几个bean，就执行几次
 * Created by wells on 2020-07-19 09:58:12
 */

public class BeanProcess  implements BeanPostProcessor {
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
