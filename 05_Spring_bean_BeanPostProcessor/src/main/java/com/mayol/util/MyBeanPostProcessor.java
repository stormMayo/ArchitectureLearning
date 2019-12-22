package com.mayol.util;

import com.mayol.serviceImpl.ISomeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean对象初始化之前....");
        return bean;
        //return  bean对象监控代理对象
    }

    public Object postProcessAfterInitialization(final Object beanInstance, String beanName) throws BeansException {
        //为当前bean对象注册代理监控对象，附则1增强bean对象方法相关能力
        Class<?> beanClass = beanInstance.getClass();
        if(beanClass == ISomeService.class){
            Object proxy = Proxy.newProxyInstance(
                    beanInstance.getClass().getClassLoader(),
                    beanInstance.getClass().getInterfaces(),
                    new InvocationHandler() {
                        /**
                         * method：dosome
                         * args:doSome执行接收实参
                         * proxy:代理监控对象
                         */
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("doSome方法被执行！");
                            String result = (String) method.invoke(beanInstance, args);
                            return result.toUpperCase();
                        }
                    }
            );
            return proxy;
        }
        return beanClass;
    }
}
