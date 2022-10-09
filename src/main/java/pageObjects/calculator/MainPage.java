package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    @FindBy(how = How.NAME, using = "One")
    public WebElement one_button;

    @FindBy(how = How.NAME, using = "Eight")
    public WebElement eight_button;

    @FindBy(how = How.NAME, using = "Plus")
    public WebElement plus_button;

    @FindBy(how = How.NAME, using = "Equals")
    public WebElement equals_button;

    @FindBy(how = How.NAME, using = "Clear")
    public WebElement clear_button;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement calculator_results;

}
