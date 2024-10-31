package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    protected WebDriver driver;
    protected String label;
    public String buttonLocator = "//span[text() = '%s']";

    public Button(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void click(){
        driver.findElement(By.xpath(String.format(buttonLocator, label))).click();
    }
}
