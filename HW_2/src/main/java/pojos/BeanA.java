package pojos;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA extends Bean implements InitializingBean, DisposableBean {

    public BeanA() {
        System.out.println("BeanA" + " created\tname:" + super.getName() + "\tvalue: " + super.getValue());
    }

    @Override
    public void destroy() {
        System.out.println("Inside destroy\t(A)");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Inside afterPropertiesSet\t(A)\n");
    }
}
