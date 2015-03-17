package com.learn.bdd.VendingMachine;

import java.math.BigDecimal;

public interface VendingMachine {

    boolean initializeStock();
	int checkStock(String drinkName);
	boolean buyDrink(BigDecimal decimal, String drinkName);
}
