package by.irun.domain.to;

import org.junit.Test;

import by.irun.domain.Gender;
import by.misterlucky.testunit.UnitTestHelper;

public class RunnerTOTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.assertAllDeclaredFieldsPrivateAndNotStatic(RunnerTO.class);
		UnitTestHelper.getSetTestForAllFieldsExcept(RunnerTO.class, "gender");
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(RunnerTO.class, "gender", Gender.MALE);
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(RunnerTO.class, "gender", Gender.FEMALE);
	}
}
