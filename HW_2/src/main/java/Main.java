import configs.Config2;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojos.BeanF;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
        context.getBean(BeanF.class);
        System.out.println("\n\n=======Tasks 1-12 done=======\n\n");

        context.close();
    }
}
