package by.irun.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import by.irun.domain.Gender;
import by.irun.domain.to.RaceClubResultTO;

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
	 * the next check - gender (male will be first, female - second)
	 * <p>
	 * the last check - time (sorts by time increasing, i.e. most faster will be
	 * first)
	 * 
	 * @param list
	 * @return
	 */
	public static TreeSet<RaceClubResultTO> getRaceClubResultTOSet(List<RaceClubResultTO> list) {
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
}
