package by.irun.persistance.daoimpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.irun.domain.Club;
import by.irun.domain.Gender;
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
import by.irun.persistance.dao.IGenericDAO;
import by.irun.persistance.dao.common.CRUDHandler;
import by.irun.persistance.dao.common.IDataProvider;

@Component
public class RepositoryConnector implements IGenericDAO{

	private static Map<String,Object> COMMONCACHE = new WeakHashMap<>();
	protected static final String PARKLIST = "parkList";
	protected static final String FULLRACETOLIST = "fullRaceTOList";
	
	private static Map<Object,RaceExtendedTO> RACEEXTENDEDTOMAP = new WeakHashMap<>();
	protected static final String EXTENDEDRACETOFORLASTRACE = "getRaceExtendedTOForLastRace";
	
	private static Map<Long,List<RunnerRaceResultTO>> MENRACERESULTMAP = new WeakHashMap<>();
	private static Map<Long,List<RunnerRaceResultTO>> WOMENRACERESULTMAP = new WeakHashMap<>();
	private static Map<Long,RaceTO> RACETOMAP = new WeakHashMap<>();
	
	@Autowired
	private CRUDHandler crudHandler;
	
	@Autowired
	private IDataProvider dataProvider;
	
	@Override
	public Long addClub(Club club) throws SQLException {
		return (Long) crudHandler.add(club);
	}

	@Override
	public boolean updateClub(Club club) throws SQLException {
		return crudHandler.update(club);
	}

	@Override
	public Long addPark(Park park) throws SQLException {
		synchronized(COMMONCACHE){
			COMMONCACHE.remove(PARKLIST);
		}
		return (Long) crudHandler.add(park);
	}

	@Override
	public boolean updatePark(Park park) throws SQLException {
		synchronized(COMMONCACHE){
			COMMONCACHE.remove(PARKLIST);
		}
		return crudHandler.update(park);
	}

	@Override
	public Long addPicture(Picture pic) throws SQLException {
		return (Long) crudHandler.add(pic);
	}

	@Override
	public boolean deletePicture(Picture pic) throws SQLException {
		return crudHandler.delete(pic);
	}

	@Override
	public Long addRace(Race race) throws SQLException {
		synchronized(COMMONCACHE){
			COMMONCACHE.remove(FULLRACETOLIST);
		}
		synchronized(RACEEXTENDEDTOMAP){
			RACEEXTENDEDTOMAP.remove(EXTENDEDRACETOFORLASTRACE);
		}
		return (Long) crudHandler.add(race);
	}

	@Override
	public Long addResult(Result result) throws SQLException {
		return (Long) crudHandler.add(result);
	}

	@Override
	public Long addRunner(Runner runner) throws SQLException {
		return (Long) crudHandler.add(runner);
	}

	@Override
	public boolean updateRunner(Runner runner) throws SQLException {
		return crudHandler.update(runner);
	}

