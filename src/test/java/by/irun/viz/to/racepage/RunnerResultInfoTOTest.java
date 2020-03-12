package by.irun.viz.to.racepage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class RunnerResultInfoTOTest {
	
	private RunnerResultInfoTO to;
	
	@Before
	public void init(){
		to = new RunnerResultInfoTO();
	}
	
	@Test
	public void clubTest(){
		assertNull(to.getClub());
		to.setClub("club");
		assertEquals("club",to.getClub());
	}
	
	@Test
	public void clubLogoTest(){
		assertNull(to.getClubLogo());
		to.setClubLogo("logo");
		assertEquals("logo",to.getClubLogo());
	}
	
	@Test
	public void dateTest(){
		assertNull(to.getDateOfBirth());
		to.setDateOfBirth("date");
		assertEquals("date",to.getDateOfBirth());
	}
	
	@Test
	public void linkToClubTest(){
		assertNull(to.getLinkToClub());
		to.setLinkToClub("link");
		assertEquals("link", to.getLinkToClub());
	}
	
	@Test
	public void linkToRunnerTest(){
		assertNull(to.getLinkToRunner());
		to.setLinkToRunner("runner");
		assertEquals("runner",to.getLinkToRunner());
	}
	
	@Test
	public void nameTest(){
		assertNull(to.getName());
		to.setName("name");
		assertEquals("name",to.getName());
	}
	
	@Test
	public void positionTest(){
		assertNull(to.getPosition());
		to.setPosition("pos");
		assertEquals("pos",to.getPosition());
	}
	
	@Test
	public void timeTest(){
		assertNull(to.getTime());
		to.setTime("time");
		assertEquals("time",to.getTime());
	}

}
