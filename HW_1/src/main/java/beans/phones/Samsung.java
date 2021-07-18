package beans.phones;

import interfaces.Phone;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("Samsung")
@Primary
@Order(2)
public class Samsung implements Phone {
    @Override
    public String getBrand() {
        return "Samsung";
    }
}
