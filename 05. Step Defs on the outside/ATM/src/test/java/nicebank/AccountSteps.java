package nicebank;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

public class AccountSteps {		//Seems the picocontainer is out of date.  Look at book's website
	KnowsTheDomain helper;

	public AccountSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}	
	
	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class)Money amount) throws Throwable {
		//Notice the helper instantiation calls two methods, in an order
		helper.getMyAccount().deposit(amount);	  
		Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}

}
