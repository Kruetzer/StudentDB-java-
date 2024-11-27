package StudentDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "TesterAdmin12345";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                try (Statement statement = connection.createStatement()) {
                    String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS test";
                    statement.executeUpdate(createDatabaseSQL);
                    System.out.println("Database 'test' created successfully.");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}