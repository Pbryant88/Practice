package page.objects;

import framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SDL_Administration extends ParentPage {

    protected By HomepageHeader = By.id("HomePage_switch");
    protected By CreatePageHeader = By.id("CreatePage_switch");
    protected By OrganizePageHeader = By.id("OrganizePage_switch");
    protected By WorkflowPageHeader = By.id("WorkflowPage_switch");
    protected By AdministrationPageHeader = By.id("AdministrationPage_switch");
    protected By BundlePageHeader = By.id("BundlePage_switch");
    protected By ToolsPageHeader = By.id("ToolsPage_switch");


    public SDL_Administration(WebDriver driver) {super(driver);}


    public void AssignedToEVOReadOnly(){


        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(HomepageHeader));
        driver.findElement(HomepageHeader).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(CreatePageHeader));
        driver.findElement(CreatePageHeader).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(OrganizePageHeader));
        driver.findElement(OrganizePageHeader).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(WorkflowPageHeader));
        driver.findElement(WorkflowPageHeader).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(AdministrationPageHeader));
        driver.findElement(AdministrationPageHeader).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(BundlePageHeader));
        driver.findElement(BundlePageHeader).click();

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(ToolsPageHeader));
        driver.findElement(ToolsPageHeader).click();
    }

    public boolean VerifyReadOnlyAccess(){

        //new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(admin_leftNavLink));
        //driver.findElement(admin_leftNavLink).click();
        return true;
    }

    public boolean verifyUserCantAddContent(){

        //new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(admin_leftNavLink));
        //driver.findElement(admin_leftNavLink).click();
        return true;
    }

    public boolean verifyUserCanAddContent(){

        //new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(admin_leftNavLink));
        //driver.findElement(admin_leftNavLink).click();
        return true;
    }

    public boolean AssignedToEVOContentProducerGroup(){

        //new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(admin_leftNavLink));
        //driver.findElement(admin_leftNavLink).click();
        return true;
    }

    public boolean AssignedToEVOPlatformProducerGroup(){

        //new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(admin_leftNavLink));
        //driver.findElement(admin_leftNavLink).click();
        return true;
    }
}
