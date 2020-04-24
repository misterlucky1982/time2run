package by.irun.persistance.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import by.irun.domain.Gender;
import by.irun.domain.to.ClubRunnerTO;
import by.irun.domain.to.ClubTO;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RaceExtendedTO;
import by.irun.domain.to.RaceTO;
import by.irun.domain.to.RunnerRaceResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
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
	@Deprecated
	List<RaceInfoTO>getFullRaceList() throws SQLException;
	
	/**
	 * Provides List of runner result for given runner id
	 * @param runnerId
	 * @return List<RunnerResultInfoTO>
	 * @throws SQLException
	 */
	List<RunnerResultTO> getRunnerResults(long runnerId) throws SQLException;
	
	/**
	 * Provides RunnerTO for given runner id
	 * @param runnerId
	 * @return RunnerTO
	 * @throws SQLException
	 */
	RunnerTO getRunnerTO(long runnerId) throws SQLException;
	
	/**
	 * Provides ClubTO for given club id
	 * @param clubId
	 * @return ClubTO
	 * @throws SQLException
	 */
	ClubTO getClubTO(long clubId) throws SQLException;
	
	/**
	 * Provides List<RaceClubResultTO> for given club id
	 * @param clubId
	 * @return List
	 * @throws SQLException
	 */
	List<RaceClubResultTO> getRaceClubResultTOList(long clubId) throws SQLException;
	
	/**
	 * Provides List<ClubRunnerTO> for given clubId
	 * <p>
	 * In fact - information about current club`s line-up
	 * @param clubId
	 * @return List
	 * @throws SQLException
	 */
	List<ClubRunnerTO> getCurrentClubRunnerTOListForClub(long clubId) throws SQLException;
	
	/**
	 * Provides List<RunnerRaceResultTO> for given race id and gender
	 * @param raceId
	 * @param gender
	 * @return
	 * @throws SQLException
	 */
	List<RunnerRaceResultTO> getRunnerRaceResultList(long raceId, Gender gender) throws SQLException;
	
	/**
	 * Provides RaceExtendedTO for given raceId
	 * @param raceId
	 * @return
	 * @throws SQLException
	 */
	RaceExtendedTO getRaceExtendedTOforRaceId (long raceId) throws SQLException;
	
	/**
	 * Provides RaceExtendedTO for last Race
	 * @return RaceTO
	 * @throws SQLException
	 */
	RaceExtendedTO getRaceExtendedTOForLastRace() throws SQLException;
	
	RaceTO getRaceTOforRaceId(long raceId) throws SQLException;
	
	/**
	 * Provides List<RaceTO> for given parameters
	 * @param from - start date of period
	 * @param to - end date of period
	 * @param parkId - Park id
	 * @return
	 * @throws SQLException
	 */
	List<RaceTO> getRaceTOList (Date from, Date to, Long parkId) throws SQLException;
}
