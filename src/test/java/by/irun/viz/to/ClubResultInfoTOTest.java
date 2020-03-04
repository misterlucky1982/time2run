package by.irun.viz.to;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * test class for {@link by.irun.viz.to.ClubResultInfoTO}
 * @author A.Dubovik
 */
public class ClubResultInfoTOTest {

	private ClubResultInfoTO to;
	
	@Before
	public void init(){
		to = new ClubResultInfoTO();
	}
	
	@Test
	public void linkToRaceTest(){
		assertNull(to.getLinkToRace());
		to.setLinkToRace("link");
		assertEquals("link",to.getLinkToRace());
	}
	
	@Test
	public void linkToRunnerTest(){
		assertNull(to.getLinkToRunner());
		to.setLinkToRunner("runner");
		assertEquals("runner",to.getLinkToRunner());
	}
	
	@Test
	public void positionTest(){
		assertNull(to.getPosition());
		to.setPosition("1");
		assertEquals("1",to.getPosition());
	}
	
	@Test
	public void raceNameTest(){
		assertNull(to.getRaceName());
		to.setRaceName("race");
		assertEquals("race",to.getRaceName());
	}
	
	@Test
	public void runnerNameTest(){
		assertNull(to.getRunnerName());
		to.setRunnerName("name");
		assertEquals("name",to.getRunnerName());
	}
	
	@Test
	public void timeTest(){
		assertNull(to.getTime());
		to.setTime("time");
		assertEquals("time",to.getTime());
	}
}
