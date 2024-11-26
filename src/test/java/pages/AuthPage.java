package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AuthPage extends BasePage{
    public static final String URL = "https://online.moysklad.ru/";
    public static final By USERNAME = By.id("lable-login");
    public static final By PASSWORD = By.id("lable-password");
    public static final By SUBMIT_BUTTON = By.id("submitButton");
    public static final By ERROR_MESSAGE = By.xpath("//div[@class='error-msg']");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter valid login and password")
    public void inputLoginAndPassword(String name, String password) {
        driver.findElement(USERNAME).sendKeys(name);
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Enter valid login and password");
    }

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(SUBMIT_BUTTON).click();
        log.info("Click login button");
    }

    @Step("Open" + URL)
    public void open() {
        driver.get(URL);
        log.info("Open" + URL);
    }

    @Override
    public boolean isOpened() {
        return isExist(SUBMIT_BUTTON);
    }

    @Step("Get error message")
    public String getErrorMessage() {
        log.info("get error message");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
