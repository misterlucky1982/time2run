package by.irun.service;

import java.util.List;

import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.to.RunnerInfoTO;
/**
 * Provides functionality for transformation data stored in DB into front-end representation
 * @author A.Dubovik
 */
public interface IDataService {
	
	/**
	 * Provides list of results of race with given id {@link by.irun.domain.Race}
	 * @param raceId
	 * @return List<RaceResultTO>
	 */
	List<RaceResultTO>getRaceResult(long raceId);
	
	/**
	 * Provides list of RaceInfoTO for all races that are stored in Data Repository
	 * @return RaceInfoTO
	 */
	List<RaceInfoTO>getFullRaceList();
	
	/**
	 * Provides RunnerInfoTO for given id of {@link by.irun.domain.Runner}
	 * @param runnerId
	 * @return
	 */
	RunnerInfoTO getRunnerInfoTO(long runnerId);

}
