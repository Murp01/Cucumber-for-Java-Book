/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
***/
package nicebank;

import cucumber.api.java.en.*;
import org.junit.Assert;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import transforms.MoneyConverter;

public class Steps {
	knowsMyAccount helper;
	
	/*Step definition class constructor where an instance of knowsMyAccount
	is created.  This means that the initialised object 'helper' is of the 
	knowsMyAccount type and contains all its methods.  This instance 
	'should' keep the state between
	different step definition calls */
	public Steps() {
		helper = new knowsMyAccount();
	}

  /*Helper Class named knowsMyaccount.  A method called getMyaccount
  which will be called in the step def constructor */  
  class knowsMyAccount {
	  private Account myAccount;
	  private CashSlot cashSlot;
	  private Teller teller;
	  
	  public Account getMyAccount() {
		  if (myAccount == null){
			  myAccount = new Account();
		  }
		return myAccount;
	  }
	  
	  public CashSlot getCashSlot(){
		  if (cashSlot == null ){
			  cashSlot = new CashSlot();				  
		  }
			  return cashSlot;
		  }
	  
	  public Teller getTeller() {
	      if (teller == null){
	        teller = new Teller(getCashSlot());
	      }
	
	      return teller;
	    }
  
	  }
    
  //step definitions
  
  @Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
  public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class)Money amount) throws Throwable {
      //Notice the helper instantiation calls two methods, in an order
	  helper.getMyAccount().deposit(amount);	  
	  Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
  }
  
  @When("^I withdraw \\$(\\d+)$")
  public void iWithdraw$(int dollars) throws Throwable {
	  helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
  }

  @Then("^\\$(\\d+) should be dispensed$")
  public void $ShouldBeDispensed(int dollars) throws Throwable {
	  Assert.assertEquals("Incorrect amount dispensed" , dollars, helper.getCashSlot().getContents());
  }
  
}
