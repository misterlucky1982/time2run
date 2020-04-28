package by.irun.viz.to.runnerpage;
import org.junit.Test;

import by.irun.viz.to.runnerpage.RunnerResultInfoTO;
import by.misterlucky.testunit.UnitTestHelper;

/**
 * Test class for {@link by.irun.viz.to.runnerpage.RunnerResultInfoTO}
 * @author A.Dubovik
 *
 */
public class RunnerResultInfoTOTest {

	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.testAsClassicPojo(RunnerResultInfoTO.class);
	}
}
