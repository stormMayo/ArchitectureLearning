import beans.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.BeanDefined;
import util.BeanFactory;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
        Teacher t = (Teacher) factory.getBean("teacher");
        System.out.println("t = " + t);

    }
}
