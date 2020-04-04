package glue;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.Assertion;
import framework.ParentScenario;
import page.objects.SDL_Administration;
import page.objects.SDL_Homepage;
import WaitEvents.SyncEvents;
import WaitEvents.SyncEvents.WindowEvents;
import page.objects.SDL_Item_Page;
//import java.lang.*;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static glue.Driver.driver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SDLStepDef extends ParentScenario {

   Properties properties = readComponentURLPropertyfile();

	@Given("^I am a producer that has logged into SDL in Dev2$")
	public void I_am_on_the_SDL_Web8_Login_Page() throws AWTException, InterruptedException,Exception {
		navigateTo_SDL_Dev2();
		//Thread.sleep(10000);
	}

	@Given("^I am a producer that has logged into SDL in TEST$")
	public void I_am_on_the_SDL_Web8_Login_Page_TEST() throws AWTException, InterruptedException,Exception {
		navigateTo_SDL_TEST();
		//Thread.sleep(10000);
	}


	@When("^I navigate to Schemas for the resource \"([^\"]*)\" on publication \"([^\"]*)\"$")
	public void iNavigateToSchemasForTheResourceOnPublication(String resource, String publication) throws Throwable {
		SDLHomepage.navigateToResource(resource,publication);
		
	}
	
	@And("^I open Building blocks$")
	public void iclickonBuildingBlock()
	{
		
	}


	@When("^I right click on publications$")
	public void irightclickonpub() throws InterruptedException,Exception
	{
		SDLHomepage.pubrightclick("000 Empty Parent", "Open");
		Thread.sleep(5000);
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Go to Location");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Publishing","Publish");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Publishing","Unpublish");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Send Item Link","Send to My Favorites");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Send Item Link","Send by E-mail");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Start Location","Use Current Location");
		Thread.sleep(5000);
		SDLHomepage.pubrightclick("000 Empty Parent", "Delete");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Properties");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Where Used");
		Thread.sleep(5000);*/
		/*SDLHomepage.pubrightclick("000 Empty Parent", "Refresh");
		Thread.sleep(5000);
		*/
		
	}
	
	
	@Then("^I should see the correct schemas format for the resource \"([^\"]*)\"$")
	public void iShouldSeeTheCorrectSchemasFormatForTheResource(String resource) throws Throwable {
		SDLHomepage.verifyfooter(resource);
	
	}

	@And("^I am assigned only to EVO Ready Only group$")
	public void iAmAssignedOnlyToEVOReadyOnlyGroup() throws Throwable {
		System.out.print("step replaced");
		// SDLAdmin.AssignedToEVOReadOnly();
	}

	@When("^I access the EVO publication of \"([^\"]*)\" for \"([^\"]*)\" group$")
	public void iAccessTheEVOPublicationOfForGroup(String arg0, String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I will see I have read only access to building blocks folder$")
	public void iWillSeeIHaveReadOnlyAccessToBuildingBlocksFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I wil see I have read only access to Root folder$")
	public void iWilSeeIHaveReadOnlyAccessToRootFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I will see that I have read only access to Category and Keyword folder$")
	public void iWillSeeThatIHaveReadOnlyAccessToCategoryAndKeywordFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I am assigned only to EVO Content Producer group$")
	public void iAmAssignedOnlyToEVOContentProducerGroup() throws Throwable {
		SDLAdmin.AssignedToEVOContentProducerGroup();
	}

	@When("^I access an EVO publication of <publication> for \"([^\"]*)\" group$")
	public void iAccessAnEVOPublicationOfPublicationForGroup(String arg0) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I will see I have read and write access to building blocks content folder$")
	public void iWillSeeIHaveReadAndWriteAccessToBuildingBlocksContentFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I wil see I have read only access to building blocks system component template folder$")
	public void iWilSeeIHaveReadOnlyAccessToBuildingBlocksSystemComponentTemplateFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I wil see I have read and write access access to Root folder$")
	public void iWilSeeIHaveReadAndWriteAccessAccessToRootFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I am assigned only to EVO Platform Producer group$")
	public void iAmAssignedOnlyToEVOPlatformProducerGroup() throws Throwable {
		SDLAdmin.AssignedToEVOPlatformProducerGroup();
	}

	@Then("^I will see I have read and write access to building blocks system meteadata folder$")
	public void iWillSeeIHaveReadAndWriteAccessToBuildingBlocksSystemMeteadataFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I will see I have read access to building blocks system folder$")
	public void iWillSeeIHaveReadAccessToBuildingBlocksSystemFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I will see that I have read and write access to Category and Keyword folder$")
	public void iWillSeeThatIHaveReadAndWriteAccessToCategoryAndKeywordFolder() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@And("^I can not add content configuration$")
	public void iCanNotAddContentConfiguration() throws Throwable {
		SDLAdmin.verifyUserCantAddContent();
	}

	@When("^I am assigned to EVO Content producer group$")
	public void iAmAssignedToEVOContentProducerGroup() throws Throwable {
		SDLAdmin.AssignedToEVOContentProducerGroup();
	}

	@Then("^I will see that I can edit content in publication <publication>$")
	public void iWillSeeThatICanEditContentInPublicationPublication() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I will see that I can publish content in publication \"([^\"]*)\"$")
	public void iWillSeeThatICanPublishContentInPublication(String type) throws Throwable {
		SDLHomepage.publish_content_any_type(type);
	}

	@When("^I navigate to publication <publication>$")
	public void iNavigateToPublicationPublication() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I will see I have Component Management right$")
	public void iWillSeeIHaveComponentManagementRight() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I will see that I only have ready only access publication \"([^\"]*)\"$")
	public void iWillSeeThatIOnlyHaveReadyOnlyAccessPublication(String arg0) throws Throwable {
		SDLAdmin.VerifyReadOnlyAccess();
	}

	@Then("^I will see that I can create content in publication \"([^\"]*)\"$")
	public void iWillSeeThatICanCreateContentInPublication(String arg0) throws Throwable {
		SDLAdmin.verifyUserCanAddContent();
	}

	@When("^I am assigned to EVO Platform producer group$")
	public void iAmAssignedToEVOPlatformProducerGroup() throws Throwable {
		SDLAdmin.AssignedToEVOPlatformProducerGroup();
	}

	@Given("^I am a producer that has logged into SDL into Acceptance Enviornment$")
	public void iAmAProducerThatHasLoggedIntoSDLIntoAcceptanceEnviornment() throws AWTException, InterruptedException,Exception {
		navigateTo_SDL_Acceptance();
		//navigateTo_SDL_Dev2();
		//navigateTo_SDL_PROD();
		
	}
	@Given("^I am a producer that has logged into SDL into dev Enviornment$")
	public void iAmAProducerThatHasLoggedIntoSDLIntodevEnviornment() throws AWTException, InterruptedException,Exception {
			//navigateTo_SDL_Dev();
		navigateTo_SDL_Dev2();
		//navigateTo_SDL_PROD();
		//navigateTo_SDL_Sandbox();
		
	}

	
	
	@When("^I create a page for \"([^\"]*)\" product$")
	public void iCreateAPageForProduct(String pub_name) throws Throwable {
		SDLHomepage.click_Frame(pub_name);
		SDLHomepage.click_table_frame(pub_name);
		SDLHomepage.click_folders_for_page(pub_name);
		//SDLHomepage.create_page(pub_name, "dev2");

	}
	
	
	

	@Then("^I will see the page saved for \"([^\"]*)\"$")
	public void iWillSeeThePageSaved(String pub_name) throws Throwable {
		//SDLHomepage.save_page(pub_name);
		System.out.println("step complete");
	}

	@When("^I click on \"([^\"]*)\" and navigate to Test Content Folder$")
	public void iclickonEvoPub(String pub_name) throws InterruptedException,Exception, IOException, AWTException
	{
		SDLHomepage.click_Frame(pub_name);
		SDLHomepage.click_table_frame(pub_name);
		SDLHomepage.click_folders_for_component(pub_name, "dev2");
		System.out.println("step complete");
	}
	
	@When("^I create component of type Content Block Schema with Multiple weblinks$")
	public void icreateContentBlk() throws InterruptedException,Exception, AWTException
	{
		SDLHomepage.createComponentRightclick();
	}

	@Then("^I can verify  multiple weblinks and Analytical Over ride to Content Block Schema$")
		public void iverifyMultWeb()
	{
		SDLHomepage.verifyComponentWeblink();
	}
	
	@And("^I click on \"([^\"]*)\"$")
	public void iclickonpub(String pub) throws InterruptedException,Exception, IOException, Throwable
	{
		SDLHomepage.click_Frame(pub);
		SDLHomepage.click_table_frame(pub);
		
	}
	@And("^I click on page$")
	public void  iclickonpage() throws InterruptedException,Exception
	{
	//SDLHomepage.click_folders_for_page(group);
	SDLHomepage.clickOnPageforAPI();
	SDLHomepage.getTcmId();
	}
	
	@And("^I create a component for \"([^\"]*)\" product$")
	public void iCreateAComponentForProduct(String pub_name) throws Throwable {
		SDLHomepage.click_Frame(pub_name);
		SDLHomepage.click_table_frame(pub_name);
		//SDLHomepage.click_folders_for_component(pub_name, "dev");
		//SDLHomepage.click_folders_for_component(pub_name, "dev2");
	}

	@And("^I create a key assignment for a component for \"([^\"]*)\"$")
	public void iCreateAKeyAssignmentForAComponentFor(String arg0) throws Throwable {
		System.out.println("step complete");
	}

	@Then("^I perform the Get query and I verify the 200 success message$")
	 public void isendApiRequest() throws Exception
	 {
		 SDLHomepage.getBrokerResponseString();
	 }
	 
	@Then("^I verify component schemaname in the table$")
	 public void iverifyschemaname() throws InterruptedException,Exception
	 {
		 SDLHomepage.compareSchemaName();
	 }
	
	
	
	
	@Then("^I will see the component published$")
	public void iWillSeeTheComponentPublished() throws Throwable {
		System.out.println("step complete");
	}

	@And("^I will see the page published$")
	public void iWillSeeThePagePublished() throws Throwable {
		System.out.println("step complete");
		// Atlanta2.SDLHomepage.publish_page();
	}

	@When("^I will see the component saved$")
	public void iWillSeeTheComponentSaved() throws Throwable {
		System.out.println("step complete");
	}

	@When("^I edit a component for \"([^\"]*)\" product$")
	public void iEditAComponentForProduct(String arg0) throws Throwable {
		System.out.println("step complete");
	}

	@When("^I un-publish the component for \"([^\"]*)\"$")
	public void iUnPublishTheComponentFor(String arg0) throws Throwable {
		System.out.println("step complete");
	}

	@Then("^I will see the component for \"([^\"]*)\" deleted$")
	public void iWillSeeTheComponentForDeleted(String arg0) throws Throwable {
		System.out.println("step complete");
	}

	@And("^I edit a page for \"([^\"]*)\" product$")
	public void iEditAPageForProduct(String arg0) throws Throwable {
		System.out.println("step complete");
	}

	@When("^I un-publish the page for \"([^\"]*)\"$")
	public void iUnPublishThePageFor(String arg0) throws Throwable {
		System.out.println("step complete");
	}

	@Then("^I will see the page for \"([^\"]*)\" deleted$")
	public void iWillSeeThePageForDeleted(String arg0) throws Throwable {
		System.out.println("step complete");
	}


	@When("^I view the media sizes with publication with component type component_title$")
	public void clickoncomponentschemafield() throws InterruptedException,Exception {
		System.out.println("Click");
		SDLHomepage.clickoncomponentschemafield();
	}

	@Then("^I can validate the correct width$")
	public void verifyweidth(DataTable table) throws InterruptedException,Exception {
			SDLHomepage.verifywidth(table.raw());
	}

	@And("^I can validate the correct height$")
	public void verifyheight(DataTable table) throws InterruptedException,Exception {
				SDLHomepage.verifyheight(table.raw());
	}

    @And("^I select publication \"([^\"]*)\"$")
    public void iSelectPublication(String pub) throws Throwable {
        SDLHomepage.click_Frame(pub);
        SDLHomepage.click_table_frame(pub);
    }

    @When("^I navigate to media beacon images for folder \"([^\"]*)\" in publication \"([^\"]*)\"$")
    public void iNavigateToMediaBeaconImagesForFolderInPublication(String folder, String pub) throws Throwable {
		SDLHomepage.click_folders_for_mb_images(folder, pub);
    }

    @Then("^I will see the page load in Tile View$")
    public void iWillSeeThePageLoadInTileView() throws Throwable {
        SDLHomepage.click_tile_view();
    }

    @And("^I navigate to folder for content for Beach Resort Overview Page$")
    public void iNavigateToFolderForContentForBeachResortOverviewPage() throws Throwable {
        SDLHomepage.click_folders_for_page("Beach Resort Overview");
    }

    @And("^I create a test overview page$")
    public void iCreateATestOverviewPage() throws Throwable {
        SDLHomepage.create_page("Beach Resort Overview", "dev2");
    }

	@Given("^I am a producer that has logged into SDL in Sandbox$")
	public void iAmAProducerThatHasLoggedIntoSDLInSandbox() throws Throwable {
		navigateTo_SDL_SB();
	}

	@When ("^I verify the EVO publications in SDL home page\\.$")
	public void verifyevopublicattions() throws InterruptedException,Exception
	{
		SDLHomepage.verifyEvopub();
	}

	@And("^I will see publication <\"([^\"]*)\"> listed$")
	public void iWillSeePublicationListed(String arg0) throws Throwable {
		System.out.println("Reporting Publications Step");
	
	}


	@When ("^I right click on the table\\.$")
	public void iclickonthetable() throws InterruptedException,Exception
	{
		//SDLHomepage.irightClickonTable("000 Empty Parent","New","Page");
		SDLHomepage.irightClickonTable("000 Empty Parent","New","Structure Group");
		//SDLHomepage.irightClickonTable("000 Empty Parent","Refresh");
		//SDLHomepage.irightClickonTable("000 Empty Parent","Start Location","Use Currrent Location");
		//SDLHomepage.irightClickonTable("000 Empty Parent","Start Location","Reset to Default");
		//SDLHomepage.irightClickonTable("005 Media Repository","Start Location","Go to Start Location");
	}

	@And("^I create a component URL for \"([^\"]*)\" product$")
	public void iCreateAComponentURLForProduct(String pub_name) throws Throwable {
		SDLHomepage.click_Frame(pub_name);
		SDLHomepage.click_table_frame(pub_name);
		//SDLHomepage.click_folders_for_component(pub_name, "dev");
}

	@And("^I create a Resource Bundle for \"([^\"]*)\" product$")
	public void iCreateAResourceBundleForProduct(String pub_name) throws Throwable {
		SDLHomepage.click_Frame(pub_name);
		SDLHomepage.click_table_frame(pub_name);
	}

	@And("^I add data to component with TCM ID of \"([^\"]*)\" in SDL$")
	public void iAddDataToComponentWithTCMIDOfInSDL(String ID) throws Throwable {
		//navigateTo_specific_component(ID);
		//readComponentURLPropertyfile();
        Properties properties = SDL_ItemPage.readComponentURLPropertyfile();
		//Properties ComponentURLs =  new properties();
		int propsLength = properties.keySet().size();
		for (int iIteration = 9068; iIteration < propsLength; iIteration++) {
			System.out.println("inside looop");
            navigateTo_specific_component(iIteration);
            SDL_ItemPage.add_data_to_component("");
            SDL_ItemPage.save_meta_data_update();
            SDL_ItemPage.verify_metadata_updated();
            System.out.println("completed URL Number:" + iIteration);
        }
	}

    @And("^I navigate to URL for image with ID of \"([^\"]*)\"$")
    public void iNavigateToURLForImageWithIDOf(String ID) throws Throwable {
        navigateTo_SDL_IMAGE(ID);
    }

    @And("^I add alt text of \"([^\"]*)\" for ID \"([^\"]*)\"$")
    public void iAddAltTextOfForID(String ALT_TEXT, String ID) throws Throwable {
      //  if(driver.findElements(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).size()==0){
			SDL_ItemPage.add_alt_text_to_metadata(ALT_TEXT, ID);
	//	}
    }

    @And("^I add Title of \"([^\"]*)\" text for ID \"([^\"]*)\"$")
    public void iAddTitleOfTextForID(String TITLE, String ID) throws Throwable {
     //    if(driver.findElements(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).size()==0) {
			SDL_ItemPage.add_title_to_metadata(TITLE, ID);
	//	}
    }

    @Then("^I should see the updated image saved successfully$")
    public void iShouldSeeTheUpdatedImageSavedSuccessfully() throws Throwable {
       //  if(driver.findElements(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).size()==0) {
			SDL_ItemPage.save_close_meta_data_update();
			SDL_ItemPage.verify_metadata_updated();
		//}
    }

    @Then("^I should see the updated component saved successfully$")
    public void iShouldSeeTheUpdatedComponentSavedSuccessfully() throws Throwable {
        SDL_ItemPage.save_meta_data_update();
        SDL_ItemPage.verify_metadata_updated();
    }

    @Then("^I will see the updated Alt text and title for each image$")
    public void iWillSeeTheUpdatedAltTextAndTitleForEachImage() throws Throwable {
		Properties properties_url = SDL_ItemPage.readMetaDataURLPropertyfile();
		Properties properties_alt = SDL_ItemPage.readAltTextPropertyfile();
		Properties properties_title = SDL_ItemPage.readTitlePropertyfile();


			int url = 1946;
			int alt_text = 1946;
			int title = 1946;
			while (url<2001){
				StringBuilder sb = new StringBuilder();
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();

				//sb.append("");
				sb.append(url);

				//sb1.append("");
				sb1.append(alt_text);

				//sb2.append("");
				sb2.append(title);

				System.out.println("URL Number: " + url);
				System.out.println("Alt Number: " + alt_text);
				System.out.println("Title Number: " + title);
				System.out.println("");
				System.out.println("------------START-------------");
				String url_string = properties_url.getProperty(sb.toString());
				System.out.println("URL: " +url_string);
				System.out.println("");
				String alt_text_string = properties_alt.getProperty(sb1.toString());
				System.out.println("Alt Text: " + alt_text_string);
				System.out.println("");
				String title_string = properties_title.getProperty(sb2.toString());
				System.out.println("Title:" + title_string);
				System.out.println("");

				navigateTo_SDL_IMAGE(sb.toString());
				//System.out.println("window handles" + driver.getWindowHandles().size());
				//if(driver.getWindowHandles().size()>1){
                Thread.sleep(2000);
				try {
                    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).isDisplayed();
						System.out.println("Alert is shown at URL: ");
						//System.out.println(properties.getProperty(ID));
						System.out.println("NO SAVE - ERROR");
					System.out.println("");
					System.out.println("------------END-------------");
					System.out.println("");
						//	Assert.assertEquals(driver.findElements(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).size(), 0);

				} catch (NoSuchElementException e) {
					SDL_ItemPage.add_alt_text_to_metadata(alt_text_string, "");
					SDL_ItemPage.add_title_to_metadata(title_string, "");
					SDL_ItemPage.save_meta_data_update();
					SDL_ItemPage.verify_metadata_updated();
					System.out.println("Save Complete");
					System.out.println("");
					System.out.println("------------END-------------");
					System.out.println("");
				}
//					if (driver.findElements(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).size()>0) {
//					System.out.println("Alert is shown at URL: ");
//					//System.out.println(properties.getProperty(ID));
//					System.out.println("");
					//	Assert.assertEquals(driver.findElements(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).size(), 0);
			//	}
				//else if (driver.getWindowHandles().size()==1){
					//else if (driver.findElements(By.xpath("//div[contains(.,'Unable to load the item Do you want to close this window?')]")).size()==0){
//				else{
//				SDL_ItemPage.add_alt_text_to_metadata(alt_text_string, "");
//					SDL_ItemPage.add_title_to_metadata(title_string, "");
//					SDL_ItemPage.save_meta_data_update();
//					SDL_ItemPage.verify_metadata_updated();
//					System.out.println("Save Complete");
//				}
				url++;
				alt_text++;
				title++;

		}



    }

	@Then("^I should check in each image item$")
	public void iShouldCheckInEachImageItem() throws Throwable {
		int url = 1;
		while (url<20001){
			StringBuilder sb = new StringBuilder();
			sb.append("");
			sb.append(url);
			String url_string = sb.toString();
			System.out.println("url_string_right_before going to URL:" + url_string);
			navigateTo_SDL_IMAGE(url_string);
			SDL_ItemPage.check_in();
			url++;
			System.out.println("integer url after:" +url);
			refresh();
		}
	}
}