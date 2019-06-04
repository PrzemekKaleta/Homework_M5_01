package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBConnections {
    private static final String DB_name = "database_m5";
    private static final String DB_user = "root";
    private static final String DB_password = "coderslab";
    private static final String DB_port = "3306";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:" + DB_port + "/" + DB_name + "?useSSL=false&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                DB_user,
                DB_password);

        return connection;
    }
}

//Polecenia do utworzenia bazy danych:

/*
    CREATE TABLE database_m5.custom_log
        (
        id INT auto_increment primary key,
        time_event DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        custom_id INT,
        first_name VARCHAR(100),
        last_name VARCHAR(100)
        );
        */
