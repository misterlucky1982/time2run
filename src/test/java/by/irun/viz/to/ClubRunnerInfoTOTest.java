package by.irun.viz.to;
import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;

/**
 * test class for {@link by.irun.viz.to.ClubRunnerInfoTO}
 * @author A.Dubovik
 */
public class ClubRunnerInfoTOTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.testAsClassicPojo(ClubRunnerInfoTO.class);
	}

}
