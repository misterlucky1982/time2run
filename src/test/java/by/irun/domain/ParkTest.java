package by.irun.domain;

import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;

public class ParkTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.getSetTestForAllFieldsExcept(Park.class, "serialVersionUID");
	}
}
