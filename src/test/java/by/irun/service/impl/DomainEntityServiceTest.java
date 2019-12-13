package by.irun.service.impl;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.sql.SQLException;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import by.irun.dao.CRUDHandler;
import by.irun.domain.Club;
import by.irun.domain.DomainEntity;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Race;
import by.irun.domain.Result;
import by.irun.domain.Runner;
import by.irun.domain.User;

/**
 * test class for {@link by.irun.service.impl.DomainEntityService}
 * @author A.Dubovik
 *
 */
@RunWith(PowerMockRunner.class)
public class DomainEntityServiceTest {
	
	@Mock
	private CRUDHandler dao;
	
	@Mock
	private DomainEntity entity;
	
	@Mock
	private Club club;
	
	@Mock
	private Park park;
	
	@Mock
	private Picture picture;
	
	@Mock
	private Race race;
	
	@Mock
	private Result result;
	
	@Mock
	private Runner runner;
	
	@Mock
	private User user;
	
	private DomainEntityService service;
	
	@Before
	public void init(){
		service = new DomainEntityService();
		Whitebox.setInternalState(service, "dao", dao);
	}
	
	/**
	 * test case with entity added successfully
	 */
	@Test
	public void addDomainEntityTest(){
		Serializable id = null;
		try {
			EasyMock.expect(dao.add(entity)).andReturn(1L);
			PowerMock.replayAll();
			id = service.add(entity);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(1L,id);
	}
	
	/**
	 * test scenario with the adding entity failed
	 */
	@Test
	public void addEntityWithoutSuccessTest(){
		Serializable id = null;
		try {
			EasyMock.expect(dao.add(entity)).andThrow(new SQLException());
			PowerMock.replayAll();
			id = service.add(entity);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(id);
	}

	/**
	 * test scenario with successfully updated entity 
	 */
	@Test
	public void updateDomainEntityTest(){
		Boolean result = null;
		try {
			EasyMock.expect(dao.update(entity)).andReturn(true);
			PowerMock.replayAll();
			result = service.update(entity);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertTrue(result);
	}
	
	/**
	 * test scenario with update entity failed
	 */
	@Test
	public void updateEntityFailedTest(){
		Boolean result = null;
		try {
			EasyMock.expect(dao.update(entity)).andThrow(new SQLException());
			PowerMock.replayAll();
			result = service.update(entity);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertFalse(result);
	}
	
	/**
	 * test scenario with delete entity successfully
	 */
	@Test
	public void deleteDomainEntityTest(){
		Boolean result = null;
		try {
			EasyMock.expect(dao.delete(entity)).andReturn(true);
			PowerMock.replayAll();
			result = service.delete(entity);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertTrue(result);
	}
	
	/**
	 * test scenario delete entity failed
	 */
	@Test
	public void deleteEntityWithoutSuccessTest(){
		Boolean result = null;
		try {
			EasyMock.expect(dao.delete(entity)).andThrow(new SQLException());
			PowerMock.replayAll();
			result = service.delete(entity);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertFalse(result);
	}
	
	/**
	 * test scenario with obtain club successfully
	 */
	@Test
	public void getClubSuccessfullyTest(){
		Club club0 = null;
		try {
			EasyMock.expect(dao.getEntityById(Club.class, 1L)).andReturn(club);
			PowerMock.replayAll();
			club0 = service.getClubByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(club,club0);
	}
	
	/**
	 * test scenario with obtain club failed
	 */
	@Test
	public void getClubWithoutSuccessTest(){
		Club club0 = null;
		try {
			EasyMock.expect(dao.getEntityById(Club.class, 1L)).andThrow(new SQLException());
			PowerMock.replayAll();
			club0 = service.getClubByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(club0);
	}
	
	/**
	 * test scenario with obtain park successfully
	 */
	@Test
	public void getParkSuccessfullyTest(){
		Park entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Park.class, 1L)).andReturn(park);
			PowerMock.replayAll();
			entity = service.getParkByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(park,entity);
	}
	
	/**
	 * test case for obtain park failed
	 */
	@Test
	public void getParkWithoutSuccessTest(){
		Park entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Park.class, 1L)).andThrow(new SQLException());
			PowerMock.replayAll();
			entity = service.getParkByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(entity);
	}
	
	/**
	 * test scenario with obtain picture successfully
	 */
	@Test
	public void getPictureSuccessfullyTest(){
		Picture entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Picture.class, 1L)).andReturn(picture);
			PowerMock.replayAll();
			entity = service.getPictureByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(picture,entity);
	}
	
	/**
	 * test scenario with obtain picture failed
	 */
	@Test
	public void getPictureWithoutSuccessTest(){
		Picture entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Picture.class, 1L)).andThrow(new SQLException());
			PowerMock.replayAll();
			entity = service.getPictureByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(entity);
	}
	
	/**
	 * test scenario with obtain race successfully
	 */
	@Test
	public void getRaceSuccessfullyTest(){
		Race entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Race.class, 1L)).andReturn(race);
			PowerMock.replayAll();
			entity = service.getRaceByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(race,entity);
	}
	
	/**
	 * test scenario with obtain race failed
	 */
	@Test
	public void getRaceWithoutSuccessTest(){
		Race entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Race.class, 1L)).andThrow(new SQLException());
			PowerMock.replayAll();
			entity = service.getRaceByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(entity);
	}
	
	/**
	 * test scenario with obtain result successfully
	 */
	@Test
	public void getResultSuccessfullyTest(){
		Result entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Result.class, 1L)).andReturn(result);
			PowerMock.replayAll();
			entity = service.getResultByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(result,entity);
	}
	
	/**
	 * test scenario with obtain result failed
	 */
	@Test
	public void getResulkWithoutSuccessTest(){
		Result entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Result.class, 1L)).andThrow(new SQLException());
			PowerMock.replayAll();
			entity = service.getResultByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(entity);
	}
	
	/**
	 * test scenario with obtain runner successfully
	 */
	@Test
	public void getRunnerSuccessfullyTest(){
		Runner entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Runner.class, 1L)).andReturn(runner);
			PowerMock.replayAll();
			entity = service.getRunnerByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(runner,entity);
	}
	
	/**
	 * test scenario with obtain runner failed
	 */
	@Test
	public void getRunnerWithoutSuccessTest(){
		Runner entity = null;
		try {
			EasyMock.expect(dao.getEntityById(Runner.class, 1L)).andThrow(new SQLException());
			PowerMock.replayAll();
			entity = service.getRunnerByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(entity);
	}
	
	/**
	 * test scenario with obtain user successfully
	 */
	@Test
	public void getUserSuccessfullyTest(){
		User entity = null;
		try {
			EasyMock.expect(dao.getEntityById(User.class, 1L)).andReturn(user);
			PowerMock.replayAll();
			entity = service.getUserByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertEquals(user,entity);
	}
	
	/**
	 * test scenario with obtain user failed
	 */
	@Test
	public void getUserWithoutSuccessTest(){
		User entity = null;
		try {
			EasyMock.expect(dao.getEntityById(User.class, 1L)).andThrow(new SQLException());
			PowerMock.replayAll();
			entity = service.getUserByID(1L);
		} catch (SQLException e) {}
		PowerMock.verifyAll();
		assertNull(entity);
	}
}
