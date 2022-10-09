package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import extensions.Accessories;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import javax.swing.text.Utilities;
import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class MyStoreWeb extends CommonOps {

    @Test(description = "Test01 - Verify Header")
    @Description("This Test login and verifies the main header")
    public void test01_VerifyHeader() {
        WebFlows.login(getData("Username"), getData("Password"));
        Verifications.verifyTextInElement(myStoreMain.heading_MyAccount, "MY ACCOUNT");
    }


    @Test(description = "Test02 - asserting purchase")
    @Description("This Test makes a purchase with random price, and verifies purchase completed")
    public void test02_VerifyPurchase() {
        UIActions.mouseHover(myStoreUpperMenu.dressesSection, myStoreDressesSection.summerDresses);
        UIActions.mouseHover(myStoreSummerDresses.summerDressesHover.get(2), myStoreSummerDresses.summerDressesPick.get(2));
        wait.until(ExpectedConditions.visibilityOf(myStoreChiffonDress.chiffonDressHeader));
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        String expectedPrice;
        String expectedDate = Accessories.getCurrentDate();
        int quantity = Accessories.generateNumber(1, 99);
        myStoreBuyingOptions.quantity_field.clear();
        UIActions.updateText(myStoreBuyingOptions.quantity_field, "" + quantity);
        UIActions.updateDropDown(myStoreBuyingOptions.size_options, "M");
        UIActions.click(myStoreBuyingOptions.colorGreen);
        UIActions.click(myStoreBuyingOptions.addToCart_button);
//        wait.until(ExpectedConditions.elementToBeClickable(myStorePopUpInCart.proceedToCheckout_Button));
        UIActions.click(myStorePopUpInCart.proceedToCheckout_Button);

//        wait.until(ExpectedConditions.elementToBeClickable(purchaseSummery_01.ProceedStep1_Button));
        UIActions.click(purchaseSummery_01.ProceedStep1_Button);

//        wait.until(ExpectedConditions.elementToBeClickable(purchaseAddress_02.ProceedStep3_Button));
        UIActions.click(purchaseAddress_02.ProceedStep3_Button);

//        wait.until(ExpectedConditions.elementToBeClickable(purchaseShipping_03.proceedStep4_Button));
        UIActions.click(purchaseShipping_03.IAgreeCheckbox);
        UIActions.click(purchaseShipping_03.proceedStep4_Button);

        wait.until(ExpectedConditions.visibilityOf(purchasePayment_04.payByBankWire_Button));
        expectedPrice = purchasePayment_04.totalCartValue.getText();
        UIActions.click(purchasePayment_04.payByBankWire_Button);

//        wait.until(ExpectedConditions.elementToBeClickable(purchaseConfirmation_05.confirmOrder_Button));
        UIActions.click(purchaseConfirmation_05.confirmOrder_Button);
//        wait.until(ExpectedConditions.visibilityOf(purchaseConfirmed_06.orderConfirmedHeader));
        UIActions.click(purchaseConfirmed_06.backToOrdersButton);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Verifications.verifyDateOnElement(myStoreOrderHistory.lastOrderDate, expectedDate);
        Verifications.verifyTextInElement(myStoreOrderHistory.lastOrderPrice, expectedPrice);
    }


    @Test(description = "Test03 - Visually Verify Image")
    @Description("This Test visually verifies the image in the top left of the site")
    public void test03_VerifyImage() {
        Verifications.visualElement("MYSTOREWOMAN");
    }

    @Test(description = "Test04 - Search Clothes", dataProvider = "data-provider-clothes", dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searches Cloth using DDT")
    public void test04_searchCloth(String cloth, String doesExists) {
        WebFlows.searchAndVerifyCloth(cloth, doesExists);
    }

    @Test(description = "ascii")
    public void test05_Ascii_For_Presentation(){
        Accessories.Print();
    }
}
