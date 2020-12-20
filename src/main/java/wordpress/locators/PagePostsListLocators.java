package wordpress.locators;

import org.openqa.selenium.By;

public class PagePostsListLocators {
    public static By buttonAddPost = new By.ByXPath("//div[@class='wrap']/a[@class='page-title-action']");
    public static By itemPost = new By.ByXPath("//a[@class='row-title']");
}
