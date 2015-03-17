package GludeCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learn.bdd.VendingMachine.DrinkService;

public class DrinkServiceStub implements DrinkService
{
	public DrinkServiceStub(){
		initializeStock();
	}
	
	List<BigDecimal> price = new ArrayList<BigDecimal>();
	Map<String, Integer> stock = new HashMap<String, Integer>();
	
	public boolean initializeStock(){
		stock.put("water",20);
		stock.put("softdrink",10);		
		stock.put("juice",15);		
		price.add(new BigDecimal(1.00));
		price.add(new BigDecimal(1.25));
		price.add(new BigDecimal(1.50));
	return true;
	}


	@Override
	public List<BigDecimal> fetchPrice(String drinkName)
	{		
		List<BigDecimal> item = new ArrayList<BigDecimal>();
			if(drinkName== "water"){
					item.add(price.get(0));		
			}else if(drinkName == "softdrink"){	
				item.add(price.get(1));
			}else if(drinkName == "juice"){
				item.add(price.get(2));
			}
		return item;		
	}

}