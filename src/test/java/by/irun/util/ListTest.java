package by.irun.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

public class ListTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void listTest(){
		@SuppressWarnings("rawtypes")
		List list = new List();
		assertNull(list.getList());
		@SuppressWarnings("rawtypes")
		java.util.List listToSet = PowerMock.createMock(java.util.List.class);
		list.setList(listToSet);
		assertEquals(listToSet,list.getList());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void constructorTest(){
		java.util.List listToSet = PowerMock.createMock(java.util.List.class);
		List list = new List(listToSet);
		assertEquals(listToSet,list.getList());
	}

}
