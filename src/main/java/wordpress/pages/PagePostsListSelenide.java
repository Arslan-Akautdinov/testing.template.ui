package wordpress.pages;

import io.qameta.allure.Step;
import wordpress.locators.PagePostsListLocators;
import java.util.List;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PagePostsListSelenide {
    @Step("Переход на страницу добавления постов.")
    public void clickAddPost() {
        $(PagePostsListLocators.buttonAddPost).click();
    }

    @Step("Получение всех имен статей.")
    public List<String> selectPosts() {
        return $$(PagePostsListLocators.itemPost).texts();
    }

    @Step("Проверка на сущевствование статьи.")
    public boolean checkPostIsHave(String articleName) {
        return selectPosts().contains(articleName);
    }
}
