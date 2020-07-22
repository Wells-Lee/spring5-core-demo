package com.wells.demo.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Description 
 * Created by wells on 2020-07-22 09:53:49
 */

@Configuration
@ComponentScan(value = "com.wells.demo.aop.annotation")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
