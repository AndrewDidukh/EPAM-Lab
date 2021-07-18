package configs;

import beans.phones.Iphone;
import beans.phones.Samsung;
import beans.phones.Stock;
import beans.phones.Xiaomi;
import interfaces.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackageClasses = {Iphone.class, Samsung.class, Xiaomi.class, Stock.class})
public class Config4 {
}
