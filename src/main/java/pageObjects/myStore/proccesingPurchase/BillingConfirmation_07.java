package pageObjects.myStore.proccesingPurchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingConfirmation_07 {

    @FindBy(how = How.CSS, using = "h1[class='page-heading']")
    public WebElement orderConfirmedHeader;

    @FindBy(how = How.CSS, using = "a[title='Back to orders']")
    public WebElement backToOrdersButton;
}
