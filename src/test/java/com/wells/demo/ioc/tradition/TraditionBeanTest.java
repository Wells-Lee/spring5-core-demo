package com.wells.demo.ioc.tradition;

import org.junit.Test;

/**
 * Description 
 * Created by wells on 2020-07-18 21:42:53
 */

public class TraditionBeanTest {
    @Test
    public void testCreateUserService() {
        UserService userService = new UserService();
        userService.delUser();
    }
}
