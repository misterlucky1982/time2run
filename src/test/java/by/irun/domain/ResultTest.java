package by.irun.domain;


import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import by.misterlucky.testunit.UnitTestHelper;

@RunWith(PowerMockRunner.class)
public class ResultTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.getSetTestForAllFieldsExcept(Result.class, "serialVersionUID", "gender", "time");
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(Result.class, "gender", Gender.MALE);
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(Result.class, "gender", Gender.FEMALE);
		UnitTestHelper.getSetForFieldWithGivenInstanceToSet(Result.class, "time", Duration.ofSeconds(555));
	}

}
