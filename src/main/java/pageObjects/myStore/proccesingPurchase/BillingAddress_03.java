package pageObjects.myStore.proccesingPurchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingAddress_03 {
    @FindBy(how = How.CSS, using = "button[name='processAddress']")
    public WebElement ProceedStep3_Button;
}
