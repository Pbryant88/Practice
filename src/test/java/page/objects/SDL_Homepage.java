package page.objects;

import com.google.common.collect.Iterables;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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

public class SDL_Homepage extends ParentPage {

	protected String currentUrl;
	protected String componentName;
	protected String schemaname;
	protected By frame_tree = By.cssSelector("div.tree iframe");
	protected By publish_button_header = By.id("PublishBtn");
	protected By publish_button_popUp = By.id("BtnPublish");
	protected By tile_button = By.id("ThumbBtn");
	protected By tile_button2 = By.className("tridion button listthumbs thumbs toggle");
	protected String weblink1;
	protected String weblink2;
	Properties properties;
	
	static SyncEvents Page= new SyncEvents(driver);
	public static int TESTING_TIMEOUT = Integer.parseInt(SyncEvents.readConfig("Default_Timeout"));

	public SDL_Homepage(WebDriver driver) {
		super(driver);
		properties = readPropertyfile();
	}

	public WebElement switch_to_frame() {
		WebElement frame3 = driver.findElement(By.tagName("iframe"));
		new WebDriverWait(driver, 80).until(ExpectedConditions.elementToBeClickable(frame3));
		// driver.switchTo().frame(frame3);
		System.out.println("I swithed Frames");
		return frame3;
	}

	public void switch_to_tree_frame() {
		WebElement first_frame = switch_to_frame();
		System.out.println("in tree method now");
		driver.switchTo().frame(first_frame);
		// WebElement frame_tree = driver.findElement(By.cssSelector("div.tree
		// iframe"));
		new WebDriverWait(driver, 120).until(ExpectedConditions.elementToBeClickable(frame_tree));
		WebElement frame_tree = driver.findElement(By.cssSelector("div.tree iframe"));
		driver.switchTo().frame(frame_tree);
		System.out.println("I switched Frames again");
	}

	public void click_Frame(String pub) throws InterruptedException,Exception,Exception, IOException {
		// TODO Auto-generated method stub

			//Thread.sleep(7000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			WebElement eframes = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(eframes);
			List<WebElement> eframes1 = driver.findElements(By.cssSelector("iframe[frameborder='no']"));
			System.out.println(eframes1.size());
			// WebElement table = driver.findElement(By.xpath("//div[contains(@id,
			// 'Dashboard Tree')]"));
			// System.out.println(table);
			WebElement ee = driver.findElement(By.cssSelector("iframe[frameborder='no']"));
			driver.switchTo().frame(eframes1.get(1));

			SDL_Homepage click1 = new SDL_Homepage(driver);
			click1.click_publication(pub);
	}

