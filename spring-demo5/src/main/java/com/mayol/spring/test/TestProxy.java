package com.mayol.spring.test;

import com.mayol.spring.service.UserService;
import com.mayol.spring.service.UserServiceImpl;
import com.mayol.spring.utils.ProxyUtils;
import org.junit.Test;

public class TestProxy {

    @Test
    public void testJdkProxy(){
        //创建目标对象
        UserService service = new UserServiceImpl();
        //生成代理对象
        UserService proxy = ProxyUtils.getProxy(service);
        //调用目标对象方法
        service.saveUser();
        System.out.println("++++++++++++++++++");
        //调用代理对象方法
        proxy.saveUser();

    }
    @Test
    public void testCjLibProxy(){
        //创建目标对象
        UserService service = new UserServiceImpl();
        //生成代理对象
        UserService proxy = ProxyUtils.getProxyByCgLib(service);
        //调用目标对象方法
        service.saveUser();
        System.out.println("++++++++++++++++++");
        //调用代理对象方法
        proxy.saveUser();

    }
}
