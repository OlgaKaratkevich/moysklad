package pages;

import elements.DropDown;
import elements.Input;
import models.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserSettingsPage extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void inputUserInfo(UserInfo userInfo) {
        new Input(driver, "Имя").write(userInfo.getName());
        new Input(driver, "Отчество").write(userInfo.getPatronymic());
        new Input(driver, "Фамилия").write(userInfo.getLastname());
        new Input(driver, "Телефон").write(userInfo.getPhone());
        new Input(driver, "Должность").write(userInfo.getPosition());
        new DropDown(driver, "Покупатель").selectOption(userInfo.getCustomer());
    }

    public void clickSaveButton(){
        driver.findElement(SAVE_BUTTON).click();
    }


    @Override
    public boolean isOpened() {
        return isExist(CHANGE_PASSWORD_BUTTON);
    }

    public String getInputText(String inputLabel){
        return driver.findElement(By.xpath("//span[text() = '"+inputLabel+"']/ancestor::tr[@class]//input")).getAttribute("value");
    }
}
