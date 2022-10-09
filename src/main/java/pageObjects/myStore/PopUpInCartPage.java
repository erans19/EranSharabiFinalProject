package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PopUpInCartPage {
    @FindBy(how = How.CSS, using = "a[title='Proceed to checkout']")
    public WebElement proceedToCheckout_Button;
}
