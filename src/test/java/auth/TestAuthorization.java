package auth;

import fixture.BasicTest;
import org.junit.jupiter.api.*;

public class TestAuthorization extends BasicTest {
    @BeforeEach
    public void setUpTestAuth() {
        pages.pageAuthorization.actionAuthorize();
    }

    @Test
    @DisplayName("Авторизация.")
    public void auth() {
        Assertions.assertTrue(pages.barHeader.isLogin(), "Вход в аккаунт не был выполнен.");
    }

    @Test
    @DisplayName("Выход из профиля.")
    public void unAuth() {
        pages.barHeader.clickLogOut();
        Assertions.assertTrue(pages.barHeader.isNotLogin(), "Выход из аккаунта не был выполнен.");
    }
}
