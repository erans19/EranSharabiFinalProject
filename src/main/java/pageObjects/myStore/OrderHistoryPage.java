package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderHistoryPage {
    @FindBy(how = How.CSS, using = "tr[class='first_item '] td[class='history_date bold']")
    public WebElement lastOrderDate;

    @FindBy(how = How.CSS, using = "tr[class='first_item '] td[class='history_price']")
    public WebElement lastOrderPrice;
}
