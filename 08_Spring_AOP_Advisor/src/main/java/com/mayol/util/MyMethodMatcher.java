package com.mayol.util;

import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

public class MyMethodMatcher implements MethodMatcher {
    /**
     * 被监控接口：baseService  没有重载方法
     * 每一个方法名称都是唯一
     * 此时可以采用静态检测方式，只根据方法名称判断
     *
     *
     * 业务：只对person eat织入
     * @param method  接口中某一个方法
     * @param targetClass   接口中的一个实现类
     * @return
     */

    public boolean matches(Method method, Class<?> targetClass) {
        String methodName = method.getName();
        if("eat".equals(methodName)){
            return  true;
        }
        return false;
    }

    public boolean isRuntime() {
        return false;
    }

    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }
}
