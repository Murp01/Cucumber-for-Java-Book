Feature: Withdraw Fixed Amount
	The "Withdraw Cash" menu contains several fixed amounts to speed up transactions for users.  This example adds larger placeholders that include text

	Scenario Outline: Withdraw Fixed Amount
		Given I have <Balance> in my account
		When I choose to withdraw the fixed amount of <Withdrawel>
		Then I should <Outcome>
		And the balance of my account should be <Remaining>
		
		Scenarios:
		| Balance | Withdrawel | Outcome  			  | Remaining |
		| $500    | $50        | recieve $50 cash     |      $450 |
		| $500    | $100       | recieve $100 cash    |      $400 |
		| $100    | $200       | see an error message |      $100 |