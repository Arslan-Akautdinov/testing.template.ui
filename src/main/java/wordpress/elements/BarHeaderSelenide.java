package wordpress.elements;


import wordpress.locators.BarHeaderLocators;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class BarHeaderSelenide {
    public void clickLogOut() {
        $(BarHeaderLocators.account).hover();
        $(BarHeaderLocators.buttonLogOut).should(exist).click();
    }

    public boolean isLogin() {
        return $(BarHeaderLocators.account).exists();
    }
}
