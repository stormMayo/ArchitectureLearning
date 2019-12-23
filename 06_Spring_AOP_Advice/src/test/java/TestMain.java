
import com.mayol.service.BaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;


public class TestMain {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
        BaseService personProxy = (BaseService) factory.getBean("personProxy");
        personProxy.eat();
        personProxy.wc();

    }
}
