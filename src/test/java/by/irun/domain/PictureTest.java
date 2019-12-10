package by.irun.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PictureTest {
	
	private Picture pic;
	private static final String LOCATION = "location";
	
	@Before
	public void init(){
		pic = new Picture();
	}
	
	@Test
	public void idTest(){
		assertNull(pic.getId());
		pic.setId(1L);
		assertTrue(pic.getId()==1);
	}
	
	@Test
	public void locationTest(){
		assertNull(pic.getLocation());
		pic.setLocation(LOCATION);
		assertEquals(LOCATION,pic.getLocation());	
	}
	
	@Test
	public void equalsTest(){
		Picture pic2 = new Picture();
		pic.setLocation(LOCATION);
		pic.setId(1L);
		assertNotEquals(pic,pic2);
		pic2.setId(1L);
		assertEquals(pic,pic2);
	}
	
}
