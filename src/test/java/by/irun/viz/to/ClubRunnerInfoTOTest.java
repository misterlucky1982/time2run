package by.irun.viz.to;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * test class for {@link by.irun.viz.to.ClubRunnerInfoTO}
 * @author A.Dubovik
 */
public class ClubRunnerInfoTOTest {
	
	private ClubRunnerInfoTO to;
	
	@Before
	public void init(){
		to = new ClubRunnerInfoTO();
	}
	@Test
	public void nameTest(){
		assertNull(to.getName());
		to.setName("name");
		assertEquals("name",to.getName());
	}
	
	@Test
	public void avatarPathTest(){
		assertNull(to.getAvatarPath());
		to.setAvatarPath("path");
		assertEquals("path",to.getAvatarPath());
	}
	
	@Test
	public void linkToPageTest(){
		assertNull(to.getLinkToPage());
		to.setLinkToPage("link");
		assertEquals("link",to.getLinkToPage());
	}

}
