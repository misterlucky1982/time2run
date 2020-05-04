package by.irun.service.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.irun.domain.Gender;
import by.irun.domain.Park;
import by.irun.domain.to.ClubRunnerTO;
import by.irun.domain.to.ClubTO;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RaceExtendedTO;
import by.irun.domain.to.RaceTO;
import by.irun.domain.to.RunnerRaceResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.locale.AppLocales;
import by.irun.locale.Internationalizer;
import by.irun.locale.Translator;
import by.irun.persistance.dao.IGenericDAO;
import by.irun.service.IDataService;
import by.irun.service.ServiceUtils;
import by.irun.util.Link;
import by.irun.viz.to.ClubInfoTO;
import by.irun.viz.to.ClubRunnerInfoTO;
import by.irun.viz.to.racepage.RaceResultInfoTO;
import by.irun.viz.to.raceselectpage.RaceInfoVizTO;
import by.irun.viz.to.raceselectpage.RaceSelectPageViewTO;
import by.irun.viz.to.runnerpage.RunnerInfoTO;
import by.irun.viz.to.runnerpage.RunnerResultInfoTO;
import by.irun.viz.utils.JSUtils;
import by.irun.viz.utils.VizUtils;
/**
 * 
 * @author A.Dubovik
 */
@SuppressWarnings({ "deprecation" })
@Service
public class DataService implements IDataService{

	@Autowired
	private IGenericDAO repository;

