package sanity;

import utilities.CommonOps;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import workflows.DesktopFlows;

@Listeners({utilities.Listeners.class})
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test 01: Verify Addition Command")
    @Description("This Test Verify Addition Command")
    public void test01_verifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElement(calcMain.calculator_results, "Display is 9");
    }
}