import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class MoneyTest {
	Currency cBrl;
	Currency cUsd;
	Money m1;
	Money m2;
	Money m3;
	MoneyBag mb;
	Object ans;
	
	@Before
	public void setUp(){
		cBrl = new Currency("BRL", 1);
		cUsd = new Currency("USD", 3);
		m1 = new Money();
		m2 = new Money();
		m3 = new Money();
		mb = new MoneyBag(); 
		
		m1.setAmount(10);
		m1.setCurrency(cBrl);
		
		m2.setAmount(7);
		m2.setCurrency(cBrl);
		
		m3.setAmount(5);
		m3.setCurrency(cUsd);
		
		mb.setmoney(m1);
	}

	@Test
	public void whenSumTheSameCurrencyTrue() {
		ans = m1.add(m2);
		assertTrue(ans instanceof Money);
		assertTrue(((Money) ans).getCurrency().equals(new Currency("BRL", 1)));
		assertTrue(((Money) ans).getAmount() == 17);
	}
	
	@Test
	public void whenSumTheSameCurrencyEquals() {
		ans = m1.add(m2);
		assertTrue(ans instanceof Money);
		assertEquals(((Money) ans).getCurrency(), new Currency("BRL", 1));
		assertEquals(((Money) ans).getAmount(), 17);
	}
	
	@Test
	public void whenSumDifferentCurrency(){
		ans = m2.add(m3);
		 

		ArrayList<Money> bag = new ArrayList<Money>();
		bag.add(m2);
		bag.add(m3);
		
		assertTrue(ans instanceof MoneyBag);
		assertTrue(((MoneyBag) ans).getMoneylist().contains(m2));
		assertTrue(((MoneyBag) ans).getMoneylist().contains(m3));
	}
	
	@Test
	public void testingSizeOfMoneyBg(){
		assertEquals(mb.size(), 1);
		mb.setmoney(m2);
		assertEquals(mb.size(), 1);
		mb.setmoney(m3);
		assertEquals(mb.size(), 2);
		
		MoneyBag emptyBag = new MoneyBag();
		assertEquals(emptyBag.size(), 0);
		
	}
	
	@Test
	public void testingTotalAmountOfMoneyInMoneyBag(){
		assertEquals(mb.getTotalAmount(), 10);
		mb.setmoney(m3);
		assertEquals(mb.getTotalAmount(), 25);
		

		MoneyBag emptyBag = new MoneyBag();
		assertEquals(emptyBag.getTotalAmount(), 0);
		
	}
}
