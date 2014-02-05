package cucumber.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	int result = 0;
	int first, second;
//	ChromeDriver chromeDriver = new ChromeDriver();
	
//	WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
	
	
	@Given("^Two digits (\\d*) and (\\d*)$")
	public void have_Two_Digits(int a, int b){
		first = a;
		second = b;
	}
	
	@Given("^Go to URL (.*)$")
	public void chromeGoToURL(String url){
		try{
			System.setProperty("webdriver.chrome.driver", "/Users/ai13/Programming/GitWorkspace/Java/CucumberSeleniumMaven/src/test/resources");
			
			URL seleniumServerUrl = null;
			try {
				seleniumServerUrl = new URL("http://localhost:9515");
				URL serverUnderTest = new URL("http://www.google.com");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			WebDriver driver = new RemoteWebDriver(seleniumServerUrl, DesiredCapabilities.chrome());
			driver.get(url);
		}catch(Exception e){
			
		}
//		chromeDriver.get(url);
	}
	
	@When("^Add those two together$")
	public void add_digits(){
		result = first + second;
	}
	
	@Then("^result is (\\d+)$")
	public void check_result(int expected){
		Assert.assertEquals(expected, result);
	}

}
