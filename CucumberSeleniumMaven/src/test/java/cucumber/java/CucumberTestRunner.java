package cucumber.java;

import org.junit.*;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
	features="src/test/resources/addTest.feature"
		)
public class CucumberTestRunner {
	//add comment to file, updates

}
