package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  BeanFactory {
    private List<BeanDefined> beanDefinedList;
    //已经创建好的实例对象
    private Map<String,Object> SpringIOC;


    public BeanFactory(List<BeanDefined> beanDefinedList) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.beanDefinedList = beanDefinedList;
        SpringIOC = new HashMap<String, Object>();//所有scope = "singleton"  单例管理的
        for(BeanDefined beanObj:this.beanDefinedList){
            if("singleton".equals(beanObj.getScope())){
                Class<?> classFile = Class.forName(beanObj.getClassPath());
                Object instance = classFile.newInstance();
                SpringIOC.put(beanObj.getBeanId(),instance);
            }

        }
    }

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }
    public Object getBean(String beanId) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object o;
        for(BeanDefined beanObj:this.beanDefinedList){
            if(beanId.equals(beanObj.getBeanId())){
                String classPath = beanObj.getClassPath();
                Class<?> aClass = Class.forName(classPath);
                String scope = beanObj.getScope();
                String factoeyBean = beanObj.getFactoryBean();
                String factoryMethod = beanObj.getFactoryMethod();
                if("prototype".equals(scope)){//getBean每次返回全新实例对象
                    //在默认情况下，Spring工厂调用默认构造放方法创建实例对象
                    o = aClass.newInstance();
                    if(factoeyBean != null && factoryMethod != null){//希望用户用指定工厂创建实例对象
                        Object factoryObj = SpringIOC.get(factoeyBean);
                        Class<?> factoryObjClass = factoryObj.getClass();
                        Method methodObj = factoryObjClass.getDeclaredMethod(factoryMethod, null);
                        methodObj.setAccessible(true);
                        o = methodObj.invoke(factoryObj, null);
                    }else {
                        o = aClass.newInstance();
                    }
                }else {//初始创建唯一一个
                    o = SpringIOC.get(beanId);

                }


                return o;
            }
        }
        return null;

    }
}
