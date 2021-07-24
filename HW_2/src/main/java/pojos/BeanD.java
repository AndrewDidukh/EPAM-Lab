package pojos;

public class BeanD extends Bean {

    public BeanD(String name, int value) {
        super(name, value);
    }

    public void myInitMethod() {
        System.out.println("Inside Init Method\t(D)\n");
    }

    public void myDestroyMethod() {
        System.out.println("Inside Destroy Method\t(D)");
    }
}
