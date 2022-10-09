package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)

public class MortgageMobile extends CommonOps {


    @Test(description = "Test01 - Verify Mortgage")
    @Description("This Test fill in mortgage field and calculate repayment")
    public void test01_VerifyMortGage(){
        MobileFlows.calculateMortgage("1000", "3", "4");
        Verifications.verifyTextInElement(mortgageMain.repayment_Field, "£30.03");
    }
}
