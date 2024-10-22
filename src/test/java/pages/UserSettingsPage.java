package pages;

import elements.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSettingsPage extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserInfo() {
        new UserInfo(driver).inputUserInfo();
    }

    public void clickSaveButton(){
        driver.findElement(SAVE_BUTTON).click();
    }


    @Override
    public boolean isOpened() {
        return isExist(CHANGE_PASSWORD_BUTTON);
    }
}
