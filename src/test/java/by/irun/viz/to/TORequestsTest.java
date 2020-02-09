package by.irun.viz.to;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.irun.viz.to.TORequests;

public class TORequestsTest {
	private static final String RACE_RESULT_TO_REQUEST = "SELECT RS.POSITION AS POSITION"
			+ ", CONCAT(RN.FIRSTNAME,' ',RN.LASTNAME) AS NAME"
			+", RS.GENDER AS GENDER"
			+ ", CL.NAME AS CLUB, RS.TIME AS TIME"
			+ " FROM RESULTS RS LEFT JOIN RUNNERS RN ON RS.RUNNER = RN.ID"
			+ " LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = ";
	
	private static final String RUNNER_RESULT_INFO_LIST_REQUEST = "SELECT RS.POSITION AS ABSPOSITION, "
			+ "(SELECT COUNT(*)+1 FROM RESULTS WHERE RACE=RS.RACE AND POSITION<RS.POSITION AND GENDER = RS.GENDER) "
			+ "AS POSITIONINGENDERGROUP,RS.CLUB AS CLUBID,CL.NAME AS CLUBNAME, CL.SMALLLOGO "
			+ "AS CLUBLOGO, RS.RACE AS RACE_ID, RC.DATE AS RACE_DATE, PK.NAME AS PARK_NAME, "
			+ "RS.TIME AS TIME FROM RESULTS RS INNER JOIN RACES RC ON RS.RACE=RC.ID INNER JOIN PARKS PK"
			+ " ON RC.PARK=PK.ID INNER JOIN CLUBS CL ON RS.CLUB = CL.ID WHERE RS.RUNNER =";

	/**
	 * request test for RaceResultTO
	 */
	@Test
	public void resultRequestTOTest(){
		String request = TORequests.raceResultRequest(1L);
		assertEquals(RACE_RESULT_TO_REQUEST+1,request);
	}
	/**
	 * request test for RunnerResultInfo List
	 */
	@Test
	public void runnerResultInfoListTest(){
		String request = TORequests.runnerResultInfoListRequest(1);
		assertEquals(RUNNER_RESULT_INFO_LIST_REQUEST+1,request);
	}
}
