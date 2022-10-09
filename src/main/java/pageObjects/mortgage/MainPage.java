package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {

    private AndroidDriver<AndroidElement> mobileDriver;

    public MainPage(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(20)), this);
    }
    @AndroidFindBy(id = "etAmount")
    public static AndroidElement amount_Field;

    @AndroidFindBy(id = "etTerm")
    public static AndroidElement term_Field;

    @AndroidFindBy(id = "etRate")
    public static AndroidElement rate_Field;

    @AndroidFindBy(id = "btnCalculate")
    public static  AndroidElement calculate_Button;

    @AndroidFindBy(id = "tvRepayment")
    public static AndroidElement repayment_Field;
}
