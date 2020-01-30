package by.irun.viz.to;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RaceInfoTOTest {
	
	private RaceInfoTO to;
	
	@Before
	public void init(){
		to = new RaceInfoTO();
	}

	/**
	 * test get/set raceId
	 */
	@Test
	public void raceIdTest(){
		assertTrue(to.getRaceId()==0);
		to.setRaceId(1L);
		assertTrue(to.getRaceId()==1);
	}
	
	/**
	 * test get/set raceName
	 */
	@Test
	public void raceNameTest(){
		assertNull(to.getRaceName());
		to.setRaceName("NAME");
		assertEquals("NAME",to.getRaceName());
	}
	
	/**
	 * test for {@link RaceInfoTO#equals(Object)}
	 */
	@Test
	public void equalsTest(){
		to.setRaceId(1L);
		RaceInfoTO to2 = new RaceInfoTO();
		assertNotEquals(to,to2);
		to2.setRaceId(1L);
		assertEquals(to,to2);
	}
}
