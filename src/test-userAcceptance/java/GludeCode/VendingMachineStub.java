package GludeCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.learn.bdd.VendingMachine.VendingMachine;

public class VendingMachineStub implements VendingMachine{

	private Map<String, AtomicInteger> stock = new HashMap<String, AtomicInteger>();
	private List<BigDecimal> price = new ArrayList<BigDecimal>();
	
	public VendingMachineStub(){
		initializeStock();
	}

	@Override
	public boolean initializeStock() {	
			  stock.put("water", new AtomicInteger(20));
			  stock.put("softdrink", new AtomicInteger(10));
			  stock.put("juice", new AtomicInteger(15));
			price.add(new BigDecimal(1.00));
			price.add(new BigDecimal(1.25));
			price.add(new BigDecimal(1.50));
		  return true;
	}

	@Override
	public int checkStock(String drinkName) {
			int value = 0;
			if(drinkName== "water"){
				value = stock.get(drinkName).intValue();
		    }else if(drinkName == "softdrink"){	
		    	value = stock.get(drinkName).intValue();
		    }else if(drinkName == "juice"){
		    	value = stock.get(drinkName).intValue();
		    }
		return value;
	}

	@Override
	public boolean buyDrink(BigDecimal decimal, String drinkName) {
			if(drinkName == "water" && decimal.equals(new BigDecimal(1.0)))
			{
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
