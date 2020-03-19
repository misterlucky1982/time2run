package by.irun.persistance.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.irun.domain.Gender;
import by.irun.persistance.util.TORequests;

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
	
	private static final String RUNNER_TO_REQUEST = "SELECT RN.FIRSTNAME AS FIRSTNAME, "
			+ "RN.LASTNAME AS LASTNAME, RN.CITY AS CITY,  PC.LOCATION AS AVATAR, CL.ID AS CLUBID, "
			+ "CL.NAME AS CLUBNAME, RN.DATEOFBIRTH AS DATEOFBIRTH," + " RN.GENDER AS GENDER FROM RUNNERS "
			+ "RN LEFT JOIN PICTURES PC ON RN.AVATAR=PC.ID LEFT " + "JOIN CLUBS CL ON RN.CLUB=CL.ID WHERE RN.ID=";
	
	private static final String CLUB_TO_REQUEST = "SELECT CL.NAME AS NAME, CL.BASECITY AS CITY, CL.BIGLOGO AS CLUBLOGO,"
			+ " A.EMAIL AS EMAIL, A.PHONE AS PHONE FROM CLUBS CL INNER JOIN USERS A ON CL.ADMIN=A.ID WHERE CL.ID=";
	
	private static final String CLUB_RACE_RESULT_TO_REQUEST = "SELECT RS.POSITION AS ABSPOSITION,"
			+ "(SELECT COUNT(*)+1 FROM RESULTS WHERE RACE=RS.RACE AND POSITION<RS.POSITION AND GENDER = RS.GENDER) "
			+ "AS POSITIONINGENDERGROUP,RC.DATE AS RACE_DATE, PK.NAME AS PARK_NAME, RC.ID AS RACE_ID,RN.FIRSTNAME AS "
			+ "FIRSTNAME, RN.LASTNAME AS LASTNAME, RN.ID AS RUNNERID, RS.GENDER AS GENDER, RS.TIME AS TIME FROM RESULTS RS "
			+ "INNER JOIN RACES RC ON RS.RACE = RC.ID INNER JOIN PARKS PK ON RC.PARK=PK.ID "
			+ "INNER JOIN RUNNERS RN ON RS.RUNNER=RN.ID WHERE RS.CLUB=";
	
	private static final String CLUB_RUNNER_TO_LIST_REQUEST = "SELECT RN.FIRSTNAME AS FIRSTNAME, RN.LASTNAME AS LASTNAME, "
			+ "RN.AVATAR AS AVATAR, RN.GENDER AS GENDER, RN.ID AS RUNNERID FROM RUNNERS RN WHERE RN.CLUB = ";
	
	private static final String RACE_TO_REQUEST = "SELECT RC.DATE AS RACE_DATE, PK.NAME AS PARK_NAME FROM RACES"
			+ " RC INNER JOIN PARKS PK ON RC.PARK=PK.ID WHERE RC.ID=";

	private final static String RUNNERRACERESULTREQUESTFORMEN = "SELECT RS.POSITION AS POSITION, RN.FIRSTNAME AS FIRSTNAME, "
			+ "RN.LASTNAME AS LASTNAME, CL.NAME AS CLUBNAME, CL.SMALLLOGO AS CLUBLOGO, CL.ID AS CLUBID, RN.DATEOFBIRTH "
			+ "AS DATEOFBIRTH, RS.TIME AS TIME, RN.ID AS RUNNERID, RN.LOGO AS AVATAR FROM RESULTS RS LEFT JOIN RUNNERS "
			+ "RN ON RS.RUNNER=RN.ID LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = 223 AND RS.GENDER = 'M'";
	private final static String RUNNERRACERESULTREQUESTFORWOMEN = "SELECT RS.POSITION AS POSITION, RN.FIRSTNAME AS FIRSTNAME, "
			+ "RN.LASTNAME AS LASTNAME, CL.NAME AS CLUBNAME, CL.SMALLLOGO AS CLUBLOGO, CL.ID AS CLUBID, RN.DATEOFBIRTH "
			+ "AS DATEOFBIRTH, RS.TIME AS TIME, RN.ID AS RUNNERID, RN.LOGO AS AVATAR FROM RESULTS RS LEFT JOIN RUNNERS "
			+ "RN ON RS.RUNNER=RN.ID LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = 223 AND RS.GENDER = 'F'";

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
	
	/**
	 * request test for RunnerTO
	 */
	@Test
	public void runnerTORequestTest() {
		String request = TORequests.runnerTORequest(22);
		assertEquals(RUNNER_TO_REQUEST + 22, request);
	}
	
	/**
	 * request test for ClubTO
	 */
	@Test
	public void clubTORequestTest(){
		String request = TORequests.clubTORequest(25);
		assertEquals(CLUB_TO_REQUEST+25,request);
	}
	
	/**
	 * request test for RaceClubResultTO
	 */
	@Test
	public void raceClubResultTORequest() {
		String request = TORequests.raceClubResultTORequest(222);
		assertEquals(CLUB_RACE_RESULT_TO_REQUEST + 222, request);
	}
	
	/**
	 * request test for clubRunnerTORequest
	 */
	@Test
	public void clubRunnerTORequestTest() {
		String request = TORequests.clubRunnerTOListReqyest(258);
		assertEquals(CLUB_RUNNER_TO_LIST_REQUEST + 258, request);
	}
	
	/**
	 * request test for RaceTO
	 */
	@Test
	public void raceTORequestTest(){
		String request = TORequests.raceTORequest(1);
		assertEquals(RACE_TO_REQUEST+1,request);
	}
	
	@Test
	public void runnerRaceResultTORequestTest(){
		String requestForMale = TORequests.runnerRaceResultTORequest(223, Gender.MALE);
		String requestForWomen = TORequests.runnerRaceResultTORequest(223, Gender.FEMALE);
		assertEquals(RUNNERRACERESULTREQUESTFORMEN,requestForMale);
		assertEquals(RUNNERRACERESULTREQUESTFORWOMEN,requestForWomen);
	}
	
}
