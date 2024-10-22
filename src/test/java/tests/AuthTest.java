package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AuthTest extends BaseTest{


    @Test
    public void loginUsingValidData(){
        authPage.open();
        authPage.inputLoginAndPassword(getName(), getPassword());
        authPage.clickLoginButton();
        boolean homePageOpened = homePage.isOpened();
        assertTrue(homePageOpened);
    }
}
