package com.mayol.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration,相当于一个spring的xml配置文件中的beans根标签
//<beans></beans>
//该类一般被称之为配置类
@Configuration
// 相当于context:component-scan标签
@ComponentScan(basePackages = "com.mayol.spring.service")
@Import(DaoConfiguration.class)
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("容器初始化...");
	}

	//Bean注解，可以指定bean的id,如果不知道，默认bean的id就是@Bean注解对应的方法名称
	//相当于原先Spring配置文件中的bean标签
//	@Bean
//	public UserService userService(){
//		return new UserServiceImpl();
//	};

}
