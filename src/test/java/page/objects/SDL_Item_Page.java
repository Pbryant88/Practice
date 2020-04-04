package page.objects;

import com.google.common.collect.Iterables;

import com.mongodb.util.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.json.JSONString;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import WaitEvents.SyncEvents;
import WaitEvents.SyncEvents.WindowEvents;
import framework.ParentPage;

import static glue.Driver.driver;
import static org.testng.Assert.assertEquals;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;
import java.util.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;


public class SDL_Item_Page extends ParentPage {

    Properties properties;
    Properties meta_data_properties;
    Properties component_properties;
    Properties alt_text_properties;
    Properties title_properties;

    //Tabs
    protected By meta_data_tab = By.id("MetadataTab_switch");
    protected By general_tab = By.id("GeneralTab_switch");
    protected By external_metadata_tab = By.id("ExternalMetadataTab_switch");
    protected By bundle_tab = By.id("BundleTab_switch");
    protected By workflow_tab = By.id("WorkflowTab_switch");
    protected By segments_tab = By.id("SegmentsTab_switch");
    protected By info_tab = By.id("InfoTab_switch");
    protected By source_tab = By.id("SourceTab_switch");
    protected By source_textarea = By.id("SourceArea");
    protected By source_middle = By.id("SourceMiddle");

    protected By save_button = By.id("SaveBtn");
    protected By save_button_ctn = By.id("SaveCloseBtn");
    protected By save_success_message = By.className("messageTitle");
    protected By success_message = By.xpath("//div[contains(@title,'Item Saved')]");
    protected By check_in_message = By.xpath("//div[contains(@title,'Item Checked In')]");
    protected By check_in_button = By.id("CheckInBtn");



    //Input Fields
    protected By alt_text_field = By.cssSelector(".field input[type=\"text\"]");
     static SyncEvents Page= new SyncEvents(driver);
    public static int TESTING_TIMEOUT = Integer.parseInt(SyncEvents.readConfig("Default_Timeout"));


    public SDL_Item_Page(WebDriver driver){
        super(driver);
        properties = readPropertyfile();
        meta_data_properties = readMetaDataURLPropertyfile();
        component_properties = readComponentURLPropertyfile();
        alt_text_properties = readAltTextPropertyfile();
        title_properties = readTitlePropertyfile();
    }

    public WebElement [] switch_to_meta_data_tab1() throws Exception{

        List<WebElement> meta_fields = driver.findElements(meta_data_tab);
        int w = 0;
        while(meta_fields.size()==0 && w<30) {
            Thread.sleep(400);
            w++;
        }
        //Thread.sleep(3000);
//        new WebDriverWait(driver, 10).until(ExpectedConditions
//                .numberOfElementsToBeMoreThan(meta_data_tab,0));
        //Thread.sleep(1000);
        try {
            driver.findElement(meta_data_tab).click();
            Thread.sleep(1000);
        } catch (ElementNotVisibleException e) {
            System.out.println("MetaData Tab Not visible");
            System.out.println("");
            System.out.println("----------------------------------");
            Thread.sleep(2000);

        }
        List<WebElement> alt_fields = driver.findElements(alt_text_field);
        int a = 0;
        while(alt_fields.size()==0 && a<30) {
            Thread.sleep(400);
            a++;
        }
        //  new WebDriverWait(driver, 5).until(ExpectedConditions
        //         .numberOfElementsToBeMoreThan(alt_text_field,0));
        Thread.sleep(3000);
        List<WebElement> text_fields = driver.findElements(By.cssSelector(".field input[type=\"text\"]"));
        int i = 0;
        while(text_fields.size()==0 && i<30) {
            Thread.sleep(400);
            i++;
        }
            WebElement alt_text_field = text_fields.get(1);
            WebElement title_text_field = text_fields.get(2);


        return new WebElement[] {alt_text_field,title_text_field};
    }

    public WebElement [] switch_to_meta_data_tab2() throws Exception{
        Thread.sleep(1000);
//        new WebDriverWait(driver, 10).until(ExpectedConditions
//                .numberOfElementsToBeMoreThan(meta_data_tab,0));
//        //Thread.sleep(1000);
//        driver.findElement(meta_data_tab).click();
//        new WebDriverWait(driver, 5).until(ExpectedConditions
//                .numberOfElementsToBeMoreThan(alt_text_field,0));
//        Thread.sleep(2000);
        List<WebElement> text_fields = driver.findElements(By.cssSelector(".field input[type=\"text\"]"));
        WebElement alt_text_field = text_fields.get(1);
        WebElement title_text_field = text_fields.get(2);
        return new WebElement[] {alt_text_field,title_text_field};
    }

