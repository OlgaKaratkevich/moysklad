package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isOpened();

    protected boolean isExist(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException exception) {
            System.out.println("No such element");
            return false;
        }
}}