package by.irun.domain.to;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.irun.domain.Gender;

/**
 * Test class for {@link by.irun.domain.to.ClubRunnerTO}
 * 
 * @author A.Dubovik
 */
public class ClubRunnerTOTest {

	private ClubRunnerTO to;

	@Before
	public void init() {
		to = new ClubRunnerTO();
	}

	@Test
	public void runnerIdTest() {
		assertTrue(to.getRunnerId() == 0);
		to.setRunnerId(1);
		assertTrue(to.getRunnerId() == 1);
	}

	@Test
	public void avatarPathTest() {
		assertNull(to.getAvatarPath());
		to.setAvatarPath("path");
		assertEquals("path", to.getAvatarPath());
	}

	@Test
	public void firstNameTest() {
		assertNull(to.getFirstName());
		to.setFirstName("name");
		assertEquals("name", to.getFirstName());
	}

	@Test
	public void lastNameTest() {
		assertNull(to.getLastName());
		to.setLastName("lastName");
		assertEquals("lastName", to.getLastName());
	}
	
	@Test
	public void genderTest(){
		assertNull(to.getGender());
		to.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE,to.getGender());
	}
}
