package Pages;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = {"src/test/resources/features/signin.feature"},
	    glue = {"Pages"},
	    plugin = {"pretty", "html:target/htmlreport.html"}
	)
public class testRunner extends AbstractTestNGCucumberTests {

}
