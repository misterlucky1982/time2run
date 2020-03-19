package by.irun.domain.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * test-class for RaceTOTest
 * @author A.Dubovik
 *
 */
public class RaceTOTest {

	private RaceTO to;
	
	@Before
	public void init(){
		to = new RaceTO();
	}
	
	@Test
	public void parkNameTest(){
		assertNull(to.getParkName());
		to.setParkName("name");
		assertEquals("name",to.getParkName());
	}
	
	@Test
	public void dateTest(){
		assertNull(to.getDate());
		Date date = Date.valueOf("2000-01-01");
		to.setDate(date);
		assertEquals(date,to.getDate());
	}
}
