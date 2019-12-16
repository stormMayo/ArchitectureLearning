import beans.Teacher;
import util.BeanDefined;
import util.BeanFactory;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //1。申明benn
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("teacher");
        beanObj.setClassPath("beans.Teacher");

        //标签中所有配置信息
        List beanList = new ArrayList();
        beanList.add(beanObj);//Spring核心配置
//        2.申明一个Spring 提供的BeanFactory
        BeanFactory factory = new BeanFactory();
        factory.setBeanDefinedList(beanList);

        //3.开发人员向BeanFactory索要实例对象
        Teacher t = (Teacher)factory.getBean("teacher");
        System.out.println(t);
    }
}
