package by.irun.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class UserTest {
	
	@Mock
	private Runner runner;
	
	private User user;
	
	@Before
	public void init(){
		user = new User();
	}
	
	@Test
	public void idTest(){
		assertNull(user.getId());
		user.setId(1L);
		assertTrue(user.getId()==1);
	}
	
	@Test
	public void emailTest(){
		assertNull(user.getEmail());
		user.setEmail("email");
		assertEquals("email",user.getEmail());
	}
	
	@Test
	public void adminPermissionTest(){
		assertFalse(user.isHasAdminPermission());
		user.setHasAdminPermission(true);
		assertTrue(user.isHasAdminPermission());
	}
	
	@Test
	public void loginTest(){
		assertNull(user.getLogin());
		user.setLogin("login");
		assertEquals("login",user.getLogin());
	}
	
	@Test
	public void passwordTest(){
		assertNull(user.getPassword());
		user.setPassword("password");
		assertEquals("password",user.getPassword());
	}
	
	@Test
	public void phoneTest(){
		assertNull(user.getPhone());
		user.setPhone("phone");
		assertEquals("phone",user.getPhone());
	}
	
	@Test
	public void runnerTest(){
		assertNull(user.getRunner());
		user.setRunner(runner);
		assertEquals(runner,user.getRunner());
	}
	
	@Test
	public void equalsTest(){
		user.setId(1L);
		user.setEmail("email");
		user.setHasAdminPermission(true);
		user.setLogin("login");
		user.setPassword("password");
		user.setPhone("phone");
		user.setRunner(runner);
		User u2 = new User();
		assertNotEquals(user,u2);
		u2.setId(1L);
		assertEquals(user,u2);
	}

}
