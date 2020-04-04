package page.objects;

import org.openqa.selenium.*;
import framework.ParentPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class MB_Asset extends ParentPage {

    private By acl_drop_down = By.id("acl_select");
    private By inputField = By.xpath(
            "//div[@id='root-content']/div[2]/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[4]/div/div/div[2]/div/div");
    protected Actions actions = new Actions(driver);

    public MB_Asset(WebDriver driver) {
        super(driver);
    }

    public void drag_and_drop_upload() throws InterruptedException, IOException{
        driver.findElement(inputField).click();
        Runtime.getRuntime().exec("C:/Users/HYATG002/Git/ecmtestsuite/src/test/java/framework/content/QA_AUTO_STARWARS1.jpg");

    }

    public void create_asset(){
        driver.findElement(inputField).sendKeys("test/java/framework/content/QA_AUTO_STARWARS1.jpg");
        driver.findElement(inputField).sendKeys(Keys.ENTER);
        System.out.print("done");
    }

    public void edit_asset(){
        //new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(acl_drop_down));
        //driver.findElement(acl_drop_down).isDisplayed();
        System.out.print("");
    }

    public void delete_asset(){
       // new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(acl_drop_down));
       // driver.findElement(acl_drop_down).isDisplayed();
        System.out.print("");
    }

    public void verify_asset(){
       // new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(acl_drop_down));
      //  driver.findElement(acl_drop_down).isDisplayed();
        System.out.print("");
    }

}
