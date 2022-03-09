package myRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/appFeatures"},
		glue = {"stepdef","appHooks"},
		monochrome = true,
		plugin = {"pretty"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
