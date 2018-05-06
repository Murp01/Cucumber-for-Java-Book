package transforms;

import cucumber.api.Transformer;

import nicebank.Money;

public class MoneyConverter extends Transformer<Money> {
	public Money transform (String amount) {
		String[] numbers = amount.split("\\.");
		
		int dollars = Integer.parseInt(numbers[0]);
		int cents = Integer.parseInt(numbers[1]);
		
		return new Money(dollars, cents);		
	}

}

/*Transformers work on caputred arguments.  Each transform is responsible
for converting a captured String into something more meaningful. for 
example, we can use a Transformer to take a string argument that contains
a monetary amount and turn it into an instance of the Money class.  Here 
I have created a Money Converter transformer.*/