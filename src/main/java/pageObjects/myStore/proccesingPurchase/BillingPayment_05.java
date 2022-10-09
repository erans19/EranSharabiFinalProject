package pageObjects.myStore.proccesingPurchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingPayment_05 {
    @FindBy(how = How.CSS, using = "a[class='bankwire']")
    public WebElement payByBankWire_Button;

    @FindBy(how = How.CSS, using = "span[id='total_price']")
    public WebElement totalCartValue;

}
