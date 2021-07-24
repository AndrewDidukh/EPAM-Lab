package configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pojos.BeanB;
import pojos.BeanC;
import pojos.BeanD;
import Processors.MyBeanFactoryPostProcessor;


@Configuration
@PropertySource("classpath:bcd.properties")
public class Config1 {

    @Value("${beanB.name}")
    private String beanBName;
    @Value("${beanB.value}")
    private int beanBValue;
    @Value("${beanC.name}")
    private String beanCName;
    @Value("${beanC.value}")
    private int beanCValue;
    @Value("${beanD.name}")
    private String beanDName;
    @Value("${beanD.value}")
    private int beanDValue;

    @Bean
    public static MyBeanFactoryPostProcessor getBFPP() {
        return new MyBeanFactoryPostProcessor();
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanD getBeanD() {
        return new BeanD(beanDName, beanDValue);
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanB BeanB() {
        return new BeanB(beanBName, beanBValue);
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanC getBeanC() {
        return new BeanC(beanCName, beanCValue);
    }
}
