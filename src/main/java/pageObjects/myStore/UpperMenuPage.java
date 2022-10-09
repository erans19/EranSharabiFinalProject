package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class UpperMenuPage {

    @FindBy(how = How.CSS, using = "a[title=Women]")
    public WebElement womenSection;

    //DOM is doubled for some reason, unable to make unique CSS
    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]")
    public WebElement dressesSection;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[3]")
    public WebElement TShirtsSection;

    @FindBy(how = How.CSS, using = "input[id='search_query_top']")
    public WebElement search_field;

    @FindBy(how = How.CSS, using = "button[name='submit_search']")
    public WebElement search_button;


}
