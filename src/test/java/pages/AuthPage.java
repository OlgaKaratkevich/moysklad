package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends BasePage{
    public static final String URL = "https://online.moysklad.ru/";
    public static final By USERNAME = By.id("lable-login");
    public static final By PASSWORD = By.id("lable-password");
    public static final By SUBMIT_BUTTON = By.id("submitButton");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public void inputLoginAndPassword(String name, String password) {
        driver.findElement(USERNAME).sendKeys(name);
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public void open() {
        driver.get(URL);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(By.xpath("//div[@class='b-page-info']/h1[@text()='Вход в МойСклад'")).isDisplayed();
    }
}
