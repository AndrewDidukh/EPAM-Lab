package beans.phones;

import interfaces.Phone;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("Xiaomi")
@Order(3)
public class Xiaomi implements Phone {
    @Override
    public String getBrand() {
        return "Xiaomi";
    }
}
