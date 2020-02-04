package by.irun.viz.to;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link by.irun.viz.to.RunnerResultInfoTO}
 * @author A.Dubovik
 *
 */
public class RunnerResultInfoTOTest {

	private RunnerResultInfoTO to;
	
	@Before
	public void init(){
		to = new RunnerResultInfoTO();
	}
	
	/**
	 * test for get/set absPosition
	 */
	@Test
	public void absPositionTest(){
		assertNull(to.getAbsPositionInfo());
		to.setAbsPositionInfo("1");
		assertEquals("1",to.getAbsPositionInfo());
	}
	
	/**
	 * test for get/set linkToRace
	 */
	@Test
	public void linkToRaceTest(){
		assertNull(to.getLinkToRace());
		to.setLinkToRace("link");
		assertEquals("link",to.getLinkToRace());
	}
	
	/**
	 * test for get/set posInOwnGender
	 */
	@Test
	public void positionInOwnGenderTest(){
		assertNull(to.getPosInOwnGenderInfo());
		to.setPosInOwnGenderInfo("position");
		assertEquals("position",to.getPosInOwnGenderInfo());
	}
	
	/**
	 * test for get/set raceInfo
	 */
	@Test
	public void raceInfoTest(){
		assertNull(to.getRaceInfo());
		to.setRaceInfo("info");
		assertEquals("info",to.getRaceInfo());
	}
	
	/**
	 * test for get/set time
	 */
	@Test
	public void timeTest(){
		assertNull(to.getTime());
		to.setTime("time");
		assertEquals("time",to.getTime());
	}
	
	/**
	 * test for equals
	 */
	@Test
	public void equalsTest(){
		to.setAbsPositionInfo("absPos");
		to.setLinkToRace("link");
		to.setPosInOwnGenderInfo("gender");
		to.setRaceInfo("race");
		to.setTime("time");
		RunnerResultInfoTO infoTO = new RunnerResultInfoTO();
		assertNotEquals(to,infoTO);
		infoTO.setAbsPositionInfo("absPos");
		assertNotEquals(to,infoTO);
		infoTO.setLinkToRace("link");
		assertNotEquals(to,infoTO);
		infoTO.setPosInOwnGenderInfo("gender");
		assertNotEquals(to,infoTO);
		infoTO.setRaceInfo("race");
		assertNotEquals(to,infoTO);
		infoTO.setTime("time");
		assertEquals(to,infoTO);
	}
}
