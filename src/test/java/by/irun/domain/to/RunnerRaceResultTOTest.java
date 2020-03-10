package by.irun.domain.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class RunnerRaceResultTOTest {
	
	private RunnerRaceResultTO to;
	
	@Before
	public void init(){
		to = new RunnerRaceResultTO();
	}
	
	@Test
	public void clubTest(){
		assertNull(to.getClub());
		to.setClub("club");
		assertEquals("club",to.getClub());
	}
	
	@Test
	public void dateOfBirthTest(){
		assertNull(to.getDateOfBirth());
		Date date = Date.valueOf("2020-01-01");
		to.setDateOfBirth(date);
		assertEquals(date,to.getDateOfBirth());
	}
	
	@Test
	public void firstNameTest(){
		assertNull(to.getFirstName());
		to.setFirstName("name");
		assertEquals("name",to.getFirstName());
	}
	
	@Test
	public void lastNameTest(){
		assertNull(to.getLastName());
		to.setLastName("name");
		assertEquals("name",to.getLastName());
	}
	
	@Test
	public void positionTest(){
		assertNull(to.getPosition());
		to.setPosition(1);
		assertEquals(Integer.valueOf(1),to.getPosition());
	}
	
	@Test
	public void timeInSecondsTest(){
		assertNull(to.getTimeInSeconds());
		to.setTimeInSeconds(5);
		assertEquals(Integer.valueOf(5),to.getTimeInSeconds());
	}

}
