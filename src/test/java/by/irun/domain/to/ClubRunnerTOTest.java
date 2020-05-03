package by.irun.domain.to;

import org.junit.Test;

import by.irun.domain.Gender;
import by.misterlucky.testunit.UnitTestHelper;

/**
 * Test class for {@link by.irun.domain.to.ClubRunnerTO}
 * 
 * @author A.Dubovik
 */
public class ClubRunnerTOTest {

	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.assertAllDeclaredFieldsPrivateAndNotStatic(ClubRunnerTO.class);
		UnitTestHelper.getSetTestForAllFieldsExcept(ClubRunnerTO.class, "gender");
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(ClubRunnerTO.class, "gender", Gender.MALE);
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(ClubRunnerTO.class, "gender", Gender.FEMALE);
	}
}
