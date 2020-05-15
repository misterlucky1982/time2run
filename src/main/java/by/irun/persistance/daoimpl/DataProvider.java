package by.irun.persistance.daoimpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import by.irun.config.ApplicationConstants;
import by.irun.domain.Gender;
import by.irun.domain.to.ClubRunnerTO;
import by.irun.domain.to.ClubTO;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RaceExtendedTO;
import by.irun.domain.to.RaceTO;
import by.irun.domain.to.RunnerRaceResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.persistance.dao.common.IDataProvider;
import by.irun.persistance.util.GenderConverter;
import by.irun.persistance.util.TORequests;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.utils.VizUtils;

/**
 * implementation of {@link by.irun.persistance.dao.common.IDataProvider}
 * @author A.Dubovik
 */
@Component
public class DataProvider implements IDataProvider{
	
	private GenderConverter genderConverter = new GenderConverter();
	
	private JdbcTemplate jdbcTemplate;
	{
		jdbcTemplate = new JdbcTemplate(new org.springframework.jdbc.datasource.DriverManagerDataSource(ApplicationConstants.DB_URL,ApplicationConstants.DB_USERNAME,ApplicationConstants.DB_PASSWORD));
	}

	/* (non-Javadoc)
	 * @see by.irun.persistance.dao.IDataProvider#getRaceResult(long raceId)
	 */
	@Override
	public List<RaceResultTO> getRaceResult(long raceId) throws SQLException{
		try{
			return getRaceResultTOListFromSqlRowSet(jdbcTemplate.queryForRowSet(TORequests.raceResultRequest(raceId)));		
		}catch(org.springframework.dao.DataAccessException e){
			throw new SQLException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see by.irun.persistance.dao.IDataProvider#getFullRaceList()
	 */
	@Override
	public List<RaceInfoTO> getFullRaceList() throws SQLException{
		try{
			return getRaceInfoTOListFromSqlRowSet(jdbcTemplate.queryForRowSet(TORequests.fullRaceListRequest()));
		}catch(org.springframework.dao.DataAccessException e){
			throw new SQLException(e);
		}
	}

	
	/**
	 * reads List of RaceResultTO from given SqlRowSet
	 * @param rowSet
	 * @return List
	 */
	private List<RaceResultTO> getRaceResultTOListFromSqlRowSet(SqlRowSet rowSet){
		List<RaceResultTO>list = new ArrayList<>();
		int posInGroup = 1;
		while(rowSet.next()){
			RaceResultTO to = new RaceResultTO();
			to.setAbsPosition(rowSet.getInt(TORequests.POSITION));
			to.setPositionInGroup(posInGroup++);
			to.setClub(rowSet.getString(TORequests.CLUB));
			to.setName(rowSet.getString(TORequests.NAME));
			to.setGender(rowSet.getString(TORequests.GENDER));
			to.setTime(VizUtils.convertNumberOfSecondsToTimeRepresentation(rowSet.getInt(TORequests.TIME)));
			list.add(to);
		}
		return list;
	}
	
	/**
	 * reads List of RaceInfoTO from given SqlRowSet
	 * @param rowSet
	 * @return List
	 */
	private List<RaceInfoTO> getRaceInfoTOListFromSqlRowSet(SqlRowSet rowSet){
		List<RaceInfoTO>list = new ArrayList<>();
		while(rowSet.next()){
			RaceInfoTO to = new RaceInfoTO();
			to.setRaceId(rowSet.getLong(TORequests.RACE_ID));
			to.setRaceName(VizUtils.convertSqlDateToFrontEndRepresentation(rowSet.getDate(TORequests.RACE_DATE))+" "+rowSet.getString(TORequests.PARK_NAME));
			list.add(to);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getRunnerResults(long runnerId)
	 */
	@Override
	public List<RunnerResultTO> getRunnerResults(long runnerId) throws SQLException {
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.runnerResultInfoListRequest(runnerId));
			List<RunnerResultTO> list = new ArrayList<>();
			while (rowSet.next()) {
				RunnerResultTO to = new RunnerResultTO();
				to.setAbsPosition(rowSet.getInt(TORequests.ABSPOSITION));
				to.setClubId(rowSet.getLong(TORequests.CLUBID));
				to.setClubLogo(rowSet.getString(TORequests.CLUBLOGO));
				to.setClubName(rowSet.getString(TORequests.CLUBNAME));
				to.setParkName(rowSet.getString(TORequests.PARK_NAME));
				to.setPositionInGenderGroup(rowSet.getInt(TORequests.POSITIONINGENDERGROUP));
				to.setRaceDate(rowSet.getDate(TORequests.RACE_DATE));
				to.setRaceId(rowSet.getLong(TORequests.RACE_ID));
				to.setRaceName(rowSet.getString(TORequests.RACENAME));
				to.setTime(rowSet.getInt(TORequests.TIME));
				list.add(to);
			}
			return list;
		} catch (DataAccessException e) {
			throw new SQLException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getRunnerTO(long runnerId)
	 */
	@Override
	public RunnerTO getRunnerTO(long runnerId) throws SQLException {
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.runnerTORequest(runnerId));
			if (rowSet.next()) {
				RunnerTO to = new RunnerTO();
				to.setAvatar(rowSet.getString(TORequests.AVATAR));
				to.setCity(rowSet.getString(TORequests.CITY));
				to.setClubId(rowSet.getLong(TORequests.CLUBID));
				to.setClubName(rowSet.getString(TORequests.CLUBNAME));
				to.setDateOfBirth(rowSet.getDate(TORequests.DATEOFBIRTH));
				to.setFirstName(rowSet.getString(TORequests.FIRSTNAME));
				to.setGender(genderConverter.convertToEntityAttribute(rowSet.getString(TORequests.GENDER)));
				to.setLastName(rowSet.getString(TORequests.LASTNAME));
				return to;
			} else
				throw new SQLException("Empty resultset for id:" + runnerId);
		} catch (DataAccessException e) {
			throw new SQLException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getClubTO(long clubId)
	 */
	@Override
	public ClubTO getClubTO(long clubId) throws SQLException {
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.clubTORequest(clubId));
			if (rowSet.next()) {
				ClubTO to = new ClubTO();
				to.setName(rowSet.getString(TORequests.NAME));
				to.setCity(rowSet.getString(TORequests.CITY));
				to.setClubLogo(rowSet.getString(TORequests.CLUBLOGO));
				to.setEmail(rowSet.getString(TORequests.EMAIL));
				to.setPhone(rowSet.getString(TORequests.PHONE));
				return to;
			} else
				throw new SQLException("Empty resultset for id:" + clubId);
		} catch (DataAccessException e) {
			throw new SQLException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getRaceClubResultTOList(long clubId)
	 */
	@Override
	public List<RaceClubResultTO> getRaceClubResultTOList(long clubId) throws SQLException {
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.raceClubResultTORequest(clubId));
			List<RaceClubResultTO> list = new ArrayList<>();
			while (rowSet.next()) {
				RaceClubResultTO to = new RaceClubResultTO();
				to.setAbsPosition(rowSet.getInt(TORequests.ABSPOSITION));
				to.setPositionInGenderGroup(rowSet.getInt(TORequests.POSITIONINGENDERGROUP));
				to.setDate(rowSet.getDate(TORequests.RACE_DATE));
				to.setRaceName(rowSet.getString(TORequests.RACENAME));
				to.setParkName(rowSet.getString(TORequests.PARK_NAME));
				to.setRaceId(rowSet.getLong(TORequests.RACE_ID));
				to.setRunnerFirstName(rowSet.getString(TORequests.FIRSTNAME));
				to.setRunnerLastName(rowSet.getString(TORequests.LASTNAME));
				to.setRunnerId(rowSet.getLong(TORequests.RUNNERID));
				to.setGender(genderConverter.convertToEntityAttribute(rowSet.getString(TORequests.GENDER)));
				to.setTimeInSeconds(rowSet.getInt(TORequests.TIME));
				list.add(to);
			}
			return list;
		} catch (DataAccessException e) {
			throw new SQLException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getCurrentClubRunnerTOListForClub(long clubId)
	 */
	@Override
	public List<ClubRunnerTO> getCurrentClubRunnerTOListForClub(long clubId) throws SQLException {
		List<ClubRunnerTO> result = new ArrayList<>();
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.clubRunnerTOListReqyest(clubId));
		while (rowSet.next()) {
			ClubRunnerTO to = new ClubRunnerTO();
			to.setRunnerId(rowSet.getLong(TORequests.RUNNERID));
			to.setFirstName(rowSet.getString(TORequests.FIRSTNAME));
			to.setLastName(rowSet.getString(TORequests.LASTNAME));
			to.setAvatarPath(rowSet.getString(TORequests.AVATAR));
			to.setGender(genderConverter.convertToEntityAttribute(rowSet.getString(TORequests.GENDER)));
			result.add(to);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getRunnerRaceResultList(long raceId, Gender gender)
	 */
	@Override
	public List<RunnerRaceResultTO> getRunnerRaceResultList(long raceId, Gender gender) throws SQLException {
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.runnerRaceResultTORequest(raceId, gender));
			List<RunnerRaceResultTO> list = new ArrayList<>();
			while (rowSet.next()) {
				RunnerRaceResultTO to = new RunnerRaceResultTO();
				to.setPosition(rowSet.getInt(TORequests.POSITION));
				to.setFirstName(rowSet.getString(TORequests.FIRSTNAME));
				to.setLastName(rowSet.getString(TORequests.LASTNAME));
				to.setClub(rowSet.getString(TORequests.CLUBNAME));
				to.setClubLogo(rowSet.getString(TORequests.CLUBLOGO));
				to.setClubId(rowSet.getLong(TORequests.CLUBID));
				to.setDateOfBirth(rowSet.getDate(TORequests.DATEOFBIRTH));
				to.setTimeInSeconds(rowSet.getInt(TORequests.TIME));
				to.setRunnerId(rowSet.getLong(TORequests.RUNNERID));
				to.setSmallAvatar(rowSet.getString(TORequests.AVATAR));
				list.add(to);
			}
			return list;
		} catch (RuntimeException e) {
			throw new SQLException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getRaceTOforRaceId (long raceId)
	 */
	@Override
	public RaceExtendedTO getRaceExtendedTOforRaceId(long raceId) throws SQLException {
		RaceExtendedTO to = null;
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.extendedRaceTORequestForRaceId(raceId));
			to = raceExtendedTOfromSqlRowSet(rowSet);
		} catch (RuntimeException e) {
			throw new SQLException(e);
		}
		return to;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getRaceTOForLastRace()
	 */
	@Override
	public RaceExtendedTO getRaceExtendedTOForLastRace() throws SQLException {
		RaceExtendedTO to = null;
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.extendedRaceTORequestForLastRace());
			to = raceExtendedTOfromSqlRowSet(rowSet);
		} catch (RuntimeException e) {
			throw new SQLException(e);
		}
		return to;
	}
	
	private RaceExtendedTO raceExtendedTOfromSqlRowSet(SqlRowSet rowSet) throws SQLException{
		if (rowSet.next()) {
			RaceExtendedTO to = null;
			to = new RaceExtendedTO();
			to.setRaceName(rowSet.getString(TORequests.RACENAME));
			to.setDate(rowSet.getDate(TORequests.RACE_DATE));
			to.setParkName(rowSet.getString(TORequests.PARK_NAME));
			to.setRaceId(rowSet.getLong(TORequests.RACE_ID));
			to.setMenParticupants(rowSet.getInt(TORequests.M_PARTICIPANTS));
			to.setWomenParticipants(rowSet.getInt(TORequests.W_PARTICIPANTS));
			return to;
		} else
			throw new SQLException("empty resultSet");
	}

	/**
	 * 
	 * @param rowSet
	 * @return RaceTO
	 */
	private RaceTO getRaceTOFromSqlRowset(SqlRowSet rowSet){
		RaceTO to = new RaceTO();
		to.setDate(rowSet.getDate(TORequests.RACE_DATE));
		to.setRaceName(rowSet.getString(TORequests.RACENAME));
		to.setParkName(rowSet.getString(TORequests.PARK_NAME));
		to.setRaceId(rowSet.getLong(TORequests.RACE_ID));
		return to;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see by.irun.persistance.dao.IDataProvider#getRaceTOList(Date from, Date to, Long parkId)
	 */
	@Override
	public List<RaceTO> getRaceTOList(Date from, Date to, Long parkId) throws SQLException {
		List<RaceTO> list = new ArrayList<>();
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.fullRaceTOListRequest(from, to, parkId));
			while (rowSet.next()) {
				list.add(getRaceTOFromSqlRowset(rowSet));
			}
		} catch (RuntimeException e) {
			throw new SQLException(e);
		}
		return list;
	}

	@Override
	public RaceTO getRaceTOforRaceId(long raceId) throws SQLException {
		RaceTO to = null;
		try {
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(TORequests.raceTORequest(raceId));
			if(rowSet.next()){
				to = getRaceTOFromSqlRowset(rowSet);
			}else throw new SQLException("empty ResultSet for raceId:"+raceId);
		} catch (RuntimeException e) {
			throw new SQLException(e);
		}
		return to;
	}
	
}
