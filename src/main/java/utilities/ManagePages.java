package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.myStore.*;
import pageObjects.myStore.proccesingPurchase.*;

public class ManagePages extends Base{

    public static void initMyStore(){
        myStoreLogin = PageFactory.initElements(driver, pageObjects.myStore.LogInPage.class);
        myStoreMain = PageFactory.initElements(driver, pageObjects.myStore.MainPage.class);
        myStoreUpperMenu = PageFactory.initElements(driver, pageObjects.myStore.UpperMenuPage.class);
        myStoreBottomMenu = PageFactory.initElements(driver, pageObjects.myStore.BottomMenuPage.class);
        myStoreOrderHistory = PageFactory.initElements(driver, pageObjects.myStore.OrderHistoryPage.class);
        myStoreDressesSection = PageFactory.initElements(driver, DressesSectionPage.class);
        myStoreWomenSection = PageFactory.initElements(driver, WomenSectionPage.class);
        myStoreSummerDresses = PageFactory.initElements(driver, SummerDressesPage.class);
        myStoreChiffonDress = PageFactory.initElements(driver, ChiffonDressPage.class);
        myStoreBuyingOptions = PageFactory.initElements(driver, BuyingOptFormPage.class);
        myStorePopUpInCart = PageFactory.initElements(driver, PopUpInCartPage.class);
        myStoreSearchResult = PageFactory.initElements(driver, SearchResultPage.class);
        purchaseSummery_01 = PageFactory.initElements(driver, BillingSummery_01.class);
        purchaseAddress_02 = PageFactory.initElements(driver, BillingAddress_03.class);
        purchaseShipping_03 = PageFactory.initElements(driver, BillingShipping_04.class);
        purchasePayment_04 = PageFactory.initElements(driver, BillingPayment_05.class);
        purchaseConfirmation_05 = PageFactory.initElements(driver, BillingConfirmOrder_06.class);
        purchaseConfirmed_06 = PageFactory.initElements(driver, BillingConfirmation_07.class);
    }

    public static void initToDo(){
        todoMain = PageFactory.initElements(driver, pageObjects.todo.MainPage.class);
    }

    public static void initMortgage(){
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
