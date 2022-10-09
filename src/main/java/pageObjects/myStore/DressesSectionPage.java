package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class DressesSectionPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
    public WebElement casualDresses;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a")
    public WebElement eveningDresses;

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")
    public WebElement summerDresses;
}
