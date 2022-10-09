package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import io.appium.java_client.android.AndroidElement;

public class CommonOps extends Base {

    /*
    #######################################
    Method Name: getData
    Method Description: This Method get the data from xml config. file
    Method Parameters: String
    Method Return: String
    #######################################
     */

    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error Reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }
   /*
    #######################################
    Method Name: initBrowser
    Method Description: This Method get browser name as string, and initiate the desirable driver
    Method Parameters: String
    Void Method
    #######################################
     */

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else if (browserType.equalsIgnoreCase("edge"))
            driver = initEdgeDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initMyStore();

    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }

 /*
    #######################################
    Method Name: initElectron
    Method Description: This Method gets the Electron Driver path from DataConfig.xml file
    and initiate the electron driver
    Method Parameters: Null
    Void Method
    #######################################
     */


    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }


 /*
    #######################################
    Method Name: initAPI
    Method Description: This Method gets base URI from DataConfig.xml file
    and username and password, and start desirable httpRequst
    Method Parameters: Null
    Void Method
    #######################################
     */

    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("UsernameAPI"), getData("PasswordAPI"));
    }

 /*
    #######################################
    Method Name: initDesktop
    Method Description: This Method Starts Windows Driver for Desktop Apps, and initiate the desirable App.
    Method Parameters: Null
    Void Method
    #######################################
     */


    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("DesktopServer")), dc);
        } catch (MalformedURLException e) {
            System.out.println("Can not Connect to Appium Server, See Details :" + e);
        }
        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
    }


 /*
    #######################################
    Method Name: initMobile
    Method Description: This Method sets the needed parameters, and Mobile Driver, for
    integration with mobile applications.
    and username and password, and start desirable httpRequst
    Method Parameters: Null
    Void Method
    #######################################
     */

    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.NO_RESET, true);
//        dc.setCapability("reportDirectory", getData("ReportDir"));
//        dc.setCapability("reportFormat", getData("ReportFormat"));
//        dc.setCapability("testName", getData("testName"));
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Cannot Connect To Appium Server, See Details:" + e);
        }
        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        mobileDriver.setLogLevel(Level.INFO);
    }


    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (platform.equalsIgnoreCase("webDB"))
            initBrowser(getData("BrowserName"));
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");

        softAssert = new SoftAssert();
        screen = new Screen();

        if (!platform.equalsIgnoreCase("mobile"))
            if (!platform.equalsIgnoreCase("api")) {
                action = new Actions(driver);
            }

        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));
    }

    @AfterClass
    public void closeSession() {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
    }

}
