package configs;


import beans.other.OtherBeanA;
import beans.other.OtherBeanB;
import beans.other.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(basePackageClasses = {OtherBeanA.class,OtherBeanB.class,OtherBeanC.class})
public class Config3 {


    @Component
    public static class otherBeanA {
        @Autowired
        public void InjectA(OtherBeanA beanA) {
        }
    }

    @Component
    public static class  otherBeanB{
        @Autowired
        public void setBeanB(OtherBeanB beanB) {
        }
    }

    @Component
    public static class otherBeanC{
        @Autowired
        @Qualifier("OtherBeanCQualifier")
        private OtherBeanC beanC;
    }
}