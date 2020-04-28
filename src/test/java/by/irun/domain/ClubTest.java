package by.irun.domain;

import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;

public class ClubTest {
	

	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.getSetTestForAllFieldsExcept(Club.class, "serialVersionUID");
	}
}
