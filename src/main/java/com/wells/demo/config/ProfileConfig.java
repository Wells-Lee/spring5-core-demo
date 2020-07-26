package com.wells.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * Description 动态激活和切换配置文件
 *
 * 通过 {@link org.springframework.context.annotation.Profile} 来实现
 * 1、加了 Profile 注解的bean，只有这个环境被激活的时候才能注册到容器中。默认是 default 环境，会被激活
 * 2、没有标注 Profile 注解的bean，默认是会被加载的
 * Created by wells on 2020-07-26 15:33:06
 */

@Configuration
public class ProfileConfig {
    @Profile(value = "dev")
    @Bean
    public DataSource dataSourceDev() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Profile(value = "test")
    @Bean
    public DataSource dataSourceTest() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Profile(value = "prod")
    @Bean
    public DataSource dataSourceProd() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean
    public DataSource dataSourceDefault() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Test
    public void testProfile() {
        /**
         * 默认全部加载
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfig.class);
        String[] beanList = applicationContext.getBeanNamesForType(DataSource.class);
        for (String bean : beanList) {
            System.out.println(bean);
        }

        /**
         * 如果要使用 Profile 注释的 bean，需要使用无参构造的 ApplicationContext，激活方式：
         * 1、环境参数: -Dspring.profiles.active=dev
         * 2、设置 ApplicationContext 的激活 Profile
         */
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 设置激活的 Profile
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dev");

        /**
         * 下面这两步相当于 new AnnotationConfigApplicationContext(ProfileConfig.class); 可以点击进去看实现
         */
        annotationConfigApplicationContext.register(ProfileConfig.class);
        annotationConfigApplicationContext.refresh();

        String[] beanList2 = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
        for (String bean : beanList2) {
            System.out.println(bean);
        }
    }
}
