package by.irun.domain;

import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;
public class RunnerTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.getSetTestForAllFieldsExcept(Runner.class, "serialVersionUID", "gender");
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(Runner.class, "gender", Gender.MALE);
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(Runner.class, "gender", Gender.FEMALE);
	}
}
