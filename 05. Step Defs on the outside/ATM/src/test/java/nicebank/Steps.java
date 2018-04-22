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
	is created.  This means that the initialised object 'helper' can call
	all methods from this class.  This instance 'should' keep the state between
	different step definition calls */
	public Steps() {
		helper = new knowsMyAccount();
	}

  //actor classes	
  class Account {
	private Money balance = new Money(); 
	 
    public void deposit(Money amount) {
    	balance = balance.add(amount);
    }
    
    public Money getBalance(){
    	return balance;
    }
  }
  
  class Teller {
	  public void withdrawFrom(Account account, int dollards){
		  
	  }
  }
  
  /*Helper Class named knowsMyaccount.  A method called getMyaccount
  which will be called in the step def constructor */  
  class knowsMyAccount {
	  private Account myAccount;
	  
	  public Account getMyAccount() {
		  if (myAccount == null){
			  myAccount = new Account();
		  }
		return myAccount;
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
  public void iWithdraw$(int amount) throws Throwable {
	  Teller teller = new Teller();
	  teller.withdrawFrom(helper.getMyAccount(), amount);
  }

  @Then("^\\$(\\d+) should be dispensed$")
  public void $ShouldBeDispensed(int arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }
  
}
