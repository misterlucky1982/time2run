package by.irun.domain;

import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;

public class UserTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.getSetTestForAllFieldsExcept(User.class, "serialVersionUID");
	}
}
