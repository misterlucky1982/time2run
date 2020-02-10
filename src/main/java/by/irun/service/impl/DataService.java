package by.irun.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.irun.dao.IDataProvider;
import by.irun.dao.IDomainEntityProvider;
import by.irun.domain.Runner;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.locale.AppLocales;
import by.irun.locale.Internationalizer;
import by.irun.service.IDataService;
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
		to.setCity(runnerTO.getCity());
		to.setClubLink(null);//TODO
		to.setClubName(runnerTO.getClubName());
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

}
