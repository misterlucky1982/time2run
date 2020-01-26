package by.irun.inf.ob;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * test class for {@link by.irun.inf.ob.RaceResultTO}
 * @author A.Dubovik
 */
public class RaceResultTOTest {

	private RaceResultTO to;
	
	@Before
	public void init(){
		to = new RaceResultTO();
	}
	
	/**
	 * get/set test for absPosition
	 */
	@Test
	public void absPositionTest(){
		assertTrue(to.getAbsPosition()==0);
		to.setAbsPosition(1);
		assertTrue(to.getAbsPosition()==1);
	}
	
	/**
	 * get/set test for position in group
	 */
	@Test
	public void positionInGroupTest(){
		assertTrue(to.getPositionInGroup()==0);
		to.setPositionInGroup(1);
		assertTrue(to.getPositionInGroup()==1);
	}
	
	/**
	 * get/set test for club
	 */
	@Test
	public void clubTest(){
		assertNull(to.getClub());
		to.setClub("CLUB");
		assertEquals("CLUB",to.getClub());
	}
	
	/**
	 * get/set test for gender
	 */
	@Test
	public void genderTest(){
		assertNull(to.getGender());
		to.setGender("GENDER");
		assertEquals("GENDER",to.getGender());
	}
	
	/**
	 * get/set test for name
	 */
	@Test
	public void nameTest(){
		assertNull(to.getName());
		to.setName("NAME");
		assertEquals("NAME",to.getName());
	}
	
	/**
	 * get/set test for time
	 */
	@Test
	public void timeTest(){
		assertNull(to.getTime());
		to.setTime("TIME");
		assertEquals("TIME",to.getTime());
	}
	
	/**
	 * equals test
	 */
	@Test
	public void equalsTest(){
		RaceResultTO to2 = new RaceResultTO();
		assertEquals(to,to2);
		to2.setName("NAME");
		assertNotEquals(to,to2);
		to.setName("NAME");
		assertEquals(to,to2);
		to2.setAbsPosition(1);
		assertNotEquals(to,to2);
		to.setAbsPosition(1);
		assertEquals(to,to2);
		to2.setPositionInGroup(1);
		assertNotEquals(to,to2);
		to.setPositionInGroup(1);
		assertEquals(to,to2);
		to2.setGender("G");
		assertNotEquals(to,to2);
		to.setGender("G");
		assertEquals(to,to2);
		to2.setClub("CLUB");
		assertNotEquals(to,to2);
		to.setClub("CLUB");
		assertEquals(to,to2);
		to.setTime("TIME");
		assertNotEquals(to,to2);
		to2.setTime("TIME");
		assertEquals(to,to2);
	}
}
