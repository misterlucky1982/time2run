package by.irun.service.impl;

import java.io.Serializable;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.irun.domain.Club;
import by.irun.domain.DomainEntity;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Race;
import by.irun.domain.Result;
import by.irun.domain.Runner;
import by.irun.domain.User;
import by.irun.persistance.dao.CRUDHandler;
import by.irun.service.IDomainEntityService;

/**
 * implementation of {@link by.irun.service.IDomainEntityService}
 * @author A.Dubovik
 *
 */

@Service
public class DomainEntityService implements IDomainEntityService{
	
	@Autowired
	private CRUDHandler dao;

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#add(DomainEntity entity)
	 */
	@Override
	public Serializable add(DomainEntity entity) {
		Serializable id = null;
		try{
			id = dao.add(entity);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return id;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#update(DomainEntity entity)
	 */
	@Override
	public boolean update(DomainEntity entity) {
		try{
			return dao.update(entity);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#delete(DomainEntity entity)
	 */
	@Override
	public boolean delete(DomainEntity entity) {
		try{
			return dao.delete(entity);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#getClubByID(Serializable id)
	 */
	@Override
	public Club getClubByID(Serializable id) {
		try{
			return (Club)this.dao.getEntityById(by.irun.domain.Club.class, id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#getParkByID(Serializable id)
	 */
	@Override
	public Park getParkByID(Serializable id) {
		try{
			return (Park)this.dao.getEntityById(by.irun.domain.Park.class, id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#getPictureByID(Serializable id)
	 */
	@Override
	public Picture getPictureByID(Serializable id) {
		try{
			return (Picture)this.dao.getEntityById(by.irun.domain.Picture.class, id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#getRaceByID(Serializable id)
	 */
	@Override
	public Race getRaceByID(Serializable id) {
		try{
			return (Race)this.dao.getEntityById(by.irun.domain.Race.class, id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#getResultByID(Serializable id)
	 */
	@Override
	public Result getResultByID(Serializable id) {
		try{
			return (Result)this.dao.getEntityById(by.irun.domain.Result.class, id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#getRunnerByID(Serializable id)
	 */
	@Override
	public Runner getRunnerByID(Serializable id) {
		try{
			return (Runner)this.dao.getEntityById(by.irun.domain.Runner.class, id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityService#getUserByID(Serializable id)
	 */
	@Override
	public User getUserByID(Serializable id) {
		try{
			return (User)this.dao.getEntityById(by.irun.domain.User.class, id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