	/* (non-Javadoc)
	 * @see by.irun.service.IDataService#getRunnerInfoTO(long runnerId)
	 */
	@Override
	public RunnerInfoTO getRunnerInfoTO(long runnerId) {
		return getRunnerInfoTO(runnerId,AppLocales.DEFAULT);
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDataService#getRunnerInfoTO(long runnerId, Locale locale)
	 */
	@Override
	public RunnerInfoTO getRunnerInfoTO(long runnerId, Locale locale) {
		RunnerTO runnerTO = null;
		try {
			runnerTO = this.repository.getRunnerTO(runnerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(runnerTO==null)return null;
		RunnerInfoTO to = new RunnerInfoTO();
		VizUtils.resolveAvatarPathForRunner(to, runnerTO, locale);
		to.setCity(VizUtils.resolveCity(runnerTO.getCity(), locale));
		to.setClubLink(VizUtils.resolveClubLink(runnerTO.getClubId()));
		to.setClubName(VizUtils.resolveClubName(runnerTO.getClubName(), locale));
		to.setDateOfBirth(Internationalizer.translate(runnerTO.getDateOfBirth(), locale));
		to.setName(runnerTO.getFirstName()+" "+runnerTO.getLastName());
		List<RunnerResultTO> resultList = null;
		try {
			resultList = this.repository.getRunnerResults(runnerId);
		} catch (SQLException e) {
			e.printStackTrace();
			resultList = Collections.emptyList();
		}
		to.setNumberOfRaces(resultList.size());
		List<RunnerResultInfoTO> listTO = new ArrayList<>();
		for(RunnerResultTO resTO:resultList)listTO.add(ServiceUtils.runnerResultInfoTOForRunnerPage(resTO, locale));
		to.setRacesList(listTO);
		return to;
	}

	@Override
	public ClubInfoTO getClubInfoTO(long clubId, Locale locale) {
		ClubTO clubTO = null;
		List<ClubRunnerTO> clubRunnerTOList = null;
		List<RaceClubResultTO> raceClubResultTOList = null;
		try {
			clubTO = repository.getClubTO(clubId);
			clubRunnerTOList = repository.getCurrentClubRunnerTOListForClub(clubId);
			raceClubResultTOList = repository.getRaceClubResultTOList(clubId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		ClubInfoTO clubInfoTO = new ClubInfoTO();
		clubInfoTO.setAmountOfRunners(clubRunnerTOList.size());
		clubInfoTO.setClubName(clubTO.getName());
		clubInfoTO.setEmail(clubTO.getEmail());
		clubInfoTO.setPhone(clubTO.getPhone());
		clubInfoTO.setCity(VizUtils.resolveCity(clubTO.getCity(), locale));
		clubInfoTO.setClubLogo(VizUtils.resolveClubLogo(clubTO.getClubLogo(), locale));
		List<ClubRunnerInfoTO> clubRunnerInfoTOList = new ArrayList<>(clubRunnerTOList.size());
		for (ClubRunnerTO crto : clubRunnerTOList) {
			ClubRunnerInfoTO clubRunnerInfoTO = new ClubRunnerInfoTO();
			clubRunnerInfoTO.setName(VizUtils.concatName(crto.getFirstName(), crto.getLastName()));
			clubRunnerInfoTO.setAvatarPath(
					VizUtils.getAvatarForAvatarPathAndGender(crto.getAvatarPath(), crto.getGender(), locale));
			// TODO link
			clubRunnerInfoTOList.add(clubRunnerInfoTO);
		}
		clubInfoTO.setCurrentRunners(clubRunnerInfoTOList);
		RaceClubResultTO firstRaceResult = raceClubResultTOList.stream()
				.min((r1, r2) -> r1.getDate().compareTo(r2.getDate())).get();
		clubInfoTO.setFirstRace(firstRaceResult != null
				? VizUtils.buildRaceName(firstRaceResult.getRaceName(), firstRaceResult.getParkName(), firstRaceResult.getDate(), locale)
				: Internationalizer.translate(Translator.KEY_UNKNOWN));
		clubInfoTO.setParkBestResults(ServiceUtils.getParkBestResultInfoTOList(raceClubResultTOList, locale));
		clubInfoTO.setRaceResults(ServiceUtils.generateSortedClubRunnerResultList(raceClubResultTOList, locale));
		return clubInfoTO;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDataService#getRaceResultInfoTO(long raceId, Locale locale)
	 */
	@Override
	public RaceResultInfoTO getRaceResultInfoTO(long raceId, Locale locale) {
		RaceTO raceTO = null;
		List<RunnerRaceResultTO> mensResult = null;
		List<RunnerRaceResultTO> womenResult = null;
		try {
			raceTO = repository.getRaceTOforRaceId(raceId);
			mensResult = repository.getMenRaceResultList(raceId);
			womenResult = repository.getWomenRaceResultList(raceId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		if (raceTO == null || mensResult == null || womenResult == null) {
			return null;
		} else {
			RaceResultInfoTO result = new RaceResultInfoTO();
			result.setRaceName(VizUtils.buildRaceName(raceTO.getRaceName(), raceTO.getParkName(), raceTO.getDate(), locale));
			result.setMenResult(new by.irun.util.List<>(ServiceUtils.resolveRunnerResultList(mensResult, locale, Gender.MALE)));
			result.setWomenResult(new by.irun.util.List<>(ServiceUtils.resolveRunnerResultList(womenResult, locale, Gender.FEMALE)));
			return result;
		}
	}

	@Override
	public RaceSelectPageViewTO getRaceSelectPageViewTOForLastRace(Locale locale) {
		RaceExtendedTO lastRace = null;
		List<Park> parkList = null;
		try {
			lastRace = repository.getRaceExtendedTOForLastRace();
			parkList = repository.getParkList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(lastRace==null||parkList==null){
			return null;
		}
		RaceSelectPageViewTO viewTO = new RaceSelectPageViewTO();
		RaceInfoVizTO raceVizTO = getRaceInfoVizTOFromRaceTO(lastRace, locale, true);
		viewTO.setRaceInfoVizTO(raceVizTO);
		viewTO.setParksMap(ServiceUtils.resolveParkKeysMap(parkList));
		return viewTO;
	}

	@Override
	public List<Link> getRaceLinkList(Date from, Date to, Long parkId, Locale locale) {
		List<RaceTO> raceTOs = null;
		try{
			raceTOs = repository.getRaceTOList(from, to, parkId);
		}catch(SQLException e){
			return Collections.emptyList();
		};
		List<Link>result = new ArrayList<>();
		for(RaceTO rto:raceTOs){
			Link link = new Link();
			link.setLinkName(VizUtils.buildRaceName(rto.getRaceName(), rto.getParkName(), rto.getDate(), locale));
			link.setLinkValue(JSUtils.clickToRaceInRaceList(rto.getRaceId()));
			result.add(link);
		}
		return result;
	}

	@Override
	public RaceInfoVizTO getRaceInfoVizTO(Long raceId, Locale locale) {
		RaceExtendedTO race = null;
		try{
			race = repository.getRaceExtendedTOforRaceId(raceId);
		}catch(SQLException e){
			return null;
		}
		return getRaceInfoVizTOFromRaceTO(race, locale, false);
	}
	
	private RaceInfoVizTO getRaceInfoVizTOFromRaceTO(RaceExtendedTO race, Locale locale, boolean lastEvent){
		RaceInfoVizTO raceVizTO = new RaceInfoVizTO();
		raceVizTO.setEventTitle(Internationalizer.translate((lastEvent?Translator.KEY_LAST_EVENT:Translator.KEY_SELECTED_RACE),locale)+Translator.DUALPOINT);
		raceVizTO.setRaceDate(Internationalizer.translate(race.getDate(),locale));
		raceVizTO.setParkName(race.getParkName());
		raceVizTO.setMenParticipant(Integer.toString(race.getMenParticupants()));
		raceVizTO.setWomenParticipant(Integer.toString(race.getWomenParticipants()));
		raceVizTO.setTotalAmountOfParticipant(Integer.toString(race.getMenParticupants()+race.getWomenParticipants()));
		raceVizTO.setLinkToRace(VizUtils.resolveRaceLink(race.getRaceId()));
		raceVizTO.setRaceName(VizUtils.buildRaceName(race.getRaceName(), race.getParkName(), race.getDate(), locale));;
		return raceVizTO;
	}
	
}
