package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AuthTest extends BaseTest {

    @DataProvider(name = "Negative tests")

    public Object[][] inputForLogin() {
        return new Object[][]{
                {"", "", "Чтобы войти, укажите имя пользователя"},
                {"login@login", "password", "Неправильный пароль или имя пользователя. Посмотрите, что можно сделать."},
        };
    }

    @Test(description = "Successful authorisation when entering valid data")
    public void loginUsingValidData(){
        authPage.open();
        authPage.inputLoginAndPassword(getName(), getPassword());
        authPage.clickLoginButton();
        boolean homePageOpened = homePage.isOpened();
        assertTrue(homePageOpened);
    }

    @Test(description = "Unsuccessful authorisation when entering invalid data", dataProvider = "Negative tests")
    public void shouldNotBeAuthorisedWhenEnteringInvalidData(String login, String password, String error) {
        authPage.open();
        authPage.inputLoginAndPassword(login, password);
        authPage.clickLoginButton();
        String errorMessage = authPage.getErrorMessage();
        assertEquals(errorMessage, error);
    }

}
