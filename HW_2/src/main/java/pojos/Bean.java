package pojos;

public abstract class Bean {
    private String name;
    private int value;

    public Bean(String name, int value) {
        this.name = name;
        this.value = value;
        System.out.println("Bean" + name.toUpperCase() + " created\tname:" + name + "\tvalue: " + value);
    }

    public Bean() {

    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
