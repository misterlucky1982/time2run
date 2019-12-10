package by.irun.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.annotation.Mock;

public class RaceTest {
	
	private Race race;
	
	@Mock
	private Park park;
	
	@Mock
	private List<Result>resultList;
	
	@Before
	public void init(){
		race = new Race();
	}
	
	@Test
	public void idTest(){
		assertNull(race.getId());
		race.setId(1L);
		assertTrue(race.getId()==1);
	}
	
	@Test
	public void parkTest(){
		assertNull(race.getPark());
		race.setPark(park);
		assertEquals(park,race.getPark());
	}
	
	@Test
	public void resultListTest(){
		assertNull(race.getResultList());
		race.setResultList(resultList);
		assertEquals(resultList,race.getResultList());
	}
	
	@Test
	public void equalsTest(){
		race.setId(1L);
		race.setPark(park);
		race.setResultList(resultList);
		Race r2 = new Race();
		assertNotEquals(race,r2);
		r2.setId(1L);
		assertEquals(race,r2);
	}
}
