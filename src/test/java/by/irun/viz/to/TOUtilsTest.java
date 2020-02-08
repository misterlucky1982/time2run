package by.irun.viz.to;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.irun.viz.to.TOUtils;

public class TOUtilsTest {
	private static final String RACE_RESULT_TO_REQUEST = "SELECT RS.POSITION AS POSITION"
			+ ", CONCAT(RN.FIRSTNAME,' ',RN.LASTNAME) AS NAME"
			+", RS.GENDER AS GENDER"
			+ ", CL.NAME AS CLUB, RS.TIME AS TIME"
			+ " FROM RESULTS RS LEFT JOIN RUNNERS RN ON RS.RUNNER = RN.ID"
			+ " LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = ";

	/**
	 * request test for RaceResultTO
	 */
	@Test
	public void resultRequestTOTest(){
		String request = TOUtils.raceResultRequest(1L);
		assertEquals(RACE_RESULT_TO_REQUEST+1,request);
	}
}
