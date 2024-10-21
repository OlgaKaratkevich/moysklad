package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenuPage extends BasePage {
    protected static final By MENU_USERNAME = By.xpath("//div[@class = 'menu-username-new']");
    protected String menuBarOption = "//td[@class = 'gwt-MenuItem' and text() = '%s']";

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return isExist(MENU_USERNAME);
    }

    public void selectMenuBarOption(String option) {
        driver.findElement(MENU_USERNAME).click();
        driver.findElement(By.xpath(String.format(menuBarOption, option))).click();
    }
}