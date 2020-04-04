package glue;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.Assertion;
import framework.ParentScenario;
import page.objects.API_broker_endpoints;
import page.objects.API_content_endpoints;
import page.objects.API_ics_content;
//import java.lang.*;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SDL_API_StepDef extends ParentScenario {
    private String response = "";

    @When("^I query the Broker API$")
    public void iQueryTheBrokerAPI() throws Throwable {
        response = API_Broker.getBrokerResponseString();
    }

    @Then("^I can see the expected successful response code of (\\d+) for broker API$")
    public void iCanSeeTheExpectedSuccessfulResponseCodeOf(int arg0) throws Throwable {
        API_Broker.verifyBrokerResponse(API_Broker.getBrokerResponse());
    }

    @Then("^I can see the type listed as Entity$")
    public void iCanSeeTheTypeListedAsEntity() throws Throwable {

    }

    
    
    @And("^I can see the tcmID attribute$")
    public void iCanSeeTheTcmIDAttribute() throws Throwable {
       // API_Broker.verifyBrokerResponsesJSON();
    }

    @And("^I can see the Pages attribute$")
    public void iCanSeeThePagesAttribute() throws Throwable {
       // API_Broker.verifyBrokerResponse();
    }

    @And("^I an see the Components attribute$")
    public void iAnSeeTheComponentsAttribute() throws Throwable {
       // API_Broker.verifyBrokerResponse();
    }

    @Given("^I am a user with ICS API access in \"([^\"]*)\" environment$")
    public void iAmAUserWithICSAPIAccessInEnvironment(String env) throws Throwable {
        API_ICScontent.Validate_ICS_health_check(env);
    }

    @When("^I make a Request to OTA Content API$")
    public void iMakeARequestToOTAContentAPI() throws Throwable {
        API_ICScontent.get_ics_response_content();
    }

    @Then("^I should see the contact information from OTA content API returned$")
    public void iShouldSeeTheContactInformationFromOTAContentAPIReturned() throws Throwable {
        API_ICScontent.get_ics_contact_info();
    }

    @Then("^I can see the items array has expected structure for component information$")
    public void iCanSeeTheItemsArrayHasExpectedStructureForComponentInformation() throws Throwable {
        API_Broker.verifyBrokerItemArrayFormat(API_Broker.getBrokerResponse());
    }

    @Given("^I query the Transformer API for a \"([^\"]*)\" in environment \"([^\"]*)\"$")
    public void iQueryTheTransformerAPIForAInEnvironment(String type, String env) throws Throwable {
       API_Transform.GetTransformerResponse(env,type);
    }

    @Then("^I can see the expected response code of (\\d+) for Transformer API \"([^\"]*)\" in environment \"([^\"]*)\"$")
    public void iCanSeeTheExpectedResponseCodeOfForTransformerAPIInEnvironment(int code, String type, String env) throws Throwable {
        API_Transform.VerifyTransformerResponse(env,type);
    }

    @Given("^I query the Transformer API Health Check for \"([^\"]*)\" environment$")
    public void iQueryTheTransformerAPIHealthCheckForEnvironment(String env) throws Throwable {
        API_Transform.TransformerGetHealthCheck(env);
    }

    @Then("^I can see the expected response of (\\d+) for Transformer API Health Check for \"([^\"]*)\"$")
    public void iCanSeeTheExpectedResponseOfForTransformerAPIHealthCheckFor(int code, String env) throws Throwable {
        API_Transform.VerifyTransformerHealthCheck(env);
    }

    @And("^I add content to the page for beach overview page$")
    public void iAddContentToThePageForBeachOverviewPage() throws Throwable {
       System.out.println("Step Complete");
    }

    @Then("^I should see the page created$")
    public void iShouldSeeThePageCreated() throws Throwable {
        System.out.println("Step Complete");
    }

    @And("^I should see the page published$")
    public void iShouldSeeThePagePublished() throws Throwable {
        System.out.println("Step Complete");
    }

    @And("^I should see the page \"([^\"]*)\" in content service response$")
    public void iShouldSeeThePageInContentServiceResponse(String arg0) throws Throwable {
        System.out.println("Step Skipped");
    }


    @Then("^I will see the correct JSON Response from content service for \"([^\"]*)\"$")
    public void iWillSeeTheCorrectJSONResponseFromContentServiceFor(String type) throws Throwable {
       API_Content.ValidateContentResponse(type);
    }
}