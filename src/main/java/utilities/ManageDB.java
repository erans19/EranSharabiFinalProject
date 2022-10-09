package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

    public static void openConnection(String dbURL, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, password);
            statement = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error while Connecting to Database, Details: " + e);
        }
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error while Closing the Database, Details: " + e);
        }
    }
}