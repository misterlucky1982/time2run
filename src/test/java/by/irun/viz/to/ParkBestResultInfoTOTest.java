package by.irun.viz.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

public class ParkBestResultInfoTOTest {
	
	private ParkBestResultInfoTO to;
	
	@Before
	public void init(){
		to = new ParkBestResultInfoTO();
	}
	
	@Test
	public void parkNameTest(){
		assertNull(to.getParkName());
		to.setParkName("name");
		assertEquals("name",to.getParkName());
	}
	
	@Test
	public void bestResultListTest(){
		assertNull(to.getBestResults());
		@SuppressWarnings("unchecked")
		List<String>bestResults = PowerMock.createMock(List.class);
		to.setBestResults(bestResults);
		assertEquals(bestResults,to.getBestResults());
	}

}
