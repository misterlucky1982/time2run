package by.irun.service.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.irun.dao.IDataProvider;
import by.irun.dao.IDomainEntityProvider;
import by.irun.domain.Gender;
import by.irun.domain.to.ClubRunnerTO;
import by.irun.domain.to.ClubTO;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.locale.AppLocales;
import by.irun.locale.Internationalizer;
import by.irun.locale.Translator;
import by.irun.service.IDataService;
import by.irun.service.ServiceUtils;
import by.irun.viz.to.ClubInfoTO;
import by.irun.viz.to.ClubRaceResultInfoTO;
import by.irun.viz.to.ClubRunnerInfoTO;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RaceResultTO;
import by.irun.viz.to.RunnerInfoTO;
import by.irun.viz.to.RunnerResultInfoTO;
import by.irun.viz.utils.VizUtils;
/**
 * 
 * @author A.Dubovik
 */
@Service
public class DataService implements IDataService{

	@SuppressWarnings("unused")
	@Autowired
	private IDomainEntityProvider entityProvider;
	
	@Autowired
	private IDataProvider dataProvider;
	
	/* (non-Javadoc)
	 * @see by.irun.service.IDataService#getRaceResult(long raceId)
	 */
	@Override
	public List<RaceResultTO> getRaceResult(long raceId) {
		List<RaceResultTO>list = null;
		try{
			list = dataProvider.getRaceResult(raceId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list!=null?list:Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDataService#getFullRaceList()
	 */
	@Override
	public List<RaceInfoTO> getFullRaceList() {
		List<RaceInfoTO>list = null;
		try{
			list = dataProvider.getFullRaceList();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list!=null?list:Collections.emptyList();
	}

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
			runnerTO = this.dataProvider.getRunnerTO(runnerId);
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
			resultList = this.dataProvider.getRunnerResults(runnerId);
		} catch (SQLException e) {
			e.printStackTrace();
			resultList = Collections.emptyList();
		}
		to.setNumberOfRaces(resultList.size());
		List<RunnerResultInfoTO> listTO = new ArrayList<>();
		for(RunnerResultTO resTO:resultList)listTO.add(VizUtils.convert(resTO, locale));
		to.setRacesList(listTO);
		return to;
	}

	@Override
	public ClubInfoTO getClubInfoTO(long clubId, Locale locale) {
		ClubTO clubTO = null;
		List<ClubRunnerTO> clubRunnerTOList = null;
		List<RaceClubResultTO> raceClubResultTOList = null;
		try {
			clubTO = dataProvider.getClubTO(clubId);
			clubRunnerTOList = dataProvider.getCurrentClubRunnerTOListForClub(clubId);
			raceClubResultTOList = dataProvider.getRaceClubResultTOList(clubId);
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
				? VizUtils.buildRaceName(firstRaceResult.getParkName(), firstRaceResult.getDate(), locale)
				: Internationalizer.translate(Translator.KEY_UNKNOWN));
		clubInfoTO.setParkBestResults(ServiceUtils.getParkBestResultInfoTOList(raceClubResultTOList, locale));
		clubInfoTO.setRaceResults(ServiceUtils.generateSortedClubRunnerResultList(raceClubResultTOList, locale));
		return clubInfoTO;
	}

}