    public void switch_to_source_tab() throws Exception{
        driver.findElement(source_tab).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(source_textarea));
    }

    public void check_in() throws Exception {
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(check_in_button));
            driver.findElement(check_in_button).isDisplayed();
            driver.findElement(check_in_button).isEnabled();
            Thread.sleep(2000);
            driver.findElement(check_in_button).click();

            int i = 0;
      while(driver.findElement(save_success_message).getText().contains("Checking") && i<30){
       Thread.sleep(500);
        i++;
        }
        Thread.sleep(4000);
        //Thread.sleep(2000);
    } catch (UnhandledAlertException f) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert data: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    }

    public void add_data_to_component(String ID) throws Exception {
        //go_to_component_page(ID);
        switch_to_source_tab();
        Robot rb = new Robot();
        WebElement text = driver.findElement(source_textarea);
        new WebDriverWait(driver, 60).until(ExpectedConditions.textToBePresentInElementValue(text,"<"));
        String  textagain = text.getAttribute("value");
        driver.findElement(source_textarea).click();
        text.click();
        text.sendKeys("o");
        Thread.sleep(1000);
        text.sendKeys(Keys.BACK_SPACE);

//
//        driver.findElement(source_textarea).clear();
//        char[] updated_text=textagain.toCharArray();
//        int size = updated_text.length;
//        int counter = 0;
//       // StringBuilder sb = new StringBuilder();
//        while(counter<size){
//           // sb.append(updated_text[counter]);
//            String updated_text_string = String.format("%s",updated_text[counter]);
//            text.sendKeys(updated_text_string);
//            //text.sendKeys(sb);
//            counter++;
//        }


        //sb.append(" ");
        //text.sendKeys(sb);
    }

    public void add_alt_text_to_metadata(String alt_text,String ID) throws Exception {
       WebElement[]array = switch_to_meta_data_tab1();
        try {
            array[0].clear();
            array[0].sendKeys(alt_text);
        } catch (InvalidElementStateException e) {
            System.out.println("Alt Text Field Was Read Only");
            System.out.println("");
            System.out.println("----------------------------------");

        }
    }

    public void add_title_to_metadata(String title,String ID ) throws Exception {
        switch_to_meta_data_tab2();
        WebElement[]array = switch_to_meta_data_tab2();
        try {
            array[1].clear();
            array[1].sendKeys(title);
            Thread.sleep(1000);
        } catch (InvalidElementStateException e) {
            System.out.println("Title Text Field Was Read Only");
            System.out.println("");
            System.out.println("----------------------------------");
        }
    }

    public void save_meta_data_update() throws Exception{
        driver.findElement(save_button).click();
    }

    public void save_close_meta_data_update() throws Exception{
        driver.findElement(save_button).click();
    }

    public void verify_metadata_updated() throws Exception {
      //  new WebDriverWait(driver, 3).
      //          until(ExpectedConditions.elementToBeClickable(save_success_message));
      //  int i = 0;
//       while(driver.findElement(save_success_message).isDisplayed()
//               && driver.findElement(save_success_message).getText().contains("...") && i<30){
//        Thread.sleep(300);
//       i++;
//       }
        Thread.sleep(8000);
//        while(driver.findElement(save_success_message).getText().equals("")){
//            Thread.sleep(300);
//        }
        //String fullText = driver.findElement(save_success_message).getText();
      // System.out.println(fullText);
      // Assert.assertEquals(fullText, "Item saved.");
      // check_in();
       //driver.navigate().refresh();
    }

    public void verify_metadata_updated_component() throws Exception {
        new WebDriverWait(driver, 60).
                until(ExpectedConditions.elementToBeClickable(save_success_message));
        while(driver.findElement(save_success_message).getText().equals("Saving item...")){
            Thread.sleep(800);
        }
        String fullText = driver.findElement(save_success_message).getText();
        System.out.println(fullText);
        Assert.assertEquals(fullText, "Item saved.");

//        new WebDriverWait(driver, 60).
//                until(ExpectedConditions.textToBePresentInElementValue
//                        (save_success_message,"The Item was updated to reflect the current schema.]" ));
//        String fullText = driver.findElement(save_success_message).getText();
//        System.out.println(fullText);
//        Assert.assertEquals(fullText, "The Item was updated to reflect the current schema.]");
          check_in();
        driver.navigate().refresh();
    }
}
