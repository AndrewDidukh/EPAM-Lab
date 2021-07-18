package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import beans.beans3.BeanE;

@Configuration
@ComponentScan(basePackages = {"beans.beans2", "beans.beans3"},excludeFilters =@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = BeanE.class) )
public class Config2 {
}
