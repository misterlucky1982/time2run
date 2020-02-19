package by.irun.viz.to;

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

	private static final String RACE_RESULT_TO_REQUEST = "SELECT RS.POSITION AS " + POSITION
			+ ", CONCAT(RN.FIRSTNAME,' ',RN.LASTNAME) AS " + NAME + ", RS.GENDER AS " + GENDER + ", CL.NAME AS " + CLUB
			+ ", RS.TIME AS " + TIME + " FROM RESULTS RS LEFT JOIN RUNNERS RN ON RS.RUNNER = RN.ID"
			+ " LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = ";

	private static final String RUNNER_RESULT_INFO_REQUEST = "SELECT RS.POSITION AS " + ABSPOSITION
			+ ", (SELECT COUNT(*)+1 FROM RESULTS WHERE RACE=RS.RACE AND POSITION<RS.POSITION AND GENDER = RS.GENDER) AS "
			+ POSITIONINGENDERGROUP + ",RS.CLUB AS " + CLUBID + ",CL.NAME AS " + CLUBNAME + ", CL.SMALLLOGO AS "
			+ CLUBLOGO + ", RS.RACE AS " + RACE_ID + ", RC.DATE AS " + RACE_DATE + ", PK.NAME AS " + PARK_NAME
			+ ", RS.TIME AS " + TIME
			+ " FROM RESULTS RS INNER JOIN RACES RC ON RS.RACE=RC.ID INNER JOIN PARKS PK ON RC.PARK=PK.ID "
			+ "INNER JOIN CLUBS CL ON RS.CLUB = CL.ID WHERE RS.RUNNER =";

	private static final String RACELIST_REQUEST = "select rc.id as " + RACE_ID + ", pk.name as " + PARK_NAME
			+ ", rc.date as " + RACE_DATE + " from races rc inner"
			+ " join parks pk on rc.park = pk.id order by rc.date desc;";
	
	private static final String RUNNER_TO_REQUEST = "SELECT RN.FIRSTNAME AS " + FIRSTNAME + ", RN.LASTNAME AS "
			+ LASTNAME + ", RN.CITY AS " + CITY + ",  PC.LOCATION AS " + AVATAR + ", CL.ID AS " + CLUBID
			+ ", CL.NAME AS " + CLUBNAME + ", RN.DATEOFBIRTH AS " + DATEOFBIRTH + ", RN.GENDER AS " + GENDER
			+ " FROM RUNNERS RN LEFT JOIN PICTURES PC ON RN.AVATAR=PC.ID LEFT JOIN CLUBS CL ON RN.CLUB=CL.ID WHERE RN.ID=";

	private static final String CLUB_TO_REQUEST = "SELECT CL.NAME AS " + NAME + ", CL.BASECITY AS " + CITY
			+ ", CL.BIGLOGO AS " + CLUBLOGO + ", A.EMAIL AS " + EMAIL + ", A.PHONE AS " + PHONE
			+ " FROM CLUBS CL INNER JOIN USERS A ON CL.ADMIN=A.ID WHERE CL.ID=";
	
	private static final String RACE_CLUB_RESULT_TO_REQUEST = "SELECT RS.POSITION AS " + ABSPOSITION
			+ ",(SELECT COUNT(*)+1 FROM RESULTS WHERE RACE=RS.RACE AND POSITION<RS.POSITION"
			+ " AND GENDER = RS.GENDER) AS " + POSITIONINGENDERGROUP + ",RC.DATE AS " + RACE_DATE + ", PK.NAME AS "
			+ PARK_NAME + ", RC.ID AS " + RACE_ID + ",RN.FIRSTNAME AS " + FIRSTNAME + ", RN.LASTNAME AS " + LASTNAME
			+ ", RN.ID AS " + RUNNERID + ", RS.TIME AS " + TIME
			+ " FROM RESULTS RS INNER JOIN RACES RC ON RS.RACE = RC.ID INNER "
			+ "JOIN PARKS PK ON RC.PARK=PK.ID INNER JOIN RUNNERS RN ON RS.RUNNER=RN.ID WHERE RS.CLUB=";

	public static String raceResultRequest(long raceId) {
		return RACE_RESULT_TO_REQUEST + raceId;
	}

	/**
	 * returns sql-request for full list of races
	 * 
	 * @return String sql-request
	 */
	public static String fullRaceListRequest() {
		return RACELIST_REQUEST;
	}

	/**
	 * 
	 * @param runnerId
	 * @return String sql-request
	 */
	public static String runnerResultInfoListRequest(long runnerId) {
		return RUNNER_RESULT_INFO_REQUEST + runnerId;
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
}
