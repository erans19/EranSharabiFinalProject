package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuyingOptFormPage {
    @FindBy(how = How.CSS, using = "form[id='buy_block']")
    public WebElement accessForm;

    @FindBy(how = How.CSS, using = "span[id='our_price_display']")
    public WebElement itemPrice;

    @FindBy(how = How.CSS, using = "input[id='quantity_wanted']")
    public WebElement quantity_field;

    @FindBy(how = How.CSS, using = "select[id='group_1']")
    public WebElement size_options;

    @FindBy(how = How.CSS, using = "a[title='Green']")
    public WebElement colorGreen;

    @FindBy(how = How.CSS, using = "a[title='Yellow']")
    public WebElement colorYellow;

    @FindBy(how = How.CSS, using = "button[class='exclusive']")
    public WebElement addToCart_button;
}
