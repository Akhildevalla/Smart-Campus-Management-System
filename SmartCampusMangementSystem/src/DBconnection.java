import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/smart_campus",
                    "root",
                    "Akhil@123");

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
        }

        return con;
    }
}