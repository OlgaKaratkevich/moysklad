package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public static final By FIRST_STEPS_TEXT_LABEL = By.xpath("//h1[text()='Первые шаги в МоемСкладе']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return isExist(FIRST_STEPS_TEXT_LABEL);
    }

}
