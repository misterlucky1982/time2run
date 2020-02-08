package by.irun.persistance.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.to.TOUtils;
import by.irun.viz.to.VizUtils;

/**
 * Test Class for testing {@link by.irun.persistance.daoimpl.DataProvider}
 * 
 * @author A.Dubovik
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DataProvider.class})
public class DataProviderTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	private static final String CLUB = "CLUB";
	private static final String NAME = "NAME";
	private static final String GENDER = "G";
	private static final String PARK = "PARK";
	
	/**
	 * test for DataProviter#getRaceResult()
	 */
	@Test
	public void getRaceResultTest(){
			SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
			EasyMock.expect(jdbcTemplate.queryForRowSet(TOUtils.raceResultRequest(1L))).andReturn(rowSet);
			DataProvider provider = new DataProvider();
			Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
			List<RaceResultTO>expected = prepareForGetRaceResultTOListFromSqlRowSet(rowSet,1);
			PowerMock.replayAll();
			List<RaceResultTO> result = provider.getRaceResult(1L);
			assertTrue(result.size()==1);
			assertEquals(expected.get(0),result.get(0));
			PowerMock.verifyAll();
	}
	
	/**
	 * test for {@link by.irun.persistance.daoimpl.DataProvider#getFullRaceList()}
	 */
	@Test
	public void getRaceInfoTOListFromSqlRowSetTest(){
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TOUtils.fullRaceListRequest())).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		List<RaceInfoTO>expected = prepareForGetRaceInfoTOListFromSqlRowSetForGivenDates(rowSet,Arrays.asList(Date.valueOf("2000-01-01"),Date.valueOf("2000-02-02")),1L);
		PowerMock.replayAll();
		List<RaceInfoTO> result = provider.getFullRaceList();
		assertTrue(result.size()==2);
		assertEquals(expected.get(0),result.get(0));
		assertEquals(expected.get(1),result.get(1));
		PowerMock.verifyAll();
	}
	
	/**
	 * prepares List RaceResultTO for given number of calls SqlRowSet
	 * @param rowSet
	 * @param numberOfResults
	 * @return
	 */
	private List<RaceResultTO> prepareForGetRaceResultTOListFromSqlRowSet(SqlRowSet rowSet,int numberOfResults){
		List<RaceResultTO>list = new ArrayList<>();
		while(numberOfResults>0){
			RaceResultTO to = new RaceResultTO();
			EasyMock.expect(rowSet.next()).andReturn(true);
			EasyMock.expect(rowSet.getInt(TOUtils.POSITION)).andReturn(numberOfResults);
			to.setAbsPosition(numberOfResults);
			to.setPositionInGroup(numberOfResults);
			EasyMock.expect(rowSet.getString(TOUtils.CLUB)).andReturn(CLUB+numberOfResults);
			to.setClub(CLUB+numberOfResults);
			EasyMock.expect(rowSet.getString(TOUtils.NAME)).andReturn(NAME+numberOfResults);
			to.setName(NAME+numberOfResults);
			EasyMock.expect(rowSet.getString(TOUtils.GENDER)).andReturn(GENDER);
			to.setGender(GENDER);
			to.setTime(VizUtils.convertNumberOfSecondsToTimeRepresentation(numberOfResults));
			EasyMock.expect(rowSet.getInt(TOUtils.TIME)).andReturn(numberOfResults--);
			list.add(to);
		}
		EasyMock.expect(rowSet.next()).andReturn(false);
		return list;
	}

	/**
	 * prepares List RaceInfoTO for given list of dates
	 * @param rowSet
	 * @param dates - list of dates
	 * @param startId - start id for RaceInfoTO
	 * @return List<RaceInfoTO>
	 */
	private List<RaceInfoTO> prepareForGetRaceInfoTOListFromSqlRowSetForGivenDates(SqlRowSet rowSet,List<Date>dates,long startId){
		List<RaceInfoTO>list = new ArrayList<>();
		for(Date d:dates){
			RaceInfoTO to = new RaceInfoTO();
			EasyMock.expect(rowSet.next()).andReturn(true);
			EasyMock.expect(rowSet.getLong(TOUtils.RACE_ID)).andReturn(startId);
			to.setRaceId(startId++);
			EasyMock.expect(rowSet.getDate(TOUtils.RACE_DATE)).andReturn(d);
			EasyMock.expect(rowSet.getString(TOUtils.PARK_NAME)).andReturn(PARK);
			to.setRaceName(VizUtils.convertSqlDateToFrontEndRepresentation(d)+" "+PARK);
			list.add(to);
		}
		EasyMock.expect(rowSet.next()).andReturn(false);
		return list;
	}
	
}
