package com.mayol.util;

import com.mayol.beans.Teacher;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TeacherFactory {
    //节省内存消耗
    public static Teacher createTeacher(){
        Teacher teacher = new Teacher();
        System.out.println("TeacherFactiry负责创建teacher类");
        return teacher;
    }
    BeanPostProcessor cc;
}
