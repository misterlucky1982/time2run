package by.irun.viz.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ExtendedInfoTOListTest {
	
	@SuppressWarnings("rawtypes")
	private ExtendedInfoTOList  list;
	
	@Before
	public void init(){
		list = new ExtendedInfoTOList<>();
	}
	
	@Test
	public void linkTest(){
		assertNull(list.getLink());
		list.setLink("link");
		assertEquals("link",list.getLink());
	}

}
