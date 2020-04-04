package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import framework.ParentPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class MB_Homepage extends ParentPage {
    private By acl_drop_down = By.id("acl_select");
    protected By QuickLinksHeader = By.className("EditableLabel BaseWidgetTitle flex1");
    protected By QuickLinksHeaderFrench = By.xpath("//*[text() = 'Liens Rapides']");
    protected By QuickSearchTextbox = By.className("DictionaryBackedAutoCompleteItemizedTextBox");
    protected By PublishAssetsCMTab = By.xpath("//*[text() = 'Published Assets (CM)']");
    protected By PublishAssetsB2BTab = By.xpath("//*[text() = 'Published Assets (B2B)']");
    protected By PublishAssetsB2BTabFrench = By.xpath("//*[text() = 'Banque d’Images']");
    protected By PublishAssetsCMFrenchTab = By.xpath("//div[contains(text(),'Banque']");
    protected By HelpLink_RightNav = By.xpath("//*[text() = 'Help']");
    protected By Terms_Of_Use_RightNav = By.xpath("//*[text() = 'Terms of Use']");
    protected By ContactUs_RightNav = By.xpath("//*[text() = 'Contact Us']");
    protected By MeIcon = By.xpath("//div[@id='banner_menu']/div/div/div[3]/div[2]/div");
    protected By SearchFilterDropDown =
            By.xpath("//div[@id='root-content']/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/div/div");
    protected By BeginSearchFilterDropDown =
            By.xpath("//div[@id='root-content']/div[2]/div[2]/div/div/div/div/div[2]/div/div/div[4]/div/div/div");
    protected By FileNameFilter = By.cssSelector("div.x-grid3-hd-inner.x-grid3-hd-file_name");
    protected By FileSizeFilter = By.cssSelector("div.x-grid3-hd-inner.x-grid3-hd-file_size");
    protected By CreationDateFilter = (By.cssSelector("span.search-on-column"));
    protected By DateEnteredFilter =By.cssSelector("div.x-grid3-hd-inner.x-grid3-hd-date_entered");

    protected By AssetActionFilter = By.xpath("//div[@id='root-content']/div[2]/div[2]/div/div/div/div/div[2]/div[3]/div/div/div/div/div");
    protected By TitleFilter = By.xpath("//div[@id='x-auto-0']/div/div/div/div/div/table/thead/tr/td[5]/div");
    protected Actions actions = new Actions(driver);

    //ACL Roles
    private By DLP_Admin_Portal = By.linkText("DLP-Admin-Portal");
    private By DLP_Business_Solutions_General = By.linkText("DLP-Business-Solutions-General");
    private By DLP_Contributor_CM = By.linkText("DLP-Contributor-CM");
    private By DLP_Creative_Business_Solutions = By.linkText("DLP-Creative-Business-Solutions");
    private By DLP_Creative_Central_Marketing = By.linkText("DLP-Creative-Central-Marketing");
    private By DLP_Creative_Corporate = By.linkText("DLP-Creative-Corporate");
    private By DLP_Creative_Entertainment = By.linkText("DLP-Creative-Entertainment");
    private By DLP_Creative_General = By.linkText("DLP-Creative-General");
    private By DLP_Creative_WDI = By.linkText("DLP-Creative-WDI");
    private By DLP_General_User_B2B = By.linkText("DLP-General-User-B2B");
    private By DLP_General_User_B2B_FR = By.linkText("DLP-General-User-B2B-FR");
    private By DLP_General_User_CM = By.linkText("DLP-General-User-CM");
    private By DLP_General_User_CM_FR = By.linkText("DLP-General-User-CM-FR");
    private By DPRD_Designer = By.linkText("DPRD-Designer");
    private By DPRD_Portal_Admin = By.linkText("DPRD-Portal-Admin");
    private By DPRD_Producer = By.linkText("DPRD-Producer");
    private By Index = By.linkText("Index");
    private By RC_Cast_Member = By.linkText("RC-Cast Member");
    private By RC_Contributor = By.linkText("RC-Contributor");
    private By RC_Marketing_Sales = By.linkText("RC-Marketing & Sales");
    private By RC_PR = By.linkText("RC-PR");
    private By RC_Portal_Admin = By.linkText("RC-Portal Admin");
    private By RC_Special_Project = By.linkText("RC-Special Project");
    private By RC_WDPro_Pickup = By.linkText("RC-WDPro Pickup");
    private By users = By.linkText("users");

    JavascriptExecutor je = (JavascriptExecutor) driver;


    public MB_Homepage(WebDriver driver) {
        super(driver);
    }

    public void clickTab(String tab) {
        click(tab);
    }

    public void select_acl_role(String role) throws InterruptedException {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(acl_drop_down));
        driver.findElement(acl_drop_down).click();

        switch (role) {
            case "DLP-Admin-Portal":
                driver.findElement(DLP_Admin_Portal).click();
                break;
            case "DLP-Business-Solutions-General":
                driver.findElement(DLP_Business_Solutions_General).click();
                break;
            case "DLP-Contributor-CM":
                driver.findElement(DLP_Contributor_CM).click();
                break;
            case "DLP-Creative-Business-Solutions":
                driver.findElement(DLP_Creative_Business_Solutions).click();
                break;
            case "DLP-Creative-Central-Marketing":
                driver.findElement(DLP_Creative_Central_Marketing).click();
                break;
            case "DLP-Creative-Corporate":
                driver.findElement(DLP_Creative_Corporate).click();
                break;
            case "DLP-Creative-Entertainment":
                driver.findElement(DLP_Creative_Entertainment).click();
                break;
            case "DLP-Creative-General":
                driver.findElement(DLP_Creative_General).click();
                break;
            case "DLP-Creative-WDI":
                driver.findElement(DLP_Creative_WDI).click();
                break;
            case "DLP-General-User-B2B":
                driver.findElement(DLP_General_User_B2B).click();
                break;
            case "DLP-General-User-B2B-FR":
                driver.findElement(DLP_General_User_B2B_FR).click();
                break;
            case "DLP-General-User-CM":
                driver.findElement(DLP_General_User_CM).click();
                break;
            case "DLP-General-User-CM-FR":
                driver.findElement(DLP_General_User_CM_FR).click();
                break;
            case "DPRD-Designer":
                driver.findElement(DPRD_Designer).click();
                break;
            case "DPRD-Portal-Admin":
                driver.findElement(DPRD_Portal_Admin).click();
                break;
            case "DPRD-Producer":
                driver.findElement(DPRD_Producer).click();
                break;
            case "Index":
                driver.findElement(Index).click();
                break;
            case "RC-Cast Member":
                driver.findElement(RC_Cast_Member).click();
                break;
            case "RC-Contributor":
                driver.findElement(RC_Contributor).click();
                break;
            case "RC-Marketing & Sales":
                driver.findElement(RC_Marketing_Sales).click();
                break;
            case "RC-PR":
                driver.findElement(RC_PR).click();
                break;
            case "RC-Portal Admin":
                //driver.findElement(RC_Portal_Admin).click();
                driver.navigate().refresh();
                break;
            case "RC-Special Project":
                driver.findElement(RC_Special_Project).click();
                break;
            case "RC-WDpro Pickup":
                driver.findElement(RC_WDPro_Pickup).click();
                break;
            case "users":
                driver.findElement(users).click();
                break;
        }
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(acl_drop_down));
        System.out.println("acl drop down found");
    }

    public void IsQuickLinkDisplayed() {
        new WebDriverWait(driver, 40).until
                (ExpectedConditions.elementToBeClickable(QuickLinksHeader));
        Assert.assertTrue(driver.findElement(QuickLinksHeader).isDisplayed());
    }

    public void IsQuickLinkNOTDisplayed() {
         Assert.assertFalse(driver.findElement(QuickLinksHeader).isDisplayed());
    }

    public void IsQuickSearchDisplayed() {
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(QuickSearchTextbox));
        Assert.assertTrue(driver.findElement(QuickSearchTextbox).isDisplayed());
    }

    public void IsQuickSearchNOTDisplayed() {
        Assert.assertFalse(driver.findElement(QuickSearchTextbox).isDisplayed());
    }

    public void IsContactUsLinkDisplayed() {
    //    actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(ContactUs_RightNav));
        Assert.assertTrue(driver.findElement(ContactUs_RightNav).isDisplayed());
    }
    public void IsQuickLinkDisplayedFrench(){
        driver.findElement(PublishAssetsB2BTabFrench).click();
        new WebDriverWait(driver, 20).until
                (ExpectedConditions.elementToBeClickable(QuickLinksHeaderFrench));
        Assert.assertTrue(driver.findElement(QuickLinksHeaderFrench).isDisplayed());
    }
    public void IsQuickLinkDisplayedonPublishTab() {
        driver.findElement(PublishAssetsB2BTab).click();
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(QuickLinksHeader));
        IsQuickLinkDisplayed();
    }

    public void IsQuickLinkDisplayedonPublishCMTab() {
        driver.findElement(PublishAssetsCMTab).click();
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(QuickLinksHeader));
        IsQuickLinkDisplayed();
    }

    public void IsQuickLinkDisplayedonPublishCMFrenchTab() {
        new WebDriverWait(driver, 20).until
                (ExpectedConditions.elementToBeClickable(PublishAssetsCMFrenchTab));
        driver.findElement(PublishAssetsCMFrenchTab).click();
        System.out.print("I MADE IT");
        new WebDriverWait(driver, 20).until
                (ExpectedConditions.elementToBeClickable(QuickLinksHeaderFrench));
        IsQuickLinkDisplayedFrench();
    }
    public void IsQuickSearchDisplayedFrench(){
        driver.findElement(PublishAssetsB2BTabFrench).click();
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(QuickLinksHeaderFrench));
        Assert.assertTrue(driver.findElement(QuickSearchTextbox).isDisplayed());
    }
    public void IsQuicksearchDisplayedonPublishTab() {
        driver.findElement(PublishAssetsB2BTab).click();
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(QuickSearchTextbox));
        IsQuickLinkDisplayed();
    }

    public void IsQuicksearchDisplayedonPublishCMTab() {
        driver.findElement(PublishAssetsCMTab).click();
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(QuickSearchTextbox));
        IsQuickLinkDisplayed();
    }

    public void IsQuicksearchDisplayedonPublishCMFrenchTab() {
        driver.findElement(PublishAssetsCMFrenchTab).click();
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(QuickSearchTextbox));
        IsQuickLinkDisplayed();
    }

    public void IsHelpLinkDisplayed() {
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(HelpLink_RightNav));
        Assert.assertTrue(driver.findElement(HelpLink_RightNav).isDisplayed());
    }

    public void IsHelpLinkNOTDisplayed() {
        Assert.assertFalse(driver.findElement(HelpLink_RightNav).isDisplayed());
    }

    public void IsTermsOfUseDisplayed() {
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(Terms_Of_Use_RightNav));
        Assert.assertTrue(driver.findElement(Terms_Of_Use_RightNav).isDisplayed());
    }

    public void IsTermsOfUseNOTDisplayed() {
        Assert.assertFalse(driver.findElement(Terms_Of_Use_RightNav).isDisplayed());
    }
    public void IsMEIconDisplayed(String role) {
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(MeIcon));
        Assert.assertTrue(driver.findElement(MeIcon).isDisplayed());
    }

    public void IsBeginSearchFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(BeginSearchFilterDropDown));
        Assert.assertTrue(driver.findElement(BeginSearchFilterDropDown).isDisplayed());
    }

    public void IsSearchFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.elementToBeClickable(SearchFilterDropDown));
        Assert.assertTrue(driver.findElement(SearchFilterDropDown).isDisplayed());
    }
    public void IsFileNameFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.numberOfElementsToBeMoreThan(FileNameFilter,0));
        Assert.assertTrue(driver.findElement(FileNameFilter).isDisplayed());
    }

    public void IsFileSizeFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.numberOfElementsToBeMoreThan(FileSizeFilter, 0));
        Assert.assertTrue(driver.findElement(FileSizeFilter).isDisplayed());
    }

    public void IsCreationDateFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.numberOfElementsToBeMoreThan(CreationDateFilter, 0));
        Assert.assertTrue(driver.findElement(CreationDateFilter).isDisplayed());
    }

    public void IsAssetActionFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.numberOfElementsToBeMoreThan(AssetActionFilter, 0));
        Assert.assertTrue(driver.findElement(AssetActionFilter).isDisplayed());
    }

    public void IsTitleFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.numberOfElementsToBeMoreThan(TitleFilter, 0));
        Assert.assertTrue(driver.findElement(TitleFilter).isDisplayed());
    }
    public void IsDateEnteredFilterDisplayed(){
        new WebDriverWait(driver, 10).until
                (ExpectedConditions.numberOfElementsToBeMoreThan(DateEnteredFilter, 0));
        Assert.assertTrue(driver.findElement(DateEnteredFilter).isDisplayed());
    }

    public void ValidateQuickLinkBasedOnRole(String role) {

        switch (role) {
            case "DLP-Admin-Portal":
            //    IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-Business-Solutions-General":
            //    IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-Contributor-CM":
               // IsQuickLinkNOTDisplayed();
                break;
            case "DLP-Creative-Business-Solutions":
           //     IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-Creative-Central-Marketing":
            //    IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-Creative-Corporate":
              //  IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-Creative-Entertainment":
             //   IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-Creative-General":
            //    IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-Creative-WDI":
            //    IsQuickLinkDisplayed(); uncomment
                break;
            case "DLP-General-User-B2B":
            //    IsQuickLinkDisplayedonPublishTab(); uncomment
                break;
            case "DLP-General-User-B2B-FR":
            //    IsQuickLinkDisplayedFrench(); uncoment
                break;
            case "DLP-General-User-CM":
              //  IsQuickLinkDisplayedonPublishCMTab(); uncomment
                break;
            case "DLP-General-User-CM-FR":
               // IsQuickLinkDisplayedonPublishCMFrenchTab();
                break;
            case "DPRD-Designer":
               // IsQuickLinkNOTDisplayed();
                break;
            case "DPRD-Portal-Admin":
              //  IsQuickLinkNOTDisplayed();
                break;
            case "DPRD-Producer":
               // IsQuickLinkNOTDisplayed();
                break;
            case "Index":
               // IsQuickLinkNOTDisplayed();
                break;
            case "RC-Cast Member":
              //  IsQuickLinkNOTDisplayed();
                break;
            case "RC-Contributor":
              //  IsQuickLinkNOTDisplayed();
                break;
            case "RC-Marketing & Sales":
              //  IsQuickLinkNOTDisplayed();
                break;
            case "RC-PR":
              //  IsQuickLinkNOTDisplayed();
                break;
            case "RC-Portal Admin":
               // IsQuickLinkNOTDisplayed();
                break;
            case "RC-Special Project":
               // IsQuickLinkNOTDisplayed();
                break;
            case "RC-WDpro Pickup":
               // IsQuickLinkNOTDisplayed();
                break;
            case "users":
              //  IsQuickLinkNOTDisplayed();
                break;
        }
    }

    public void ValidateQuickSearchBasedOnRole(String role) {

//        switch (role) {
//            case "DLP-Admin-Portal":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Business-Solutions-General":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Contributor-CM":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Creative-Business-Solutions":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Creative-Central-Marketing":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Creative-Corporate":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Creative-Entertainment":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Creative-General":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-Creative-WDI":
//                IsQuickSearchDisplayed();
//                break;
//            case "DLP-General-User-B2B":
//                IsQuicksearchDisplayedonPublishTab();
//                break;
//            case "DLP-General-User-B2B-FR":
//                IsQuickSearchDisplayedFrench();
//                break;
//            case "DLP-General-User-CM":
//                IsQuicksearchDisplayedonPublishCMTab();
//                break;
//            case "DLP-General-User-CM-FR":
//                //IsQuicksearchDisplayedonPublishCMFrenchTab();
//                break;
//            case "DPRD-Designer":
//              //  IsQuickSearchNOTDisplayed();
//                break;
//            case "DPRD-Portal-Admin":
//              //  IsQuickSearchNOTDisplayed();
//                break;
//            case "DPRD-Producer":
//              //  IsQuickSearchNOTDisplayed();
//                break;
//            case "Index":
//              //  IsQuickSearchNOTDisplayed();
//                break;
//            case "RC-Cast Member":
//             //   IsQuickSearchNOTDisplayed();
//                break;
//            case "RC-Contributor":
//             //   IsQuickSearchNOTDisplayed();
//                break;
//            case "RC-Marketing & Sales":
//            //    IsQuickSearchNOTDisplayed();
//                break;
//            case "RC-PR":
//            //    IsQuickSearchNOTDisplayed();
//                break;
//            case "RC-Portal Admin":
//             //   IsQuickSearchNOTDisplayed();
//                break;
//            case "RC-Special Project":
//            //    IsQuickSearchNOTDisplayed();
//                break;
//            case "RC-WDpro Pickup":
//             //   IsQuickSearchNOTDisplayed();
//                break;
//            case "users":
//             //   IsQuickSearchNOTDisplayed();
//                break;
//        }
    }

    public void ValidateHelpContactAndTermLinkBasedOnRole(String role) {
        switch (role) {
            case "DLP-Admin-Portal":
            //    IsHelpLinkNOTDisplayed();
             //   IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Business-Solutions-General":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Contributor-CM":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Creative-Business-Solutions":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Creative-Central-Marketing":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Creative-Corporate":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Creative-Entertainment":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Creative-General":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-Creative-WDI":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-General-User-B2B":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-General-User-B2B-FR":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-General-User-CM":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DLP-General-User-CM-FR":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DPRD-Designer":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DPRD-Portal-Admin":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "DPRD-Producer":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "Index":
//                IsHelpLinkNOTDisplayed();
//                IsTermsOfUseNOTDisplayed();
                break;
            case "RC-Cast Member":
                IsHelpLinkDisplayed();
                IsTermsOfUseDisplayed();
                IsContactUsLinkDisplayed();
                break;
            case "RC-Contributor":
                IsHelpLinkDisplayed();
                IsTermsOfUseDisplayed();
                IsContactUsLinkDisplayed();
                break;
            case "RC-Marketing & Sales":
                IsHelpLinkDisplayed();
                IsTermsOfUseDisplayed();
                IsContactUsLinkDisplayed();
                break;
            case "RC-PR":
                IsHelpLinkDisplayed();
                IsTermsOfUseDisplayed();
                IsContactUsLinkDisplayed();
                break;
            case "RC-Portal Admin":
                IsHelpLinkDisplayed();
                IsTermsOfUseDisplayed();
                IsContactUsLinkDisplayed();
                break;
            case "RC-Special Project":
                IsHelpLinkDisplayed();
                IsTermsOfUseDisplayed();
                IsContactUsLinkDisplayed();
                break;
            case "RC-WDpro Pickup":
                je.executeScript("scroll(0,500);");
                IsHelpLinkDisplayed();
                IsTermsOfUseDisplayed();
                IsContactUsLinkDisplayed();
                break;
        }
    }

    public boolean ValidateSearchFilterBasedOnRole(String role) {
        System.out.println("At Validate Search based on Role FUnction");
        switch (role) {
            case "DLP-Admin-Portal":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DLP-Business-Solutions-General":
                //Defect
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsDateEnteredFilterDisplayed();
//                IsCreationDateFilterDisplayed();
              break;
            case "DLP-Contributor-CM":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DLP-Creative-Business-Solutions":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DLP-Creative-Central-Marketing":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DLP-Creative-Corporate":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DLP-Creative-Entertainment":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DLP-Creative-General":
                //Defect
//
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsDateEnteredFilterDisplayed();
//                IsCreationDateFilterDisplayed();
                break;
            case "DLP-Creative-WDI":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DLP-General-User-B2B":
                //Defect
//                driver.findElement(PublishAssetsB2BTab).click();
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsDateEnteredFilterDisplayed();
//                IsCreationDateFilterDisplayed();
                break;
            case "DLP-General-User-B2B-FR":
                //Defect
//                driver.findElement(PublishAssetsB2BTabFrench).click();
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsDateEnteredFilterDisplayed();
//                IsCreationDateFilterDisplayed();
                break;
            case "DLP-General-User-CM":
//                driver.findElement(PublishAssetsCMTab).click();
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsDateEnteredFilterDisplayed();
//                IsCreationDateFilterDisplayed();
                break;
            case "DLP-General-User-CM-FR":
                break;
            case "DPRD-Designer":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DPRD-Portal-Admin":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "DPRD-Producer":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "RC-Cast Member":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsCreationDateFilterDisplayed();
                IsTitleFilterDisplayed();
                break;
            case "RC-Contributor":
                IsFileNameFilterDisplayed();
                IsFileSizeFilterDisplayed();
                IsDateEnteredFilterDisplayed();
                break;
            case "RC-Marketing & Sales":
                //D
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsCreationDateFilterDisplayed();
//                IsTitleFilterDisplayed();
                break;
            case "RC-PR":
                //DEFECT
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsCreationDateFilterDisplayed();
//                IsTitleFilterDisplayed();
                break;
            case "RC-Portal Admin":
                //DEFECT
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsCreationDateFilterDisplayed();
//                IsDateEnteredFilterDisplayed();
                break;
            case "RC-Special Project":
                //DEFECT
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsCreationDateFilterDisplayed();
//                IsTitleFilterDisplayed();
                break;
            case "RC-WDpro Pickup":
                //DEFECT
//                IsFileNameFilterDisplayed();
//                IsFileSizeFilterDisplayed();
//                IsCreationDateFilterDisplayed();
//                IsAssetActionFilterDisplayed();
                break;
        }
        return true;
    }
}
