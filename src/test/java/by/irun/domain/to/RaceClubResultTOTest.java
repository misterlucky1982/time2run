package by.irun.domain.to;

import org.junit.Test;

import by.irun.domain.Gender;
import by.misterlucky.testunit.UnitTestHelper;

/**
 * Test class for {@link by.irun.domain.to.RaceClubResultTO}
 * @author A.Dubovik
 */
public class RaceClubResultTOTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.assertAllDeclaredFieldsPrivateAndNotStatic(RaceClubResultTO.class);
		UnitTestHelper.getSetTestForAllFieldsExcept(RaceClubResultTO.class, "gender");
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(RaceClubResultTO.class, "gender", Gender.MALE);
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(RaceClubResultTO.class, "gender", Gender.FEMALE);
	}
}