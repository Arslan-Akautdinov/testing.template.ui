package posts;

import fixture.BasicTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wordpress.enums.WPMenu;

import java.util.UUID;

public class TestPosts extends BasicTest {

    @BeforeEach
    public void setUpTestAuth() {
        pages.pageAuthorization.actionAuthorize();
    }

    @Test
    @DisplayName("Создание статьи.")
    public void createPost()
    {
        String postName = UUID.randomUUID().toString();
        pages.barNavigation.navigateTo(WPMenu.POSTS);
        pages.pagePostsList.clickAddPost();
        pages.pagePostEdit.clickCloseModal();
        pages.pagePostEdit.insertPostTitle(postName);
        pages.pagePostEdit.clickPublish();
        pages.pagePostEdit.clickPublishAccept();
        pages.pagePostEdit.checkPublishNotify();
        pages.pagePostEdit.navigateToPostsList();
        pages.pagePostsList.checkPostIsHave(postName);
    }

}
