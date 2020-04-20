package by.irun.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IdItemTest {
	
	private IdItem item;
	
	@Before
	public void init(){
		item = new IdItem();
	}
	
	@Test
	public void nameTest(){
		assertNull(item.getName());
		item.setName("name");
		assertEquals("name",item.getName());
	}
	
	@Test
	public void longIdTest(){
		item.setId(1L);
		assertEquals("1",item.getId());
	}
	
	@Test
	public void stringIdTest(){
		assertNull(item.getId());
		item.setId("ID");
		assertEquals("ID",item.getId());
	}
	
	@Test
	public void constructorTest(){
		IdItem it = new IdItem(2L,"name");
		assertEquals("name",it.getName());
		assertEquals("2",it.getId());
	}
}
