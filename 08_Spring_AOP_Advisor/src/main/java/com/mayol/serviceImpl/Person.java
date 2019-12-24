package com.mayol.serviceImpl;

import com.mayol.service.BaseService;

public class Person implements BaseService {
    public void eat() {//切入点Pointcut   主要业务方法
        System.out.println("吃泡面");
    }

    public void wc() {
        System.out.println("上厕所");
    }
}
