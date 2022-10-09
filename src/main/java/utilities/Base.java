package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.myStore.BuyingOptFormPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    //Web
    protected static WebDriver driver;

    //Mobile

    protected static pageObjects.mortgage.MainPage mortgageMain;
    protected static AndroidDriver<AndroidElement> mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database
    protected static Connection con;
    protected static Statement statement;
    protected static ResultSet rs;

    // Page Objects - Web
    protected static pageObjects.myStore.LogInPage myStoreLogin;
    protected static pageObjects.myStore.MainPage myStoreMain;
    protected static pageObjects.myStore.UpperMenuPage myStoreUpperMenu;
    protected static pageObjects.myStore.BottomMenuPage myStoreBottomMenu;
    protected static pageObjects.myStore.OrderHistoryPage myStoreOrderHistory;
    protected static pageObjects.myStore.DressesSectionPage myStoreDressesSection;
    protected static pageObjects.myStore.WomenSectionPage myStoreWomenSection;
    protected static pageObjects.myStore.SummerDressesPage myStoreSummerDresses;
    protected static pageObjects.myStore.ChiffonDressPage myStoreChiffonDress;
    protected static BuyingOptFormPage myStoreBuyingOptions;
    protected static pageObjects.myStore.PopUpInCartPage myStorePopUpInCart;
    protected static pageObjects.myStore.SearchResultPage myStoreSearchResult;
    protected static pageObjects.myStore.proccesingPurchase.BillingSummery_01 purchaseSummery_01;
    protected static pageObjects.myStore.proccesingPurchase.BillingAddress_03 purchaseAddress_02;
    protected static pageObjects.myStore.proccesingPurchase.BillingShipping_04 purchaseShipping_03;
    protected static pageObjects.myStore.proccesingPurchase.BillingPayment_05 purchasePayment_04;
    protected static pageObjects.myStore.proccesingPurchase.BillingConfirmOrder_06 purchaseConfirmation_05;
    protected static pageObjects.myStore.proccesingPurchase.BillingConfirmation_07 purchaseConfirmed_06;


    // Page Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;

    // Page Objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;
}
