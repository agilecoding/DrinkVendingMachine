package com.learn.bdd.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public interface DrinkService
{
	List<BigDecimal> fetchPrice(String name);
}