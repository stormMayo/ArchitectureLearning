package com.mayol.serviceImpl;

import com.mayol.service.BaseService;

public class Dog implements BaseService {
    public void eat() {
        System.out.println("啃骨头");
    }

    public void wc() {
        System.out.println("嘘嘘。。。。");
    }
}
