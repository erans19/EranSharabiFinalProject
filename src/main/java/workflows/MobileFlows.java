package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("fill form and calculate mortgage")
    public static void calculateMortgage(String amount, String term, String rate){
        MobileActions.updateText(mortgageMain.amount_Field, amount);
        MobileActions.updateText(mortgageMain.term_Field, term);
        MobileActions.updateText(mortgageMain.rate_Field, rate);
        MobileActions.tap(mortgageMain.calculate_Button);
    }

}
