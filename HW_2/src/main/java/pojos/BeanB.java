package pojos;

public class BeanB extends Bean {

    public BeanB(String name, int value) {
        super(name, value);
    }

    public void myInitMethod() {
        System.out.println("Inside Init Method\t(B)\n");
    }

    public void myInitMethodForFactoryPostProcessor() {
        System.out.println("Changed Init Method in BeanFactoryPostProcessor\t(B)\n");
    }

    public void myDestroyMethod() {
        System.out.println("Inside Destroy Method\t(B)");
    }
}
