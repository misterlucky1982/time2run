package by.irun.domain;

import org.junit.Test;

import by.misterlucky.testunit.UnitTestHelper;

public class PictureTest {
	
	@Test
	public void testAsPojo() throws Exception{
		UnitTestHelper.getSetTestForAllFieldsExcept(Picture.class, "serialVersionUID");
	}
}
