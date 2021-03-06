package by.irun.persistance.util;

import java.sql.Date;

import by.irun.domain.Gender;

/**
 * Utility class for operations with request`s result sets
 * <p>
 * Provides sql requests for info-objects (front-end representation of data
 * stored in db)
 * <p>
 * and transfer operations for result-sets
 * 
 * @author A.Dubovik
 *
 */
public class TORequests {

	public static final String POSITION = "POSITION";
	public static final String NAME = "NAME";
	public static final String GENDER = "GENDER";
	public static final String TIME = "TIME";
	public static final String CLUB = "CLUB";
	public static final String RACE_ID = "RACE_ID";
	public static final String PARK_NAME = "PARK_NAME";
	public static final String RACE_DATE = "RACE_DATE";
	public static final String ABSPOSITION = "ABSPOSITION";
	public static final String POSITIONINGENDERGROUP = "POSITIONINGENDERGROUP";
	public static final String CLUBID = "CLUBID";
	public static final String CLUBNAME = "CLUBNAME";
	public static final String CLUBLOGO = "CLUBLOGO";
	public static final String FIRSTNAME = "FIRSTNAME";
	public static final String LASTNAME = "LASTNAME";
	public static final String AVATAR = "AVATAR";
	public static final String DATEOFBIRTH = "DATEOFBIRTH";
	public static final String CITY = "CITY";
	public static final String EMAIL = "EMAIL";
	public static final String PHONE = "PHONE";
	public static final String RUNNERID = "RUNNERID";
	public static final String RACENAME = "RACENAME";
	
	private static final String RACEIDREGEX = "&&RACE&&";
	private static final String GENDERREGEX = "&&GENDER&&";
	private static final String RUNNERIDREGEX = "&&RUNNERID&&";

	private static final String RACE_RESULT_TO_REQUEST = "SELECT RS.POSITION AS " + POSITION
			+ ", CONCAT(RN.FIRSTNAME,' ',RN.LASTNAME) AS " + NAME + ", RS.GENDER AS " + GENDER + ", CL.NAME AS " + CLUB
			+ ", RS.TIME AS " + TIME + " FROM RESULTS RS LEFT JOIN RUNNERS RN ON RS.RUNNER = RN.ID"
			+ " LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = ";

	private static final String RUNNER_RESULT_INFO_REQUEST = "SELECT RS.POSITION AS " + ABSPOSITION
			+ ", (SELECT COUNT(*)+1 FROM RESULTS WHERE RACE=RS.RACE AND POSITION<RS.POSITION AND GENDER = RS.GENDER) AS "
			+ POSITIONINGENDERGROUP + ",RS.CLUB AS " + CLUBID + ",CL.NAME AS " + CLUBNAME + ", CL.SMALLLOGO AS "
			+ CLUBLOGO + ", RS.RACE AS " + RACE_ID + ", RC.DATE AS " + RACE_DATE + ", RC.NAME AS "+RACENAME+", PK.NAME AS " + PARK_NAME
			+ ", RS.TIME AS " + TIME
			+ " FROM RESULTS RS INNER JOIN RACES RC ON RS.RACE=RC.ID INNER JOIN PARKS PK ON RC.PARK=PK.ID "
			+ "LEFT JOIN CLUBS CL ON RS.CLUB = CL.ID WHERE RS.RUNNER =&&RUNNERID&& ORDER BY RC.DATE DESC, RC.ID DESC;";
	
	private static final String RUNNER_TO_REQUEST = "SELECT RN.FIRSTNAME AS " + FIRSTNAME + ", RN.LASTNAME AS "
			+ LASTNAME + ", RN.CITY AS " + CITY + ",  PC.LOCATION AS " + AVATAR + ", CL.ID AS " + CLUBID
			+ ", CL.NAME AS " + CLUBNAME + ", RN.DATEOFBIRTH AS " + DATEOFBIRTH + ", RN.GENDER AS " + GENDER
			+ " FROM RUNNERS RN LEFT JOIN PICTURES PC ON RN.AVATAR=PC.ID LEFT JOIN CLUBS CL ON RN.CLUB=CL.ID WHERE RN.ID=";

	private static final String CLUB_TO_REQUEST = "SELECT CL.NAME AS " + NAME + ", CL.BASECITY AS " + CITY
			+ ", PC.LOCATION AS " + CLUBLOGO + ", A.EMAIL AS " + EMAIL + ", A.PHONE AS " + PHONE
			+ " FROM CLUBS CL INNER JOIN USERS A ON CL.ADMIN=A.ID LEFT JOIN PICTURES PC ON CL.BIGLOGO=PC.ID WHERE CL.ID=";
	
