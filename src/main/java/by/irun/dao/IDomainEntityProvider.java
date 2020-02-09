package by.irun.dao;

import java.io.Serializable;
import java.sql.SQLException;

import by.irun.domain.DomainEntity;

/**
 * Provides functionality for READ operations with DB
 * @author A.Dubovik
 *
 */
public interface IDomainEntityProvider {

	/**
	 * Read DomainEntity from database
	 * @param entityClass - class of entity
	 * @param id - id of the required entity
	 * @return DomainEntity
	 * @throws SQLException
	 */
	DomainEntity getEntityById(@SuppressWarnings("rawtypes") Class entityClass, Serializable id) throws SQLException;
}
