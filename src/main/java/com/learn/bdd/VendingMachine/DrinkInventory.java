package com.learn.bdd.VendingMachine;


import java.math.BigDecimal;

public class DrinkInventory {

	private String drink;
	private int stock;
	private BigDecimal price;

	public DrinkInventory(String Drink, int Stock, BigDecimal Price ){
		this.drink = Drink;
		this.stock = Stock;
		this.price = Price;
	}
	
	public String getDrink(){
		return drink;
	}
	
	public int getStock(){
		return stock;
	}
	
	public BigDecimal getPrice(){
		return price;
	}
}