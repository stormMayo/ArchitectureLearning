
import com.mayol.service.BaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {
    public static void main(String[] args){
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
        BaseService personProxy = (BaseService) factory.getBean("personProxy");
        personProxy.eat();//洗手  吃饭
        personProxy.wc();//wc

    }
}
