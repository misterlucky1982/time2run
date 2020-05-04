package by.irun.service.impl;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.irun.domain.Club;
import by.irun.domain.Park;
import by.irun.domain.Picture;
import by.irun.domain.Runner;
import by.irun.domain.User;
import by.irun.persistance.dao.IGenericDAO;
import by.irun.service.IDomainEntityServiceProvider;

/**
 * implementation of {@link by.irun.service.IDomainEntityServiceProvider}
 * @author A.Dubovik
 *
 */

@Service
public class DomainEntityServiceProvider implements IDomainEntityServiceProvider{
	
	@Autowired
	private IGenericDAO repository;

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityServiceProvider#getClubByID(Long id)
	 */
	@Override
	public Club getClubByID(Long id) {
		try{
			return this.repository.getClubById(id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityServiceProvider#getParkByID(Long id)
	 */
	@Override
	public Park getParkByID(Long id) {
		try{
			return this.repository.getParkById(id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityServiceProvider#getPictureByID(Long id)
	 */
	@Override
	public Picture getPictureByID(Long id) {
		try{
			return this.repository.getPictureById(id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityServiceProvider#getRunnerByID(Long id)
	 */
	@Override
	public Runner getRunnerByID(Long id) {
		try{
			return this.repository.getRunnerById(id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see by.irun.service.IDomainEntityServiceProvider#getUserByID(Long id)
	 */
	@Override
	public User getUserByID(Long id) {
		try{
			return this.repository.getUserById(id);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
