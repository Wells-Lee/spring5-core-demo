package com.wells.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;

/**
 * Description 我们如果想使用 Spring 中的上下文，可以通过实现 Aware 中的实现类得到
 * 例如:
 *      获取 ApplicationContext 通过 {@link ApplicationContextAware} 获取到
 *
 * 另外，还可以获得：环境变量Aware({@link EnvironmentAware})、资源配置 {@link org.springframework.context.ResourceLoaderAware}
 * 值解析器，可以拿到环境变量中的值 ({@link org.springframework.context.EmbeddedValueResolverAware})
 * Created by wells on 2020-07-26 15:29:50
 */

public class AwareConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
