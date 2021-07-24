package Processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import pojos.Bean;

public class MyPostProcessor implements BeanPostProcessor {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Bean) {
            if (((Bean) bean).getName() == null || ((Bean) bean).getValue() <= 0) {
                System.out.println(ANSI_RED + "VALIDATION FAILED" + ANSI_RESET);
            }
        }
        return bean;
    }

}