	private static final String RACE_CLUB_RESULT_TO_REQUEST = "SELECT RS.POSITION AS " + ABSPOSITION
			+ ",(SELECT COUNT(*)+1 FROM RESULTS WHERE RACE=RS.RACE AND POSITION<RS.POSITION"
			+ " AND GENDER = RS.GENDER) AS " + POSITIONINGENDERGROUP + ",RC.DATE AS " + RACE_DATE + ", RC.NAME"
					+ " AS "+RACENAME+", PK.NAME AS "
			+ PARK_NAME + ", RC.ID AS " + RACE_ID + ",RN.FIRSTNAME AS " + FIRSTNAME + ", RN.LASTNAME AS " + LASTNAME
			+ ", RN.ID AS " + RUNNERID + ", RS.GENDER AS "+GENDER+", RS.TIME AS " + TIME
			+ " FROM RESULTS RS INNER JOIN RACES RC ON RS.RACE = RC.ID INNER "
			+ "JOIN PARKS PK ON RC.PARK=PK.ID INNER JOIN RUNNERS RN ON RS.RUNNER=RN.ID WHERE RS.CLUB=";
	
	private static final String CLUB_RUNNER_TO_LIST_REQUEST = "SELECT RN.FIRSTNAME AS " + FIRSTNAME + ", "
			+ "RN.LASTNAME AS " + LASTNAME + ", RN.AVATAR AS " + AVATAR +  ", RN.GENDER AS "+GENDER+", RN.ID AS " + RUNNERID
			+ " FROM RUNNERS RN WHERE RN.CLUB = ";
	
	private static final String RACE_TO_REQUEST_FOR_ID = "SELECT RC.ID AS "+RACE_ID+", RC.DATE AS " + RACE_DATE
			+ ", RC.NAME AS "+RACENAME+", PK.NAME AS " + PARK_NAME + " FROM RACES RC INNER JOIN PARKS PK ON RC.PARK=PK.ID WHERE RC.ID=";
	
	private static final String FULL_RACE_TO_REQUEST = "SELECT RC.ID AS "+RACE_ID+", RC.DATE AS " + RACE_DATE
			+ ", RC.NAME AS " + RACENAME + ", PK.NAME AS " + PARK_NAME
			+ " FROM RACES RC INNER JOIN PARKS PK ON RC.PARK=PK.ID";
	
	private static final String EXTENDED_RACE_TO_REQUEST = "SELECT RC.ID AS RACE_ID, RC.DATE AS RACE_DATE, RC.NAME AS RACENAME, PK.NAME AS PARK_NAME, (SELECT COUNT(RT.ID) FROM RESULTS RT WHERE RT.RACE=RC.ID AND RT.GENDER='M') AS M_PARTICIPANTS, (SELECT COUNT(RT.ID) FROM RESULTS RT WHERE RT.RACE=RC.ID AND RT.GENDER='F') AS W_PARTICIPANTS FROM RACES RC INNER JOIN PARKS PK ON RC.PARK=PK.ID";
	
	public static final String M_PARTICIPANTS = "M_PARTICIPANTS";
	
	public static final String W_PARTICIPANTS = "W_PARTICIPANTS";
	
	private static final String EXTENDED_RACE_TO_REQUEST_ENDING_FOR_LAST_RACE = " ORDER BY RC.DATE DESC, RC.ID DESC LIMIT 1;";
	
	private static final String EXTENDED_RACE_TO_REQUEST_ENDING_FOR_RACE_ID = " WHERE RC.ID=";
	
	private static final String WHERE = " WHERE";
	
	private static final String AND = " AND";
	
	private static final String FULL_RACE_TO_REQUEST_ENDING_PARK_ID = " PK.ID=";
	
	private static final String FULL_RACE_TO_REQUEST_ENDING_DATE_AFTER = " NOT RC.DATE<";
	
	private static final String FULL_RACE_TO_REQUEST_ENDING_DATE_BEFORE = " NOT RC.DATE>";
	
	private static final String FULL_RACE_TO_REQUEST_ENDING_FOR_LIST = " ORDER BY RC.DATE DESC, RC.ID DESC;";
	
	private static final String RUNNER_RACE_RESULT_REQUEST = "SELECT RS.POSITION AS "+POSITION+", RN.FIRSTNAME AS "+FIRSTNAME
			+", RN.LASTNAME AS "+LASTNAME+", CL.NAME AS "+CLUBNAME+", PC1.LOCATION AS "+CLUBLOGO+", CL.ID AS "+CLUBID
			+", RN.DATEOFBIRTH AS "+DATEOFBIRTH+", RS.TIME AS "+TIME+", RN.ID AS "+RUNNERID+", PC2.LOCATION AS "+AVATAR+
			" FROM RESULTS RS LEFT JOIN RUNNERS RN ON RS.RUNNER=RN.ID LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID LEFT JOIN PICTURES PC1 ON CL.SMALLLOGO=PC1.ID LEFT JOIN PICTURES PC2 ON RN.LOGO=PC2.ID "
			+ "WHERE RS.RACE = &&RACE&& AND RS.GENDER = '&&GENDER&&'";
	
	
	
