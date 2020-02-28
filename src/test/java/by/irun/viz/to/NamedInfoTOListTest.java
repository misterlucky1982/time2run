package by.irun.viz.to;

import static org.junit.Assert.*;

import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

/**
 * test-class for {@link by.irun.viz.to.NamedInfoTOList}
 * @author A.Dubovik
 *
 */
public class NamedInfoTOListTest {

	private NamedInfoTOList<InfoTO> list;
	
	@Mock
	private InfoTO to;
	
	@Before
	public void init(){
		list = new NamedInfoTOList<>();
	}
	
	@Test
	public void nameTest(){
		assertNull(list.getName());
		list.setName("name");
		assertEquals("name",list.getName());
	}
	
	@Test
	public void listTest(){
		assertNotNull(list.getInfoTOs());
		assertTrue(list.size()==0);
		assertTrue(list.getInfoTOs().size()==0);
		list.add(to);
		assertEquals(to,list.get(0));
		assertEquals(to,list.getInfoTOs().get(0));
		assertTrue(list.size()==1);
	}
	
}