	@Override
	public Long addUser(User user) throws SQLException {
		return (Long) crudHandler.add(user);
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		return crudHandler.update(user);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Park> getParkList() throws SQLException {
		List<Park>parks=(List<Park>) COMMONCACHE.get(PARKLIST);
		if(parks==null){
			synchronized(COMMONCACHE){
				parks = (List<Park>) crudHandler.getEntityList(Park.class);
				COMMONCACHE.put(PARKLIST, parks);
			}
		}
		return parks;
	}

	@Override
	public Club getClubById(long id) throws SQLException {
		return (Club) crudHandler.getEntityById(Club.class, id);
	}

	@Override
	public Park getParkById(long id) throws SQLException {
		return (Park) crudHandler.getEntityById(Park.class, id);
	}

	@Override
	public Picture getPictureById(long id) throws SQLException {
		return (Picture) crudHandler.getEntityById(Picture.class, id);
	}

	@Override
	public Runner getRunnerById(long id) throws SQLException {
		return (Runner) crudHandler.getEntityById(Runner.class, id);
	}

	@Override
	public User getUserById(long id) throws SQLException {
		return (User) crudHandler.getEntityById(User.class, id);
	}

	@Override
	public List<RunnerResultTO> getRunnerResults(long runnerId) throws SQLException {
		return dataProvider.getRunnerResults(runnerId);
	}

	@Override
	public RunnerTO getRunnerTO(long runnerId) throws SQLException {
		return dataProvider.getRunnerTO(runnerId);
	}

	@Override
	public ClubTO getClubTO(long clubId) throws SQLException {
		return dataProvider.getClubTO(clubId);
	}

	@Override
	public List<RaceClubResultTO> getRaceClubResultTOList(long clubId) throws SQLException {
		return dataProvider.getRaceClubResultTOList(clubId);
	}

	@Override
	public List<ClubRunnerTO> getCurrentClubRunnerTOListForClub(long clubId) throws SQLException {
		return dataProvider.getCurrentClubRunnerTOListForClub(clubId);
	}

	@Override
	public RaceExtendedTO getRaceExtendedTOforRaceId(long raceId) throws SQLException {
		RaceExtendedTO to = (RaceExtendedTO) RACEEXTENDEDTOMAP.get(raceId);
		if(to==null){
			to = dataProvider.getRaceExtendedTOforRaceId(raceId);
			synchronized(RACEEXTENDEDTOMAP){
				RACEEXTENDEDTOMAP.put(raceId, to);
			}
		}
		return to;
	}

	@Override
	public RaceExtendedTO getRaceExtendedTOForLastRace() throws SQLException {
		RaceExtendedTO to = (RaceExtendedTO) RACEEXTENDEDTOMAP.get(EXTENDEDRACETOFORLASTRACE);
		if(to==null){
			to = dataProvider.getRaceExtendedTOForLastRace();
			synchronized(RACEEXTENDEDTOMAP){
				RACEEXTENDEDTOMAP.put(EXTENDEDRACETOFORLASTRACE, to);
			}
		}
		return to;
	}

	@Override
	public RaceTO getRaceTOforRaceId(long raceId) throws SQLException {
		RaceTO to = RACETOMAP.get(raceId);
		if(to==null){
			to = dataProvider.getRaceTOforRaceId(raceId);
			synchronized(RACETOMAP){
				RACETOMAP.put(raceId, to);
			}
		}
		return to;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RaceTO> getRaceTOList(Date from, Date to, Long parkId) throws SQLException {
		List<RaceTO> list = null;
		if(from==null||to==null||parkId==null){
			list = (List<RaceTO>) COMMONCACHE.get(FULLRACETOLIST);
			if(list==null){
				list = dataProvider.getRaceTOList(from, to, parkId);
				synchronized(COMMONCACHE){
					COMMONCACHE.put(FULLRACETOLIST, list);
				}
			}
		}else list = dataProvider.getRaceTOList(from, to, parkId);
		return list;
	}

	@Override
	public List<RunnerRaceResultTO> getMenRaceResultList(long raceId) throws SQLException {
		List<RunnerRaceResultTO> list = MENRACERESULTMAP.get(raceId);
		if(list==null){
			list = dataProvider.getRunnerRaceResultList(raceId, Gender.MALE);
			synchronized(MENRACERESULTMAP){
				MENRACERESULTMAP.put(raceId, list);
			}
		}
		return list;
	}

	@Override
	public List<RunnerRaceResultTO> getWomenRaceResultList(long raceId) throws SQLException {
		List<RunnerRaceResultTO> list = WOMENRACERESULTMAP.get(raceId);
		if(list==null){
			list = dataProvider.getRunnerRaceResultList(raceId, Gender.FEMALE);
			synchronized(WOMENRACERESULTMAP){
				WOMENRACERESULTMAP.put(raceId, list);
			}
		}
		return list;
	}

	

	
}
