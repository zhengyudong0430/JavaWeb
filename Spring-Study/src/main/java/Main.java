import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
       /* Object o = context.getBean("myName");
        System.out.println(o.getClass());
        System.out.println(o);*/
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
            System.out.println(context.getBean(name));
            System.out.println("====================================");
        }
    }
}