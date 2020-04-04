package page.objects;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class TestAutho {

    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO Auto-generated method stub

        WebDriver driver	= new FirefoxDriver();
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\AuthenticationPopup.exe");
        driver.navigate().to("http://fldcvdswa13705.wdw.disney.com/SDL/#app=wcm&entry=cme&url=%23locationId%3Dcme%3A0-1-custompg");
        Thread.sleep(3000);

    }






}