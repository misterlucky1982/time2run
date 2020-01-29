package by.irun.viz.to;


/**
 * Utility class for operations with request`s result sets
 * Provides sql requests for info-objects (front-end representation of data stored in db)
 * and transfer operations for result-sets
 * @author A.Dubovik
 *
 */
public class ResultTOUtil {

	public static final String POSITION = "POSITION";
	public static final String NAME = "NAME";
	public static final String GENDER = "GENDER";
	public static final String TIME = "TIME";
	public static final String CLUB = "CLUB";
	private static final String RACE_RESULT_TO_REQUEST = "SELECT RS.POSITION AS "+POSITION
			+ ", CONCAT(RN.FIRSTNAME,' ',RN.LASTNAME) AS "+NAME+
			", RS.GENDER AS "+GENDER
			+ ", CL.NAME AS "+CLUB+", RS.TIME AS "+TIME
			+ " FROM RESULTS RS LEFT JOIN RUNNERS RN ON RS.RUNNER = RN.ID"
			+ " LEFT JOIN CLUBS CL ON RS.CLUB=CL.ID WHERE RS.RACE = ";
	
	public static String raceResultRequest(long raceId) {
		return RACE_RESULT_TO_REQUEST + raceId;
	}
}
