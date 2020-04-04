package framework;

import com.gargoylesoftware.htmlunit.activex.javascript.msxml.XMLHTTPRequest;
import org.apache.commons.lang.math.RandomUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.objects.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.awt.event.KeyEvent;
import java.io.InterruptedIOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import WaitEvents.SyncEvents;
import WaitEvents.SyncEvents.WindowEvents;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import static glue.Driver.driver;

public class ParentScenario {
    //private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    protected MB_LoginPage MBLoginPage;
    protected MainPage mainPage;
    protected MB_Homepage MBHomepage;
    protected MB_Asset MBAsset;
    protected SDL_Administration SDLAdmin;
    protected SDL_Homepage SDLHomepage;
    protected API_broker_endpoints API_Broker;
    protected API_ics_content API_ICScontent;
    protected MB_API_endpoints MB_API;
    protected API_transformer_endpoints API_Transform;
    protected API_content_endpoints API_Content;
    protected Properties properties;
    protected SDL_Item_Page SDL_ItemPage;
    public Mongo_DB MongoDB;
    protected By page_load = By.id("DashboardView");
    
    static SyncEvents Page= new SyncEvents(driver);
	public static int TESTING_TIMEOUT = Integer.parseInt(SyncEvents.readConfig("Default_Timeout"));



    public ParentScenario() {
       // driver = Driver.driver;
        MBLoginPage = new MB_LoginPage(driver);
        MBHomepage = new MB_Homepage(driver);
        mainPage = new MainPage(driver);
        MBAsset = new MB_Asset(driver);
        SDLAdmin = new SDL_Administration(driver);
        SDLHomepage = new SDL_Homepage(driver);
        SDL_ItemPage = new SDL_Item_Page(driver);
        API_Broker = new API_broker_endpoints(driver);
        API_ICScontent = new API_ics_content(driver);
        MB_API = new MB_API_endpoints(driver);
        API_Transform = new API_transformer_endpoints(driver);
        API_Content = new API_content_endpoints(driver);
        MongoDB = new Mongo_DB(driver);
        By source_middle = By.id("SourceMiddle");
    }


