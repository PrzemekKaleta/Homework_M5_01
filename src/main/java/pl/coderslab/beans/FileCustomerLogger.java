package pl.coderslab.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.pojo.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
//@Primary
public class FileCustomerLogger implements CustomerLogger {

    private String filename = "LogFile";
    @Override
    public void log(Customer customer) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.append(LocalDateTime.now().toString() + String.format(" ID: %d , Name: %s, Surname: %s", customer.getId(), customer.getFirstName(), customer.getLastName()) + '\n');
            fileWriter.close();
        }catch (IOException e){
            System.out.println(e.getCause());
        }

    }
}
