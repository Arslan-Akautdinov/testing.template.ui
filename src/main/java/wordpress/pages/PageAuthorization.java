package wordpress.pages;

import common.ApplicationManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.locators.PageAuthorizationLocators;


public class PageAuthorization extends PageObject {
    public PageAuthorization(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    @Step("Авторизация.")
    public void actionAuthorize() {
        insertLogin();
        insertPassword();
        clickEnter();
    }


    @Step("Авторизация.")
    public void actionAuthorize(String login, String password)
    {
        insertLogin(login);
        insertPassword(password);
        clickEnter();
    }

    @Step("Ввод логина.")
    public void insertLogin(String login) {
        wd.findElement(PageAuthorizationLocators.inputLogin).sendKeys(login);
    }

    @Step("Ввод пароля.")
    public void insertPassword(String password) {
        wd.findElement(PageAuthorizationLocators.inputPassword).sendKeys(password);
    }

    @Step("Ввод логина.")
    public void insertLogin() {
        Allure.addAttachment("логин", ApplicationManager.config.login);
        insertLogin(ApplicationManager.config.login);
    }

    @Step("Ввод пароля.")
    public void insertPassword() {
        Allure.addAttachment("пароль", ApplicationManager.config.password);
        insertPassword(ApplicationManager.config.password);
    }

    @Step("Нажатие на кнопку 'Войти'. ")
    public void clickEnter() {
        wd.findElement(PageAuthorizationLocators.buttonEnter).click();
    }
}
