package elements;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class UserInfo extends UserInfoOptions {

    protected WebDriver driver;

    public void inputUserInfo() {
        new Input(driver, "Имя").write(name);
        new Input(driver, "Отчество").write(patronymic);
        new Input(driver, "Фамилия").write(lastName);
        new Input(driver, "Телефон").write(phone);
        new Input(driver, "Должность").write(position);
    }


}
