package by.irun.domain.to;

import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;

/**
 * Test class for {@link by.irun.domain.to.ClubTO}
 * @author A.Dubovik
 */
public class ClubTOTest {

	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.testAsClassicPojo(ClubTO.class);
	}

}
