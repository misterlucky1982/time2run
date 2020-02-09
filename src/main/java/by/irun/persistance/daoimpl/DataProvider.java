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
import by.irun.domain.to.RunnerResultTO;
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

}
