package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.CSS, using = "h1[class='page-heading']")
    public WebElement heading_MyAccount;
}
