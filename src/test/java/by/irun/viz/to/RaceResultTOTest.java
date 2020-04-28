package by.irun.viz.to;

import org.junit.Test;

import by.irun.viz.to.RaceResultTO;
import by.misterlucky.testunit.UnitTestHelper;
/**
 * test class for {@link by.irun.viz.to.RaceResultTO}
 * @author A.Dubovik
 */
public class RaceResultTOTest {

	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.testAsClassicPojo(RaceResultTO.class);
	}

}
