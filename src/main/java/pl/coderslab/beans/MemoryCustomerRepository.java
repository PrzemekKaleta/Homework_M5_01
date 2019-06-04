package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.pojo.Customer;

import java.util.ArrayList;

@Component
public class MemoryCustomerRepository implements CustomerRepository {

    private ArrayList<Customer> allCustomers = new ArrayList<>();
    private CustomerLogger customerLogger;

    @Autowired
    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
            }

    @Override
    public void addCustomer(Customer customer) {
        allCustomers.add(customer);
        customerLogger.log(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        if(allCustomers.contains(customer)) {
            allCustomers.remove(customer);
            customerLogger.log(customer);
        }else{
            System.out.println("can't remove this Customer, it is not in memory");
        }
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }
}
