Feature: Withdraw Fixed Amount
	The "Withdraw Cash" menu contains several fixed amounts to speed up transactions for users.  This example adds larger placeholders that include text

	Scenario Outline: Withdraw Fixed Amount
		Given I have <Balance> in my account
		When I choose to withdraw the fixed amount of <Withdrawel>
		Then I should <Outcome>
		And the balance of my account should be <Remaining>
		
		Scenarios: Successful withdrawel
			Withdrawel of an amount which is available in the account
		| Balance | Withdrawel | Outcome  			  | Remaining |
		| $500    | $50        | recieve $50 cash     |      $450 |
		| $500    | $100       | recieve $100 cash    |      $400 |
				
		Scenarios: Attempt to withdraw too much
			Withdrawel of an amount which is more than what is available in the account
		| Balance | Withdrawel | Outcome  			  | Remaining |		
		| $100    | $200       | see an error message |      $100 |
		| $0	  | $50        | see an error message |      $0   |
		