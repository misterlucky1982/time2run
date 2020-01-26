package by.irun.dao;

import java.util.List;

import by.irun.inf.ob.RaceResultTO;

/**
 * Provides information from DB without creation entity-objects
 * 
 * @author A.Dubovik
 *
 */
public interface IDataProvider {
	
	/**
	 * Provides list of results of race with given id
	 * @param raceId
	 * @return List<RaceResultTO>
	 */
	List<RaceResultTO>getRaceResult(long raceId);
}
