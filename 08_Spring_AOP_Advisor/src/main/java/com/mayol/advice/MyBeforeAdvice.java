package com.mayol.advice;

import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.lang.reflect.Method;

/**
 *
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    //切面：次要业务
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---------洗手-----------");
    }
}
