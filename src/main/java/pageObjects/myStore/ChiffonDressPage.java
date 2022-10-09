package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChiffonDressPage {
    @FindBy(how = How.CSS, using = "h1[itemprop='name']")
    public WebElement chiffonDressHeader;
}
