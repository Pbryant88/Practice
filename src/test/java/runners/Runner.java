package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;
import framework.ParentScenario;

import java.io.File;

@CucumberOptions(
        features = {"src/test/resources/features/SDL/SDL_Save_Metadata_on_Images.feature"},
        glue = "glue",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
                "pretty", "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "usage:target/cucumber-usage.json"},
        tags = {"@mb,@sdl,@smoke,@jenk,~@wip,~@defect, ~@manual"})
        

public class Runner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() throws Exception {
        String className = this.getClass().getName();

        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File("target/report.html"), false);
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(new File("target/" + className + ".html"), false);

        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/java/runners/extent-config.xml"));
    }

}