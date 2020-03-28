package by.irun.config;

import org.hibernate.cfg.Configuration;

/**
 * This class provides configuration for hibernate
 * 
 * @author A.Dubovik
 *
 */

public class HibernateConfig {
	
	private HibernateConfig(){}
	
	/**
	 * obtain hibernate configuration
	 * @return Configuration
	 */
	public static Configuration getConfiguration(){
		Configuration configuration = new Configuration()
                .setProperty( "hibernate.connection.driver_class", 
                		"org.postgresql.Driver" )
                .setProperty( "hibernate.connection.url", ApplicationConstants.DB_URL )
                .setProperty( "hibernate.connection.username", ApplicationConstants.DB_USERNAME)
                .setProperty( "hibernate.connection.password", ApplicationConstants.DB_PASSWORD)
                .setProperty( "hibernate.connection.autocommit", "false" )
                .setProperty( "hibernate.cache.provider_class", 
                                     "org.hibernate.cache.NoCacheProvider" )
                .setProperty( "hibernate.cache.use_second_level_cache", 
                                     "false" )
                .setProperty( "hibernate.cache.use_query_cache", "false" )
                .setProperty( "hibernate.dialect",
                                     "org.hibernate.dialect.PostgreSQLDialect" )
                .setProperty( "hibernate.show_sql","true" )
                .setProperty( "hibernate.current_session_context_class",
                                     "org.hibernate.context.internal.ThreadLocalSessionContext" )
                .setProperty("hibernate.enable_lazy_load_no_trans", "true")
                .setProperty("hibernate.temp.use_jdbc_metadata_defaults", "true")
                .setProperty("hibernate.jdbc.lob.non_contextual_creation", "true")
                .addAnnotatedClass(by.irun.domain.Result.class)
                .addAnnotatedClass(by.irun.domain.Race.class)
                .addAnnotatedClass(by.irun.domain.Runner.class)
                .addAnnotatedClass(by.irun.domain.Club.class)
                .addAnnotatedClass(by.irun.domain.Park.class)
                .addAnnotatedClass(by.irun.domain.Picture.class)
                .addAnnotatedClass(by.irun.domain.User.class);
		return configuration;
	}

}
