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

}
