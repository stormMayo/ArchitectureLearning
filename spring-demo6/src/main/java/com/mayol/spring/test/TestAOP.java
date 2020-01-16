package com.mayol.spring.test;

import com.mayol.spring.service.UserService;
import com.mayol.spring.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml" )
public class TestAOP {

    @Autowired
    private UserService userService;

    @Test
    public void testBefor(){
        userService.saveUser();

    }

}
