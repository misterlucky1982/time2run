package by.irun.viz.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

import by.irun.viz.to.runnerpage.RunnerResultInfoTO;

public class ClubRaceResultInfoTOTest {

	@SuppressWarnings("deprecation")
	private ClubRaceResultInfoTO to;
	
	@SuppressWarnings("deprecation")
	@Before
	public void init(){
		to = new ClubRaceResultInfoTO();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void raceNameTest(){
		assertNull(to.getRaceName());
		to.setRaceName("race");
		assertEquals("race",to.getRaceName());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void linkToRaceTest(){
		assertNull(to.getLinkToRace());
		to.setLinkToRace("link");
		assertEquals("link",to.getLinkToRace());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void womenResultTest(){
		assertNull(to.getWomenResults());
		@SuppressWarnings("unchecked")
		List<RunnerResultInfoTO> list = PowerMock.createMock(List.class);
		to.setWomenResults(list);
		assertEquals(list,to.getWomenResults());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void menResultTest(){
		assertNull(to.getMenResults());
		@SuppressWarnings("unchecked")
		List<RunnerResultInfoTO> list = PowerMock.createMock(List.class);
		to.setMenResults(list);
		assertEquals(list,to.getMenResults());
	}
}
