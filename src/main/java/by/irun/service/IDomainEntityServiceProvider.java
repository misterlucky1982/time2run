package by.irun.service;

import by.irun.domain.Club;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Runner;
import by.irun.domain.User;

/**
 * Provides functionality for CRUD operations with {@link by.irun.domain.DomainEntity}
 * without direct call to database
 * 
 * @author A.Dubovik
 *
 */
public interface IDomainEntityServiceProvider {
	
	public Club getClubByID(Long id);
	
	/**
	 * obtains Park from repository if its exists with given id
	 * @param id
	 * @return Park
	 */
	public Park getParkByID(Long id);
	
	/**
	 * obtains Picture from repository if its exists with given id
	 * @param id
	 * @return Picture
	 */
	public Picture getPictureByID(Long id);
	
	/**
	 * obtains Runner from repository if its exists with given id
	 * @param id
	 * @return Runner
	 */
	public Runner getRunnerByID(Long id);
	
	/**
	 * obtains User from repository if its exists with given id
	 * @param id
	 * @return Use
	 */
	public User getUserByID(Long id);
}
