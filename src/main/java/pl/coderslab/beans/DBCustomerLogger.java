package pl.coderslab.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.pojo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@Primary
public class DBCustomerLogger implements CustomerLogger {

    private static final String CREATE_QUERY = "INSERT INTO database_m5.custom_log (custom_id , first_name , last_name) VALUES (?, ?, ?);";
    @Override
    public void log(Customer customer) {

        try(Connection connection = DBConnections.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);

            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setString(2,customer.getFirstName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.executeUpdate();

            System.out.println("Log to DB");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
