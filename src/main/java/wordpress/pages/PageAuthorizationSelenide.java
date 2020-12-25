package wordpress.pages;

import common.ApplicationManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import wordpress.locators.PageAuthorizationLocators;

import static com.codeborne.selenide.Selenide.$;

public class PageAuthorizationSelenide {
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
        $(PageAuthorizationLocators.inputLogin).setValue(login);
    }

    @Step("Ввод пароля.")
    public void insertPassword(String password) {
        $(PageAuthorizationLocators.inputPassword).setValue(password);
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
        $(PageAuthorizationLocators.buttonEnter).click();
    }
}
