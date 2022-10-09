package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class MyStoreWebDB extends CommonOps {
    @Test(description = "Test01 - Login to My Store with DB")
    @Description("This Test login with DB credentials and verifies the main header")
    public void test01_loginDBAndVerifyHeader(){
        WebFlows.loginDB();
        Verifications.verifyTextInElement(myStoreMain.heading_MyAccount, "MY ACCOUNT");
    }
}
