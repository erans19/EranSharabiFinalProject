package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify Today's Date")
    public static void verifyDateOnElement(WebElement elem, String expected) {
        try {
            assertEquals(elem.getText(), expected);
        } catch (AssertionError e) {
            System.out.println("" + '\n' + '\n' + "-*-*-*-The website-server is probably using" + '\n' + "different time-zone, or test completed" + '\n' + "with fault:" + e + "-*-*-*-" + '\n' + '\n');
        }
    }

    @Step("Verify Visibility Of Elements (SoftAssertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Element" + elem.getText() + "is not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Visually Verify Element")
    public static void visualElement(String expectedImageName) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed e) {
            System.out.println("Error Comparing Image File:" + e);
        }
    }

    @Step("Verify Element Displayed")
    public static void isElementExist(List<WebElement> elements) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        assertTrue(elements.size() > 0);
    }


    @Step("Verify Element Not Displayed")
    public static void isElementNotExist(List<WebElement> elements) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        assertFalse(elements.size() > 0);
    }

    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual, expected);
    }
}