	private static GenderConverter GENDERCONVERTER = new GenderConverter();
	
	public static String raceResultRequest(long raceId) {
		return RACE_RESULT_TO_REQUEST + raceId;
	}

	/**
	 * returns sql-request for full list of races
	 * 
	 * @return String sql-request
	 */
	public static String fullRaceListRequest() {
		return fullRaceTOListRequest(null,null,null);
	}

	/**
	 * 
	 * @param runnerId
	 * @return String sql-request
	 */
	public static String runnerResultInfoListRequest(long runnerId) {
		return RUNNER_RESULT_INFO_REQUEST.replaceAll(RUNNERIDREGEX, Long.toString(runnerId));
	};
	
	/**
	 * returns RunnerTO request for given runnerId
	 * 
	 * @param runnerId
	 * @return String sql-request
	 */
	public static String runnerTORequest(long runnerId) {
		return RUNNER_TO_REQUEST + runnerId;
	}

	/**
	 * returns ClubTO request for given club id
	 * 
	 * @param clubId
	 * @return String sql-request
	 */
	public static String clubTORequest(long clubId) {
		return CLUB_TO_REQUEST + clubId;
	}
	
	/**
	 * returns RaceClubResultTO request for given club id
	 * 
	 * @param clubId
	 * @return String sql-request
	 */
	public static String raceClubResultTORequest(long clubId) {
		return RACE_CLUB_RESULT_TO_REQUEST + clubId;
	}
	
	/**
	 * returns request for List of ClubRunnerTO for club with given id
	 * @param clubId
	 * @return String sql-request
	 */
	public static String clubRunnerTOListReqyest(long clubId){
		return CLUB_RUNNER_TO_LIST_REQUEST+clubId;
	}
	
	/**
	 * returns sql-request for RaceTO
	 * @param raceId
	 * @return
	 */
	public static String raceTORequest(long raceId) {
		return RACE_TO_REQUEST_FOR_ID + raceId;
	}
	
	/**
	 * returns sql-request for RunnerRaceresultTO
	 * @param raceId
	 * @param gender
	 * @return
	 */
	public static String runnerRaceResultTORequest(long raceId, Gender gender) {
		return RUNNER_RACE_RESULT_REQUEST.replaceAll(RACEIDREGEX, Long.toString(raceId)).replaceAll(GENDERREGEX,
				GENDERCONVERTER.convertToDatabaseColumn(gender));
	}
	
	/**
	 * provides sql-request for RaceTO for last Race
	 * @return String sql-request
	 */
	public static String extendedRaceTORequestForLastRace(){
		return EXTENDED_RACE_TO_REQUEST+EXTENDED_RACE_TO_REQUEST_ENDING_FOR_LAST_RACE;
	}
	
	/**
	 * provides sql-request for RaceTO for last Race
	 * @return String sql-request
	 */
	public static String extendedRaceTORequestForRaceId(long raceId){
		return EXTENDED_RACE_TO_REQUEST+EXTENDED_RACE_TO_REQUEST_ENDING_FOR_RACE_ID+raceId;
	}
	
	/**
	 * provides sql-request for for fetching the list of RaceTO for given time-interval and parkId 
	 * @param from - start date
	 * @param to - end date
	 * @param parkId - id of park
	 * @return String sql-request
	 */
	public static String fullRaceTOListRequest(Date from, Date to, Long parkId) {
		StringBuilder sb = new StringBuilder();
		sb.append(FULL_RACE_TO_REQUEST);
		boolean appended = false;
		if (parkId != null) {
			appended = true;
			sb.append(WHERE);
			sb.append(FULL_RACE_TO_REQUEST_ENDING_PARK_ID);
			sb.append(Long.toString(parkId));
		}
		if (from != null) {
			if (!appended) {
				sb.append(WHERE);
				appended = true;
			}else sb.append(AND);
			sb.append(FULL_RACE_TO_REQUEST_ENDING_DATE_AFTER);
			sb.append("'" + from.toString() + "'");
		}
		if (to != null) {
			if (!appended) {
				sb.append(WHERE);
			}else sb.append(AND);
			sb.append(FULL_RACE_TO_REQUEST_ENDING_DATE_BEFORE);
			sb.append("'" + to.toString() + "'");
		}
		sb.append(FULL_RACE_TO_REQUEST_ENDING_FOR_LIST);
		return sb.toString();
	}
}
