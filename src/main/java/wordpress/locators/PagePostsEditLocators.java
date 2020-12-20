package wordpress.locators;

import org.openqa.selenium.By;

public class PagePostsEditLocators {
    public static By buttonCloseModal = new By.ByXPath("//button[@aria-label='Закрыть окно']");
    public static By buttonPostCreate = new By.ByXPath("//button[text() = 'Опубликовать']");
    public static By buttonPostCreateAccept = new By.ByXPath("//div[@class = 'editor-post-publish-panel__header']//button");
    public static By fieldTitle = new By.ById("post-title-0");
    public static By buttonGoToPostsList = new By.ByXPath("//div[@class='edit-post-header']/a");

}
