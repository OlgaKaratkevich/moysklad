package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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

    @Step("Select option '{option}'")
    public void selectMenuBarOption(String option) {
        driver.findElement(MENU_USERNAME).click();
        driver.findElement(By.xpath(String.format(menuBarOption, option))).click();
        log.info("Select option '{option}'");
    }

    @Step("Get user name")
    public String getUserName(){
        log.info("Get user name");
        return driver.findElement(By.xpath("//div[@class='menu-username-new']")).getText();
    }
}