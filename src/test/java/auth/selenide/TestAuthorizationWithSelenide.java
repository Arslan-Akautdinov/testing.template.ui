package auth.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import common.ApplicationManager;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import wordpress.locators.PageAuthorizationLocators;
import wordpress.pages.PageAuthorization;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;


@ExtendWith(SeleniumJupiter.class)
public class TestAuthorizationWithSelenide {

    @ParameterizedTest
    @CsvSource("admin, admin")
    public void test(String login, String password)
    {
        open(ApplicationManager.config.url);
        $(PageAuthorizationLocators.inputLogin).setValue(login);
        $(PageAuthorizationLocators.inputPassword).setValue(password).pressEnter();
        $$("asdasd").shouldHave(sizeGreaterThanOrEqual(10));
        // $(PageAuthorizationLocators.buttonEnter).click();
    }

    @ParameterizedTest
    @CsvSource("admin, admin")
    public void testDriver(String login, String password, ChromeDriver driver){
        driver.get(ApplicationManager.config.url);
        WebElement element = driver.findElement(PageAuthorizationLocators.inputLogin);
        element.sendKeys(login);
        WebElement elementPassword = driver.findElement(PageAuthorizationLocators.inputPassword);
        elementPassword.sendKeys(password);
        elementPassword.sendKeys(Keys.ENTER);

    }

}
