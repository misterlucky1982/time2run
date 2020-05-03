package by.irun.persistance.proxi;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import by.irun.domain.Club;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Race;
import by.irun.domain.Result;
import by.irun.domain.Runner;
import by.irun.domain.User;
import by.irun.domain.to.ClubRunnerTO;
import by.irun.domain.to.ClubTO;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RaceExtendedTO;
import by.irun.domain.to.RaceTO;
import by.irun.domain.to.RunnerRaceResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;

public interface InterimRepositoryConnector {

	Long addClub(Club club) throws SQLException;

	boolean updateClub(Club club) throws SQLException;

	Long addPark(Park park) throws SQLException;

	boolean updatePark(Park park) throws SQLException;

	Long addPicture(Picture pic) throws SQLException;

	boolean deletePicture(Picture pic) throws SQLException;

	Long addRace(Race race) throws SQLException;

	Long addResult(Result result) throws SQLException;

	Long addRunner(Runner runner) throws SQLException;

	boolean updateRunner(Runner runner) throws SQLException;

	Long addUser(User user) throws SQLException;

	boolean updateUser(User user) throws SQLException;

	List<Park> getParkList() throws SQLException;

	Club getClubById(long id) throws SQLException;

	Park getParkById(long id) throws SQLException;

	Picture getPictureById(long id) throws SQLException;

	Runner getRunnerById(long id) throws SQLException;

	User getUserById(long id) throws SQLException;

	List<RunnerResultTO> getRunnerResults(long runnerId) throws SQLException;

	RunnerTO getRunnerTO(long runnerId) throws SQLException;

	ClubTO getClubTO(long clubId) throws SQLException;

	List<RaceClubResultTO> getRaceClubResultTOList(long clubId) throws SQLException;

	List<ClubRunnerTO> getCurrentClubRunnerTOListForClub(long clubId) throws SQLException;

	List<RunnerRaceResultTO> getMenRaceResultList(long raceId) throws SQLException;
	
	List<RunnerRaceResultTO> getWomenRaceResultList(long raceId) throws SQLException;

	RaceExtendedTO getRaceExtendedTOforRaceId(long raceId) throws SQLException;

	RaceExtendedTO getRaceExtendedTOForLastRace() throws SQLException;

	RaceTO getRaceTOforRaceId(long raceId) throws SQLException;

	List<RaceTO> getRaceTOList(Date from, Date to, Long parkId) throws SQLException;
}
