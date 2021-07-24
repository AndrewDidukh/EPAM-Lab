package pojos;

public class BeanC extends Bean {

    public BeanC(String name, int value) {
        super(name, value);
    }

    public void myInitMethod() {
        System.out.println("Inside Init Method\t(C)\n");
    }

    public void myDestroyMethod() {
        System.out.println("Inside Destroy Method\t(C)");
    }
}
