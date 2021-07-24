package pojos;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE extends Bean {

    public BeanE() {
        System.out.println("BeanE" + " created\tname:" + super.getName() + "\tvalue: " + super.getValue());
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Inside postConstruct\t(E)\n");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Inside preDestroy\t(E)");
    }
}
