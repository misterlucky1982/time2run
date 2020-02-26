package by.irun.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import by.irun.domain.Gender;
import by.irun.domain.to.RaceClubResultTO;

/**
 * Test class for {@link by.irun.service.ServiceUtils}
 * @author A.Dubovik
 *
 */
public class ServiceUtilsTest {
	
	/**
	 * test for {@link by.irun.service.ServiceUtils#checkBestResultsInPark(Map, RaceClubResultTO)}
	 */
	@Test
	public void checkBestResultsInParkTest() {
		String park1 = "park 1";
		String park2 = "park 2";
		RaceClubResultTO to1 = new RaceClubResultTO();
		to1.setGender(Gender.FEMALE);
		to1.setTimeInSeconds(20);
		to1.setParkName(park1);
		RaceClubResultTO to2 = new RaceClubResultTO();
		to2.setGender(Gender.MALE);
		to2.setParkName(park1);
		to2.setTimeInSeconds(33);
		RaceClubResultTO to3 = new RaceClubResultTO();
		to3.setGender(Gender.FEMALE);
		to3.setTimeInSeconds(20);
		to3.setParkName(park2);
		RaceClubResultTO to4 = new RaceClubResultTO();
		to4.setGender(Gender.MALE);
		to4.setTimeInSeconds(20);
		to4.setParkName(park2);
		List<RaceClubResultTO> list = new ArrayList<>();
		list.addAll(generateRaceClubResultTOListForParkAndGenderWithBestResult(to1, 10));
		list.addAll(generateRaceClubResultTOListForParkAndGenderWithBestResult(to2, 10));
		list.addAll(generateRaceClubResultTOListForParkAndGenderWithBestResult(to3, 10));
		list.addAll(generateRaceClubResultTOListForParkAndGenderWithBestResult(to4, 10));
		Map<String, Map<Gender, RaceClubResultTO>> map = new HashMap<>();
		for (RaceClubResultTO to : list) {
			ServiceUtils.checkBestResultsInPark(map, to);
		}
		assertTrue(map.size() == 2);
		assertTrue(map.get(park1).size() == 2);
		assertTrue(map.get(park2).size() == 2);
		assertEquals(to1, map.get(park1).get(Gender.FEMALE));
		assertEquals(to2, map.get(park1).get(Gender.MALE));
		assertEquals(to3, map.get(park2).get(Gender.FEMALE));
		assertEquals(to4, map.get(park2).get(Gender.MALE));
	}
	
	/**
	 * Generates List<RaceClubResultTO> for testing
	 * @param to
	 * @param numberGeneratedResults
	 * @return
	 */
	private List<RaceClubResultTO> generateRaceClubResultTOListForParkAndGenderWithBestResult(RaceClubResultTO to,
			int numberGeneratedResults) {
		List<RaceClubResultTO> list = new ArrayList<>();
		list.add(to);
		while (numberGeneratedResults-- > 0) {
			RaceClubResultTO to0 = new RaceClubResultTO();
			to0.setTimeInSeconds(to.getTimeInSeconds() + 1);
			to0.setGender(to.getGender());
			to0.setParkName(to.getParkName());
			list.add(to0);
		}
		return list;
	}

}
