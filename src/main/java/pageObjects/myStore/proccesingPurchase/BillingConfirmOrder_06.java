package pageObjects.myStore.proccesingPurchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingConfirmOrder_06 {
    @FindBy(how = How.CSS, using = "button[class='button btn btn-default button-medium']")
    public WebElement confirmOrder_Button;
}
