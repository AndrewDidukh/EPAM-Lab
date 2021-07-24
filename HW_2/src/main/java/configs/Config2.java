package configs;

import Processors.MyPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import pojos.*;

@Configuration
@Import({Config1.class})
public class Config2 {

    @Bean
    public MyPostProcessor getPP() {
        return new MyPostProcessor();
    }

    @Bean
    @Lazy()
    public BeanF getBeanF() {
        return new BeanF();
    }

    @Bean
    public BeanA getBeanA() {
        return new BeanA();
    }

    @Bean
    public BeanE getBeanE() {
        return new BeanE();
    }
}