    public Properties readPropertyfile()
    {
        properties = new Properties();
        FileInputStream fip;
        try{

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/DataInput.properties");
            properties.load(fip);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties readMetaDataURLPropertyfile()
    {
        properties = new Properties();
        FileInputStream fip;
        try{

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/MetaDataURLs.properties");
            properties.load(fip);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties readAltTextPropertyfile()
    {
        properties = new Properties();
        FileInputStream fip;
        try{

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/alt_text.properties");
            properties.load(fip);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties readTitlePropertyfile()
    {
        properties = new Properties();
        FileInputStream fip;
        try{

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/title.properties");
            properties.load(fip);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties readComponentURLPropertyfile()
    {
        properties = new Properties();
        FileInputStream fip;
        try{

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/ComponentURLs3.properties");
            properties.load(fip);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties readMongoDB_IN_Propertyfile()
    {
        properties = new Properties();
        FileInputStream fip;
        try{

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/mongo_db_input.properties");
            properties.load(fip);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties readMongoDB_OUT_Propertyfile()
    {
        properties = new Properties();
        FileInputStream fip;
        try{

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/mongo_db_output.properties");
            properties.load(fip);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }



    public void navigateTo_SDL_SB() throws AWTException, InterruptedException,Exception{
        readPropertyfile();
        driver.navigate().to(properties.getProperty("sdl.sandbox.6344.url"));
        Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
        handle_SDL_alert("glen");
        Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
    }

    public void navigateTo_SDL_Dev2() throws AWTException, InterruptedException,Exception {
        readPropertyfile();
        driver.navigate().to(properties.getProperty("sdl.dev2.url"));
        handle_SDL_alert("glen");
        //handle_SDL_alert("test10");
        Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
    }

    public void navigateTo_SDL_TEST() throws AWTException, InterruptedException,Exception {
        readPropertyfile();
        driver.navigate().to(properties.getProperty("sdl.test.url"));
        handle_SDL_alert("glen");
        //handle_SDL_alert("test10");
        Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
    }


    
    public void navigateTo_SDL_Dev() throws AWTException, InterruptedException,Exception {
        readPropertyfile();
        driver.navigate().to(properties.getProperty("sdl.dev.url"));
        handle_SDL_alert("admin");
        //handle_SDL_alert("test2");
        Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
    }
    
    
    public void navigateTo_SDL_Sandbox() throws AWTException, InterruptedException,Exception
    {
    	 readPropertyfile();
         driver.navigate().to(properties.getProperty("sdl.sandbox.url"));
         handle_SDL_alert("admin");
         //handle_SDL_alert("test2");
         Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
    }
    public void navigateTo_MB_SB() {
        readPropertyfile();
        driver.navigate().to(properties.getProperty("mb.sb.url"));
    }

    public void navigateTo_MB_QA_5555() {
        readPropertyfile();
        // port 55555 Core Engine
        driver.navigate().to(properties.getProperty("mb.qa.url.5555"));
    }

    public void navigateTo_MB_QA_8080() {
        readPropertyfile();
        // port 55555 Core Engine
        driver.navigate().to(properties.getProperty("mb.qa.url.8080"));
    }

    public void navigateTo_SDL_Acceptance() throws AWTException, InterruptedException,Exception {
        readPropertyfile();
        // port 55555 Core Engine
        driver.navigate().to(properties.getProperty("sdl.prod.url"));
        handle_SDL_alert("test3");
    }

    public void navigateTo_SDL_PROD() throws AWTException, InterruptedException {
        readPropertyfile();
        // port 55555 Core Engine
        driver.navigate().to(properties.getProperty("sdl.prod.url"));
        handle_SDL_alert("test1");
        //handle_SDL_alert("test9");
    }
    public void navigateTo_SDL_IMAGE(String ID) throws AWTException, InterruptedException {
        Properties properties = readMetaDataURLPropertyfile();
        //driver.navigate().refresh();
       //  new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(page_load));
        //Thread.sleep(5000);
        //driver.navigate().refresh();
        try {
// Check the presence of alert
            Alert alert = driver.switchTo().alert();
            // Alert present; set the flag
            // if present consume the alert
            alert.accept();
            System.out.println("Alert - Save Didn't Complete before going to Next One");
            System.out.println("");
            System.out.println("------------END-------------");
            System.out.println("");
            //driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Thread.sleep(2000);
        } catch (NoAlertPresentException ex) {
            driver.navigate().refresh();
            // System.out.println("Properties URL:" + properties.getProperty(ID));
            try{
                driver.get(properties.getProperty(ID));
                Thread.sleep(2000);
            }
            catch(UnhandledAlertException e){
                Alert alert = driver.switchTo().alert();
                // Alert present; set the flag
                // if present consume the alert
                alert.accept();
                System.out.println("Alert - Save Didn't Complete before going to Next One");
                System.out.println("");
                System.out.println("------------END-------------");
                System.out.println("");
            }
        }
       // driver.navigate().refresh();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //System.out.println("ID Number: " + ID);
        //System.out.println("");
    }
    public void refresh(){
        driver.navigate().refresh();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void navigateTo_specific_component(int ID) throws AWTException, InterruptedException {
        readComponentURLPropertyfile();

        //new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(page_load));
        driver.navigate().refresh();
       // new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(page_load));
        Thread.sleep(5000);
        String ID1 = Integer.toString(ID);
        driver.navigate().to(properties.getProperty(ID1));
    }
    public void handle_SDL_alert(String user) throws AWTException, InterruptedException {
        Robot rb = new Robot();
        readPropertyfile();
        //Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());

           if( new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent())==null)
           {
            //while(ExpectedConditions.alertIsPresent())
           System.out.println("No Alert Shown For Login");
        }
      //  if(a!=null)
        if (new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent())!=null)
       // Thread.sleep(4000);
        {
            if (user.equals("glen")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("username.sdl.glen"));
                String password = properties.getProperty("password.sdl.glen");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);

            }
            if (user.equals("nayak")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("username.sdl.nayak"));
                String password = properties.getProperty("password.sdl.nayak");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }

            if (user.equals("admin")) {

                String admin_user = properties.getProperty("sdl.prod.user");
                //String password = properties.getProperty("sdl.prod.pwd");
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.prod.user"));
                String password = properties.getProperty("sdl.prod.pwd");

                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }

            if (user.equals("test1")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test1.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }

            if (user.equals("test2")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test2.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if (user.equals("test3")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test3.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }

            if (user.equals("test4")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test4.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if (user.equals("test5")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test5.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }

            if (user.equals("test6")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test6.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if (user.equals("test7")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test7.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if (user.equals("test8")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test8.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if (user.equals("test9")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test9.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }

            if (user.equals("test10")) {
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test10.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);


            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
//
//        String password = properties.getProperty("sdl.prod.pwd");
//        StringSelection stringSelection = new StringSelection(password);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, stringSelection);
//
//        rb.keyPress(KeyEvent.VK_TAB);
//        rb.keyRelease(KeyEvent.VK_TAB);
//
//
//        rb.keyPress(KeyEvent.VK_CONTROL);
//        rb.keyPress(KeyEvent.VK_V);
//        rb.keyRelease(KeyEvent.VK_V);
//        rb.keyRelease(KeyEvent.VK_CONTROL);

            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            //Thread.sleep(20000);
        }
        }
    //}

    
    
    protected void closeBrowser(){
        driver.quit();
    }
}