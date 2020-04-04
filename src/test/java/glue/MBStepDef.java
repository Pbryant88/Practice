package glue;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.ParentScenario;

import static org.hamcrest.core.Is.is;

public class MBStepDef extends ParentScenario {

    @Given("^I log in as a Media Beacon User With all Roles in environment \"([^\"]*)\"$")
    public void iLogInAsAMediaBeaconUserWithAllRolesInEnvironment(String env) throws Throwable {
        if (env.equals("qa_5555")) {navigateTo_MB_QA_5555();
            MBLoginPage.enterLoginCredentials("QA");
        }
        if (env.equals("qa_8080")) {navigateTo_MB_QA_8080();
            MBLoginPage.enterLoginCredentials("QA");
        }
        if (env.equals("sandbox")) {navigateTo_MB_SB();
            MBLoginPage.enterLoginCredentials("SB");
        }
    }

    @Given("^I log in as a Media Beacon User With all Roles$")
    public void I_am_on_the_SDL_Web8_Login_Page() {
        navigateTo_MB_QA_5555();
        MBLoginPage.enterLoginCredentials("QA");
    }

    @When("^I select the \"([^\"]*)\" role$")
    public void iSelectTheRole(String role) throws Throwable {
        System.out.println("Step 2" + role);
        //MBHomepage.select_acl_role(role);
    }

    @When("^I create an asset$")
    public void iCreateAnAsset() throws Throwable {
        MBAsset.create_asset();
    }

    @Then("^I should see the asset created$")
    public void iShouldSeeTheAssetCreated() throws Throwable {
        MBAsset.verify_asset();
    }

    @When("^I edit an asset$")
    public void iEditAnAsset() throws Throwable {
        MBAsset.edit_asset();
    }

    @Then("^I should see the asset edited$")
    public void iShouldSeeTheAssetEdited() throws Throwable {
        MBAsset.verify_asset();
    }

    @When("^I delete an asset$")
    public void iDeleteAnAsset() throws Throwable {
        MBAsset.delete_asset();
    }

    @Then("^I should see the asset deleted$")
    public void iShouldSeeTheAssetDeleted() throws Throwable {
        MBAsset.verify_asset();
    }

    @And("^I should see Contact us Link$")
    public void iShouldSeeContactUsLink() throws Throwable {
        MBHomepage.IsContactUsLinkDisplayed();
    }

    @And("^I Should see or not see Quick Search based on role \"([^\"]*)\"$")
    public void iShouldSeeOrNotSeeQuickSearchBasedOnRole(String role) throws Throwable {
        MBHomepage.ValidateQuickSearchBasedOnRole(role);
    }

    @Then("^I should see or not see Quick Links based on role \"([^\"]*)\"$")
    public void iShouldSeeOrNotSeeQuickLinksBasedOnRole(String role) throws Throwable {
        MBHomepage.ValidateQuickLinkBasedOnRole(role);
    }

    @And("^I should see User info based on role \"([^\"]*)\"$")
    public void iShouldSeeUserInfoBasedOnRole(String role) throws Throwable {
        MBHomepage.IsMEIconDisplayed(role);
    }

    @And("^I should see Help, Contact us, and Terms of Use Link based on role \"([^\"]*)\"$")
    public void iShouldSeeHelpLinkAndTermsOfUseLinkBasedOnRole(String role) throws Throwable {
       // MBHomepage.ValidateHelpContactAndTermLinkBasedOnRole(role);
        System.out.println("MBHomepage.ValidateHelpContactAndTermLinkBasedOnRole(role)");
    }

    @Then("^I should see the expected filters for \"([^\"]*)\"$")
    public void iShouldSeeTheExpectedFiltersFor(String role) throws Throwable {
       System.out.println("replacement");
       // MBHomepage.ValidateSearchFilterBasedOnRole(role);
    }

}