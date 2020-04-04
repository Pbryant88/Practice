package framework;

import static glue.Driver.driver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import WaitEvents.SyncEvents;
import WaitEvents.SyncEvents.WindowEvents;

public abstract class ParentPage extends DSL {
	Properties properties;
    public ParentPage(WebDriver driver)  {

        super(driver);
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

            fip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/ComponentURLs.properties");
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

    public Properties readMongoDB_OUT_Propertyfile() {
        properties = new Properties();
        FileInputStream fip;
        try {

            fip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/mongo_db_output.properties");
            properties.load(fip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void handle_SDL_alert(String user) throws AWTException  {
        Robot rb = new Robot();
        readPropertyfile();
       /* if( new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent())==null)
        {
            System.out.println("No Alert Shown For Login");
        }*/
        if (isAlertPresent())
        {
            if(user.equals("glen")){
                driver.switchTo().alert().sendKeys(properties.getProperty("username.sdl.glen"));
                String password = properties.getProperty("password.sdl.glen");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
                
            }
            if(user.equals("nayak")){
                driver.switchTo().alert().sendKeys(properties.getProperty("username.sdl.nayak"));
                String password = properties.getProperty("password.sdl.nayak");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }

            if(user.equals("admin")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.prod.user"));
                String password = properties.getProperty("sdl.prod.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            
            
            
            
            
            if(user.equals("test1")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test1.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            
            if(user.equals("test2")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test2.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if(user.equals("test3")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test3.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            
            if(user.equals("test4")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test4.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if(user.equals("test5")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test5.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            
            if(user.equals("test6")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test6.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if(user.equals("test7")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test7.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if(user.equals("test8")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test8.user"));
                String password = properties.getProperty("sdl.test.pwd");
                StringSelection stringSelection = new StringSelection(password);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, stringSelection);
            }
            if(user.equals("test9")){
                driver.switchTo().alert().sendKeys(properties.getProperty("sdl.test9.user"));
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

            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();

        }
    
    
    
    
    
    }
    public long randomgennumber()
    {
    	//Random rnd = new Random();
    	//int n = 100000 + rnd.nextInt(900000);
    	long n= System.currentTimeMillis();
		return n;
    }
   
    public boolean isAlertPresent(){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }






}