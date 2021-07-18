package beans.phones;

import interfaces.Phone;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("iPhone")
@Order(1)
public class Iphone implements Phone {
    @Override
    public String getBrand() {
        return "Apple";
    }
}
