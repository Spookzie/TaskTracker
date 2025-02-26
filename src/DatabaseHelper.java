// This class handles the MySQL connection

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseHelper
{
    private static final String url = "jdbc:mysql://localhost:3306/TaskTrackerDB";
    private static final String user = "root";
    private static final String password = "Spookzie@123";


    public static Connection Connect()
    {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, password);
            System.err.println("Connection established successfully");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check the entered credentials");
            e.printStackTrace();
        }


        return con;
    }

    public static void Close(Connection connection)
    {
        try {
            if(connection != null)
            {
                connection.close();
                System.err.println("Database connection successfully closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}