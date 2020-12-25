package wordpress.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.locators.PagePostsEditLocators;

public class PagePostEdit extends PageObject {
    public PagePostEdit(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    @Step("Закрытие модального окна.")
    public void clickCloseModal()
    {
        waitElement(PagePostsEditLocators.buttonCloseModal).click();
    }

    @Step("Ввод загаловка статьи")
    public void insertPostTitle(String postTitle) {
        waitElement(PagePostsEditLocators.fieldTitle).sendKeys(postTitle);
    }

    @Step("Нажатие на кнопку 'Опубликовать'.")
    public void clickPublish() {
        waitElement(PagePostsEditLocators.buttonPostCreate).click();
    }

    @Step("Нажатие на кнопку подтверждения 'Опубликовать'.")
    public void clickPublishAccept() {
        waitElement(PagePostsEditLocators.buttonPostCreateAccept).click();
    }

    @Step("Проверка нотификации о создании записи")
    public void checkPublishNotify() {
        attachPng("Скрин");
    }

    @Step("Переход на страницу постов.")
    public void navigateToPostsList() {
        actions
                .moveToElement(waitElement(PagePostsEditLocators.buttonGoToPostsList))
                .click()
                .perform();
    }

}
