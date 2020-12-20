package wordpress.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.locators.BarHeaderLocators;

public class BarHeader extends PageObject {
    public BarHeader(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    public void hoverOnAccount() {
        actions
                .moveToElement(wd.findElement(BarHeaderLocators.account))
                .perform();
    }

    public void clickLogOut() {
        hoverOnAccount();
        waitElement(BarHeaderLocators.buttonLogOut).click();
    }

    public boolean isLogin() {
       return wd.findElements(BarHeaderLocators.account).size() != 0;
    }

    public boolean isNotLogin() {
        return wd.findElements(BarHeaderLocators.account).size() == 0;
    }
}
