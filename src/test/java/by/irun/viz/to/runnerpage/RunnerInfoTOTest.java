package by.irun.viz.to.runnerpage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

import by.irun.viz.to.runnerpage.RunnerInfoTO;
import by.irun.viz.to.runnerpage.RunnerResultInfoTO;

/**
 * test class for {@link by.irun.viz.to.runnerpage.RunnerInfoTO}
 * @author A.Dubovik
 *
 */
public class RunnerInfoTOTest {

	private RunnerInfoTO to;
	
	@Before
	public void init(){
		to = new RunnerInfoTO();
	}
	
	/**
	 * get/set test for avatar
	 */
	@Test
	public void avatarTest(){
		assertNull(to.getAvatar());
		to.setAvatar("avatar");
		assertEquals("avatar",to.getAvatar());
	}
	
	/**
	 * get/set test for city
	 */
	@Test
	public void cityTest(){
		assertNull(to.getCity());
		to.setCity("city");
		assertEquals("city",to.getCity());
	}
	
	/**
	 * get/set test for clubLink
	 */
	@Test
	public void clubLinkTest(){
		assertNull(to.getClubLink());
		to.setClubLink("clublink");
		assertEquals("clublink",to.getClubLink());
	}
	
	
	/**
	 * get/set test for clubName
	 */
	@Test
	public void clubNameTest(){
		assertNull(to.getClubName());
		to.setClubName("club");
		assertEquals("club",to.getClubName());
	}
	
	/**
	 * get/set test for dateOfBirth
	 */
	@Test
	public void dateOfBirthTest(){
		assertNull(to.getDateOfBirth());
		to.setDateOfBirth("date");
		assertEquals("date",to.getDateOfBirth());
	}
	
	/**
	 * get/set test for name
	 */
	@Test
	public void nameTest(){
		assertNull(to.getName());
		to.setName("name");
		assertEquals("name",to.getName());
	}
	
	/**
	 * get/set test for number of races
	 */
	@Test
	public void numberOfRacesTest(){
		assertTrue(to.getNumberOfRaces()==0);
		to.setNumberOfRaces(1);
		assertTrue(to.getNumberOfRaces()==1);
	}
	
	/**
	 * get/set test for raceRequest
	 */
	@Test
	public void raceRequestTest(){
		assertNull(to.getRacesRequest());
		to.setRacesRequest("request");
		assertEquals("request",to.getRacesRequest());
	}
	/**
	 * get/set test for raceList
	 */
	@Test
	public void raceResultListTest(){
		assertNull(to.getRacesList());
		@SuppressWarnings("unchecked")
		List<RunnerResultInfoTO>list = PowerMock.createMock(List.class);
		to.setRacesList(list);
		assertEquals(list,to.getRacesList());
	}
}
