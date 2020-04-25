package by.irun.persistance.proxi;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.easymock.EasyMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.reflect.Whitebox;

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
import by.irun.domain.to.RunnerRaceResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.persistance.dao.CRUDHandler;
import by.irun.persistance.dao.IDataProvider;

@RunWith(PowerMockRunner.class)
public class RepositoryConnectorTest {
	
	private RepositoryConnector proxi;
	
	@Mock
	private IDataProvider dataProvider;
	
	@Mock
	private CRUDHandler crudHandler;
	
	@Mock
	private Map<String,Object> COMMONCACHE;
	
	@Mock
	private Map<Object,RaceExtendedTO> RACEEXTENDEDTOMAP;
	
	@Mock
	private Map<Long,List<RunnerRaceResultTO>> MENRACERESULTMAP;
	
	@Mock
	private Map<Long,List<RunnerRaceResultTO>> WOMENRACERESULTMAP;
	
	@Before
	public void init(){
		proxi = new RepositoryConnector();
		Whitebox.setInternalState(proxi, "crudHandler", crudHandler);
		Whitebox.setInternalState(proxi, "dataProvider", dataProvider);
		Whitebox.setInternalState(RepositoryConnector.class, "COMMONCACHE", COMMONCACHE);
		Whitebox.setInternalState(RepositoryConnector.class, "RACEEXTENDEDTOMAP", RACEEXTENDEDTOMAP);
		Whitebox.setInternalState(RepositoryConnector.class, "MENRACERESULTMAP", MENRACERESULTMAP);
		Whitebox.setInternalState(RepositoryConnector.class, "WOMENRACERESULTMAP", WOMENRACERESULTMAP);
	}

	@Test
	public void addClubWithSuccessTest() throws SQLException{
		Club club = PowerMock.createMock(Club.class);
		EasyMock.expect(crudHandler.add(club)).andReturn(1L);
		PowerMock.replayAll();
		Long id = proxi.addClub(club);
		PowerMock.verifyAll();
		assertEquals(Long.valueOf(1),id);
	}
	
