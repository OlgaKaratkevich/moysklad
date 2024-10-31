package tests;

import models.UserInfo;
import models.UserInfoBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest{

    @Test(description = "Успешное изменение настроек пользователя")
    public void changeUserInfo() {
        authPage.open();
        authPage.inputLoginAndPassword(getName(), getPassword());
        authPage.clickLoginButton();
        homePage.isOpened();
        topMenuPage.selectMenuBarOption("Настройки пользователя");
        UserInfo userInfo = UserInfoBuilder.get();
        userSettingsPage.inputUserInfo(userInfo);
        userSettingsPage.clickSaveButton();
        driver.navigate().refresh();
        String lastName = userSettingsPage.getInputText("Фамилия");
        Assert.assertTrue(topMenuPage.getUserName().contains(lastName));
    }
}
