package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;


public class WebFlows extends CommonOps {

    @Step("Login to my store")
    public static void login(String username, String password){
        UIActions.updateText(myStoreLogin.Email_field, username);
        UIActions.updateText(myStoreLogin.password_field, password);
        UIActions.click(myStoreLogin.LogIn_Button);
    }

    @Step("Login to my store with Database Credentials")
    public static void loginDB(){
        String query = "SELECT email, password FROM Employees WHERE id='1'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(myStoreLogin.Email_field, cred.get(0));
        UIActions.updateText(myStoreLogin.password_field, cred.get(1));
        UIActions.click(myStoreLogin.LogIn_Button);

    }

    @Step("Search cloth and verify it")
    public static void searchAndVerifyCloth(String text, String shouldExist){
        UIActions.updateText(myStoreUpperMenu.search_field, text);
        UIActions.click(myStoreUpperMenu.search_button);
        if(shouldExist.equalsIgnoreCase("exists"))
            Verifications.isElementExist(myStoreSearchResult.resultOfSearch);
        else if (shouldExist.equalsIgnoreCase("not-exists"))
            Verifications.isElementNotExist(myStoreSearchResult.resultOfSearch);
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven Testing, Should be 'exists' or 'not-exists'");
    }
}
