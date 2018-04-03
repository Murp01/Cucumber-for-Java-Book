Feature: Withdraw Fixed Amount
	The "Withdraw Cash" menu contains several fixed amounts to speed up transactions for users

	Scenario Outline: Withdraw Fixed Amount
		Given I have <Balance> in my account
		When I choose to withdraw the fixed amount of <Withdrawel>
		Then I should recieve <Recieved> cash
		And the balance of my account should be <Remaining>
		
		Scenarios:
		| Balance | Withdrawel | Recieved | Remaining |
		| $500    | $50        |     $50  |      $450 |
		| $500    | $100       |     $100 |      $400 |
		| $500    | $200       |     $200 |      $300 |