package tests;

import org.openqa.selenium.By;
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
        userSettingsPage.inputUserInfo();
        userSettingsPage.clickSaveButton();
        driver.navigate().refresh();
        String settingsName = driver.findElement(By.xpath("//span[text() = 'Фамилия']/ancestor::tr[@class]//input")).getAttribute("value");
        boolean menuBarNameContainsSettingsName = driver.findElement(By.xpath("//div[@class='menu-username-new']")).getText().contains(settingsName);
        Assert.assertTrue(menuBarNameContainsSettingsName);
    }
}
