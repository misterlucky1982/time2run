package by.irun.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * test class for ApplicationConfig
 * @author A.Dubovik
 */
public class ApplicationConfigTest {

	private ApplicationConfig appConfig;
	
	@Before
	public void init(){
		appConfig = new ApplicationConfig();
	}
	
	@Test
	public void localeResolverTest(){
		assertNotNull(appConfig.localeResolver());
	}
}
