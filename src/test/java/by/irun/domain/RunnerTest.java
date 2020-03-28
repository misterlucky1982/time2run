package by.irun.domain;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class RunnerTest {
	
	@Mock
	private Picture avatar;
	
	@Mock
	private Club currentClub;
	
	@Mock
	private Date dateOfBirth;
	
	@Mock
	private Picture logo;
	
	@Mock
	private User user;
	
	private Runner runner;
	
	@Before
	public void init(){
		this.runner = new Runner();
	}

	@Test
	public void idTest(){
		assertNull(runner.getId());
		runner.setId(1L);
		assertTrue(runner.getId()==1);
	}
	
	@Test
	public void avatarTest(){
		assertNull(runner.getAvatar());
		runner.setAvatar(avatar);
		assertEquals(avatar,runner.getAvatar());
	}
	
	@Test
	public void cityTest(){
		assertNull(runner.getCity());
		runner.setCity("City");
		assertEquals("City",runner.getCity());
	}
	
	@Test
	public void currentClubTest(){
		assertNull(runner.getCurrentClub());
		runner.setCurrentClub(currentClub);
		assertEquals(currentClub,runner.getCurrentClub());
	}
	
	@Test
	public void dateOfBirthTest(){
		assertNull(runner.getDateOfBirth());
		runner.setDateOfBirth(dateOfBirth);
		assertEquals(dateOfBirth,runner.getDateOfBirth());
	}
	
	@Test
	public void firstNameTest(){
		assertNull(runner.getFirstName());
		runner.setFirstName("FirstName");
		assertEquals("FirstName",runner.getFirstName());
	}
	
	@Test
	public void lastNameTest(){
		assertNull(runner.getLastName());
		runner.setLastName("LastName");
		assertEquals("LastName",runner.getLastName());
	}
	
	@Test
	public void genderTest(){
		assertNull(runner.getGender());
		runner.setGender(Gender.MALE);
		assertEquals(Gender.MALE,runner.getGender());
	}
	
	@Test
	public void logoTest(){
		assertNull(runner.getLogo());
		runner.setLogo(logo);
		assertEquals(logo,runner.getLogo());
	}
	
	@Test
	public void userTest(){
		assertNull(runner.getUser());
		runner.setUser(user);
		assertEquals(user,runner.getUser());
	}
	
	@Test
	public void equalsTest(){
		runner.setId(1L);
		runner.setAvatar(avatar);
		runner.setCity("City");
		runner.setCurrentClub(currentClub);
		runner.setDateOfBirth(dateOfBirth);
		runner.setFirstName("FirstName");
		runner.setGender(Gender.MALE);
		runner.setLastName("LastName");
		runner.setLogo(logo);
		runner.setUser(user);
		Runner run2 = new Runner();
		assertNotEquals(runner,run2);
		run2.setId(1L);
		assertEquals(runner,run2);
	}
}
