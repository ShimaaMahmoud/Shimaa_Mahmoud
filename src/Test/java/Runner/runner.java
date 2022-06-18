//Automation test for registration and login page for Facebook
// using selenium and cucumber framework


package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(features = "src/main/resources/Features" ,glue="Steps",
            plugin = {"pretty",
                    "html:target/cucumber.html",
                    "json:target/cucumber.json",
                    "junit:target/cukes.xml",
                    "rerun:target/rerun.txt"}
            //tags = "@s"
    )
    public class runner  extends AbstractTestNGCucumberTests {
    }

