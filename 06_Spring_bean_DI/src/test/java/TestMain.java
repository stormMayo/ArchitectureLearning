import com.mayol.beans.Teacher;
import com.mayol.service.BaseService;
import com.mayol.util.BeanDefined;
import com.mayol.util.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
        Teacher teacher = (Teacher) factory.getBean("teacher");
        System.out.println(teacher.getTeacherName());
        System.out.println(teacher.getFriendArray());
        System.out.println(teacher.getShcool());

    }
}
