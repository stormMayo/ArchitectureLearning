package util;

import beans.Teacher;

public class TeacherFactory {
    public Teacher createTeacher(){
        Teacher teacher = new Teacher();
        System.out.println("TeacherFactiry负责创建teacher类");
        return teacher;
    }
}
