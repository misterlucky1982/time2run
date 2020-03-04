package by.irun.viz.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * test class for {@link by.irun.viz.to.ClubRunnerResultInfoTO}
 * 
 * @author A.Dubovik
 *
 */
public class ClubRunnerResultInfoTOTest {

	private ClubRunnerResultInfoTO to;

	@Before
	public void init() {
		to = new ClubRunnerResultInfoTO();
	}

	@Test
	public void nameTest() {
		assertNull(to.getName());
		to.setName("name");
		assertEquals("name", to.getName());
	}

	@Test
	public void positionTest() {
		assertNull(to.getPosition());
		to.setPosition("1");
		assertEquals("1", to.getPosition());
	}

	@Test
	public void timeTest() {
		assertNull(to.getTime());
		to.setTime("time");
		assertEquals("time", to.getTime());
	}
}
