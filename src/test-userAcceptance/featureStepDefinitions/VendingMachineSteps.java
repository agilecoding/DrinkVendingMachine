package featureStepDefinitions;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import glueCode.DrinkServiceStub;
import glueCode.VendingMachineStub;

import com.learn.bdd.VendingMachine.Drink;
import com.learn.bdd.VendingMachine.DrinkInventory;
import com.learn.bdd.VendingMachine.DrinkService;
import com.learn.bdd.VendingMachine.VendingMachine;
import com.learn.bdd.VendingMachine.VendingMachineImpl;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VendingMachineSteps {
	
	VendingMachineImpl vendingMachine = new VendingMachineImpl(new DrinkServiceStub());	
	DrinkService drinkService = new DrinkServiceStub();
	VendingMachine vendingMachineService = new VendingMachineStub();
	private int stock;
	private int quantity;
	Drink drink;
    String drinkName = null;
	private boolean purchased = false;
	List<DrinkInventory> stocksSpecifiedBySpec =  new ArrayList<DrinkInventory>();
	Map<String, Integer> stockMap = new HashMap<String,Integer>();
	Map<String, String> errorMap = new HashMap<String,String>();
	List<String> waterComments = new ArrayList<String>();
	List<String> softdrinkComments = new ArrayList<String>();
	List<String> juiceComments = new ArrayList<String>();

	@Given("^stock for <Drink> exist$")
	public void stock_for_Drink_exist(DataTable cukeTable) throws Throwable {
			boolean initialized = vendingMachine.initializeStock();
			assertThat(initialized).isTrue();
		    stocksSpecifiedBySpec = cukeTable.asList(DrinkInventory.class);				
			
			for(DrinkInventory drinkInventory : stocksSpecifiedBySpec)
			{
				drinkName =drinkInventory.getDrink();
				int quantity = vendingMachine.checkStock(drinkName);			
				switch (quantity) {
					case 10: 
						assertThat(drinkName).isEqualTo("softdrink");
						drink = Drink.softdrink;
						softdrinkComments.add("User wants to buy softdrink!");
						softdrinkComments.add("Stock initialized for softdrink");
					break;
					case 15: 
						assertThat(drinkName).isEqualTo("juice");
						drink = Drink.juice;
						juiceComments.add("User wants to buy juice!");
						juiceComments.add("Stock initialized for juice");
					break;
					case 20: 
						assertThat(drinkName).isEqualTo("water");
						drink = Drink.water;
						waterComments.add("User wants to buy water!");
						waterComments.add("Stock initialized for water");
					break;
				default: 
					   System.out.println("	Drink not supported to be initialized");
					   drink = Drink.unknown;
					break;
				}
			}	
	}

	@When("^User puts in exact change for the price and selects the drink$")
	public void user_puts_in_exact_change_for_the_price_and_selects_the_drink() throws Throwable {	
		for(DrinkInventory drinkInventory : stocksSpecifiedBySpec)
		{
			BigDecimal price =  drinkInventory.getPrice();
			String name = drinkInventory.getDrink();
			drink = Drink.valueOf(name);
			switch(drink) {
			case water:
				new DrinkServiceStub();
				purchased = vendingMachine.buyDrink(new BigDecimal(1.00), "water");
				waterComments.add("Accepted $ "+price.setScale(2)+" for water");
				break;
			case softdrink:
				new DrinkServiceStub();
				purchased = vendingMachine.buyDrink(new BigDecimal(1.25), "softdrink");
				softdrinkComments.add("Accepted $ "+price.setScale(2)+" for softdrink");
				break;
			case juice:
				new DrinkServiceStub();
				purchased = vendingMachine.buyDrink(new BigDecimal(1.50), "juice");
				juiceComments.add("Accepted $ "+price.setScale(2)+" for juice");
				break;
			default:
				System.out.println("	Non supported Drink can't be purchased");
				purchased = false;
				break;
			}
		}
	}

	@Then("^Vending Machine should deliver the requested drink$")
	public void vending_Machine_should_deliver_the_requested_drink() throws Throwable {
		for(DrinkInventory drinkInventory : stocksSpecifiedBySpec)
		{
			String name = drinkInventory.getDrink();
			drink = Drink.valueOf(name);
			switch(drink) {
			case water:
				stock = vendingMachineService.checkStock("water");
				quantity = vendingMachine.checkStock("water");
				assertThat(quantity).isEqualTo(stock -1);
				stockMap.put("water", (stock -1));
				assertTrue(purchased);
				waterComments.add("water drink is delivered");
				waterComments.add("");
			break;
			case juice:
				//stock = drinkService.checkStock("juice");
				stock = vendingMachineService.checkStock("juice");
				quantity = vendingMachine.checkStock("juice");
				assertThat(quantity).isEqualTo(stock -1);
				stockMap.put("juice", (stock -1));
				assertTrue(purchased);
				juiceComments.add("juice drink is delivered");
				juiceComments.add("");
			break;
			case softdrink:
				stock = vendingMachineService.checkStock("softdrink");
				quantity = vendingMachine.checkStock("softdrink");
				assertThat(quantity).isEqualTo(stock -1);
				stockMap.put("softdrink", (stock -1));
				assertTrue(purchased);
				softdrinkComments.add("softdrink drink is delivered");
				softdrinkComments.add("");
			break;
			default:
				System.out.println("Non supported Drink and can not be delivered");
				assertFalse(purchased);
			break;		
			}
		}
				Iterator<String> water = waterComments.iterator();
			      	while(water.hasNext()) {
			          Object element = water.next();
			          System.out.println(element + " ");
			       }
				Iterator<String> softdrink = softdrinkComments.iterator();
				     while(softdrink.hasNext()) {
				          Object element = softdrink.next();
				          System.out.println(element + " ");
				       }
		        Iterator<String> juice = juiceComments.iterator();
			         while(juice.hasNext()) {
			              Object element = juice.next();
			              System.out.println(element + " ");
			       }

	}
	
	@Then("^the stock for the drink must be auto decremented$")
	public void the_stock_for_the_drink_must_be_auto_decremented() throws Throwable {
			assertSame(Integer.valueOf(stockMap.get("water")),Integer.valueOf(19));
			assertSame(Integer.valueOf(stockMap.get("softdrink")),Integer.valueOf(9));
			assertSame(Integer.valueOf(stockMap.get("juice")),Integer.valueOf(14));
	}
	
	@When("^User wants to buy an invalid <Drink>$")
	public void user_wants_to_buy_an_invalid_drink(DataTable invalidDrink) throws Throwable {
	       stocksSpecifiedBySpec = invalidDrink.asList(DrinkInventory.class);
	       drinkName = stocksSpecifiedBySpec.get(0).getDrink();     
	}
	
	@Then("^Vending Machine should alert the user with exception \"(.*?)\"$")
	public void vending_Machine_should_alert_the_user_with_exception(String exception) throws Throwable {
			if(exception.equalsIgnoreCase("insufficient funds")){
					assertThat(errorMap.get("water"), is("Transaction Failed: not enough funds"));
				    assertThat(errorMap.get("softdrink"), is("Transaction Failed: not enough funds"));
				    assertThat(errorMap.get("juice"), is("Transaction Failed: not enough funds"));
			     }

			if(exception.equalsIgnoreCase("invalid drink")){
				  System.out.println("Transaction Failed: invalid drink requested "+ drinkName);
		          try{
		    		   new DrinkServiceStub();
				       vendingMachine.buyDrink(stocksSpecifiedBySpec.get(0).getPrice(), drinkName);	 
			           }catch (RuntimeException e) {
			           assertThat(e.getMessage().toString(), is("Transaction Failed: invalid drink requested"));	           
			           }
			}
			
	}
	
	@When("^User puts in \"(.*?)\" than the price and selects the <Drink>$")
	public void user_puts_in_than_the_price_and_selects_the_Drink(String scenario, DataTable specTable) throws Throwable {
	       stocksSpecifiedBySpec = specTable.asList(DrinkInventory.class);
		   Integer count = null;
		   if(scenario.equalsIgnoreCase("lesser amount")){
				count = 0;
			}else if(scenario.equalsIgnoreCase("greater amount")){
				count = 1;
			}

		   //Switching between the 2 scenarios "paid lesser or greater amount"
		 switch(count){
		   //Switching between 3 drinks
			case 0:				
				   for(DrinkInventory drinkInventory : stocksSpecifiedBySpec){
						String name = drinkInventory.getDrink();
						drink = Drink.valueOf(name);
						switch(drink) {
							case water:
								try{
								new DrinkServiceStub();
								purchased = vendingMachine.buyDrink(stocksSpecifiedBySpec.get(0).getPrice(), "water");
								}catch(RuntimeException e){
									assertThat(e.getMessage().toString(), is("Transaction Failed: not enough funds"));
									errorMap.put("water", e.getMessage());
									System.out.println("Transaction Failed: not enough funds for water");
								}
							break;
							case softdrink:
								try{
								new DrinkServiceStub();
								purchased = vendingMachine.buyDrink(stocksSpecifiedBySpec.get(1).getPrice(), "softdrink");
								}catch(RuntimeException e){
									assertThat(e.getMessage().toString(), is("Transaction Failed: not enough funds"));
									errorMap.put("softdrink", e.getMessage());
									System.out.println("Transaction Failed: not enough funds for softdrink");
								}
							break;
							case juice:
								try{
								new DrinkServiceStub();
								purchased = vendingMachine.buyDrink(stocksSpecifiedBySpec.get(2).getPrice(), "juice");
								}catch(RuntimeException e){
									assertThat(e.getMessage().toString(), is("Transaction Failed: not enough funds"));
									errorMap.put("juice", e.getMessage());
									System.out.println("Transaction Failed: not enough funds for juice");
								}
							break;
							default:
								System.out.println("	Non supported Drink can't be purchased");
								purchased = false;
							break;
							}
						}
			break; 
			   
            case 1:			
				   for(DrinkInventory drinkInventory : stocksSpecifiedBySpec){
						String name = drinkInventory.getDrink();
						drink = Drink.valueOf(name);
						switch(drink) {
							case water:
								try{
								new DrinkServiceStub();
								purchased = vendingMachine.buyDrink(stocksSpecifiedBySpec.get(0).getPrice(), "water");
								}catch(RuntimeException e){
									assertThat(e.getMessage().toString(), is("Transaction Failed: please put in exact amount"));
									errorMap.put("water", e.getMessage());
									System.out.println("Transaction Failed: please put in exact amount for water");
								}
							break;
							case softdrink:
								try{
								new DrinkServiceStub();
								purchased = vendingMachine.buyDrink(stocksSpecifiedBySpec.get(1).getPrice(), "softdrink");
								}catch(RuntimeException e){
									assertThat(e.getMessage().toString(), is("Transaction Failed: please put in exact amount"));
									errorMap.put("softdrink", e.getMessage());
									System.out.println("Transaction Failed: please put in exact amount for softdrink");
								}
							break;
							case juice:
								try{
								new DrinkServiceStub();
								purchased = vendingMachine.buyDrink(stocksSpecifiedBySpec.get(2).getPrice(), "juice");
								}catch(RuntimeException e){
									assertThat(e.getMessage().toString(), is("Transaction Failed: please put in exact amount"));
									errorMap.put("juice", e.getMessage());
									System.out.println("Transaction Failed: please put in exact amount for juice");
								}
							break;
							default:
								System.out.println("	Non supported Drink can't be purchased");
								purchased = false;
							break;
							}
						}
					   
			break;
		}
	}
}