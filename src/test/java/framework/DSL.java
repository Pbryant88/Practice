package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static glue.Driver.driver;

public abstract class DSL {

    public static WebDriver driver;
    //DSL = Domain Specific Language - Use This Class to create common actions  that are more readable

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void click(String text) {
        click(By.linkText(text));
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public boolean hasElement(By by) {
        return !driver.findElements(by).isEmpty();
    }

}