package by.irun.domain;

import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;

public class RaceTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.getSetTestForAllFieldsExcept(Race.class, "serialVersionUID");
	}
}
