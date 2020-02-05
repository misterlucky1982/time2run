package by.irun.locale;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;
/**
 * Test class for {@link by.irun.locale.Internationalizer}
 * 
 * @author A.Dubovik
 *
 */
public class InternationalizerTest {
	
	/**
	 * test for {@link by.irun.locale.Internationalizer#translate(Date, java.util.Locale)}
	 */
	@Test
	public void translateDataTest(){
		Date d1 = Date.valueOf("2000-01-25");
		Date d2 = Date.valueOf("1999-10-01");
		Date d3 = Date.valueOf("2020-05-05");
		assertEquals("25 января 2000г.",Internationalizer.translate(d1,AppLocales.RU));
		assertEquals("1 октября 1999г.",Internationalizer.translate(d2,AppLocales.RU));
		assertEquals("5 мая 2020г.",Internationalizer.translate(d3,AppLocales.RU));
		assertEquals("25 студзеня 2000г.",Internationalizer.translate(d1,AppLocales.BY));
		assertEquals("1 кастрычніка 1999г.",Internationalizer.translate(d2,AppLocales.BY));
		assertEquals("5 мая 2020г.",Internationalizer.translate(d3,AppLocales.BY));
		assertEquals("25 January 2000",Internationalizer.translate(d1,AppLocales.EN));
		assertEquals("1 October 1999",Internationalizer.translate(d2,AppLocales.EN));
		assertEquals("5 May 2020",Internationalizer.translate(d3,AppLocales.EN));
	}

}
