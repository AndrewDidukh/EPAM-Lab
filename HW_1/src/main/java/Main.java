import beans.phones.Stock;
import configs.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String LINE = "\n==================================\n";
    private static ApplicationContext applicationContext;


    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("task 1-3\tpress '1'\ntask 4  \tpress '2'\ntask 5-6\tpress '3'\ntask 7  \tpress '4'\ntask 8  \tpress '5'\n\nfor exit press 'ENTER'");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            switch (reader.readLine()) {
                case "1":
                    Main.applicationContext = new AnnotationConfigApplicationContext(Config1.class);
                    Main.getBeanNames();
                    System.out.println(LINE);
                    break;
                case "2":
                    Main.applicationContext = new AnnotationConfigApplicationContext(Config2.class);
                    Main.getBeanNames();
                    System.out.println(LINE);
                    break;
                case "3":
                    Main.applicationContext = new AnnotationConfigApplicationContext(Config3.class);
                    Main.getBeanNames();
                    System.out.println(LINE);
                    break;
                case "4":
                    Main.applicationContext = new AnnotationConfigApplicationContext(Config4.class);
                    Main.getBeanNames();
                    System.out.println();
                    Main.applicationContext.getBean(Stock.class).printStock();
                    System.out.println(LINE);
                    break;
                case "5":
                    Main.applicationContext = new AnnotationConfigApplicationContext(Config5.class);
                    Main.getBeanNames();
                    System.out.println(LINE);
                    break;
                case "":
                    System.exit(0);
                default:
                    System.out.println("Wrong input, try again!");
                    System.out.println(LINE);
                    break;
            }
        }

    }

    public static void getBeanNames() {
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
