package com.learn.bdd.IntegrationTest;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.learn.bdd.VendingMachine.DrinkService;
import com.learn.bdd.VendingMachine.DrinkServiceImpl;
import com.learn.bdd.VendingMachine.VendingMachine;
import com.learn.bdd.VendingMachine.VendingMachineImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:database-integration-context.xml"})
public class DrinkServiceImplTest
{

	@Autowired
	private DataSource dataSource;

	@Test
	public void checkPriceOfDrinkWater()
	{
		DrinkService drinkService = new DrinkServiceImpl(dataSource);
		List<BigDecimal> drinks = drinkService.fetchPrice("water");
		BigDecimal price = drinks.get(0);
		assertThat(price).isEqualTo(new BigDecimal(1.00).setScale(2));
	}
	
	@Test
	public void checkPriceOfDrinkJuice()
	{
		DrinkService drinkService = new DrinkServiceImpl(dataSource);
		List<BigDecimal> drinks = drinkService.fetchPrice("juice");
		BigDecimal price = drinks.get(0);
		assertThat(price).isEqualTo(new BigDecimal(1.50).setScale(2));
	}
	
	@Test
	public void checkPriceOfDrinkSoftDrink()
	{
		DrinkService drinkService = new DrinkServiceImpl(dataSource);
		List<BigDecimal> drinks = drinkService.fetchPrice("softdrink");
		BigDecimal price = drinks.get(0);
		assertThat(price).isEqualTo(new BigDecimal(1.25).setScale(2));
	}
	
	@Test
	public void checkStockOfDrinkWater()
	{
		DrinkService drinkService = new DrinkServiceImpl(dataSource);
		VendingMachine vendingMachineService = new VendingMachineImpl(drinkService);
		Integer stock =  vendingMachineService.checkStock("water");
		assertThat(stock).isEqualTo(20);
	}
	
}
