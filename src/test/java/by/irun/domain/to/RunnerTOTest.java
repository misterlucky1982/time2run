package by.irun.domain.to;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import by.irun.domain.Gender;

public class RunnerTOTest {
	
	private RunnerTO to;
	
	@Before
	public void init(){
		to = new RunnerTO();
	}
	
	@Test
	public void avatarTest(){
		assertNull(to.getAvatar());
		to.setAvatar("avatar");
		assertEquals("avatar",to.getAvatar());
	}
	
	@Test
	public void cityTest(){
		assertNull(to.getCity());
		to.setCity("city");
		assertEquals("city",to.getCity());
	}
	
	@Test
	public void clubIdTest(){
		assertNull(to.getClubId());
		to.setClubId(1L);
		assertTrue(to.getClubId()==1);
	}
	
	@Test
	public void clubNameTest(){
		assertNull(to.getClubName());
		to.setClubName("club");
		assertEquals("club",to.getClubName());
	}
	
	@Test
	public void dateOfBirthTest(){
		assertNull(to.getDateOfBirth());
		Date date = Date.valueOf("2000-01-01");
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
	public void genderTest(){
		assertNull(to.getGender());
		to.setGender(Gender.MALE);
		assertEquals(Gender.MALE,to.getGender());
	}
}