	public void click_publication(String pub_name) throws InterruptedException,Exception {
		if(pub_name.equals("error")) {
		if (pub_name.equals("WDW") || pub_name.equals("Disneyland Resort") || pub_name.equals("Theme Parks")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement publication2 = driver
					.findElement(By.xpath("//div[contains(@title,'Travel Trade Publish (en-US)')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", publication2);
			executor.executeScript("arguments[0].click()", publication2);
		}

		if (pub_name.equals("Recommendations") || pub_name.equals("Travel Preferences")
				|| pub_name.equals("Travel Details")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement publication2 = driver.findElement(By.xpath("//div[contains(@title,'WDW Publish (en-US)')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", publication2);
			executor.executeScript("arguments[0].click()", publication2);
		}
		if (pub_name.equals("EVO040 Beach Resorts Content (en-US)")) {
			System.out.println("hi");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement publication2 = driver.findElement(By.xpath("//div[contains(@title,'Beach Resorts Content')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", publication2);
			executor.executeScript("arguments[0].click()", publication2);
		}
		if (pub_name.contains("EVO070")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement publication2 = driver
					.findElement(By.xpath("//div[contains(@title,'Beach Resorts Publish (en-US)')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", publication2);
			executor.executeScript("arguments[0].click()", publication2);
		}
		if (pub_name.equals("EVO040 DLR Content (en-US)")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement publication2 = driver
					.findElement(By.xpath("//div[contains(@title,'EVO040 DLR Content (en-US)')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", publication2);
			executor.executeScript("arguments[0].click()", publication2);
		}
		if (pub_name.equals("005 Media Repository")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement publication2 = driver
					.findElement(By.xpath("//div[contains(@title,'005')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", publication2);
			executor.executeScript("arguments[0].click()", publication2);
		}
            if (pub_name.equals("070 WDW Publish (en-US)")) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                WebElement publication2 = driver
                        .findElement(By.xpath("//div[contains(@title,'070 WDW Publish (en-US)')]"));
                executor.executeScript("arguments[0].scrollIntoView(true);", publication2);
                executor.executeScript("arguments[0].click()", publication2);
            }
		
		//Thread.sleep(5000);
            Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		else
		{
			System.out.println("skip");
		}
		
	}

	public void click_table_frame(String structured_group) throws InterruptedException,Exception {
		driver.switchTo().defaultContent();
		WebElement eframes = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(eframes);
		// //Thread.sleep(2000);
       Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		List<WebElement> eframes1 = driver.findElements(By.cssSelector("iframe[frameborder='no']"));
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		 //Thread.sleep(5000);
       Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

	}
	
	public void click_folders_for_page(String group) throws InterruptedException,Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("//div[contains(text(),'Root')]"));
		Actions action = new Actions(driver);
		action.doubleClick(root);
		action.perform();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		//group = "Beach Resort Overview Accept";
		if (group.equals("WDW")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Sites')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement sites2 = driver.findElement(By.xpath("//div[contains(text(),'WDW')]"));
			action.doubleClick(sites2);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		/*if (group.equals("Personalization")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Personalization')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(5000);
Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

					}*/
		if (group.equals("Disneyland Resort")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Sites')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement sites2 = driver.findElement(By.xpath("//div[contains(text(),'DLR')]"));
			action.doubleClick(sites2);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Theme Parks")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Sites')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement sites2 = driver.findElement(By.xpath("//div[contains(text(),'WDW')]"));
			action.doubleClick(sites2);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement sites3 = driver.findElement(By.xpath("//div[contains(text(),'Theme')]"));
			action.doubleClick(sites3);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Recommendations")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Vacation')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		}
		if (group.equals("Travel Preferences")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Vacation')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Travel Details")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Vacation')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (group.equals("Beach Resort Overview")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Vero')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (group.equals("Beach Resort Overview Accept")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'beach')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement sites2 = driver.findElement(By.xpath("//div[contains(text(),'vero')]"));
			action.doubleClick(sites2);
			action.perform();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

	}

	public void click_folders_for_component(String group, String env) throws InterruptedException,Exception,Exception, AWTException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("//div[contains(text(),'Building')]"));
		Actions action = new Actions(driver);
		action.doubleClick(root);
		action.perform();
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		if (group.equals("WDW")) {
			WebElement content = driver.findElement(By.xpath("//div[contains(text(),'Content')]"));
			action.doubleClick(content);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement test_wdw_folder = driver
					.findElement(By.xpath("//tr[contains(@title,'QA-Automation')]/td[2]//div[@class='text']"));
			executor.executeScript("arguments[0].scrollIntoView(true);", test_wdw_folder);
			// executor.executeScript("arguments[0].click()", test_wdw_folder);
			action.doubleClick(test_wdw_folder);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement destination_folder = driver.findElement(By.xpath("//div[contains(text(),'Destinations')]"));
			action.doubleClick(destination_folder);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement epcot_folder = driver.findElement(By.xpath("//div[contains(text(),'Epcot')]"));
			action.doubleClick(epcot_folder);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			System.out.println("You made IT WDW");

			WebElement trade_folder = driver
					.findElement(By.xpath("//tr[contains(@title,'00-Trade')]/td[2]//div[@class='text']"));
			action.doubleClick(trade_folder);
			action.perform();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			System.out.println("Clicked on Trade Folder");
			currentUrl = driver.getCurrentUrl();
			if (env.equals("dev2")) {
				driver.navigate().to(properties.getProperty("createcomponentpage.url.dev2"));
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
				handle_SDL_alert("nayak");
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			}
			if (env.equals("accept")) {
				driver.navigate().to(properties.getProperty("createcomponentpage.url.accept"));
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
				handle_SDL_alert("nayak");
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			}
			if (env.equals("dev")) {
				driver.navigate().to(properties.getProperty("createcomponentpage.url.dev"));
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
				handle_SDL_alert("admin");
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			}
			if (env.equals("sandbox")) {
				driver.navigate().to(properties.getProperty("createcomponentpage.url.sandbox"));
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
				handle_SDL_alert("admin");
				//Thread.sleep(5000);
				Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			}
			System.out.println(driver.getTitle());
			WebElement name = driver.findElement(By.xpath("//input[@id='Title']"));
			componentName = "Testcomponent".concat(String.valueOf(randomgennumber()));
			name.clear();
			name.sendKeys(componentName);

			driver.findElement(By.xpath("//div[@id='Schema']//div[@class='image']")).click();
			//Thread.sleep(10000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			driver.switchTo().frame(driver.findElement(By.id("dropdownpanel_1_frame_details")));
			schemaname = driver
					.findElement(By.xpath("//tr[contains(@title,'Analytics_Dart')]/td[2]//div[@class='text']"))
					.getText();

			System.out.println(schemaname);
			driver.findElement(By.xpath("//tr[contains(@title,'Analytics_Dart')]/td[2]//div[@class='text']")).click();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.switchTo().defaultContent();

			driver.findElement(By.xpath("//div[@id='SaveBtn']/div[1]")).click();
			//Thread.sleep(20000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Disneyland Resort")) {
			WebElement content = driver.findElement(By.xpath("//div[contains(text(),'Content')]"));
			action.doubleClick(content);
			action.perform();
			//Thread.sleep(1000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement test_DLR_folder = driver.findElement(By.xpath("//div[contains(@title,'DLR')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", test_DLR_folder);
			executor.executeScript("arguments[0].click()", test_DLR_folder);

			WebElement trade_folder = driver.findElement(By.xpath("//div[contains(text(),'Trade')]"));
			action.doubleClick(trade_folder);
			action.perform();
			//Thread.sleep(1000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			System.out.println("You made IT DLR");

		}
		if (group.equals("Theme Parks")) {
			WebElement content = driver.findElement(By.xpath("//div[contains(text(),'Content')]"));
			action.doubleClick(content);
			action.perform();
			//Thread.sleep(1000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement test_WDW_folder = driver.findElement(By.xpath("//div[contains(@title,'Things To Do - WDW')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", test_WDW_folder);
			executor.executeScript("arguments[0].click()", test_WDW_folder);

			WebElement trade_folder = driver.findElement(By.xpath("//div[contains(text(),'Trade')]"));
			action.doubleClick(trade_folder);
			action.perform();
			//Thread.sleep(1000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			System.out.println("You made IT THEME PARK");
		}
		if (group.equals("Recommendations")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Vacation')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		}
		if (group.equals("Travel Preferences")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Vacation')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Travel Details")) {
			WebElement sites = driver.findElement(By.xpath("//div[contains(text(),'Vacation')]"));
			action.doubleClick(sites);
			action.perform();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (group.equals("EVO040 DLR Content (en-US)")) {

			WebElement test_content = driver
					.findElement(By.xpath("//tr[contains(@title,'Test Content')]/td[2]//div[@class='text']"));
			;
			action.doubleClick(test_content);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		}
	}

	public void click_folders_for_mb_images(String folder, String pub) throws InterruptedException,Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement media_beacon = driver.findElement(By.xpath("//div[contains(text(),'Media')]"));
		Actions action = new Actions(driver);
		action.doubleClick(media_beacon);
		action.perform();
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		folder = "";

		if (folder.equals("Frozen") && pub.equals("EVO040 Beach Resorts Content (en-US)")) {
			WebElement wdpro_asset = driver.findElement(By.xpath("//div[contains(text(),'wdpro')]"));
			action.doubleClick(wdpro_asset);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement dlr = driver.findElement(By.xpath("//div[contains(text(),'dlr')]"));
			action.doubleClick(dlr);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement parks_tickets = driver.findElement(By.xpath("//div[contains(text(),'parks-and-tickets')]"));
			action.doubleClick(parks_tickets);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement attractions = driver.findElement(By.xpath("//div[contains(text(),'attractions')]"));
			action.doubleClick(attractions);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement frozen = driver.findElement(By.xpath("//div[contains(text(),'frozen')]"));
			action.doubleClick(frozen);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (folder.equals("Vero Beach") && pub.equals("EVO040 Beach Resorts Content (en-US)")) {
			WebElement wdpro_asset2 = driver.findElement(By.xpath("//div[contains(text(),'wdpro')]"));
			action.doubleClick(wdpro_asset2);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement beachR = driver.findElement(By.xpath("//div[contains(text(),'beach')]"));
			action.doubleClick(beachR);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement vero = driver.findElement(By.xpath("//div[contains(text(),'vero-beach-resort')]"));
			action.doubleClick(vero);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (folder.equals("Hilton") && pub.equals("EVO040 Beach Resorts Content (en-US)")) {
			WebElement wdpro_asset3 = driver.findElement(By.xpath("//div[contains(text(),'wdpro')]"));
			action.doubleClick(wdpro_asset3);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement beachR = driver.findElement(By.xpath("//div[contains(text(),'beach')]"));
			action.doubleClick(beachR);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement hilton = driver.findElement(By.xpath("//div[contains(text(),'hilton-head-resort')]"));
			action.doubleClick(hilton);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (folder.equals("Holiday") && pub.equals("EVO040 DLR Content (en-US)")) {
			WebElement wdpro_asset = driver.findElement(By.xpath("//div[contains(text(),'wdpro')]"));
			action.doubleClick(wdpro_asset);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement dlr = driver.findElement(By.xpath("//div[contains(text(),'dlr')]"));
			action.doubleClick(dlr);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement parks_tickets = driver.findElement(By.xpath("//div[contains(text(),'parks-and-tickets')]"));
			action.doubleClick(parks_tickets);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement attractions = driver.findElement(By.xpath("//div[contains(text(),'attractions')]"));
			action.doubleClick(attractions);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement holiday = driver.findElement(By.xpath("//div[contains(text(),'holiday')]"));
			action.doubleClick(holiday);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (folder.equals("Mickey") && pub.equals("EVO040 DLR Content (en-US)")) {
			WebElement wdpro_asset2 = driver.findElement(By.xpath("//div[contains(text(),'wdpro')]"));
			action.doubleClick(wdpro_asset2);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement dlr = driver.findElement(By.xpath("//div[contains(text(),'dlr')]"));
			action.doubleClick(dlr);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement parks_tickets = driver.findElement(By.xpath("//div[contains(text(),'parks-and-tickets')]"));
			action.doubleClick(parks_tickets);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement attractions = driver.findElement(By.xpath("//div[contains(text(),'attractions')]"));
			action.doubleClick(attractions);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement disneyland = driver.findElement(By.xpath("//div[contains(text(),'disneyland')]"));
			action.doubleClick(disneyland);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement mickey = driver.findElement(By.xpath("//div[contains(text(),'mickeys')]"));
			action.doubleClick(mickey);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (pub.equals("EVO040 DLR Content (en-US)")) {

			action.doubleClick(media_beacon);

			WebElement wdpro_asset2 = driver.findElement(By.xpath("//div[contains(text(),'wdpro')]"));
			action.doubleClick(wdpro_asset2);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement dlr = driver.findElement(By.xpath("//div[contains(text(),'dlr')]"));
			action.doubleClick(dlr);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement parks_tickets = driver.findElement(By.xpath("//div[contains(text(),'parks-and-tickets')]"));
			action.doubleClick(parks_tickets);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement attractions = driver.findElement(By.xpath("//div[contains(text(),'attractions')]"));
			action.doubleClick(attractions);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement disneyland = driver.findElement(By.xpath("//div[contains(text(),'disneyland')]"));
			action.doubleClick(disneyland);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement mickey = driver.findElement(By.xpath("//div[contains(text(),'mickeys')]"));
			action.doubleClick(mickey);
			action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
	}

	public void compareSchemaName() throws InterruptedException,Exception {
		driver.navigate().to(currentUrl);
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		String actualSchemaName = driver
				.findElement(By.xpath("//div[text()='" + componentName + "']/parent::td/following-sibling::td[2]/div"))
				.getText().trim();
		System.out.println(schemaname.toString());
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		Assert.assertEquals(actualSchemaName, schemaname);

	}

	public void click_tile_view() throws InterruptedException,Exception {
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		List<WebElement> eframes1 = driver.findElements(By.tagName("iframe"));
		System.out.println(eframes1.size());
		// //Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		// WebElement frame =
		// driver.findElement(By.cssSelector("iframe[id='views_container_frame_3']"));

		// new WebDriverWait(driver,
		// 60).until(ExpectedConditions.elementToBeClickable
		// (driver.findElement(By.cssSelector("iframe[id='views_container_frame_3']"))));
		// driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='views_container_frame_3']")));
		// new WebDriverWait(driver,
		// 60).until(ExpectedConditions.elementToBeClickable(tile_button));
		// driver.findElement(tile_button).click();
		// //Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
	}

	public void create_page(String group, String env) throws InterruptedException,Exception,Exception, AWTException {
		Actions action = new Actions(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Robot rb = new Robot();
		// Acceptance Enviornment
		if (group.equals("WDW") && env.equals("accept")) {
			driver.navigate().to(properties.getProperty("wdw.url.accept"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Disneyland Resort") && env.equals("accept")) {
			driver.navigate().to(properties.getProperty("disneylandResort.url.accept"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Theme Parks") && env.equals("accept")) {
			driver.navigate().to(properties.getProperty("themeParks.url.accept"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Recommendations") && env.equals("accept")) {
			driver.navigate().to(properties.getProperty("recommendations.url.accept"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Travel Preferences") && env.equals("accept")) {
			driver.navigate().to(properties.getProperty("travelPreferences.url.accept"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Travel Details") && env.equals("accept")) {
			driver.navigate().to(properties.getProperty("travelDetails.url.accept"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		// Dev2 Enviornment
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		if (group.equals("WDW") && env.equals("dev2")) {
			driver.navigate().to(properties.getProperty("wdw.url.dev2"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Disneyland Resort") && env.equals("dev2")) {
			driver.navigate().to(properties.getProperty("disneylandResort.url.dev2"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Theme Parks") && env.equals("dev2")) {
			driver.navigate().to(properties.getProperty("themeParks.url.dev2"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Recommendations") && env.equals("dev2")) {
			driver.navigate().to(properties.getProperty("recommendations.url.dev2"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Travel Preferences") && env.equals("dev2")) {
			driver.navigate().to(properties.getProperty("travelPreferences.url.dev2"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Travel Details") && env.equals("dev2")) {
			driver.navigate().to(properties.getProperty("travelDetails.url.dev2"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (group.equals("Beach Resort Overview Copy") && env.equals("dev2")) {
			// This method makes a copy of the Overview Page
			WebElement overview = driver.findElement(By.xpath("//div[contains(text(),'overview')]"));
			action.click(overview);
			driver.findElement(By.xpath("//div[contains(text(),'overview')]")).click();
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_C);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_C);
			//Thread.sleep(1000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.switchTo().alert();
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.findElement(By.xpath("//div[contains(text(),'Copy of overview')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			driver.findElement(By.id("PublishBtn")).click();

		}
		if (group.equals("Beach Resort Overview") && env.equals("dev2")) {
			String winHandleBefore = driver.getWindowHandle();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);

			driver.findElement(By.id("CreatePage_switch")).click();
			System.out.println("clicked");
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.findElement(By.id("NewPageBtn1")).click();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			save_page(group);
			driver.switchTo().window(winHandleBefore);
		}
	}

	public String save_page(String pub_name) throws InterruptedException,Exception,Exception, AWTException {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.switchTo().defaultContent();
		new WebDriverWait(driver, 60).until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@id,'Title')]"))));
		WebElement name = driver.findElement(By.xpath("//input[contains(@id,'Title')]"));
		WebElement namejson = driver.findElement(By.xpath("//input[contains(@id,'FileName')]"));
		WebElement schema = driver.findElement(By.id("MetadataSchema"));
		WebElement save = driver.findElement(By.xpath("//div[contains(text(),'Save')]"));
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(name));
		Actions action = new Actions(driver);
		Random randoms = new Random();
		Robot rb = new Robot();
		String random = "";
		int n = randoms.nextInt(500);
		if (pub_name.equals("Beach Resort Overview")) {
			StringBuilder sb = new StringBuilder();
			sb.append("");
			sb.append(n);
			String ranString = sb.toString();
			random = "overviewTest" + ranString;
			driver.findElement(By.xpath("//input[contains(@id,'Title')]")).sendKeys(random);
			driver.findElement(By.xpath("//input[@id='FileName']")).sendKeys("verobeachTEST");
			action.doubleClick(schema).build().perform();
			List<WebElement> arrows = driver.findElements(By.className("arrow"));
			WebElement second_arrow = Iterables.getLast(arrows);

			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_DOWN);
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			rb.keyPress(KeyEvent.VK_UP);
			rb.keyRelease(KeyEvent.VK_UP);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			action.release(schema);

			driver.findElement(By.cssSelector("div.input > input.text")).click();
			driver.findElement(By.cssSelector("div.input > input.text")).clear();
			driver.findElement(By.cssSelector("div.input > input.text"))
					.sendKeys("vb.site.resorts.overview.facility.vero-beach-resort.test");
			driver.findElement(By.xpath("//div[@id='MetadataFields']/div/div[2]/div/div/div/div/div/div/div")).click();
			//Thread.sleep(7000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs3.get(2));
			driver.manage().window().maximize();
			driver.switchTo().defaultContent();
			List<WebElement> eframes1 = driver.findElements(By.tagName("iframe"));
			System.out.println(eframes1.size());
			driver.switchTo().frame(6);
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement folder = driver.findElement(By.xpath("//div[contains(text(),'vero-beach-resort-overview')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", folder);
			action.doubleClick(folder);
			driver.findElement(By.xpath("//div[contains(text(),'vero-beach-resort-overview')]")).click();
			executor.executeScript("arguments[0].click()", folder);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//div[@id='InsertButton']")).click();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			// Insert Component
			// driver.findElement(By.xpath("//div[@id='InsertButton']")).click();
			// //Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			// driver.switchTo().window(tabs3.get(1));
			// add_component(pub_name);
			// driver.close();
			// driver.switchTo().window(tabs2.get(0));
			driver.switchTo().window(tabs3.get(1));
			driver.switchTo().defaultContent();
			ArrayList<String> tabs4 = new ArrayList<String>(driver.getWindowHandles());
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.findElement(By.xpath("//div[@id='SaveBtn']/div[1]")).click();
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.findElement(By.xpath("//div[@id='CheckInBtn']/div[1]")).click();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.findElement(By.xpath("//div[@id='PublishBtn']/div[1]")).click();
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			driver.switchTo().window(tabs4.get(1));
			driver.manage().window().maximize();
			driver.switchTo().defaultContent();
			List<WebElement> eframes5 = driver.findElements(By.tagName("iframe"));
			System.out.println(eframes5.size());
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.findElement(By.id("BtnPublish")).click();
			// driver.findElement(By.xpath("//div[@id='BtnPublish']/div[1]")).click();
			// driver.switchTo().frame(6);
			// driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		}

		else {
			StringBuilder sb = new StringBuilder();
			sb.append("");
			sb.append(n);
			String ranString = sb.toString();
			random = "autotest" + ranString;
			driver.findElement(By.xpath("//input[contains(@id,'Title')]")).sendKeys(random);
			driver.findElement(By.xpath("//input[@id='FileName']")).sendKeys(random);

			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			StringSelection stringSelection = new StringSelection(random);
			System.out.println(random);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);

		}
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		// add_component(pub_name);
		//Thread.sleep(1000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		
		return random;
	}

	public void add_component(String pub_name) throws InterruptedException,Exception,Exception, AWTException {
		Actions action = new Actions(driver);
		Robot rb = new Robot();
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//div[@id='ComponentPresentationsTab_switch']")).click();
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		String parentWindowHandler = driver.getWindowHandle(); // Store your
		// parent window
		String subWindowHandler = null;

		driver.findElement(By.xpath("//div[@id='buttonComponentInsert']/span")).click();
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		Set<String> handles = driver.getWindowHandles(); // get all window
		// handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (!handle.equals(parentWindowHandler)) {
				subWindowHandler = handle;
			}
		}
		driver.switchTo().window(subWindowHandler);
		System.out.println(driver.getTitle());

		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		driver.manage().window().maximize();

		if (pub_name.equals("WDW") || pub_name.equals("Disneyland Resort") || pub_name.equals("Theme Parks")) {
			driver.findElement(By.xpath("//tr[contains(@title,'Button- Deck Parties')]/td[2]//div[@class='text']"))
					.click();
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//div[@id='ComponentTemplates']/div[2]/div")).click();
			driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@id='dropdownpanel_1_frame_details']")));
			driver.findElement(By.xpath("//tr[contains(@title,'CT_Generic Component XML')]/td[2]//div[@class='text']"))
					.click();
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//div[@id='InsertButton']/span")).click();
			driver.findElement(By.xpath("//div[@id='CloseButton']/span")).click();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

		if (pub_name.equals("Recommendations") || pub_name.equals("Travel Preferences")
				|| pub_name.equals("Travel Details")) {
			driver.findElement(By.xpath("//tr[contains(@title,'entityCard4')]/td[2]//div[@class='text']")).click();
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//div[@id='ComponentTemplates']/div[2]/div")).click();
			driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@id='dropdownpanel_1_frame_details']")));
			driver.findElement(By.xpath("//tr[contains(@title,'CT_Generic Component XML')]/td[2]//div[@class='text']"))
					.click();
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//div[@id='InsertButton']/span")).click();
			driver.findElement(By.xpath("//div[@id='CloseButton']/span")).click();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
		if (pub_name.equals("Beach Resort Overview")) {
			//Thread.sleep(5000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.switchTo().defaultContent();
			List<WebElement> eframes2 = driver.findElements(By.tagName("iframe"));
			System.out.println(eframes2.size());
			driver.switchTo().frame(5);
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			// driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[frameborder='no']")));
			// WebElement TestCF1 =
			// driver.findElement(By.xpath("//div[@title='Test Content']"));
			// action.doubleClick(TestCF1);
			WebElement TestContentFolder = driver.findElement(By.xpath("//div[@id='node_tcm:286-19082-2']/div/div[3]"));
			action.doubleClick(TestContentFolder);
			driver.findElement(By.xpath("//div[@id='node_tcm:286-19082-2']/div/div[3]")).click();
			System.out.println("frame selected");
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(6);

			// WebElement Beach_folder =
			// driver.findElement(By.xpath("//div[contains(text(),'Beach')]"));
			// action.doubleClick(Beach_folder);
			driver.findElement(By.cssSelector("div.text")).click();
			// action.perform();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			// WebElement vero_folder =
			// driver.findElement(By.xpath("//div[contains(text(),'Vero')]"));
			// action.doubleClick(vero_folder);
			// action.perform();
			driver.findElement(By.xpath("//tr[@id='item_tcm:286-19182-2']/td[2]/div")).click();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement overview_folder = driver.findElement(By.xpath("//div[contains(text(),'Overview')]"));
			action.doubleClick(overview_folder);
			action.perform();
			driver.findElement(By.xpath("//tr[@id='item_tcm:286-124748']/td[2]/div")).click();
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

			WebElement folder = driver.findElement(By.xpath("//div[contains(text(),'vb-overview')]"));
			executor.executeScript("arguments[0].scrollIntoView(true);", folder);
			action.doubleClick(folder);
			action.perform();
			driver.findElement(By.xpath("//tr[@id='item_tcm:286-19261-2']/td[2]/div")).click();
		}

		driver.switchTo().window(parentWindowHandler);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[@id='SaveBtn']/div[1]")).click();
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.findElement(By.xpath("//div[@id='CheckInBtn']/div[1]")).click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

	}

	public void publish_page() throws InterruptedException,Exception {
		String parentWindowHandler = driver.getWindowHandle(); // Store your
																// parent window
		String subWindowHandler = null;

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(publish_button_header));
		driver.findElement(publish_button_header).click();

		Set<String> handles = driver.getWindowHandles(); // get all window
		// handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (!handle.equals(parentWindowHandler)) {
				subWindowHandler = handle;
			}
		}
		driver.switchTo().window(subWindowHandler);

		// Preview Selected By Default so This will publish in Preview
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(publish_button_popUp));
		driver.findElement(publish_button_popUp).click();

	}

	public void clickoncomponentschemafield() throws InterruptedException,Exception {
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id= 'FavoritesTree']/iframe")));
		driver.findElement(By.xpath("//div[contains(@title,'Reports')][@class='title']")).click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id= 'CustomPagesFrame']")));
		/*
		 * new WebDriverWait(driver,
		 * 120).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(
		 * "CustomPagesFrame"))); new WebDriverWait(driver,
		 * 120).until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "CustomPagesFrame")));
		 */
		driver.findElement(By.xpath("//a[text()='Media Size']")).click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		new WebDriverWait(driver, 120).until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'loading-icon')]")));
	}

	public void verifyheight(List<List<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			String componenttitle = list.get(i).get(0);
			String expectedheight = list.get(i).get(1);
			String height = driver.findElement(By.xpath("//table[contains(@class,'table')]//a[text()='" + componenttitle
					+ "']/parent::td/following-sibling::td[2]")).getText();
			System.out.println(height + "=" + expectedheight);
			Assert.assertEquals(height, expectedheight);
		}
	}

	public void verifywidth(List<List<String>> list) {
		/*
		 * driver.switchTo().frame(driver.findElement(By.
		 * xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		 */
		/*
		 * new WebDriverWait(driver,
		 * 120).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(
		 * "CustomPagesFrame"))); new WebDriverWait(driver,
		 * 120).until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "CustomPagesFrame")));
		 */
		/*
		 * driver.switchTo().frame(driver.findElement(By.id("CustomPagesFrame"))
		 * );
		 */
		for (int i = 0; i < list.size(); i++) {
			String componenttitle = list.get(i).get(0);
			String expectedwidth = list.get(i).get(1);
			new WebDriverWait(driver, 120).until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'table')]//a[text()='"
							+ componenttitle + "']/parent::td/following-sibling::td[1]")));
			new WebDriverWait(driver, 120).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[contains(@class,'table')]//a[text()='"
							+ componenttitle + "']/parent::td/following-sibling::td[1]")));
			String width = driver.findElement(By.xpath("//table[contains(@class,'table')]//a[text()='" + componenttitle
					+ "']/parent::td/following-sibling::td[1]")).getText();
			System.out.println(width + "=" + expectedwidth);
			Assert.assertEquals(width, expectedwidth);

		}

	}

	public String verifyEvopub() throws InterruptedException,Exception

	{

		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id= 'DashboardTree']/iframe")));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.findElement(By.xpath("//div[contains(@title,'Content Management (tcm:0)')]")).click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		driver.switchTo().defaultContent();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement evo1 = driver
				.findElement(By.xpath("//tr[contains(@title,'EVO010 Schema Master')]/td[2]//div[@class='text']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", evo1);

		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		String val1 = evo1.getText();
		System.out.println(val1);
		List<WebElement> l1 = driver.findElements(By.xpath("//tr[contains(@title,'EVO')]/td[2]//div[@class='text']"));
		List<String> l2 = new ArrayList<>();

		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i).getText());
			l2.add(l1.get(i).getText().trim());

		}
		Assert.assertTrue(l2.contains("EVO010 Schema Master"));
		Assert.assertTrue(l2.contains("EVO020 WDPR Schemas"));
		Assert.assertTrue(l2.contains("EVO030 WDPR Content Master (en-US)"));
		Assert.assertTrue(l2.contains("EVO030 WDPR Design Master"));
		Assert.assertTrue(l2.contains("EVO035 WDPR Content Master (es-AR)"));
		Assert.assertTrue(l2.contains("EVO035 WDPR Content Master (fr-CA)"));
		Assert.assertTrue(l2.contains("EVO035 WDPR Content Master (pt-BR)"));
		Assert.assertTrue(l2.contains("EVO040 Beach Resorts Content (en-US)"));
		Assert.assertTrue(l2.contains("EVO040 Beach Resorts Design"));
		Assert.assertTrue(l2.contains("EVO050 Beach Resorts Content (es-AR)"));
		Assert.assertTrue(l2.contains("EVO050 Beach Resorts Content (fr-CA)"));
		Assert.assertTrue(l2.contains("EVO050 Beach Resorts Content (pt-BR)"));
		Assert.assertTrue(l2.contains("EVO060 Beach Resorts Web Structure"));
		Assert.assertTrue(l2.contains("EVO070 Beach Resorts Publish (en-US)"));
		Assert.assertTrue(l2.contains("EVO070 Beach Resorts Publish (es-AR)"));
		Assert.assertTrue(l2.contains("EVO070 Beach Resorts Publish (fr-CA)"));
		Assert.assertTrue(l2.contains("EVO070 Beach Resorts Publish (pt-BR)"));
		return val1;
	}

	public void clickonpage() throws InterruptedException,Exception {
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		/*
		 * driver.switchTo().frame(driver.findElement(By.xpath(
		 * "//div[@class='frame-application-animated']/iframe")));
		 * driver.switchTo().frame(driver.findElement(By.
		 * xpath("//div[@id= 'DashboardContent']/iframe")));
		 */
		String parentWindowHandler = driver.getWindowHandle(); // Store your
																// parent window
		String subWindowHandler = null;

		WebElement page1 = driver.findElement(By.xpath("//*[@id='item_tcm:49-129066-64']/td[2]/div"));
		Actions action = new Actions(driver);
		action.doubleClick(page1);
		action.perform();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		Set<String> handles = driver.getWindowHandles(); // get all window
		// handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (!handle.equals(parentWindowHandler)) {
				subWindowHandler = handle;
			}
		}
		driver.switchTo().window(subWindowHandler);
	}

	public void navigateToResource(String resource, String publication) throws InterruptedException,Exception {

		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id= 'DashboardTree']/iframe")));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.findElement(By.xpath("//div[contains(@title,'Content Management (tcm:0)')]")).click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement evo1 = driver
				.findElement(By.xpath("//tr[contains(@title,'" + publication + "')]/td[2]//div[@class='text']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", evo1);
		doubleClick(evo1);
		WebElement buildingBlocks = driver.findElement(By.xpath("//div[contains(text(),'Building')]"));
		doubleClick(buildingBlocks);
		WebElement system = driver.findElement(By.xpath("//div[contains(text(),'System')]"));
		doubleClick(system);
		WebElement schema = driver.findElement(By.xpath("//div[contains(text(),'Schemas')]"));
		doubleClick(schema);
		WebElement content = driver.findElement(By.xpath("//div[contains(text(),'Content')]"));
		doubleClick(content);
		WebElement footer = driver.findElement(By.xpath("//div[contains(text(),'" + resource + "')]"));
		String parent = driver.getWindowHandle();
		doubleClick(footer);
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parent)) {
				driver.switchTo().window(window);
			}
		}

	}

	public void verifyfooter(String resourcename) throws InterruptedException,Exception {
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement footername = driver.findElement(By.xpath("//input[@id='Title']"));
		Assert.assertEquals(footername.getAttribute("value").trim(), resourcename);
		WebElement rootelement = driver.findElement(By.xpath("//input[@id='RootElementName']"));
		Assert.assertEquals(rootelement.getAttribute("value").trim(), resourcename);
		driver.findElement(By.xpath("//div[@id='SourceTab_switch']")).click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		String source = driver.findElement(By.xpath("//textarea[@id='SourceArea']")).getAttribute("value");
		source = source.split("\n")[0];
		String[] footer = source.split("\"");
		int count = 0;
		for (int i = 0; i < footer.length; i++) {
			if (footer[i].equalsIgnoreCase("http://ecm.disney.com/wdpr/Footer")) {
				count++;
			}

		}

		Assert.assertTrue(count == 2, "Footer is available 2 times");

	}

	public void pubrightclick(String publishName, String option1, String... option2) throws InterruptedException,Exception {

		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id= 'DashboardTree']/iframe")));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement pubname = driver.findElement(
				By.xpath("//div[contains(@class,'node')]//div[@class='title'][text()='" + publishName + "']"));
		scrollToElement(pubname);
		rightClick(pubname);
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));

		if (option2.length == 0) {
			WebElement option = driver
					.findElement(By.xpath("//ul[@id='DashboardContextMenu']/li/span[text()='" + option1 + "']"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			clickUsingJs(option);
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		} else {
			WebElement option = driver
					.findElement(By.xpath("//ul[@id='DashboardContextMenu']/li/span[text()='" + option1 + "']"));

			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			hoverOnElement(option);
			// clickUsingJs(option);
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			WebElement option3 = driver
					.findElement(By.xpath("//ul[contains(@class,'submenu')]//span[text()='" + option2[0] + "']"));
			clickUsingJs(option3);
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}
	}

	public void irightClickonTable(String publishName, String option1, String... option2) throws InterruptedException,Exception {
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id= 'DashboardTree']/iframe")));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement pubname = driver.findElement(
				By.xpath("//div[contains(@class,'node')]//div[@class='title'][text()='" + publishName + "']"));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		scrollToElement(pubname);
		pubname.click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		WebElement roots = driver.findElement(By.xpath("//div[contains(text(),'Root')]"));
		doubleClick(roots);
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		// WebElement name=
		// driver.findElement(By.xpath("//div[@id='FilteredItemsList']//div[text()='Name']"));
		WebElement name = driver.findElement(By.tagName("body"));
		Actions action = new Actions(driver);
		action.moveToElement(name, 150, 150).contextClick().build().perform();
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));

		if (option2.length == 0) {
			WebElement option = driver
					.findElement(By.xpath("//ul[@id='DashboardContextMenu']/li/span[text()='" + option1 + "']"));
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			clickUsingJs(option);
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		} else {
			WebElement option = driver
					.findElement(By.xpath("//ul[@id='DashboardContextMenu']/li/span[text()='" + option1 + "']"));

			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			hoverOnElement(option);
			// clickUsingJs(option);
			//Thread.sleep(2000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
			WebElement option3 = driver
					.findElement(By.xpath("//ul[contains(@class,'submenu')]//span[text()='" + option2[0] + "']"));
			clickUsingJs(option3);
			//Thread.sleep(3000);
			Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		}

	}

	String parentwindow;

	public void createComponentRightclick() throws InterruptedException,Exception,Exception, AWTException {
		WebElement name = driver.findElement(By.tagName("body"));
		Actions action = new Actions(driver);
		action.moveToElement(name, 150, 150).contextClick().build().perform();
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		driver.switchTo()
				.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));

		parentwindow = driver.getWindowHandle();
		WebElement option = driver.findElement(By.xpath("//ul[@id='DashboardContextMenu']/li/span[text()='New']"));
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		clickUsingJs(option);
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		WebElement option3 = driver.findElement(By.xpath("//ul[contains(@class,'submenu')]//span[text()='Component']"));
		clickUsingJs(option3);
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		String childwindow1 = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {

			if (!currentWindowHandle.equals(parentwindow)) {
				childwindow1 = currentWindowHandle;
				driver.switchTo().window(currentWindowHandle);
				break;
			}
		}
		System.out.println(driver.getTitle());
		WebElement names = driver.findElement(By.xpath("//input[@id='Title']"));
		componentName = "Testcomponent".concat(String.valueOf(randomgennumber()));
		names.clear();
		names.sendKeys(componentName);

		driver.findElement(By.xpath("//div[@id='Schema']//div[@class='image']")).click();
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		driver.switchTo().frame(driver.findElement(By.id("dropdownpanel_1_frame_details")));
		WebElement contentblk = driver
				.findElement(By.xpath("//tr[contains(@title,'Content Block')]/td[2]//div[@class='text']"));
		scrollToElement(contentblk);
		schemaname = contentblk.getText();
		contentblk.click();
		System.out.println(schemaname);

		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		WebElement Browse = driver.findElement(
				By.xpath("//label[contains(@title,'Web Link')]/following-sibling::div//div[@title='Browse']/div"));
		Browse.click();
		String childwindow2 = null;
		Set<String> allWindowHandles2 = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles2) {
			if (!currentWindowHandle.equals(parentwindow) && !currentWindowHandle.equals(childwindow1))

			{
				childwindow2 = currentWindowHandle;
				driver.switchTo().window(currentWindowHandle);
				break;

			}

		}
		
