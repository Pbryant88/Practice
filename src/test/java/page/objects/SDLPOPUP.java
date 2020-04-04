package page.objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SDLPOPUP {

	public static void main(String[] args)  throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.http.phishy-userpass-length", 255);
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://SARAN007:India123@fldcvdswa13705.wdw.disney.com/SDL/#app=wcm&entry=cme&url=%23locationId%3Dcme%3A0-1-custompg");
		
		Thread.sleep(50000);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\Auth.exe");
		Thread.sleep(5000);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\Auth.exe");
	
	}

	

}
