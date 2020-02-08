package by.irun.persistance.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import by.irun.config.ApplicationConstants;
import by.irun.dao.IDataProvider;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.to.TOUtils;
import by.irun.viz.to.VizUtils;

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
	public List<RaceResultTO> getRaceResult(long raceId) {
		return getRaceResultTOListFromSqlRowSet(jdbcTemplate.queryForRowSet(TOUtils.raceResultRequest(raceId)));		
	}
	
	/* (non-Javadoc)
	 * @see by.irun.dao.IDataProvider#getFullRaceList()
	 */
	@Override
	public List<RaceInfoTO> getFullRaceList() {
		return getRaceInfoTOListFromSqlRowSet(jdbcTemplate.queryForRowSet(TOUtils.fullRaceListRequest()));
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
			to.setAbsPosition(rowSet.getInt(TOUtils.POSITION));
			to.setPositionInGroup(posInGroup++);
			to.setClub(rowSet.getString(TOUtils.CLUB));
			to.setName(rowSet.getString(TOUtils.NAME));
			to.setGender(rowSet.getString(TOUtils.GENDER));
			to.setTime(VizUtils.convertNumberOfSecondsToTimeRepresentation(rowSet.getInt(TOUtils.TIME)));
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
			to.setRaceId(rowSet.getLong(TOUtils.RACE_ID));
			to.setRaceName(VizUtils.convertSqlDateToFrontEndRepresentation(rowSet.getDate(TOUtils.RACE_DATE))+" "+rowSet.getString(TOUtils.PARK_NAME));
			list.add(to);
		}
		return list;
	}
}