		//Thread.sleep(12000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		WebElement name2 = driver.findElement(By.tagName("body"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(name2, 200, 200).contextClick().build().perform();
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
			
		WebElement option2 = driver.findElement(By.xpath("//ul[@id='DashboardContextMenu']/li/span[text()='New']"));
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		clickUsingJs(option2);
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement option4 = driver.findElement(By.xpath("//ul[contains(@class,'submenu')]//span[text()='Component']"));
		clickUsingJs(option4);
		Thread.sleep(8000);
		
		String childwindow3 = null;
		Set<String> allWindowHandles3 = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles3) {
			if (!currentWindowHandle.equals(parentwindow) && !currentWindowHandle.equals(childwindow1) && !currentWindowHandle.equals(childwindow2))

			{
				childwindow3 = currentWindowHandle;
				driver.switchTo().window(currentWindowHandle);
				break;

			}

		}
		
		
		WebElement weblinkname = driver.findElement(By.xpath("//input[@id='Title']"));
		weblink1 = "weblink".concat(String.valueOf(randomgennumber()));
		weblinkname.clear();
		weblinkname.sendKeys(weblink1);

		driver.findElement(By.xpath("//div[@id='Schema']//div[@class='image']")).click();
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		driver.switchTo().frame(driver.findElement(By.id("dropdownpanel_1_frame_details")));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement weblinkoption = driver
				.findElement(By.xpath("//tr[contains(@title,'Web Link')]/td[2]//div[@class='text']"));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		scrollToElement(weblinkoption);
		schemaname = weblinkoption.getText();
		weblinkoption.click();
		System.out.println(schemaname);
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		WebElement url1=driver.findElement(By.xpath("//div[@id='SchemaBasedFields']/div/div[1]/div/input[@class='text']"));
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		url1.sendKeys("www.disney.com");
		WebElement title=driver.findElement(By.xpath("//div[@id='SchemaBasedFields']/div/div[2]/div/input[@class='text']"));
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		title.sendKeys("weblink1");
		driver.findElement(By.xpath("//div[@id='MetadataTab_switch']")).click();
		WebElement analyticID = driver.findElement(By.xpath("//div[@id='ItemMetadata']/div/div[1]/div/input"));
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		analyticID.sendKeys("ID123");
		driver.findElement(By.xpath("//div[@id='SaveCloseBtn']/div[1]")).click();
		//Thread.sleep(20000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().window(childwindow2);
		// creating weblink 2
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		WebElement name3 = driver.findElement(By.tagName("body"));
		Actions action3 = new Actions(driver);
		action3.moveToElement(name3, 200, 200).contextClick().build().perform();
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
			
		WebElement option5 = driver.findElement(By.xpath("//ul[@id='DashboardContextMenu']/li/span[text()='New']"));
		//Thread.sleep(2000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		clickUsingJs(option5);
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement option6 = driver.findElement(By.xpath("//ul[contains(@class,'submenu')]//span[text()='Component']"));
		clickUsingJs(option6);
		Thread.sleep(8000);
		
		childwindow3 = null;
		allWindowHandles3 = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles3) {
			if (!currentWindowHandle.equals(parentwindow) && !currentWindowHandle.equals(childwindow1) && !currentWindowHandle.equals(childwindow2))

			{
				childwindow3 = currentWindowHandle;
				driver.switchTo().window(currentWindowHandle);
				break;

			}

		}
		
		
		WebElement weblinkname2 = driver.findElement(By.xpath("//input[@id='Title']"));
		weblink2 = "weblink".concat(String.valueOf(randomgennumber()));
		weblinkname2.clear();
		weblinkname2.sendKeys(weblink2);

		driver.findElement(By.xpath("//div[@id='Schema']//div[@class='image']")).click();
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);

		driver.switchTo().frame(driver.findElement(By.id("dropdownpanel_1_frame_details")));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement weblinkoption2 = driver
				.findElement(By.xpath("//tr[contains(@title,'Web Link')]/td[2]//div[@class='text']"));
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		scrollToElement(weblinkoption2);
		schemaname = weblinkoption2.getText();
		weblinkoption2.click();
		System.out.println(schemaname);
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		WebElement url2=driver.findElement(By.xpath("//div[@id='SchemaBasedFields']/div/div[1]/div/input[@class='text']"));
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		url2.sendKeys("www.disney2.com");
		WebElement title2=driver.findElement(By.xpath("//div[@id='SchemaBasedFields']/div/div[2]/div/input[@class='text']"));
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		title2.sendKeys("weblink2");
		driver.findElement(By.xpath("//div[@id='MetadataTab_switch']")).click();
		WebElement analyticID2 = driver.findElement(By.xpath("//div[@id='ItemMetadata']/div/div[1]/div/input"));
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		analyticID2.sendKeys("ID123");
		driver.findElement(By.xpath("//div[@id='SaveCloseBtn']/div[1]")).click();
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		//Switching back to component content type
		
		driver.switchTo().window(childwindow1);
	
		//driver.switchTo().frame(driver.findElement(By.id("dropdownpanel_1_frame_details")));
		//Select weblink1
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement Browse3 = driver.findElement(
				By.xpath("//label[contains(@title,'Web Link')]/following-sibling::div//div[@title='Browse']/div"));
		Browse3.click();
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().window(childwindow2);
	
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		
		doubleClick(driver.findElement(By.xpath("//tr[contains(@title,'"+weblink1+"')]//td[contains(@class,'col1 even')]/div[@class='text']")));
		
		driver.switchTo().window(childwindow1);
		driver.findElement(By.xpath("//label[contains(@title,'Title override')]/following-sibling::div/input")).sendKeys("Titles");
		driver.findElement(By.xpath("(//div[contains(@class,'insert')])[3]")).click();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		WebElement Browse4 = driver.findElement(
				By.xpath("(//label[contains(@title,'Web Link')]/following-sibling::div//div[@title='Browse']/div)[2]"));
		Browse4.click();
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		
		allWindowHandles3 = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles3) {
			if (!currentWindowHandle.equals(parentwindow) && !currentWindowHandle.equals(childwindow1))

			{
				
				driver.switchTo().window(currentWindowHandle);
				break;

			}

		}
		
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		
		//Thread.sleep(3000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		doubleClick(driver.findElement(By.xpath("//tr[contains(@title,'"+weblink2+"')]//td[contains(@class,'col1 even')]/div[@class='text']")));
		driver.switchTo().window(childwindow1);
		
		driver.findElement(By.xpath("//div[@id='SaveCloseBtn']/div[1]")).click();
		//Thread.sleep(10000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().window(parentwindow);
		
	}

	public void verifyComponentWeblink()
	{
		driver.switchTo()
		.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.id("FilteredItemsList_frame_details")));
		
		Assert.assertTrue(isElementPresent(By.xpath("//tr[contains(@title,'"+componentName+"')]//div[@class='text']")) );
		
		
	}

	public Boolean isElementPresent(By by) {
		  try {
		   // Get the element using the Unique identifier of the element
		   driver.findElement(by);
		  } catch (NoSuchElementException e) {
		   // Return false if element is not found
		   return false;
		  } catch (Exception e) {
		   return false;
		  }
		  // Return true if element is found
		  return true;
		 }
	
	public void hoverOnElement(WebElement w) {
		Actions action = new Actions(driver);
		action.moveToElement(w).build().perform();

	}

	public void clickUsingJs(WebElement w) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", w);
	}

	public void rightClick(WebElement w) {
		Actions action = new Actions(driver);
		action.contextClick(w);
		action.build().perform();

	}

	public void scrollToElement(WebElement w) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", w);
	}

	public void doubleClick(WebElement w) {
		Actions action = new Actions(driver);
		action.doubleClick(w);
		action.perform();
	}

	
	public void clickOnPageforAPI() throws InterruptedException,Exception
{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement root = driver.findElement(By.xpath("//div[contains(text(),'Root')]"));
		Actions action = new Actions(driver);
		action.doubleClick(root);
		action.perform();
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		
		WebElement page = driver.findElement(By.xpath("//div[text()='Page']/parent::td/preceding-sibling::td[1]/div"));
		String parentWindow=driver.getWindowHandle();
		doubleClick(page);
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		driver.switchTo().defaultContent();
		driver.switchTo()
		.frame(driver.findElement(By.xpath("//div[@class= 'frame-application-scroll-wrapper']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='popupdialog popupdialog gradient']")));
		driver.findElement(By.xpath("//input[@id='openreadonly']")).click();
		
		
		driver.findElement(By.xpath("//div[@id='BtnOk']/span")).click();
		
		//Thread.sleep(5000);
		Page.WaitForEvent(WindowEvents.WINDOW_LOADING, TESTING_TIMEOUT);
		
		Set<String> allwindows=driver.getWindowHandles();
		for (String window : allwindows) {
			if (!parentWindow.equals(window))
			{
				driver.switchTo().window(window);
				break;
				
			}
		
		}
		

}
	   public String getBrokerResponseString() throws Exception{

	       CloseableHttpClient client = HttpClients.createDefault();
	        //Dev2 Live URL
	       String url= "http://fldcvdsla13707.wdw.disney.com:8005/content-service/environments/live/pages/tcm:"+getTcmId();
	        HttpGet httpGETBroker = new HttpGet(url);
	        CloseableHttpResponse response = client.execute(httpGETBroker);

	       HttpEntity eResponse = response.getEntity() ;
	        String responseBody = EntityUtils.toString(eResponse);
	        System.out.println(responseBody);
	        String status=response.getStatusLine().toString();
	        System.out.println(status);
	        Assert.assertTrue(status.contains("200"));
	        return status;
	    }

public String getTcmId()
{
	String tcmid=driver.getCurrentUrl().split("=")[2].split(":")[1].trim();
	System.out.println(tcmid);
	return tcmid;
}

public void publish_content_any_type(String type) throws Exception{
		System.out.println("publish content for" + type);
}

}
	
	

