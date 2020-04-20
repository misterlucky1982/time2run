package by.irun.domain;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ResultTest {
	
	private Result result;
	
	@Mock
	private Club club;
	
	
	@Mock
	private Race race;
	
	@Mock
	private Duration time;
	
	@Mock
	private Runner runner;
	
	@Before
	public void init(){
		result = new Result();
	}
	
	@Test
	public void idTest(){
		assertNull(result.getId());
		result.setId(1L);
		assertTrue(result.getId()==1);
	}
	
	@Test
	public void absolutePositionTest(){
		assertTrue(result.getAbsolutePosition()==0);
		result.setAbsolutePosition(1);
		assertTrue(result.getAbsolutePosition()==1);
	}
	
	@Test
	public void clubTest(){
		assertNull(result.getClub());
		result.setClub(club);
		assertEquals(club,result.getClub());
	}
	
	@Test
	public void genderTest(){
		assertNull(result.getGender());
		result.setGender(Gender.MALE);
		assertEquals(Gender.MALE,result.getGender());
	}
	
	@Test
	public void raceTest(){
		assertNull(result.getRace());
		result.setRace(race);
		assertEquals(race,result.getRace());
	}
	
	@Test
	public void runnerTest(){
		assertNull(result.getRunner());
		result.setRunner(runner);
		assertEquals(runner,result.getRunner());
	}
	
	@Test
	public void timeTest(){
		assertNull(result.getTime());
		result.setTime(time);
		assertEquals(time, result.getTime());
	}
	
	@Test
	public void equalsTest(){
		Result res2 = new Result();
		result.setId(1L);
		result.setAbsolutePosition(1);
		result.setClub(club);
		result.setGender(Gender.MALE);
		result.setRace(race);
		result.setRunner(runner);
		result.setTime(time);
		assertNotEquals(result,res2);
		res2.setId(1L);
		assertEquals(result,res2);
	}

}
