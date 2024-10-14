package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AuthTest extends BaseTest{
    private String name = "admin@uxtov";
    private String password = "qwerty11";

    @Test
    public void loginUsingValidData(){
        authPage.open();
        authPage.inputLoginAndPassword(name, password);
        authPage.clickLoginButton();
        boolean homePageOpened = homePage.isOpened();
        assertTrue(homePageOpened);
    }
}
