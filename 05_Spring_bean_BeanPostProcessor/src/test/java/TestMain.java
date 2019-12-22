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
        BaseService isomeService = (BaseService) factory.getBean("isomeService");
        System.out.println(isomeService.doSome());
//        //1。申明benn
//        BeanDefined beanObj = new BeanDefined();
//        beanObj.setBeanId("teacher");
//        beanObj.setClassPath("com.mayol.beans.Teacher");
//        beanObj.setFactoryBean("factory1");
//        beanObj.setFactoryMethod("createTeacher");
//        beanObj.setScope("prototype");

//
//        BeanDefined beanObj2 = new BeanDefined();
//        beanObj2.setBeanId("factory1");
//        beanObj2.setClassPath("com.mayol.util.TeacherFactory");
//
//
//        //标签中所有配置信息
//        List configuration = new ArrayList();
//        configuration.add(beanObj);//Spring核心配置
//        configuration.add(beanObj2);
////        2.申明一个Spring 提供的BeanFactory
//        BeanFactory factory = new BeanFactory(configuration);
//        factory.setBeanDefinedList(configuration);
//
//        //3.开发人员向BeanFactory索要实例对象
//        Teacher t = (Teacher)factory.getBean("teacher");
//        System.out.println("t= " + t);

    }
}
