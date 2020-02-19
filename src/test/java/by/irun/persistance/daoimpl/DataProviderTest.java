package by.irun.persistance.daoimpl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
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

import by.irun.domain.Gender;
import by.irun.domain.to.ClubTO;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.to.TORequests;
import by.irun.viz.utils.VizUtils;

/**
 * Test Class for testing {@link by.irun.persistance.daoimpl.DataProvider}
 * 
 * @author A.Dubovik
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ DataProvider.class })
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
	public void getRaceResultTest() {
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.raceResultRequest(1L))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		List<RaceResultTO> expected = prepareForGetRaceResultTOListFromSqlRowSet(rowSet, 1);
		PowerMock.replayAll();
		List<RaceResultTO> result = null;
		try {
			result = provider.getRaceResult(1L);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(result.size() == 1);
		assertEquals(expected.get(0), result.get(0));
		PowerMock.verifyAll();
	}

	/**
	 * test for
	 * {@link by.irun.persistance.daoimpl.DataProvider#getRaceResult(long)} with
	 * Exception
	 */
	@Test
	public void getRaceResultWithExceptionTest() {
		org.springframework.dao.DataAccessException exception = PowerMock
				.createMock(org.springframework.dao.DataAccessException.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.raceResultRequest(1L))).andThrow(exception);
		EasyMock.expect(exception.getCause()).andReturn(new RuntimeException());
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		PowerMock.replayAll();
		List<RaceResultTO> result = null;
		try {
			result = provider.getRaceResult(1L);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNull(result);
		PowerMock.verifyAll();
	}

	/**
	 * test for
	 * {@link by.irun.persistance.daoimpl.DataProvider#getFullRaceList()}
	 */
	@Test
	public void getFullRaceListTest() {
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.fullRaceListRequest())).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		List<RaceInfoTO> expected = prepareForGetRaceInfoTOListFromSqlRowSetForGivenDates(rowSet,
				Arrays.asList(Date.valueOf("2000-01-01"), Date.valueOf("2000-02-02")), 1L);
		PowerMock.replayAll();
		List<RaceInfoTO> result = null;
		try {
			result = provider.getFullRaceList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(result.size() == 2);
		assertEquals(expected.get(0), result.get(0));
		assertEquals(expected.get(1), result.get(1));
		PowerMock.verifyAll();
	}

	/**
	 * test for
	 * {@link by.irun.persistance.daoimpl.DataProvider#getFullRaceList()}
	 */
	@Test
	public void getFullRaceListTestWithException() {
		org.springframework.dao.DataAccessException exception = PowerMock
				.createMock(org.springframework.dao.DataAccessException.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.fullRaceListRequest())).andThrow(exception);
		EasyMock.expect(exception.getCause()).andReturn(new RuntimeException());
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		PowerMock.replayAll();
		List<RaceInfoTO> result = null;
		try {
			result = provider.getFullRaceList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNull(result);
		PowerMock.verifyAll();
	}

	/**
	 * prepares List RaceResultTO for given number of calls SqlRowSet
	 * 
	 * @param rowSet
	 * @param numberOfResults
	 * @return
	 */
	private List<RaceResultTO> prepareForGetRaceResultTOListFromSqlRowSet(SqlRowSet rowSet, int numberOfResults) {
		List<RaceResultTO> list = new ArrayList<>();
		while (numberOfResults > 0) {
			RaceResultTO to = new RaceResultTO();
			EasyMock.expect(rowSet.next()).andReturn(true);
			EasyMock.expect(rowSet.getInt(TORequests.POSITION)).andReturn(numberOfResults);
			to.setAbsPosition(numberOfResults);
			to.setPositionInGroup(numberOfResults);
			EasyMock.expect(rowSet.getString(TORequests.CLUB)).andReturn(CLUB + numberOfResults);
			to.setClub(CLUB + numberOfResults);
			EasyMock.expect(rowSet.getString(TORequests.NAME)).andReturn(NAME + numberOfResults);
			to.setName(NAME + numberOfResults);
			EasyMock.expect(rowSet.getString(TORequests.GENDER)).andReturn(GENDER);
			to.setGender(GENDER);
			to.setTime(VizUtils.convertNumberOfSecondsToTimeRepresentation(numberOfResults));
			EasyMock.expect(rowSet.getInt(TORequests.TIME)).andReturn(numberOfResults--);
			list.add(to);
		}
		EasyMock.expect(rowSet.next()).andReturn(false);
		return list;
	}

	/**
	 * prepares List RaceInfoTO for given list of dates
	 * 
	 * @param rowSet
	 * @param dates
	 *            - list of dates
	 * @param startId
	 *            - start id for RaceInfoTO
	 * @return List<RaceInfoTO>
	 */
	private List<RaceInfoTO> prepareForGetRaceInfoTOListFromSqlRowSetForGivenDates(SqlRowSet rowSet, List<Date> dates,
			long startId) {
		List<RaceInfoTO> list = new ArrayList<>();
		for (Date d : dates) {
			RaceInfoTO to = new RaceInfoTO();
			EasyMock.expect(rowSet.next()).andReturn(true);
			EasyMock.expect(rowSet.getLong(TORequests.RACE_ID)).andReturn(startId);
			to.setRaceId(startId++);
			EasyMock.expect(rowSet.getDate(TORequests.RACE_DATE)).andReturn(d);
			EasyMock.expect(rowSet.getString(TORequests.PARK_NAME)).andReturn(PARK);
			to.setRaceName(VizUtils.convertSqlDateToFrontEndRepresentation(d) + " " + PARK);
			list.add(to);
		}
		EasyMock.expect(rowSet.next()).andReturn(false);
		return list;
	}
	
	/**
	 * test for {@linkplain DataProvider#getRunnerResults(long)}
	 */
	@Test
	public void getRunnerResultsTest() {
		int absPos = 2;
		long clubId = 100;
		String clubLogo = "logo";
		String clubName = "name";
		String parkName = "park";
		int posInGr = 1;
		Date date = Date.valueOf("2000-01-01");
		long raceId = 333;
		int time = 300;
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.runnerResultInfoListRequest(1))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		EasyMock.expect(rowSet.next()).andReturn(true);
		EasyMock.expect(rowSet.getInt(TORequests.ABSPOSITION)).andReturn(absPos);
		EasyMock.expect(rowSet.getLong(TORequests.CLUBID)).andReturn(clubId);
		EasyMock.expect(rowSet.getString(TORequests.CLUBLOGO)).andReturn(clubLogo);
		EasyMock.expect(rowSet.getString(TORequests.CLUBNAME)).andReturn(clubName);
		EasyMock.expect(rowSet.getString(TORequests.PARK_NAME)).andReturn(parkName);
		EasyMock.expect(rowSet.getInt(TORequests.POSITIONINGENDERGROUP)).andReturn(posInGr);
		EasyMock.expect(rowSet.getDate(TORequests.RACE_DATE)).andReturn(date);
		EasyMock.expect(rowSet.getLong(TORequests.RACE_ID)).andReturn(raceId);
		EasyMock.expect(rowSet.getInt(TORequests.TIME)).andReturn(time);
		EasyMock.expect(rowSet.next()).andReturn(false);
		PowerMock.replayAll();
		List<RunnerResultTO> list = null;
		try {
			list = provider.getRunnerResults(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNotNull(list);
		assertTrue(list.size() == 1);
		RunnerResultTO to = list.get(0);
		assertTrue(to.getAbsPosition() == absPos);
		assertTrue(to.getClubId() == clubId);
		assertEquals(clubLogo, to.getClubLogo());
		assertEquals(clubName, to.getClubName());
		assertEquals(parkName, to.getParkName());
		assertTrue(to.getPositionInGenderGroup() == posInGr);
		assertEquals(date, to.getRaceDate());
		assertTrue(to.getTime() == time);
	}

	/**
	 * test for {@linkplain DataProvider#getRunnerResults(long)} with exception
	 */
	@Test
	public void getRunnerResultsTestWithException() {
		org.springframework.dao.DataAccessException exception = PowerMock
				.createMock(org.springframework.dao.DataAccessException.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.runnerResultInfoListRequest(1))).andThrow(exception);
		EasyMock.expect(exception.getCause()).andReturn(new RuntimeException());
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		PowerMock.replayAll();
		List<RunnerResultTO> list = null;
		try {
			list = provider.getRunnerResults(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNull(list);
	}
	
	/**
	 * test for {@link DataProvider#getRunnerTO(long)} with successful scenario  
	 */
	@Test
	public void getRunnerTOTest(){
		String avatar = "avatar";
		String city = "city";
		Long clubId = 1L;
		String clubName = "club";
		Date dateOfBirth = Date.valueOf("2000-01-01");
		String firstName = "firstName";
		String lastName = "lastName";
		String gender = "F";
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.runnerTORequest(33))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		EasyMock.expect(rowSet.next()).andReturn(true);
		EasyMock.expect(rowSet.getString(TORequests.AVATAR)).andReturn(avatar);
		EasyMock.expect(rowSet.getString(TORequests.CITY)).andReturn(city);
		EasyMock.expect(rowSet.getLong(TORequests.CLUBID)).andReturn(clubId);
		EasyMock.expect(rowSet.getString(TORequests.CLUBNAME)).andReturn(clubName);
		EasyMock.expect(rowSet.getDate(TORequests.DATEOFBIRTH)).andReturn(dateOfBirth);
		EasyMock.expect(rowSet.getString(TORequests.FIRSTNAME)).andReturn(firstName);
		EasyMock.expect(rowSet.getString(TORequests.GENDER)).andReturn(gender);
		EasyMock.expect(rowSet.getString(TORequests.LASTNAME)).andReturn(lastName);
		PowerMock.replayAll();
		RunnerTO to = null;
		try {
			to = provider.getRunnerTO(33);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNotNull(to);
		assertEquals(avatar,to.getAvatar());
		assertEquals(city,to.getCity());
		assertEquals(clubId,to.getClubId());
		assertEquals(dateOfBirth,to.getDateOfBirth());
		assertEquals(firstName,to.getFirstName());
		assertEquals(lastName,to.getLastName());
		assertEquals(Gender.FEMALE,to.getGender());
	}
	
	/**
	 * test for {@link DataProvider#getRunnerTO(long)} for empty ResultSet
	 */
	@Test
	public void runnerTOwithEmptyResultSetTest(){
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.runnerTORequest(33))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		EasyMock.expect(rowSet.next()).andReturn(false);
		PowerMock.replayAll();
		RunnerTO to = null;
		try {
			to = provider.getRunnerTO(33);
		} catch (SQLException e) {
			assertEquals("Empty resultset for id:33",e.getMessage());
		}
		PowerMock.verifyAll();
		assertNull(to);
	}
	
	/**
	 * test for {@link DataProvider#getRunnerTO(long)} with exception  
	 */
	@Test
	public void runnerTOwithExceptionTest(){
		org.springframework.dao.DataAccessException exception = PowerMock
				.createMock(org.springframework.dao.DataAccessException.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.runnerTORequest(33))).andThrow(exception);
		EasyMock.expect(exception.getCause()).andReturn(new RuntimeException());
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		PowerMock.replayAll();
		RunnerTO to = null;
		try {
			to = provider.getRunnerTO(33);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNull(to);
	}
	
	/**
	 * test for {@link DataProvider#getClubTO(long)} with successful scenario
	 */
	@Test
	public void getClubTOTest() {
		String name = "name";
		String city = "city";
		String logo = "logo";
		String email = "email";
		String phone = "phone";
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.clubTORequest(33))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		EasyMock.expect(rowSet.next()).andReturn(true);
		EasyMock.expect(rowSet.getString(TORequests.NAME)).andReturn(name);
		EasyMock.expect(rowSet.getString(TORequests.CITY)).andReturn(city);
		EasyMock.expect(rowSet.getString(TORequests.CLUBLOGO)).andReturn(logo);
		EasyMock.expect(rowSet.getString(TORequests.EMAIL)).andReturn(email);
		EasyMock.expect(rowSet.getString(TORequests.PHONE)).andReturn(phone);
		PowerMock.replayAll();
		ClubTO to = null;
		try {
			to = provider.getClubTO(33);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNotNull(to);
		assertEquals(city, to.getCity());
		assertEquals(name, to.getName());
		assertEquals(logo, to.getClubLogo());
		assertEquals(email, to.getEmail());
		assertEquals(phone, to.getPhone());
	}

	/**
	 * test for {@link DataProvider#getClubTO(long)} for empty ResultSet
	 */
	@Test
	public void clubTOwithEmptyResultSetTest() {
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.clubTORequest(33))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		EasyMock.expect(rowSet.next()).andReturn(false);
		PowerMock.replayAll();
		ClubTO to = null;
		try {
			to = provider.getClubTO(33);
		} catch (SQLException e) {
			assertEquals("Empty resultset for id:33", e.getMessage());
		}
		PowerMock.verifyAll();
		assertNull(to);
	}

	/**
	 * test for {@link DataProvider#getClubTO(long)} with exception
	 */
	@Test
	public void clubTOwithExceptionTest() {
		org.springframework.dao.DataAccessException exception = PowerMock
				.createMock(org.springframework.dao.DataAccessException.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.clubTORequest(33))).andThrow(exception);
		EasyMock.expect(exception.getCause()).andReturn(new RuntimeException());
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		PowerMock.replayAll();
		ClubTO to = null;
		try {
			to = provider.getClubTO(33);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNull(to);
	}

	/**
	 * test for {@link DataProvider#getRaceClubResultTOList(long)} with
	 * successful scenario
	 */
	@Test
	public void getRaceClubResultTOListTest() {

		int absPos = 5;
		int posInGen = 3;
		Date date = Date.valueOf("2020-01-01");
		String park = "park";
		long raceId = 11;
		String firstName = "firstName";
		String lastName = "lastName";
		long runnerId = 333;
		int time = 150;

		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.raceClubResultTORequest(100))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		EasyMock.expect(rowSet.next()).andReturn(true);
		EasyMock.expect(rowSet.getInt(TORequests.ABSPOSITION)).andReturn(absPos);
		EasyMock.expect(rowSet.getInt(TORequests.POSITIONINGENDERGROUP)).andReturn(posInGen);
		EasyMock.expect(rowSet.getDate(TORequests.RACE_DATE)).andReturn(date);
		EasyMock.expect(rowSet.getString(TORequests.PARK_NAME)).andReturn(park);
		EasyMock.expect(rowSet.getLong(TORequests.RACE_ID)).andReturn(raceId);
		EasyMock.expect(rowSet.getString(TORequests.FIRSTNAME)).andReturn(firstName);
		EasyMock.expect(rowSet.getString(TORequests.LASTNAME)).andReturn(lastName);
		EasyMock.expect(rowSet.getLong(TORequests.RUNNERID)).andReturn(runnerId);
		EasyMock.expect(rowSet.getInt(TORequests.TIME)).andReturn(time);
		EasyMock.expect(rowSet.next()).andReturn(false);
		PowerMock.replayAll();
		List<RaceClubResultTO> list = null;

		try {
			list = provider.getRaceClubResultTOList(100);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNotNull(list);
		assertTrue(list.size() == 1);
		RaceClubResultTO to = list.get(0);
		assertTrue(to.getAbsPosition() == absPos);
		assertTrue(to.getPositionInGenderGroup() == posInGen);
		assertEquals(date, to.getDate());
		assertEquals(park, to.getParkName());
		assertEquals(firstName, to.getRunnerFirstName());
		assertEquals(lastName, to.getRunnerLastName());
		assertTrue(to.getRaceId() == raceId);
		assertTrue(to.getRunnerId() == runnerId);
		assertTrue(to.getTimeInSeconds() == time);
	}

	/**
	 * test for {@link DataProvider#getClubTO(long)} for empty ResultSet
	 */
	@Test
	public void getRaceClubResultTOListwithEmptyResultSetTest() {
		SqlRowSet rowSet = PowerMock.createMock(org.springframework.jdbc.support.rowset.SqlRowSet.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.raceClubResultTORequest(33))).andReturn(rowSet);
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		EasyMock.expect(rowSet.next()).andReturn(false);
		PowerMock.replayAll();
		List<RaceClubResultTO> list = null;
		try {
			list = provider.getRaceClubResultTOList(33);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNotNull(list);
		assertTrue(list.size() == 0);
	}

	/**
	 * test for {@link DataProvider#getClubTO(long)} with exception
	 */
	@Test
	public void getRaceClubResultTOListwithExceptionTest() {
		org.springframework.dao.DataAccessException exception = PowerMock
				.createMock(org.springframework.dao.DataAccessException.class);
		EasyMock.expect(jdbcTemplate.queryForRowSet(TORequests.raceClubResultTORequest(133))).andThrow(exception);
		EasyMock.expect(exception.getCause()).andReturn(new RuntimeException());
		DataProvider provider = new DataProvider();
		Whitebox.setInternalState(provider, "jdbcTemplate", jdbcTemplate);
		PowerMock.replayAll();
		List<RaceClubResultTO> list = null;
		try {
			list = provider.getRaceClubResultTOList(133);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNull(list);
	}
}
