package by.irun.domain.to;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link by.irun.domain.to.ClubTO}
 * @author A.Dubovik
 */
public class ClubTOTest {

	private ClubTO to;
	
	@Before
	public void init(){
		to = new ClubTO();
	}
	
	@Test
	public void cityTest(){
		assertNull(to.getCity());
		to.setCity("city");
		assertEquals("city",to.getCity());
	}
	
	@Test
	public void nameTest(){
		assertNull(to.getName());
		to.setName("name");
		assertEquals("name",to.getName());
	}
	
	@Test
	public void clubLogoTest(){
		assertNull(to.getClubLogo());
		to.setClubLogo("logo");
		assertEquals("logo",to.getClubLogo());
	}
	
	@Test
	public void emailTest(){
		assertNull(to.getEmail());
		to.setEmail("email");
		assertEquals("email",to.getEmail());
	}
	
	@Test
	public void phoneTest(){
		assertNull(to.getPhone());
		to.setPhone("123");
		assertEquals("123",to.getPhone());
	}

}
