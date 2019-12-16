package util;

import java.util.List;

public class BeanFactory {
    private List<BeanDefined> beanDefinedList;

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }
    public Object getBean(String beanId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object o;
        for(BeanDefined beanObj:this.beanDefinedList){
            if(beanId.equals(beanObj.getBeanId())){
                String classPath = beanObj.getClassPath();
                Class<?> aClass = Class.forName(classPath);
                //在默认情况下，Spring工厂调用默认构造放方法创建实例对象
                o = aClass.newInstance();
                return o;
            }
        }
        return null;

    }
}
