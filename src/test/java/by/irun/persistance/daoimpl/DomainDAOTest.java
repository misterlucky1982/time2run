package by.irun.persistance.daoimpl;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.sql.SQLException;
import org.easymock.EasyMock;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import by.irun.domain.DomainEntity;
import by.irun.persistance.util.DBUtils;

/**
 * Test Class for testing DomainDAO
 * 
 * @author A.Dubovik
 *
 */
@RunWith(PowerMockRunner.class)
public class DomainDAOTest {

	private DomainDAO dao = new DomainDAO();

	@Mock
	private DomainEntity entity;

	@Mock
	private SessionFactory sessionFactory;

	@Mock
	private org.hibernate.Session session;

	@Mock
	private org.hibernate.Transaction transaction;

	private static Serializable ID = 1L;

	@Before
	public void init() {
		Whitebox.setInternalState(DBUtils.class, "SESSION_FACTORY", sessionFactory);
		EasyMock.expect(sessionFactory.openSession()).andReturn(session);
	}

	/**
	 * Test for add entity
	 */
	@Test
	public void addEntityTest() {
		EasyMock.expect(session.beginTransaction()).andReturn(transaction);
		EasyMock.expect(session.save(entity)).andReturn(ID);
		transaction.commit();
		EasyMock.expect(session.isOpen()).andReturn(true);
		EasyMock.expectLastCall();
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		Serializable id = null;
		try {
			id = dao.add(entity);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertEquals(ID, id);
	}

	/**
	 * Test for add entity with exception
	 */
	@Test
	public void addEntityTestWithException() {
		EasyMock.expect(session.beginTransaction()).andReturn(transaction);
		EasyMock.expect(session.save(entity)).andThrow(new javax.persistence.PersistenceException("exception"));
		transaction.rollback();
		EasyMock.expectLastCall();
		EasyMock.expect(session.isOpen()).andReturn(true);
		EasyMock.expectLastCall();
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		Serializable id = null;
		try {
			id = dao.add(entity);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNull(id);
	}

	/**
	 * test for update entity
	 */
	@Test
	public void updateEntityTest() {
		EasyMock.expect(session.beginTransaction()).andReturn(transaction);
		session.update(entity);
		EasyMock.expectLastCall();
		transaction.commit();
		EasyMock.expect(session.isOpen()).andReturn(true);
		EasyMock.expectLastCall();
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		try {
			assertTrue(dao.update(entity));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
	}

	/**
	 * test for update entity with exception
	 */
	@Test
	public void updateEntityTestWithException() {
		EasyMock.expect(session.beginTransaction()).andReturn(transaction);
		session.update(entity);
		EasyMock.expectLastCall().andThrow(new javax.persistence.PersistenceException("exception"));
		transaction.rollback();
		EasyMock.expectLastCall();
		EasyMock.expect(session.isOpen()).andReturn(true);
		EasyMock.expectLastCall();
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		try {
			dao.update(entity);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
	}

	/**
	 * test for delete entity
	 */
	@Test
	public void deleteEntityTest() {
		EasyMock.expect(session.beginTransaction()).andReturn(transaction);
		session.delete(entity);
		EasyMock.expectLastCall();
		transaction.commit();
		EasyMock.expect(session.isOpen()).andReturn(true);
		EasyMock.expectLastCall();
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		try {
			assertTrue(dao.delete(entity));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
	}

	/**
	 * test for delete entity with exception
	 */
	@Test
	public void deleteEntityTestWithException() {
		EasyMock.expect(session.beginTransaction()).andReturn(transaction);
		session.delete(entity);
		EasyMock.expectLastCall().andThrow(new javax.persistence.PersistenceException("exception"));
		transaction.rollback();
		EasyMock.expectLastCall();
		EasyMock.expect(session.isOpen()).andReturn(true);
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		try {
			dao.delete(entity);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
	}

	/**
	 * test for getEntityById
	 */
	@Test
	public void getEntityByIdTest() {
		DomainEntity entity = null;
		EasyMock.expect(session.get(DomainEntity.class, ID)).andReturn(this.entity);
		EasyMock.expect(session.isOpen()).andReturn(true);
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		try {
			entity = dao.getEntityById(DomainEntity.class, ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertEquals(this.entity, entity);
	}

	/**
	 * test for getEntityById with exception
	 */
	@Test
	public void getEntityByIdTestWithException() {
		DomainEntity en = null;
		EasyMock.expect(session.get(DomainEntity.class, ID)).andThrow(new javax.persistence.PersistenceException("exception"));
		EasyMock.expect(session.isOpen()).andReturn(true);
		session.close();
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		try {
			en = dao.getEntityById(DomainEntity.class, ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PowerMock.verifyAll();
		assertNull(en);
	}
}
