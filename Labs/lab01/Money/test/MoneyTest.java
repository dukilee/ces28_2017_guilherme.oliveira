import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MoneyTest {
	Currency cBrl;
	@Before
	public void setUp(){
		cBrl = new Currency("BRL");
	}

	@Test
	public void whenSumTheSameCurrencyTrue() {
		Money m1 = new Money();
		Money m2 = new Money();
		
		m1.setAmount(10);
		m1.setCurrency(cBrl);
		
		m2.setAmount(7);
		m2.setCurrency(cBrl);
		
		Money ans = new Money();
		ans = m1.add(m2);
		assertTrue(ans.getCurrency().equals(new Currency("BRL")));
		assertTrue(ans.getAmount() == 17);
	}
	
	@Test
	public void whenSumTheSameCurrencyEquals() {
		Money m1 = new Money();
		Money m2 = new Money();
		
		m1.setAmount(10);
		m1.setCurrency(cBrl);
		
		m2.setAmount(7);
		m2.setCurrency(cBrl);
		
		Money ans = new Money();
		ans = m1.add(m2);
		assertEquals(ans.getCurrency(), new Currency("BRL"));
		assertEquals(ans.getAmount(), 17);
	}

}
