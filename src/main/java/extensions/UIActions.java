package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Send Keyboard keys")
    public static void sendKeys(WebElement elem, Keys value) {
        elem.sendKeys(value);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text) {
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Mouse hover on elements")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).build().perform();
        wait.until(ExpectedConditions.visibilityOf(elem2));
        action.moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse hover on elements")
    public static void mouseHover(WebElement elem1) {
        action.moveToElement(elem1).click().build().perform();
    }

}
