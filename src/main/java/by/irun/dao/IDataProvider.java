package by.irun.dao;

import java.sql.SQLException;
import java.util.List;

import by.irun.domain.to.RunnerResultTO;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;

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
	List<RaceResultTO>getRaceResult(long raceId) throws SQLException;
	
	/**
	 * Provides entire list of races from DB
	 * @return
	 */
	List<RaceInfoTO>getFullRaceList() throws SQLException;
	
	/**
	 * Provides List of runner result for given runner id
	 * @param runnerId
	 * @return List<RunnerResultInfoTO>
	 * @throws SQLException
	 */
	List<RunnerResultTO> getRunnerResults(long runnerId) throws SQLException;
}
