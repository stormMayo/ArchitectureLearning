package com.mayol.spring.advice;

public class MyAdvice {
    //演示前置通知
    public void log() {
        System.out.println("开始记录日志了...");
    }

    //演示后置通知
    public void log2() {
        System.out.println("开始记录日志了log2...");
    }
    //演示最终通知
    public void log3() {
        System.out.println("开始记录日志了log3...");
    }
    //演示异常抛出通知
    public void log4() {
        System.out.println("开始记录日志了log4...");
    }

}
