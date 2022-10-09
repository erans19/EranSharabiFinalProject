package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get Credentials from Database")
    public static List<String> getCredentials(String query) {
        List<String> credentials = new ArrayList<String>();
        try {
            rs = statement.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        } catch (Exception e) {
            System.out.println("Error while Interacting with Data from the DataBase: " + e);
        }
        return credentials;
    }
}
