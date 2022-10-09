package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SummerDressesPage {
    @FindBy(how = How.CSS, using = "a[title='View']")
    public List <WebElement> summerDressesPick;

    @FindBy(how = How.CSS, using = "h5[itemprop='name']")
    public List <WebElement> summerDressesHover;
}
