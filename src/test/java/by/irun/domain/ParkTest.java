package by.irun.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ParkTest {
	
	private Park park;
	
	@Before
	public void init(){
		park = new Park();
	}

	@Test
	public void idTest(){
		assertNull(park.getId());
		park.setId(1L);
		assertTrue(park.getId()==1);
	}
	
	@Test
	public void nameTest(){
		assertNull(park.getName());
		park.setName("name");
		assertEquals("name",park.getName());
	}
	
	@Test
	public void racesTest(){
		assertNull(park.getRaces());
		@SuppressWarnings("unchecked")
		List<Race>races = PowerMock.createMock(List.class);
		park.setRaces(races);
		assertEquals(races,park.getRaces());
	}
	
	@Test
	public void equalsTest(){
		Park p2 = new Park();
		park.setName("name");
		park.setId(1L);
		@SuppressWarnings("unchecked")
		List<Race>races = PowerMock.createMock(List.class);
		park.setRaces(races);
		assertNotEquals(park,p2);
		p2.setId(1L);
		assertEquals(park,p2);
	}
}
