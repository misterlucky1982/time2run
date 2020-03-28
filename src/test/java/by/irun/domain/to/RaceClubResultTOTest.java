package by.irun.domain.to;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import by.irun.domain.Gender;

/**
 * Test class for {@link by.irun.domain.to.RaceClubResultTO}
 * @author A.Dubovik
 */
public class RaceClubResultTOTest {
	
	private RaceClubResultTO to;
	
	@Before
	public void init(){
		to = new RaceClubResultTO();
	}
	
	@Test
	public void absPositionTest(){
		assertTrue(to.getAbsPosition()==0);
		to.setAbsPosition(1);
		assertTrue(to.getAbsPosition()==1);
	}
	
	@Test
	public void dateTest(){
		assertNull(to.getDate());
		Date d = Date.valueOf("2020-01-01");
		to.setDate(d);
		assertEquals(d,to.getDate());
	}
	
	@Test
	public void parkNameTest(){
		assertNull(to.getParkName());
		to.setParkName("park");
		assertEquals("park",to.getParkName());
	}
	
	@Test
	public void positionInGenderGroupTest(){
		assertTrue(to.getPositionInGenderGroup()==0);
		to.setPositionInGenderGroup(1);
		assertTrue(to.getPositionInGenderGroup()==1);
	}
	
	@Test
	public void raceIdTest(){
		assertTrue(to.getRaceId()==0);
		to.setRaceId(1);
		assertTrue(to.getRaceId()==1);
	}
	
	@Test
	public void runnerFirstName(){
		assertNull(to.getRunnerFirstName());
		to.setRunnerFirstName("name");
		assertEquals("name",to.getRunnerFirstName());
	}
	
	@Test
	public void runnerLastName(){
		assertNull(to.getRunnerLastName());
		to.setRunnerLastName("name");
		assertEquals("name",to.getRunnerLastName());
	}
	
	@Test
	public void runnerIdTest(){
		assertTrue(to.getRunnerId()==0);
		to.setRunnerId(1);
		assertTrue(to.getRunnerId()==1);
	}
	
	@Test
	public void timeInSecondsTest(){
		assertTrue(to.getTimeInSeconds()==0);
		to.setTimeInSeconds(10);
		assertTrue(to.getTimeInSeconds()==10);
	}
	
	@Test
	public void genderTest(){
		assertNull(to.getGender());
		to.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE,to.getGender());
	}
	
	@Test
	public void raceNameTest(){
		assertNull(to.getRaceName());
		to.setRaceName("race");
		assertEquals("race",to.getRaceName());
	}
}