package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Addition: 1 + 8")
    public static void calculateAddition(){
        UIActions.click(calcMain.clear_button);
        UIActions.click(calcMain.one_button);
        UIActions.click(calcMain.plus_button);
        UIActions.click(calcMain.eight_button);
        UIActions.click(calcMain.equals_button);
    }
}
