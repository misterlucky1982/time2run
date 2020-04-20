package by.irun.domain.to;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
/**
 * Test class for {@link by.irun.domain.to.RunnerResultTO}
 * @author Home
 *
 */
public class RunnerResultTOTest {
	
	private RunnerResultTO to;
	
	@Before
	public void init(){
		to = new RunnerResultTO();
	}
	
	@Test
	public void absPositionTest(){
		assertTrue(to.getAbsPosition()==0);
		to.setAbsPosition(1);
		assertTrue(to.getAbsPosition()==1);
	}
	
	@Test
	public void clubIdTest(){
		assertTrue(to.getClubId()==0);
		to.setClubId(1L);
		assertTrue(to.getClubId()==1);
	}
	
	@Test
	public void clubLogoTest(){
		assertNull(to.getClubLogo());
		to.setClubLogo("logo");
		assertEquals("logo",to.getClubLogo());
	}
	
	@Test
	public void clubNameTest(){
		assertNull(to.getClubName());
		to.setClubName("name");
		assertEquals("name",to.getClubName());
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
	public void raceDateTest(){
		assertNull(to.getRaceDate());
		Date date = Date.valueOf("2000-02-02");
		to.setRaceDate(date);
		assertEquals(date,to.getRaceDate());
	}
	
	@Test
	public void raceIdTest(){
		assertTrue(to.getRaceId()==0);
		to.setRaceId(1L);
		assertTrue(to.getRaceId()==1);
	}
	
	@Test
	public void timeTest(){
		assertTrue(to.getTime()==0);
		to.setTime(100);
		assertTrue(to.getTime()==100);
	}
	
	@Test
	public void raceNameTest(){
		assertNull(to.getRaceName());
		to.setRaceName("KEY_RACE");
		assertEquals("KEY_RACE",to.getRaceName());
	}

}
