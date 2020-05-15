package by.irun.persistance.daoimpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.irun.domain.DomainEntity;
import by.irun.persistance.dao.common.CRUDHandler;
import by.irun.persistance.util.DBUtils;

@Transactional
@Repository
public class DomainDAO implements CRUDHandler{

	/* (non-Javadoc)
	 * @see by.irun.persistance.dao.CRUDHandler#add(DomainEntity entity)
	 */
	@Override
	public Serializable add(DomainEntity entity) throws SQLException {
		Session session = null;
		Transaction tr = null;
		Serializable id = null;
		try{
			session = DBUtils.getSessionFactory().openSession();
			tr = session.beginTransaction();
			id = session.save(entity);
			tr.commit();
		}catch(javax.persistence.PersistenceException e){
			if(tr!=null)tr.rollback();
			throw new SQLException();
		}finally{
			if(session!=null&&session.isOpen())session.close();
		}
		return id;
	}

	/* (non-Javadoc)
	 * @see by.irun.persistance.dao.CRUDHandler#update(DomainEntity entity)
	 */
	@Override
	public boolean update(DomainEntity entity) throws SQLException {
		Session session = null;
		Transaction tr = null;
		try{
			session = DBUtils.getSessionFactory().openSession();
			tr = session.beginTransaction();
			session.update(entity);
			tr.commit();
			return true;
		}catch(javax.persistence.PersistenceException e){
			if(tr!=null)tr.rollback();
			throw new SQLException();
		}finally{
			if(session!=null&session.isOpen())session.close();;
		}
	}

	/* (non-Javadoc)
	 * @see by.irun.persistance.dao.CRUDHandler#delete(DomainEntity entity)
	 */
	@Override
	public boolean delete(DomainEntity entity) throws SQLException {
		Session session = null;
		Transaction tr = null;
		try{
			session = DBUtils.getSessionFactory().openSession();
			tr = session.beginTransaction();
			session.delete(entity);
			tr.commit();
			return true;
		}catch(javax.persistence.PersistenceException e){
			if(tr!=null)tr.rollback();
			throw new SQLException();
		}finally{
			if(session!=null&session.isOpen())session.close();;
		}
	}



	/* (non-Javadoc)
	 * @see by.irun.persistance.dao.CRUDHandler#getEntityById(Class entityClass, Serializable id)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DomainEntity getEntityById(@SuppressWarnings("rawtypes") Class entityClass, Serializable id) throws SQLException {
		Session session = null;
	    DomainEntity entity = null;
	    try {
	      session = DBUtils.getSessionFactory().openSession();
	      entity = (DomainEntity) session.get(entityClass, id);
	    } catch (javax.persistence.PersistenceException e) {
	      throw new SQLException();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return entity;
	}

	/* (non-Javadoc)
	 * @see by.irun.persistance.dao.CRUDHandler#getEntityList(Class<?>entityClass)
	 */
	@Override
	public List<?> getEntityList(Class<?>entityClass) throws SQLException {
		Session session = null;
	    List<?>result = null;
	    Transaction tr = null;
	    try {
	      session = DBUtils.getSessionFactory().openSession();
	      tr = session.beginTransaction();
	      result = session.createQuery("from "+entityClass.getSimpleName()).getResultList();
	      tr.commit();
	    } catch (javax.persistence.PersistenceException e) {
	    	if(tr!=null)tr.rollback();
	    	throw new SQLException();
	    } finally {
	      if (session != null && session.isOpen()) {
	        session.close();
	      }
	    }
	    return result;
	}

}
