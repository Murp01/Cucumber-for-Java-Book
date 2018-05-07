package support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.Teller;

/*Helper Class named knowsMyaccount.  A method called getMyaccount
which will be called in the step def constructor */ 
public class KnowsTheDomain {
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
