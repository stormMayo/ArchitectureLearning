package com.mayol.spring.test;

import com.mayol.spring.configuration.SpringConfiguration;
import com.mayol.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestSpringIoC {

	@Test
	public void test1() {
		// 创建纯注解方式的spring容器
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		//获取实例
		UserService service = context.getBean(UserService.class);
		service.saveUser();

		UserService userService2 = (UserService) context.getBean("userService");
		userService2.saveUser();
	}
}
