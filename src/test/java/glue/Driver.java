package glue;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
    protected Properties properties;
    public static WebDriver driver;
    protected ThreadLocal<RemoteWebDriver> localDriver = null;
    protected RemoteWebDriver remoteDriver;
    @Before
    public void startBrowser() throws InterruptedException, IOException {
        readPropertyfile();
        if (properties.getProperty("browserName").equalsIgnoreCase("Firefox")) {
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myprofile = profile.getProfile("AutoUser");
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            driver = new FirefoxDriver(dc);
           // driver = new FirefoxDriver(myprofile);

            //GRID
//            localDriver = new ThreadLocal<>();
//            DesiredCapabilities dc = new DesiredCapabilities();
//            FirefoxProfile fp = new FirefoxProfile();
//            dc.setCapability(FirefoxDriver.PROFILE, fp);
//            dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
//            remoteDriver = new RemoteWebDriver(new URL("http://172.16.188.78:4444/wd/hub"), dc);
//            localDriver.set(remoteDriver);
//            driver = localDriver.get();
        }
        else if (properties.getProperty("browserName").equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\AllBrowsers\\chromedriver.exe");
            //driver = new ChromeDriver();
        }

        else
        {
            System.out.println("Enter a Browser Name");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    public void readPropertyfile()
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
    }
}