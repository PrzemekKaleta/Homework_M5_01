package pl.coderslab;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.CustomerRepository;
import pl.coderslab.pojo.Customer;

public class SpringDiApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Customer customer1 = new Customer(1, "Jan", "Nowak");
        Customer customer2 = new Customer(2, "Tomasz", "Kowalski");

        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
        customerRepository.addCustomer(customer1);

        System.out.println(customerRepository.getAllCustomers());

        customerRepository.addCustomer(customer2);

        System.out.println(customerRepository.getAllCustomers());

        customerRepository.deleteCustomer(customer1);

        System.out.println(customerRepository.getAllCustomers());

        context.close();
    }
}
