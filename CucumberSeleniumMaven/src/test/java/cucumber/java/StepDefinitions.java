package cucumber.java;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	int result = 0;
	int first, second;

	WebDriver driver = null;
		
	@Given("^Two digits (\\d*) and (\\d*)$")
	public void have_Two_Digits(int a, int b){
		first = a;
		second = b;
	}
	
	@Given("^Go to URL (.*)$")
	public void chromeGoToURL(String url){
		try{
			
			URL seleniumServerUrl = null;
			try {
				seleniumServerUrl = new URL("http://localhost:9515");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver = new RemoteWebDriver(seleniumServerUrl, DesiredCapabilities.chrome());
			driver.get(url);
		}catch(Exception e){
			
		}
	}
	
	@When("^Add those two together$")
	public void add_digits(){
		result = first + second;
	}
	
	@When("^search using keyword \"(.*)\"$")
	public void search_keyword(String keyword){
		//bring browser to front
		driver.switchTo().window(driver.getWindowHandle());
		//enter keyword to search box
		WebElement searchTextBox = driver.findElement(By.id("gbqfq"));
		searchTextBox.sendKeys(keyword + "\n");
	}
	
	@Then("^result is (\\d+)$")
	public void check_result(int expected){
		Assert.assertEquals(expected, result);
	}
	
	@Then("get all results")
	public void get_google_result(){
		//wait for browser to load completely with timeout at 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//now get all link (which are result of searching)
		List<WebElement> results = driver.findElements(By.className("r"));
		//print title to ensure that it is searched with specified keyword
		System.out.println(driver.getTitle() + " " + results.size());
		for(int i = 0; i < results.size(); i++){
			WebElement el = results.get(i).findElement(By.tagName("a"));
			System.out.println(el.getAttribute("text"));
		}
	}

}
