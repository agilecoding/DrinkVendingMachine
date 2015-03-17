Feature: Buying a drink from Vending Machine

In order to buy a drink
As a Vending Machine user
I want to pay the exact price listed

Background:
Given stock for <Drink> exist
	|Drink    | Stock| Price|
	|water    | 20   | 1.0  |
	|softdrink| 10   | 1.25 |
	|juice    | 15   | 1.50 |

Scenario: Buy any valid drink for the exact price displayed on vending machine
And User puts in exact change for the price and selects the drink
Then Vending Machine should deliver the requested drink
And the stock for the drink must be auto decremented

@BuyAnInvalidDrinkFromVendingMachine
Scenario: Buy an invalid drink from vending machine
And User wants to buy an invalid <Drink>
		| Drink        | Stock| Price |
		| vitamindrink | 8    |  2.00 |
Then Vending Machine should alert the user with exception "invalid drink"

@BuyAValidDrinkForLessAmountThanPrice
Scenario: Buy a valid drink for lesser amount than the expected price
And User puts in "lesser amount" than the price and selects the <Drink>	
	|Drink    | Stock| Price|
	|water    | 20   | 0.50 |
	|softdrink| 10   | 1.00 |
	|juice    | 15   | 1.25 |
Then Vending Machine should alert the user with exception "insufficient funds"

@BuyAValidDrinkForMoreAmountThanPrice
Scenario: Buy a valid drink for more amount than the expected price
And User puts in "greater amount" than the price and selects the <Drink>	
	|Drink    | Stock| Price|
	|water    | 20   | 1.25 |
	|softdrink| 10   | 1.75 |
	|juice    | 15   | 2.25 |
Then Vending Machine should alert the user with exception "exact funds needed"