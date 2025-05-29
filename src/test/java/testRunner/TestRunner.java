package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"steps"},
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		dryRun = false,
		monochrome = true,
		tags= "@p1"
		
		) 
		
		//name = {"Logo"}


public class TestRunner {

	
	
}
