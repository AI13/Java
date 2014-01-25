package cucumber.java;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	int result = 0;
	int first, second;
	
	@Given("^Two digits (\\d*) and (\\d*)$")
	public void have_Two_Digits(int a, int b){
		first = a;
		second = b;
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
