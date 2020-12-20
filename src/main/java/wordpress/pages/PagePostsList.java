package wordpress.pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.PageObject;
import wordpress.locators.PagePostsListLocators;

import java.util.ArrayList;
import java.util.Arrays;

public class PagePostsList extends PageObject {
    public PagePostsList(WebDriver _wd, WebDriverWait _waiter) {
        super(_wd, _waiter);
    }

    @Step("Переход на страницу добавления постов.")
    public void clickAddPost() {
        waitElement(PagePostsListLocators.buttonAddPost).click();
    }

    @Step("Получение всех имен статей.")
    public ArrayList<String> selectPosts()
    {
        ArrayList<String> resultList = new ArrayList<>();
        waitElements(PagePostsListLocators.itemPost);
        for (WebElement element: wd.findElements(PagePostsListLocators.itemPost))
        {
            resultList.add(element.getText());
        }
        Allure.addAttachment("статьи", Arrays.toString(resultList.toArray()));
        return resultList;
    }

    @Step("Проверка на сущевствование статьи.")
    public boolean checkPostIsHave(String articleName)
    {
        ArrayList<String> articles = selectPosts();
        return articles.contains(articleName);
    }

}
