package by.irun.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
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
import by.irun.viz.to.ClubRaceResultInfoTO;
import by.irun.viz.to.ClubRunnerResultInfoTO;
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

	public static List<NamedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> generateSortedClubRunnerResultList(
			List<RaceClubResultTO> list, Locale locale) {
		List<NamedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> result = new ArrayList<>();
		Iterator<RaceClubResultTO> it = getRaceClubResultTOSet(list).iterator();
		Date date = null;
		String park = null;
		boolean isMenResults = true;
		NamedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>> raceResultList = null;
		NamedInfoTOList<ClubRunnerResultInfoTO> currentResults = null;
		while (it.hasNext()) {
			RaceClubResultTO to = it.next();
			if (to.getDate().equals(date)) {
				if (!to.getParkName().equals(park)) {
					park = to.getParkName();
					result.add(raceResultList);
					raceResultList = new NamedInfoTOList<>();
					raceResultList.setName(VizUtils.buildRaceName(to.getParkName(), to.getDate(), locale));
					currentResults = new NamedInfoTOList<>();
					raceResultList.add(currentResults);
					if (to.getGender() == Gender.FEMALE) {
						isMenResults = false;
						currentResults.setName(Internationalizer.translate(Translator.KEY_WOMENS_RESULTS, locale));
					} else {
						isMenResults = true;
						currentResults.setName(Internationalizer.translate(Translator.KEY_MENS_RESULTS, locale));
					}
					currentResults.add(buildClubRunnerResultInfoTO(to));
				} else {
					if (to.getGender() == Gender.MALE) {
						currentResults.add(buildClubRunnerResultInfoTO(to));
					} else {
						if (isMenResults) {
							isMenResults = false;
							currentResults = new NamedInfoTOList<>();
							raceResultList.add(currentResults);
							currentResults.setName(Internationalizer.translate(Translator.KEY_WOMENS_RESULTS, locale));
						}
						currentResults.add(buildClubRunnerResultInfoTO(to));
					}
				}
			} else {
				date = to.getDate();
				park = to.getParkName();
				raceResultList = new NamedInfoTOList<>();
				result.add(raceResultList);
				raceResultList.setName(VizUtils.buildRaceName(to.getParkName(), to.getDate(), locale));
				currentResults = new NamedInfoTOList<>();
				raceResultList.add(currentResults);
				if (to.getGender() == Gender.FEMALE) {
					isMenResults = false;
					currentResults.setName(Internationalizer.translate(Translator.KEY_WOMENS_RESULTS, locale));
				} else {
					isMenResults = true;
					currentResults.setName(Internationalizer.translate(Translator.KEY_MENS_RESULTS, locale));
				}
				currentResults.add(buildClubRunnerResultInfoTO(to));
			}
		}
		return result;
	}

	private static ClubRunnerResultInfoTO buildClubRunnerResultInfoTO(RaceClubResultTO to) {
		ClubRunnerResultInfoTO resultInfoTO = new ClubRunnerResultInfoTO();
		resultInfoTO.setName(VizUtils.concatName(to.getRunnerFirstName(), to.getRunnerLastName()));
		resultInfoTO.setPosition(Integer.toString(to.getPositionInGenderGroup()));
		resultInfoTO.setTime(VizUtils.convertNumberOfSecondsToTimeRepresentation(to.getTimeInSeconds()));
		return resultInfoTO;
	}
}
