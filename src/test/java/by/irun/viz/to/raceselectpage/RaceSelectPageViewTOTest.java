package by.irun.viz.to.raceselectpage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

public class RaceSelectPageViewTOTest {
	
	private RaceSelectPageViewTO to;
	
	@Before
	public void init(){
		to = new RaceSelectPageViewTO();
	}
	
	@Test
	public void lastRaceNameTest(){
		assertNull(to.getLastRaceName());
		to.setLastRaceName("RACE");
		assertEquals("RACE",to.getLastRaceName());
	}
	
	@Test
	public void lastRaceDateTest(){
		assertNull(to.getLastRaceDate());
		to.setLastRaceDate("DATE");
		assertEquals("DATE",to.getLastRaceDate());
	}
	
	@Test
	public void lastRaceParkTest(){
		assertNull(to.getLastRacePark());
		to.setLastRacePark("PARK");
		assertEquals("PARK",to.getLastRacePark());
	}
	
	@Test
	public void eventTitleTest(){
		assertNull(to.getEventTitle());
		to.setEventTitle("TITLE");
		assertEquals("TITLE",to.getEventTitle());
	}
	
	@Test
	public void linkToRaceTest(){
		assertNull(to.getLinkToLastRace());
		to.setLinkToLastRace("LINK");
		assertEquals("LINK",to.getLinkToLastRace());
	}
	
	@Test
	public void parksMapTest(){
		assertNull(to.getParksMap());
		@SuppressWarnings("unchecked")
		Map<String,String>map = PowerMock.createMock(Map.class);
		to.setParksMap(map);
		assertEquals(map,to.getParksMap());
	}

}
