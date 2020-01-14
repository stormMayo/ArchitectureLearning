package com.mayol.spring.utils;

import com.mayol.spring.service.UserService;
import com.mayol.spring.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *使用jdk的动态代理实现
 */
public class ProxyUtils {
    public static UserService getProxy(UserService userService){
        UserService o = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("记录日志：----------前");
                Object invoke = method.invoke(userService, objects);
                System.out.println("记录日志：——————————后");
                return invoke;
            }
        });
        return o;
    }

    /**
     * 使用cglib动态代理核技术实现
     * 基于继承方式实现
     * @param userService
     * @return
     */
    public static UserService getProxyByCgLib(UserService userService){
        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置需要增强的类对象
        enhancer.setSuperclass(UserServiceImpl.class);

        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
//            MethodProxy 代理之后的对象方法引用
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("记录开始时间————————"+ System.currentTimeMillis());
                //改行代码，实际调用的是目标对象的方法
                Object o1 = methodProxy.invokeSuper(o, objects);
                System.out.println("记录结束时间————————" +System.currentTimeMillis());
                return o1;
            }
        });
        //获取增强之后的代理对象
        UserService o = (UserService) enhancer.create();
        return o;
    }



}




