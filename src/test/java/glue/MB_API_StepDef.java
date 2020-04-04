package glue;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpResponse;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.Assertion;
import framework.ParentScenario;
import page.objects.API_broker_endpoints;
import page.objects.API_ics_content;
import page.objects.MB_API_endpoints;

//import java.lang.*;

public class MB_API_StepDef {
    @Given("^I query the media beacon API in QA with string \"([^\"]*)\"$")
    public void iQueryTheMediaBeaconAPIInQAWithString(String search) throws Throwable {
        MB_API_endpoints.MBQuickSearchResponse(search);
    }

    @Then("^I will see the expected response code for string \"([^\"]*)\"$")
    public void iWillSeeTheExpectedResponseCode(String search) throws Throwable {
        MB_API_endpoints.ValidateResponseCode(search);
    }

    @And("^I will see the expected response format for string \"([^\"]*)\"$")
    public void iWillSeeTheExpectedResponseFormat(String search) throws Throwable {
        MB_API_endpoints.ValidateResponseFormatQuickSearch(search);
    }

    @Given("^I query the media beacon API in QA for src folder content$")
    public void iQueryTheMediaBeaconAPIInQAForSrcFolderContent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I will see the expected response code for folder content at src directory$")
    public void iWillSeeTheExpectedResponseCodeForFolderContentAtSrcDirectory() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I will see the expected response format for folder content at src directory$")
    public void iWillSeeTheExpectedResponseFormatForFolderContentAtSrcDirectory() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I query the media beacon API in QA for WDPRO Assets folder content$")
    public void iQueryTheMediaBeaconAPIInQAForWDPROAssetsFolderContent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I will see the expected response code for folder content at WDPRO Assets directory$")
    public void iWillSeeTheExpectedResponseCodeForFolderContentAtWDPROAssetsDirectory() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I will see the expected response format for folder content at WDPRO Assets directory$")
    public void iWillSeeTheExpectedResponseFormatForFolderContentAtWDPROAssetsDirectory() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I query the media beacon API in QA for  folder contents of folder \"([^\"]*)\"$")
    public void iQueryTheMediaBeaconAPIInQAForFolderContentsOfFolder(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I will see the expected response code for folder content of folder \"([^\"]*)\"$")
    public void iWillSeeTheExpectedResponseCodeForFolderContentOfFolder(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I will see the expected response format for folder content of folder \"([^\"]*)\"$")
    public void iWillSeeTheExpectedResponseFormatForFolderContentOfFolder(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
