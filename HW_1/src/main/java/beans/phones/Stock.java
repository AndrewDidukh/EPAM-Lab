package beans.phones;

import interfaces.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Stock {
    @Autowired
    private List<Phone> phones;

    public void printStock(){
        for (Phone phone : phones) {
            System.out.println(phone.getBrand());
        }
    }
}
