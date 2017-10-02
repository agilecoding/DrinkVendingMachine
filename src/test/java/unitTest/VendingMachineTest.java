package unitTest;

import static org.fest.assertions.Assertions.assertThat;
import glueCode.DrinkServiceStub;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.learn.bdd.VendingMachine.VendingMachineImpl;

public class VendingMachineTest{
	
	private VendingMachineImpl vendingMachineUnderTest;

		@Rule
		public ExpectedException expectedEx = ExpectedException.none();
		
		@Before
		public void setup(){
			
			vendingMachineUnderTest = new VendingMachineImpl(new DrinkServiceStub());}
		
		@Test
		public void checkThatWaterDrinkHasAStockOf20() throws Exception{
		      	int Quantity = vendingMachineUnderTest.checkStock("water");
				assertThat(Quantity).isEqualTo(20);}
		
		@Test
		public void BuyAWaterDrinkSuccessfully(){
			int stock = 20;
			vendingMachineUnderTest.buyDrink(new BigDecimal(1.00), "water");
			int quantity = vendingMachineUnderTest.checkStock("water");
			assertThat(quantity).isEqualTo(stock -1);}
		
		@Test
		public void checkWaterDrinkStockAfterOnePurchase(){
			vendingMachineUnderTest.buyDrink(new BigDecimal(1.0), "water");
			int quantity = vendingMachineUnderTest.checkStock("water");
			assertThat(quantity).isEqualTo(19);}
		
		@Test
		public void checkWaterDrinkStockAfterThreePurchase(){
			int stock = 20;
			for(int i=1;i<4;i++){
		      vendingMachineUnderTest.buyDrink(new BigDecimal(1.0), "water");
		      int quantity = vendingMachineUnderTest.checkStock("water");
		      assertThat(quantity).isEqualTo(stock - i);}}
		
		@Test
		public void checkThatCustomerCantBuyWithInsufficientFunds(){
			expectedEx.expect(IllegalStateException.class);
			expectedEx.expectMessage("Transaction Failed: not enough funds");
			vendingMachineUnderTest.buyDrink(new BigDecimal(0.50), "water");}
		
		
		@Test
		public void checkThatCustomerCantBuyWithMoreFunds(){
			expectedEx.expect(IllegalStateException.class);
			expectedEx.expectMessage("Transaction Failed: please put in exact amount");
			vendingMachineUnderTest.buyDrink(new BigDecimal(1.50), "water");}
		
		@Test
		public void BuyJuiceDrinkSuccessfully(){
			int stock = 15;
			vendingMachineUnderTest.buyDrink(new BigDecimal(1.50), "juice");
			int quantity = vendingMachineUnderTest.checkStock("juice");
			assertThat(quantity).isEqualTo(stock -1);}
		
		@Test
		public void BuySoftDrinkSuccessfully(){
			int stock = 10;
			vendingMachineUnderTest.buyDrink(new BigDecimal(1.25), "softdrink");
			int quantity = vendingMachineUnderTest.checkStock("softdrink");
			assertThat(quantity).isEqualTo(stock -1);}
		
		@Test
		public void BuyAnInvalidDrink(){
			expectedEx.expect(IllegalStateException.class);
			expectedEx.expectMessage("Transaction Failed: invalid drink requested");
			vendingMachineUnderTest.buyDrink(new BigDecimal(2.25), "invaliddrink");}

}


