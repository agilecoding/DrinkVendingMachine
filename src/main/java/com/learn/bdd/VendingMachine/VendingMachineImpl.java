package com.learn.bdd.VendingMachine;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachineImpl implements VendingMachine
{
	private final DrinkService drinkService;
	private Map<String, AtomicInteger> stock = new HashMap<String, AtomicInteger>();
	
	public VendingMachineImpl(DrinkService drinkService) {		
		this.drinkService = drinkService;
		initializeStock();
	}

	@Override
	public boolean initializeStock() {
		  stock.put("water", new AtomicInteger(20));
		  stock.put("juice", new AtomicInteger(15));
		  stock.put("softdrink", new AtomicInteger(10));
		return true;
	}	
    
	@Override
	public int checkStock(String drinkName) {
		return stock.get(drinkName).intValue();
	}

	@Override
	public boolean buyDrink(BigDecimal decimal, String drinkName) {		
		
		List<BigDecimal> drinks = drinkService.fetchPrice(drinkName);
		BigDecimal item = null;

		int index = 0;
			
		if(drinkName =="water" && drinkName != null){
			 index = 0;		
		}else if(drinkName == "softdrink" && drinkName != null){
			index = 1;			
		}else if(drinkName == "juice" && drinkName != null){
			index = 2;					
		}else{
			throw new IllegalStateException("Transaction Failed: invalid drink requested");
		}
					
		switch (index){
			case 0:
				item = drinks.get(0);
				break;
			case 1:			
				item = drinks.get(0);
				break;
			case 2:			
				item = drinks.get(0);
				break;
        }
       
		
		if(decimal.subtract(new BigDecimal(item.doubleValue())).doubleValue() < 0)
		{
			 throw new IllegalStateException("Transaction Failed: not enough funds");
		}else if(decimal.subtract(new BigDecimal(drinks.get(0).doubleValue())).doubleValue() > 0){
			throw new IllegalStateException("Transaction Failed: please put in exact amount");
		}
		
		if(drinkName == "water" && decimal.equals(new BigDecimal(1.0))){
				stock.get(drinkName).decrementAndGet();
			return true;
			}else if(drinkName == "softdrink" && decimal.equals(new BigDecimal(1.25))){
				stock.get(drinkName).decrementAndGet();
			return true;
			}else if(drinkName == "juice" && decimal.equals(new BigDecimal(1.50))){
				stock.get(drinkName).decrementAndGet();
			return true;
			}
		
		return false;
	}
}