	@Test
	public void addClubWithExceptionTest() throws SQLException{
		Club club = PowerMock.createMock(Club.class);
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.add(club)).andThrow(ex);
		PowerMock.replayAll();
		try{
			proxi.addClub(club);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateClubWithSuccessTest() throws SQLException{
		Club cl = PowerMock.createMock(Club.class);
		EasyMock.expect(crudHandler.update(cl)).andReturn(true);
		PowerMock.replayAll();
		assertTrue(proxi.updateClub(cl));
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateClubWithExceptionTest() throws SQLException{
		Club cl = PowerMock.createMock(Club.class);
		Boolean result = null;
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.update(cl)).andThrow(ex);
		PowerMock.replayAll();
		try{
			result = proxi.updateClub(cl);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
		assertNull(result);
	}
	
	@Test
	public void addParkWithSuccessTest() throws SQLException{
		Park park = PowerMock.createMock(Park.class);
		EasyMock.expect(COMMONCACHE.remove(RepositoryConnector.PARKLIST)).andReturn(EasyMock.anyBoolean());
		EasyMock.expect(crudHandler.add(park)).andReturn(1L);
		PowerMock.replayAll();
		Long id = proxi.addPark(park);
		PowerMock.verifyAll();
		assertEquals(Long.valueOf(1),id);
	}
	
	@Test
	public void addParkWithExceptionTest() throws SQLException{
		Park park = PowerMock.createMock(Park.class);
		SQLException ex = new SQLException();
		EasyMock.expect(COMMONCACHE.remove(RepositoryConnector.PARKLIST)).andReturn(EasyMock.anyBoolean());
		EasyMock.expect(crudHandler.add(park)).andThrow(ex);
		PowerMock.replayAll();
		try{
			proxi.addPark(park);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateParkWithSuccessTest() throws SQLException{
		Park p = PowerMock.createMock(Park.class);
		EasyMock.expect(COMMONCACHE.remove(RepositoryConnector.PARKLIST)).andReturn(EasyMock.anyBoolean());
		EasyMock.expect(crudHandler.update(p)).andReturn(true);
		PowerMock.replayAll();
		assertTrue(proxi.updatePark(p));
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateParkWithExceptionTest() throws SQLException{
		Park p = PowerMock.createMock(Park.class);
		EasyMock.expect(COMMONCACHE.remove(RepositoryConnector.PARKLIST)).andReturn(EasyMock.anyBoolean());
		Boolean result = null;
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.update(p)).andThrow(ex);
		PowerMock.replayAll();
		try{
			result = proxi.updatePark(p);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
		assertNull(result);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void cachedParkListTest() throws SQLException{
		Whitebox.setInternalState(RepositoryConnector.class, "COMMONCACHE", new WeakHashMap<>());
		@SuppressWarnings("rawtypes")
		List list = PowerMock.createMock(List.class);
		EasyMock.expect(crudHandler.getEntityList(Park.class)).andReturn(list);
		PowerMock.replayAll();
		List<Park> list1 = proxi.getParkList();
		List<Park> list2 = proxi.getParkList();
		PowerMock.verifyAll();
		assertEquals(list,list1);
		assertEquals(list,list2);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void cachedParkListWithAddParkTest() throws SQLException{
		Whitebox.setInternalState(RepositoryConnector.class, "COMMONCACHE", new WeakHashMap<>());
		@SuppressWarnings("rawtypes")
		List list1 = PowerMock.createMock(List.class);
		@SuppressWarnings("rawtypes")
		List list2 = PowerMock.createMock(List.class);
		Park park = PowerMock.createMock(Park.class);
		EasyMock.expect(crudHandler.getEntityList(Park.class)).andReturn(list1);
		EasyMock.expect(crudHandler.add(park)).andReturn(EasyMock.anyLong());
		EasyMock.expect(crudHandler.getEntityList(Park.class)).andReturn(list2);
		PowerMock.replayAll();
		List<Park> result1 = proxi.getParkList();
		proxi.addPark(park);
		List<Park> result2 = proxi.getParkList();
		PowerMock.verifyAll();
		assertEquals(list1,result1);
		assertEquals(list2,result2);
	}
	
	@Test
	public void addPictureWithSuccessTest() throws SQLException{
		Picture pic = PowerMock.createMock(Picture.class);
		EasyMock.expect(crudHandler.add(pic)).andReturn(1L);
		PowerMock.replayAll();
		Long id = proxi.addPicture(pic);
		PowerMock.verifyAll();
		assertEquals(Long.valueOf(1),id);
	}
	
	@Test
	public void addPictureWithExceptionTest() throws SQLException{
		Picture pic = PowerMock.createMock(Picture.class);
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.add(pic)).andThrow(ex);
		PowerMock.replayAll();
		try{
			proxi.addPicture(pic);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
	}
	
	@Test
	public void deletePictureWithSuccessTest() throws SQLException{
		Picture pic = PowerMock.createMock(Picture.class);
		EasyMock.expect(crudHandler.delete(pic)).andReturn(true);
		PowerMock.replayAll();
		assertTrue(proxi.deletePicture(pic));
		PowerMock.verifyAll();
	}
	
	@Test
	public void deletePictureWithExceptionTest() throws SQLException{
		Boolean result = null;
		Picture pic = PowerMock.createMock(Picture.class);
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.delete(pic)).andThrow(ex);
		PowerMock.replayAll();
		try{
			result = proxi.deletePicture(pic);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
		assertNull(result);
	}
	
	@Test
	public void addRaceWithSuccessTest() throws SQLException{
		Race race = PowerMock.createMock(Race.class);
		EasyMock.expect(COMMONCACHE.remove(RepositoryConnector.FULLRACETOLIST)).andReturn(EasyMock.anyObject());
		EasyMock.expect(RACEEXTENDEDTOMAP.remove(RepositoryConnector.EXTENDEDRACETOFORLASTRACE)).andReturn(EasyMock.anyObject());
		EasyMock.expect(crudHandler.add(race)).andReturn(1L);
		PowerMock.replayAll();
		Long id = proxi.addRace(race);
		PowerMock.verifyAll();
		assertEquals(Long.valueOf(1),id);
	}
	
	@Test
	public void addRaceWithExceptionTest() throws SQLException{
		Race race = PowerMock.createMock(Race.class);
		SQLException ex = new SQLException();
		EasyMock.expect(COMMONCACHE.remove(RepositoryConnector.FULLRACETOLIST)).andReturn(EasyMock.anyObject());
		EasyMock.expect(RACEEXTENDEDTOMAP.remove(RepositoryConnector.EXTENDEDRACETOFORLASTRACE)).andReturn(EasyMock.anyObject());
		EasyMock.expect(crudHandler.add(race)).andThrow(ex);
		PowerMock.replayAll();
		try{
			proxi.addRace(race);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
	}
	
	@Test
	public void addResultWithSuccessTest() throws SQLException{
		Result res = PowerMock.createMock(Result.class);
		EasyMock.expect(crudHandler.add(res)).andReturn(1L);
		PowerMock.replayAll();
		Long id = proxi.addResult(res);
		PowerMock.verifyAll();
		assertEquals(Long.valueOf(1),id);
	}
	
	@Test
	public void addResultWithExceptionTest() throws SQLException{
		Result res = PowerMock.createMock(Result.class);
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.add(res)).andThrow(ex);
		PowerMock.replayAll();
		try{
			proxi.addResult(res);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
	}
	
	@Test
	public void addRunnerWithSuccessTest() throws SQLException{
		Runner rn = PowerMock.createMock(Runner.class);
		EasyMock.expect(crudHandler.add(rn)).andReturn(1L);
		PowerMock.replayAll();
		Long id = proxi.addRunner(rn);
		PowerMock.verifyAll();
		assertEquals(Long.valueOf(1),id);
	}
	
	@Test
	public void addRunnerWithExceptionTest() throws SQLException{
		Runner rn = PowerMock.createMock(Runner.class);
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.add(rn)).andThrow(ex);
		PowerMock.replayAll();
		try{
			proxi.addRunner(rn);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateRunnerWithSuccessTest() throws SQLException{
		Runner rn = PowerMock.createMock(Runner.class);
		EasyMock.expect(crudHandler.update(rn)).andReturn(true);
		PowerMock.replayAll();
		assertTrue(proxi.updateRunner(rn));
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateRunnerWithExceptionTest() throws SQLException{
		Runner rn = PowerMock.createMock(Runner.class);
		Boolean result = null;
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.update(rn)).andThrow(ex);
		PowerMock.replayAll();
		try{
			result = proxi.updateRunner(rn);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
		assertNull(result);
	}
	
	@Test
	public void addUserWithSuccessTest() throws SQLException{
		User u = PowerMock.createMock(User.class);
		EasyMock.expect(crudHandler.add(u)).andReturn(1L);
		PowerMock.replayAll();
		Long id = proxi.addUser(u);
		PowerMock.verifyAll();
		assertEquals(Long.valueOf(1),id);
	}
	
	@Test
	public void addUserWithExceptionTest() throws SQLException{
		User u = PowerMock.createMock(User.class);
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.add(u)).andThrow(ex);
		PowerMock.replayAll();
		try{
			proxi.addUser(u);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateUserWithSuccessTest() throws SQLException{
		User u = PowerMock.createMock(User.class);
		EasyMock.expect(crudHandler.update(u)).andReturn(true);
		PowerMock.replayAll();
		assertTrue(proxi.updateUser(u));
		PowerMock.verifyAll();
	}
	
	@Test
	public void updateUserWithExceptionTest() throws SQLException{
		User u = PowerMock.createMock(User.class);
		Boolean result = null;
		SQLException ex = new SQLException();
		EasyMock.expect(crudHandler.update(u)).andThrow(ex);
		PowerMock.replayAll();
		try{
			result = proxi.updateUser(u);
		}catch(SQLException e){
			assertEquals(ex,e);
		}
		PowerMock.verifyAll();
		assertNull(result);
	}
	
	@Test
	public void getClubByIdTest() throws SQLException{
		Club vl = PowerMock.createMock(Club.class);
			EasyMock.expect(crudHandler.getEntityById(Club.class, 1L)).andReturn(vl);
		PowerMock.replayAll();
		assertEquals(vl,proxi.getClubById(1L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getPictureByIdTest() throws SQLException{
		Picture vl = PowerMock.createMock(Picture.class);
			EasyMock.expect(crudHandler.getEntityById(Picture.class, 1L)).andReturn(vl);
		PowerMock.replayAll();
		assertEquals(vl,proxi.getPictureById(1L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRunnerByIdTest() throws SQLException{
		Runner vl = PowerMock.createMock(Runner.class);
			EasyMock.expect(crudHandler.getEntityById(Runner.class, 1L)).andReturn(vl);
		PowerMock.replayAll();
		assertEquals(vl,proxi.getRunnerById(1L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getUserByIdTest() throws SQLException{
		User vl = PowerMock.createMock(User.class);
			EasyMock.expect(crudHandler.getEntityById(User.class, 1L)).andReturn(vl);
		PowerMock.replayAll();
		assertEquals(vl,proxi.getUserById(1L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getParkByIdTest() throws SQLException{
		Park vl = PowerMock.createMock(Park.class);
			EasyMock.expect(crudHandler.getEntityById(Park.class, 1L)).andReturn(vl);
		PowerMock.replayAll();
		assertEquals(vl,proxi.getParkById(1L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getClubTOTest() throws SQLException{
		ClubTO to = PowerMock.createMock(ClubTO.class);
		EasyMock.expect(dataProvider.getClubTO(1L)).andReturn(to);
		PowerMock.replayAll();
		assertEquals(to,dataProvider.getClubTO(1L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getCurrentClubRunnerTOListForClubTest() throws SQLException{
		@SuppressWarnings("unchecked")
		List<ClubRunnerTO>list = PowerMock.createMock(List.class);
		EasyMock.expect(dataProvider.getCurrentClubRunnerTOListForClub(1L)).andReturn(list);
		PowerMock.replayAll();
		assertEquals(list,proxi.getCurrentClubRunnerTOListForClub(1L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRunnerTOTest() throws SQLException{
		RunnerTO to = PowerMock.createMock(RunnerTO.class);
		EasyMock.expect(dataProvider.getRunnerTO(3L)).andReturn(to);
		PowerMock.replayAll();
		assertEquals(to,proxi.getRunnerTO(3L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRaceClubResultTOTest() throws SQLException{
		@SuppressWarnings("unchecked")
		List<RaceClubResultTO>list = PowerMock.createMock(List.class);
		EasyMock.expect(dataProvider.getRaceClubResultTOList(33L)).andReturn(list);
		PowerMock.replayAll();
		assertEquals(list,proxi.getRaceClubResultTOList(33L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRunnerResultsTest() throws SQLException{
		@SuppressWarnings("unchecked")
		List<RunnerResultTO> list = PowerMock.createMock(List.class);
		EasyMock.expect(dataProvider.getRunnerResults(2L)).andReturn(list);
		PowerMock.replayAll();
		assertEquals(list,proxi.getRunnerResults(2L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRaceExtendedTOForLastRaceWithCachedTOTest() throws SQLException{
		RaceExtendedTO to = PowerMock.createMock(RaceExtendedTO.class);
		EasyMock.expect(RACEEXTENDEDTOMAP.get(RepositoryConnector.EXTENDEDRACETOFORLASTRACE)).andReturn(to);
		PowerMock.replayAll();
		assertEquals(to,proxi.getRaceExtendedTOForLastRace());
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRaceExtendedTOForLastRaceWithNoCachedTOTest() throws SQLException{
		RaceExtendedTO to = PowerMock.createMock(RaceExtendedTO.class);
		EasyMock.expect(RACEEXTENDEDTOMAP.get(RepositoryConnector.EXTENDEDRACETOFORLASTRACE)).andReturn(null);
		EasyMock.expect(dataProvider.getRaceExtendedTOForLastRace()).andReturn(to);
		EasyMock.expect(RACEEXTENDEDTOMAP.put(RepositoryConnector.EXTENDEDRACETOFORLASTRACE, to)).andReturn(to);
		PowerMock.replayAll();
		assertEquals(to,proxi.getRaceExtendedTOForLastRace());
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRaceExtendedTOForRaceIdWithCachedTOTest() throws SQLException{
		RaceExtendedTO to = PowerMock.createMock(RaceExtendedTO.class);
		EasyMock.expect(RACEEXTENDEDTOMAP.get(3L)).andReturn(to);
		PowerMock.replayAll();
		assertEquals(to,proxi.getRaceExtendedTOforRaceId(3L));
		PowerMock.verifyAll();
	}
	
	@Test
	public void getRaceExtendedTOForRaceIdWithNoCachedTOTest() throws SQLException{
		RaceExtendedTO to = PowerMock.createMock(RaceExtendedTO.class);
		EasyMock.expect(RACEEXTENDEDTOMAP.get(55L)).andReturn(null);
		EasyMock.expect(dataProvider.getRaceExtendedTOforRaceId(55L)).andReturn(to);
		EasyMock.expect(RACEEXTENDEDTOMAP.put(55L, to)).andReturn(to);
		PowerMock.replayAll();
		assertEquals(to,proxi.getRaceExtendedTOforRaceId(55L));
		PowerMock.verifyAll();
	}
	
}
