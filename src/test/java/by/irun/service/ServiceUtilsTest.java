package by.irun.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	/**
	 * test for {@link by.irun.service.ServiceUtils#getRaceClubResultTOSet(List)}
	 */
	@Test
	public void getRaceClubResultTOSetTest(){
		Date date1 = Date.valueOf("2020-02-02");
		Date date2 = Date.valueOf("2020-01-01");
		String park1 = "park1";
		String park2 = "park2";
		Gender m = Gender.MALE;
		Gender f = Gender.FEMALE;
		RaceClubResultTO to1 = getRaceClubResultTO(date2,park2,f,1);
		RaceClubResultTO to2 = getRaceClubResultTO(date2,park1,f,20);
		RaceClubResultTO to3 = getRaceClubResultTO(date1,park1,m,2);
		RaceClubResultTO to4 = getRaceClubResultTO(date1,park2,f,8);
		RaceClubResultTO to5 = getRaceClubResultTO(date2,park1,m,18);
		RaceClubResultTO to6 = getRaceClubResultTO(date1,park2,f,28);
		List<RaceClubResultTO>list = Arrays.asList(to1,to2,to3,to4,to5,to6);
		List<RaceClubResultTO>sorted = new ArrayList<>(ServiceUtils.getRaceClubResultTOSet(list));
		assertTrue(sorted.get(0)==to3);
		assertTrue(sorted.get(1)==to4);
		assertTrue(sorted.get(2)==to6);
		assertTrue(sorted.get(3)==to5);
		assertTrue(sorted.get(4)==to2);
		assertTrue(sorted.get(5)==to1);
	}
	
	/**
	 * Creates RaceClubResultTO for testing
	 * @param d
	 * @param park
	 * @param g
	 * @param absPosition
	 * @return
	 */
	private RaceClubResultTO getRaceClubResultTO(Date d, String park, Gender g, int absPosition){
		RaceClubResultTO to = new RaceClubResultTO();
		to.setAbsPosition(absPosition);
		to.setDate(d);
		to.setGender(g);
		to.setParkName(park);
		return to;
	}

}
