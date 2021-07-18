package configs;

import beans.phones.Iphone;
import beans.phones.Samsung;
import beans.phones.Xiaomi;
import interfaces.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Samsung.class, Iphone.class, Xiaomi.class})
public class Config5 {

    @Bean
    @Autowired
    Phone getPhone1(Phone phone1){
        return phone1;
    }

    @Bean
    @Autowired
    @Qualifier("iPhone")
    Phone getPhone2(Phone phone2){
        return phone2;
    }

    @Bean
    @Autowired
    @Qualifier("Xiaomi")
    Phone getPhone3(Phone phone3) {
        return phone3;
    }

}

