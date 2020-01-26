package by.irun.persistance.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
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

import by.irun.inf.ob.RaceResultTO;
import by.irun.inf.ob.ResultTOUtil;

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
	
	/**
	 * test for DataProviter#getRaceResult()
	 */
	@Test
	public void getRaceResultTest(){
			SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
			EasyMock.expect(jdbcTemplate.queryForRowSet(ResultTOUtil.raceResultRequest(1L))).andReturn(rowSet);
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
			EasyMock.expect(rowSet.getInt(ResultTOUtil.POSITION)).andReturn(numberOfResults);
			to.setAbsPosition(numberOfResults);
			to.setPositionInGroup(numberOfResults);
			EasyMock.expect(rowSet.getString(ResultTOUtil.CLUB)).andReturn(CLUB+numberOfResults);
			to.setClub(CLUB+numberOfResults);
			EasyMock.expect(rowSet.getString(ResultTOUtil.NAME)).andReturn(NAME+numberOfResults);
			to.setName(NAME+numberOfResults);
			EasyMock.expect(rowSet.getString(ResultTOUtil.GENDER)).andReturn(GENDER);
			to.setGender(GENDER);
			to.setTime(Integer.toString(numberOfResults));
			EasyMock.expect(rowSet.getInt(ResultTOUtil.TIME)).andReturn(numberOfResults--);
			list.add(to);
		}
		EasyMock.expect(rowSet.next()).andReturn(false);
		return list;
	}

}
