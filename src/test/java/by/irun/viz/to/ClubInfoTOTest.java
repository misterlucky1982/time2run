package by.irun.viz.to;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

public class ClubInfoTOTest {

	private ClubInfoTO to;

	@Before
	public void init() {
		to = new ClubInfoTO();
	}

	@Test
	public void amountOfRunnersTest() {
		assertTrue(to.getAmountOfRunners() == 0);
		to.setAmountOfRunners(2);
		assertTrue(to.getAmountOfRunners() == 2);
	}

	@Test
	public void clubNameTest() {
		assertNull(to.getClubName());
		to.setClubName("name");
		assertEquals("name", to.getClubName());
	}

	@Test
	public void currentRunnersTest() {
		assertNull(to.getCurrentRunners());
		@SuppressWarnings("unchecked")
		List<ClubRunnerInfoTO> list = PowerMock.createMock(List.class);
		to.setCurrentRunners(list);
		assertEquals(list, to.getCurrentRunners());
	}

	@Test
	public void emailTest() {
		assertNull(to.getEmail());
		to.setEmail("email");
		assertEquals("email", to.getEmail());
	}

	@Test
	public void firstRaceTest() {
		assertNull(to.getFirstRace());
		to.setFirstRace("race");
		assertEquals("race", to.getFirstRace());
	}

	@Test
	public void linkToFirstRaceTest() {
		assertNull(to.getLinkToFirstRace());
		to.setLinkToFirstRace("link");
		assertEquals("link", to.getLinkToFirstRace());
	}

	@Test
	public void numberOfRacesTest() {
		assertTrue(to.getNumberOfRaces() == 0);
		to.setNumberOfRaces(2);
		assertTrue(to.getNumberOfRaces() == 2);
	}

	@Test
	public void numberOfRunnersInHistoryTest() {
		assertTrue(to.getNumberOfRunnersInHistory() == 0);
		to.setNumberOfRunnersInHistory(3);
		assertTrue(to.getNumberOfRunnersInHistory() == 3);
	}

	@Test
	public void parkBestResultsTest() {
		assertNull(to.getParkBestResults());
		@SuppressWarnings("unchecked")
		List<ParkBestResultInfoTO> list = PowerMock.createMock(List.class);
		to.setParkBestResults(list);
		assertEquals(list, to.getParkBestResults());
	}

	@Test
	public void phoneTest() {
		assertNull(to.getPhone());
		to.setPhone("123");
		assertEquals("123", to.getPhone());
	}

	@Test
	public void raceResultTest() {
		assertNull(to.getRaceResults());
		@SuppressWarnings("unchecked")
		List<NamedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> list = PowerMock.createMock(List.class);
		to.setRaceResults(list);
		assertEquals(list, to.getRaceResults());
	}

}
