import frank.Duck3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");
        /*for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
            System.out.println(context.getBean(name));
            System.out.println("====================================");
        }*/
        Duck3 duck1 = (Duck3) context.getBean("dk1");
        System.out.println(duck1);
        Duck3 duck2 = (Duck3) context.getBean("dk2");
        System.out.println(duck1);
        Duck3 duck3 = (Duck3) context.getBean("dk3");
        System.out.println(duck1);
    }

}
