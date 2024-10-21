package pages;

import elements.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSettingsPage extends BasePage {
    protected static final By MENU_LOGIN = By.xpath("//div/span[text() = 'Логин']");
    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserInfo() {
        new UserInfo(driver).inputUserInfo();
    }


    @Override
    public boolean isOpened() {
        return isExist(CHANGE_PASSWORD_BUTTON);
    }
}
