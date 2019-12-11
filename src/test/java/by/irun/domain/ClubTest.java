package by.irun.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ClubTest {
	
	private Club club;
	
	@Mock
	private User admin;
	
	@Before
	public void init(){
		club = new Club();
	}
	
	@Test
	public void idTest(){
		assertNull(club.getId());
		club.setId(1L);
		assertEquals(Long.valueOf(1),club.getId());
	}
	
	@Test
	public void nameTest(){
		assertNull(club.getName());
		club.setName("name");
		assertEquals("name",club.getName());
	}
	
	@Test
	public void smallLogoTest(){
		assertNull(club.getSmallLogo());
		Picture pic = PowerMock.createMock(Picture.class);
		club.setSmallLogo(pic);
		assertEquals(pic,club.getSmallLogo());
	}
	
	@Test
	public void bigLogoTest(){
		assertNull(club.getBigLogo());
		Picture pic = PowerMock.createMock(Picture.class);
		club.setBigLogo(pic);
		assertEquals(pic,club.getBigLogo());
	}
	
	@Test
	public void currentRunnersTest(){
		assertNull(club.getCurrentRunners());
		@SuppressWarnings("unchecked")
		List<Runner>list = PowerMock.createMock(List.class);
		club.setCurrentRunners(list);
		assertEquals(list,club.getCurrentRunners());
	}
	
	@Test
	public void baseCityTest(){
		assertNull(club.getBaseCity());
		club.setBaseCity("city");
		assertEquals("city",club.getBaseCity());
	}
	
	@Test
	public void adminTest(){
		assertNull(club.getAdmin());
		club.setAdmin(admin);
		assertEquals(admin,club.getAdmin());
	}
	
	@Test
	public void equalsTest(){
		Club club2 = new Club();
		club2.setName("name");
		club.setId(1L);
		assertNotEquals(club2,club);
		club2.setId(1L);
		assertEquals(club2,club);
	}

}
