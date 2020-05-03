package by.irun.persistance.util;

import org.hibernate.SessionFactory;

import by.irun.config.HibernateConfig;

/**
 * Utility class for variety of standard operations with DB
 * @author A.Dubovik
 *
 */
public class DBUtils {
	
	private static SessionFactory SESSION_FACTORY;
	
	/**
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		return SESSION_FACTORY!=null?SESSION_FACTORY:buildSessionFactory();
	}
	
	/**
	 * SessionFactory initialization
	 * @return SessionFactory
	 */
	private synchronized static SessionFactory buildSessionFactory() {
		try {
			SESSION_FACTORY = HibernateConfig.getConfiguration().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return SESSION_FACTORY;
	}

}
