package pageObjects.myStore.proccesingPurchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingShipping_04 {
    @FindBy(how = How.CSS, using = "button[name='processCarrier']")
    public WebElement proceedStep4_Button;

    @FindBy(how = How.CSS, using = "div[id='uniform-cgv']")
    public WebElement IAgreeCheckbox;
}
