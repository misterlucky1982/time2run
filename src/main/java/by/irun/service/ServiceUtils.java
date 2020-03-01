package by.irun.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import by.irun.domain.Gender;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.locale.Internationalizer;
import by.irun.locale.Translator;
import by.irun.viz.to.ClubRunnerResultInfoTO;
import by.irun.viz.to.ExtendedInfoTOList;
import by.irun.viz.to.NamedInfoTOList;
import by.irun.viz.utils.VizUtils;

/**
 * provides utility methods for service`s components
 * 
 * @author A.Dubovik
 *
 */
public class ServiceUtils {

	private ServiceUtils() {
	}

	/**
	 * Replaces best RaceClubResultTO for given Park for given Gender
	 * <p>
	 * if such presents or puts RaceClubResultTO if not
	 * 
	 * @param map
	 * @param to
	 */
	public static void checkBestResultsInPark(Map<String, Map<Gender, RaceClubResultTO>> map, RaceClubResultTO to) {
		if (map.get(to.getParkName()) == null) {
			Map<Gender, RaceClubResultTO> genderMap = new HashMap<>();
			genderMap.put(to.getGender(), to);
			map.put(to.getParkName(), genderMap);
		} else {
			if (map.get(to.getParkName()).get(to.getGender()) == null) {
				map.get(to.getParkName()).put(to.getGender(), to);
			} else {
				if (map.get(to.getParkName()).get(to.getGender()).getTimeInSeconds() > to.getTimeInSeconds()) {
					map.get(to.getParkName()).put(to.getGender(), to);
				}
			}
		}
	}

	/**
	 * Provides TreeSet which formed by list
	 * <p>
	 * using following comparator:
	 * <p>
	 * firstly check the date of race (most earliest will be at begin)
	 * <p>
	 * secondly check the name of park (sorts by park name)
	 * <p>
	 * the last check - time (sorts by time increasing, i.e. most faster will be
	 * first)
	 * 
	 * @param list
	 * @return
	 */
	protected static TreeSet<RaceClubResultTO> getRaceClubResultTOSet(List<RaceClubResultTO> list) {
		TreeSet<RaceClubResultTO> raceClubResultTOSet = new TreeSet<>(new Comparator<RaceClubResultTO>() {
			@Override
			public int compare(RaceClubResultTO o1, RaceClubResultTO o2) {
				if (o1.getDate().equals(o2.getDate())) {
					if (o1.getParkName().equals(o2.getParkName())) {
						if (o1.getGender().equals(o2.getGender())) {
							return o1.getAbsPosition() > o2.getAbsPosition() ? 1 : -1;
						}
						return o1.getGender() == Gender.MALE ? -1 : 1;
					} else
						return o1.getParkName().compareTo(o2.getParkName());
				} else
					return o2.getDate().compareTo(o1.getDate());
			}
		});
		raceClubResultTOSet.addAll(list);
		return raceClubResultTOSet;
	}

	/**
	 * Produces structured list of results 
	 * <p>
	 * {@link by.irun.viz.to.ClubRunnerResultInfoTO}
	 * <p>
	 * based of given list of RaceClubResultTO
	 * <p>
	 * sorts by: races, gender, position
	 * @param list
	 * @param locale
	 * @return List
	 */
	public static List<ExtendedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> generateSortedClubRunnerResultList(
			List<RaceClubResultTO> list, Locale locale) {
		List<ExtendedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> result = new ArrayList<>();
		Iterator<RaceClubResultTO> it = getRaceClubResultTOSet(list).iterator();
		NamedInfoTOList<ClubRunnerResultInfoTO>currentList = null;
		Date date = null;
		String park = null;
		RaceClubResultTO to = null;
		boolean mensRes = true;
		ExtendedInfoTOList <NamedInfoTOList<ClubRunnerResultInfoTO>>currentResultList = null;
		while(it.hasNext()){
			to = it.next();
			if((!to.getDate().equals(date))||(!to.getParkName().equals(park))){
				currentResultList = new ExtendedInfoTOList<>();
				result.add(currentResultList);
				park = to.getParkName();
				date = to.getDate();
				currentResultList.setName(VizUtils.buildRaceName(park, date, locale));
				currentList = new NamedInfoTOList<>();
				if(to.getGender()==Gender.MALE){
					mensRes = true;
					currentList.setName(Internationalizer.translate(Translator.KEY_MENS_RESULTS,locale));
				}else{
					mensRes = false;
					currentList.setName(Internationalizer.translate(Translator.KEY_WOMENS_RESULTS,locale));
				}
				currentResultList.add(currentList);
			}else{
				if(mensRes&&to.getGender()==Gender.FEMALE){
					mensRes = false;
					currentList = new NamedInfoTOList<>();
					currentList.setName(Internationalizer.translate(Translator.KEY_WOMENS_RESULTS,locale));
					currentResultList.add(currentList);
				}
			}
			currentList.add(buildClubRunnerResultInfoTO(to));
		}
		return result;
	}

	/**
	 * Constructs ClubRunnerResultInfoTO based on given RaceClubResultTO
	 * @param to
	 * @return ClubRunnerResultInfoTO
	 */
	private static ClubRunnerResultInfoTO buildClubRunnerResultInfoTO(RaceClubResultTO to) {
		ClubRunnerResultInfoTO resultInfoTO = new ClubRunnerResultInfoTO();
		resultInfoTO.setName(VizUtils.concatName(to.getRunnerFirstName(), to.getRunnerLastName()));
		resultInfoTO.setPosition(Integer.toString(to.getPositionInGenderGroup()));
		resultInfoTO.setTime(VizUtils.convertNumberOfSecondsToTimeRepresentation(to.getTimeInSeconds()));
		return resultInfoTO;
	}
}
