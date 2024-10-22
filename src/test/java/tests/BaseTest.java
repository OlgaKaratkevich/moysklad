package tests;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;


import java.time.Duration;

@Data
public abstract class BaseTest {

    protected WebDriver driver;
    protected AuthPage authPage;
    protected HomePage homePage;
    protected TopMenuPage topMenuPage;
    protected UserSettingsPage userSettingsPage;
    private String name = "admin@uxtov";
    private String password = "qwerty11";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        authPage = new AuthPage(driver);
        homePage = new HomePage(driver);
        topMenuPage = new TopMenuPage(driver);
        userSettingsPage = new UserSettingsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}