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
	public void raceInfoVizTOTest(){
		RaceInfoVizTO vizTO = PowerMock.createMock(RaceInfoVizTO.class);
		to.setRaceInfoVizTO(vizTO);
		assertEquals(vizTO,to.getRaceInfoVizTO());
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
