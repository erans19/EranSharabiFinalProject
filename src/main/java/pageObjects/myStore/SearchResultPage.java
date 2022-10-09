package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchResultPage {
    @FindBy(how = How.CSS, using = "ul[class='product_list grid row']")
    public List<WebElement> resultOfSearch;
}
