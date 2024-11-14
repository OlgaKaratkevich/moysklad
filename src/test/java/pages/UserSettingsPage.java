package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class UserSettingsPage extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//span[text() = 'Сохранить']");
    protected static final By CHANGE_PASSWORD_BUTTON = By.xpath("//span[text() = 'Изменить пароль']");

    public UserSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input user information")
    public void inputUserInfo(UserInfo userInfo) {
        new Input(driver, "Имя").write(userInfo.getName());
        new Input(driver, "Отчество").write(userInfo.getPatronymic());
        new Input(driver, "Фамилия").write(userInfo.getLastname());
        new Input(driver, "Телефон").write(userInfo.getPhone());
        new Input(driver, "Должность").write(userInfo.getPosition());
        new DropDown(driver, "Покупатель").selectOption(userInfo.getCustomer());
    }

    @Step("Click save button")
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
