package by.irun.service;

import java.io.Serializable;

import by.irun.domain.Club;
import by.irun.domain.DomainEntity;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Race;
import by.irun.domain.Result;
import by.irun.domain.Runner;
import by.irun.domain.User;

/**
 * Provides functionality for CRUD operations with {@link by.irun.domain.DomainEntity}
 * without direct call to database
 * 
 * @author A.Dubovik
 *
 */
public interface IDomainEntityService {
	
	public Club getClubByID(Serializable id);
	
	/**
	 * obtains Park from repository if its exists with given id
	 * @param id
	 * @return Park
	 */
	public Park getParkByID(Serializable id);
	
	/**
	 * obtains Picture from repository if its exists with given id
	 * @param id
	 * @return Picture
	 */
	public Picture getPictureByID(Serializable id);
	
	/**
	 * obtains Race from repository if its exists with given id 
	 * @param id
	 * @return Race
	 */
	public Race getRaceByID(Serializable id);
	
	/**
	 * obtains Result from repository if its exists with given id
	 * @param id
	 * @return Result
	 */
	public Result getResultByID(Serializable id);
	
	/**
	 * obtains Runner from repository if its exists with given id
	 * @param id
	 * @return Runner
	 */
	public Runner getRunnerByID(Serializable id);
	
	/**
	 * obtains User from repository if its exists with given id
	 * @param id
	 * @return Use
	 */
	public User getUserByID(Serializable id);
}
