package by.irun.persistance.dao.common;

import java.io.Serializable;
import java.sql.SQLException;

import by.irun.domain.DomainEntity;

/**
 * Implementation of this interface
 * provides standard CREATE, READ, UPDATE and DELETE operations with 
 * {@link by.irun.domain.DomainEntity}
 *
 */
public interface CRUDHandler extends IDomainEntityProvider{

	/**
	 * Persists entity into database
	 * @param entity - DomainEntity for persist
	 * @return ID of the entity if entity has been persisted or null if it hasn`t persisted
	 * @throws SQLException
	 */
	Serializable add(DomainEntity entity) throws SQLException;
	
	/**
	 * Updates existing entity
	 * @param entity - DomainEntity for update
	 * @return true - if entity was updated successfully or false - if it wasn`t updated
	 * @throws SQLException
	 */
	boolean update(DomainEntity entity) throws SQLException;
	
	/**
	 * Deletes entity from database
	 * @param entity - DomainEntity for delete
	 * @return true - if entity was deleted successfully or false - if it wasn`t deleted
	 * @throws SQLException
	 */
	boolean delete(DomainEntity entity) throws SQLException;
	
}
