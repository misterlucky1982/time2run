package by.irun.service;

import java.sql.Date;
import java.util.List;
import java.util.Locale;
import by.irun.util.Link;
import by.irun.viz.to.ClubInfoTO;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.to.racepage.RaceResultInfoTO;
import by.irun.viz.to.raceselectpage.RaceInfoVizTO;
import by.irun.viz.to.raceselectpage.RaceSelectPageViewTO;
import by.irun.viz.to.runnerpage.RunnerInfoTO;
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
	
	/**
	 * Provides RunnerTO for given id of {@link by.irun.domain.Runner}
	 * @param runnerId
	 * @param locale
	 * @return
	 */
	RunnerInfoTO getRunnerInfoTO(long runnerId, Locale locale);
	
	/**
	 * Provides ClubInfoTO for given id of {@link by.irun.domain.Club}
	 * @param runnerId
	 * @param locale
	 * @return
	 */
	ClubInfoTO getClubInfoTO(long clubId, Locale locale);
	
	/**
	 * Provides RaceResultInfoTO for given id of {@link by.irun.domain.Race}
	 * @param raceId
	 * @return
	 */
	RaceResultInfoTO getRaceResultInfoTO(long raceId, Locale locale);
	
	/**
	 * Provides RaceSelectPageViewTO for last race
	 * @param locale
	 * @return
	 */
	RaceSelectPageViewTO getRaceSelectPageViewTOForLastRace(Locale locale);

	/**
	 * Provides List of links to races for given parameters
	 * @param from
	 * @param to
	 * @param parkId
	 * @param locale
	 * @return
	 */
	java.util.List<Link> getRaceLinkList(Date from, Date to, Long parkId, Locale locale);
	
	RaceInfoVizTO getRaceInfoVizTO(Long raceId, Locale locale);
	
}
