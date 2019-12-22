import beans.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BaseService;
import serviceImpl.ISomeService;
import util.BeanDefined;
import util.BeanFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
//        Teacher t = (Teacher) factory.getBean("teacher");
//        System.out.println("t = " + t);
        //1。申明benn
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("isomeService");
        beanObj.setClassPath("serviceImpl.ISomeService");

        BeanDefined beanObj2 = new BeanDefined();
        beanObj2.setClassPath("util.MyBeanPostProcessor");


        //标签中所有配置信息
        List configuration = new ArrayList();
        configuration.add(beanObj);//Spring核心配置
        configuration.add(beanObj2);
//        2.申明一个Spring 提供的BeanFactory
        BeanFactory factory = new BeanFactory(configuration);
//        factory.setBeanDefinedList(configuration);

        //3.开发人员向BeanFactory索要实例对象
        BaseService t = (BaseService) factory.getBean("isomeService");
        System.out.println("t= " + t);
        System.out.println(t.doSome());

    }
}
