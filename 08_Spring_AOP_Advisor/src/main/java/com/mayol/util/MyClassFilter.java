package com.mayol.util;

import com.mayol.serviceImpl.Person;
import org.springframework.aop.ClassFilter;

public class MyClassFilter implements ClassFilter {
    public boolean matches(Class<?> clazz) {
        /**
         * 1.一个借口下面会有多个实现类
         * 2.判断当前实现类是不是我们织入方式关心的目标类
         * BaseService接口现在只想管理person
         * 参数：就是当前被拦截雷，可能是Person  可能是Dog
         *
         */
        if(clazz == Person.class){
            return true;//高度顾问，当前类是需要我们提供织入服务
        }
        //DOg
        return false;
    }
}
