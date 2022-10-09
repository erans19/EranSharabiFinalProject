package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BottomMenuPage {
    @FindBy(how = How.LINK_TEXT, using = "Women")
    public WebElement bottomWomen;

    @FindBy(how = How.CSS, using = "a[title='Specials']")
    public WebElement infoSpecials;

    @FindBy(how = How.CSS, using = "a[title='New products']")
    public WebElement infoNewProducts;

    @FindBy(how = How.CSS, using = "a[title='Best sellers']")
    public WebElement infoBestSellers;

    @FindBy(how = How.CSS, using = "a[title='Our stores']")
    public WebElement infoOurStores;

    @FindBy(how = How.CSS, using = "a[title='Contact us']")
    public WebElement infoContactUs;

    @FindBy(how = How.CSS, using = "a[title='Terms and conditions of use']")
    public WebElement infoTerms;

    @FindBy(how = How.CSS, using = "a[title='About us']")
    public WebElement infoAboutUs;

    @FindBy(how = How.CSS, using = "a[title='Sitemap']")
    public WebElement infoSitemap;

    @FindBy(how = How.CSS, using = "a[title='My orders']")
    public WebElement accountOrders;

    @FindBy(how = How.CSS, using = "a[title='My credit slips']")
    public WebElement accountCreditSlips;

    @FindBy(how = How.CSS, using = "a[title='My addresses']")
    public WebElement accountAddresses;

    @FindBy(how = How.CSS, using = "a[title='Manage my personal information']")
    public WebElement accountPersonalInfo;

    @FindBy(how = How.CSS, using = "a[title='Sign out']")
    public WebElement accountSignOut;
}
