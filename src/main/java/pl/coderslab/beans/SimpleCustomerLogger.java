package pl.coderslab.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.pojo.Customer;

import java.time.LocalDateTime;

@Component
//@Primary
public class SimpleCustomerLogger implements CustomerLogger {

    @Override
    public void log(Customer customer) {
        System.out.println(LocalDateTime.now().toString() + String.format(" ID: %d , Name: %s, Surname: %s", customer.getId(), customer.getFirstName(), customer.getLastName()));
    }
}
