package by.irun.viz.to.racepage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;

public class RaceResultInfoTOTest {
	
	private RaceResultInfoTO to;
	
	@Mock
	private List<RunnerResultInfoTO> resultList;
	
	@Before
	public void init(){
		to = new RaceResultInfoTO();
	}
	
	@Test
	public void raceNameTest(){
		assertNull(to.getRaceName());
		to.setRaceName("race");
		assertEquals("race",to.getRaceName());
	}
	
	@Test
	public void mensResultListTest(){
		assertNull(to.getMenResult());
		to.setMenResult(resultList);
		assertEquals(resultList,to.getMenResult());
	}
	
	@Test
	public void womensResultTest(){
		assertNull(to.getWomenResult());
		to.setWomenResult(resultList);
		assertEquals(resultList,to.getWomenResult());
	}

}
