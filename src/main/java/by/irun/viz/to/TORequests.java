package by.irun.viz.to;


/**
 * Utility class for operations with request`s result sets
 * <p>
 * Provides sql requests for info-objects (front-end representation of data stored in db)
 * <p>
 * and transfer operations for result-sets
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
	
	private static final String RACE_RESULT_TO_REQUEST = "SELECT RS.POSITION AS "+POSITION
			+ ", CONCAT(RN.FIRSTNAME,' ',RN.LASTNAME) AS "+NAME+
			", RS.GENDER AS "+GENDER
			+ ", CL.NAME AS "+CLUB+", RS.TIME AS "+TIME
			+ " FROM RESULTS RS LEFT JOIN RUNNERS RN ON RS.RUNNER = RN.ID"
			+ " LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = ";
	
	private static final String RACELIST_REQUEST = "select rc.id as "+RACE_ID
			+", pk.name as "+PARK_NAME+", rc.date as "+RACE_DATE+" from races rc inner"
					+ " join parks pk on rc.park = pk.id order by rc.date desc;";
	
	public static String raceResultRequest(long raceId) {
		return RACE_RESULT_TO_REQUEST + raceId;
	}
	
	/**
	 * returns sql-request for full list of races
	 * @return String sql-request
	 */
	public static String fullRaceListRequest(){
		return RACELIST_REQUEST;
	}
}
