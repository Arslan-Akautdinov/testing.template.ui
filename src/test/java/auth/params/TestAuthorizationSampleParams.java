package auth.params;

import fixture.BasicTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.*;
import utils.aggregators.TestAuthorizationAggregator;
import utils.models.AuthUser;

import java.util.stream.Stream;

@DisplayName("Авторизация с параметрами.")
public class TestAuthorizationSampleParams extends BasicTest {

    @ParameterizedTest(name = "login and password {0} - Параметризация строками.")
    @ValueSource(strings = {"admin:admin"})
    public void authWithString(String cred) {
        String[] arr = cred.split(":");
        pages.pageAuthorization.actionAuthorize(arr[0], arr[1]);
        Assertions.assertTrue(pages.barHeader.isLogin(), "Вход в аккаунт не был выполнен.");
    }

    @ParameterizedTest(name = "login {0} password {1} - Параметризация строками.")
    @CsvSource({"admin, admin"})
    public void authWithCsvParams(String login, String password) {
        pages.pageAuthorization.actionAuthorize(login, password);
        Assertions.assertTrue(pages.barHeader.isLogin(), "Вход в аккаунт не был выполнен.");
    }

    @DisplayName("Параметризация с ArgumentAggregator.")
    @ParameterizedTest(name = "login {0} password {1} - Параметризация строками.")
    @CsvSource({"admin, admin"})
    public void authWithProvider(@AggregateWith(TestAuthorizationAggregator.class) AuthUser user)
    {
        pages.pageAuthorization.actionAuthorize(user.email, user.password);
        Assertions.assertTrue(pages.barHeader.isLogin(), "Вход в аккаунт не был выполнен.");
        pages.barHeader.clickLogOut();
    }

    @DisplayName("Параметризация с MethodSource.")
    @ParameterizedTest(name = "login and password {0} - Параметризация строками.")
    @MethodSource("provideParameters")
    public void authWithMethodSource(String login, String password) {
        pages.pageAuthorization.actionAuthorize(login, password);
        Assertions.assertTrue(pages.barHeader.isLogin(), "Вход в аккаунт не был выполнен.");
        pages.barHeader.clickLogOut();
    }

    @DisplayName("Параметризация с CsvFile.")
    @ParameterizedTest(name = "login and password {0} - Параметризация строками.")
    @CsvFileSource(resources = "/users.csv")
    public void authWithCsvFile(String login, String password) {
        pages.pageAuthorization.actionAuthorize(login, password);
        Assertions.assertTrue(pages.barHeader.isLogin(), "Вход в аккаунт не был выполнен.");
        pages.barHeader.clickLogOut();
    }



    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("admin", "admin")
        );
    }
}
