package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import framework.ParentPage;

public class MB_LoginPage extends ParentPage {
   private By username = By.id("user_name_text_box");
   private By password = By.id("pw_text_box");
   private By login_button = By.id("x-auto-0");

    public MB_LoginPage(WebDriver driver) {
        super(driver);
    }

       public void enterLoginCredentials(String user) {
        if(user.equals("SB")) {
            new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(username));
            driver.findElement(username).sendKeys("glenn");
            driver.findElement(password).sendKeys("Disney123");
            driver.findElement(login_button).click();
        }
        if(user.equals("QA")){
            new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(username));
            driver.findElement(username).sendKeys("qa-tester1");
            driver.findElement(password).sendKeys("Disney123");
            driver.findElement(login_button).click();
        }
    }

}