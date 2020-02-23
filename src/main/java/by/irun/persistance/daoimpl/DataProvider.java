package by.irun.persistance.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import by.irun.config.ApplicationConstants;
import by.irun.dao.IDataProvider;
import by.irun.domain.to.ClubRunnerTO;
import by.irun.domain.to.ClubTO;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.persistance.util.GenderConverter;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.to.TORequests;
import by.irun.viz.utils.VizUtils;

/**
 * implementation of {@link by.irun.dao.IDataProvider}
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
	 * @see by.irun.dao.IDataProvider#getRaceResult(long raceId)
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
	 * @see by.irun.dao.IDataProvider#getFullRaceList()
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
	 * @see by.irun.dao.IDataProvider#getRunnerResults(long runnerId)
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
	 * @see by.irun.dao.IDataProvider#getRunnerTO(long runnerId)
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
	 * @see by.irun.dao.IDataProvider#getClubTO(long clubId)
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
	 * @see by.irun.dao.IDataProvider#getRaceClubResultTOList(long clubId)
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
	 * @see by.irun.dao.IDataProvider#getCurrentClubRunnerTOListForClub(long clubId)
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

}
