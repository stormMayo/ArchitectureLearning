package com.mayol.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mayol.spring.service.UserService;

public class TestSpring {
	@Test
	public void test1(){
		//创建容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//根据类型获取实例
		UserService service1 = context.getBean(UserService.class);
		UserService service2 = (UserService)context.getBean("userService");
		//
		service1.saveUser();
		service2.saveUser();
		
	}

}
