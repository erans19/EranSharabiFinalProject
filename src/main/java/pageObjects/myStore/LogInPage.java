package pageObjects.myStore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {

    @FindBy( how = How.CSS, using = "input[id='email']")
    public WebElement Email_field;

    @FindBy( how= How.CSS, using = "input[id='passwd']")
    public WebElement password_field;

    @FindBy( how= How.XPATH, using = "//button[@name='SubmitLogin']")
    public WebElement LogIn_Button;
}
