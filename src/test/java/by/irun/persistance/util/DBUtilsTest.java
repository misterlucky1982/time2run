package by.irun.persistance.util;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DBUtils.class })
public class DBUtilsTest {

	@Mock
	private SessionFactory sessionFactory;

	/**
	 * test case for SessionFactory is initialized
	 */
	@Test
	public void getSessionFactoryTestWithSessionFactoryIsInitialized() {
		Whitebox.setInternalState(DBUtils.class, "SESSION_FACTORY", sessionFactory);
		SessionFactory factory = DBUtils.getSessionFactory();
		assertEquals(sessionFactory, factory);
	}

	/**
	 * test case for SessionFactory is not initialized
	 */
	@Test
	public void getSessionFactoyTestWithSessionFactoyIsNotInitialized() {
		SessionFactory sessionFactoryIsNull = null;
		Whitebox.setInternalState(DBUtils.class, "SESSION_FACTORY", sessionFactoryIsNull);
		SessionFactory factory = null;
		try {
			PowerMock.mockStaticPartial(DBUtils.class, "buildSessionFactory");
			PowerMock.expectPrivate(DBUtils.class, "buildSessionFactory").andReturn(sessionFactory);
			PowerMock.replayAll();
			factory = DBUtils.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertEquals(sessionFactory, factory);
	}

}
