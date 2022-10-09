package pageObjects.myStore.proccesingPurchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingSummery_01 {
    @FindBy(how = How.CSS, using = "a[class='button btn btn-default standard-checkout button-medium']")
    public WebElement ProceedStep1_Button;
}
