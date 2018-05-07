package nicebank;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import support.KnowsTheDomain;

public class CashSlotSteps {
	KnowsTheDomain helper;

	public CashSlotSteps() {
		helper = new KnowsTheDomain();
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
		Assert.assertEquals("Incorrect amount dispensed" , dollars, helper.getCashSlot().getContents());
	}	

}
