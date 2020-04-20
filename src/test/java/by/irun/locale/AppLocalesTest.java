package by.irun.locale;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * test class for {@link by.irun.locale.AppLocales}
 * @author A.Dubovik
 *
 */
public class AppLocalesTest {

	@Test
	public void getLocaleTest(){
		assertEquals(AppLocales.BY,AppLocales.getLocale("by"));
		assertEquals(AppLocales.RU,AppLocales.getLocale("ru"));
		assertEquals(AppLocales.EN,AppLocales.getLocale("en"));
		assertEquals(AppLocales.DEFAULT,AppLocales.getLocale(null));
		assertEquals(AppLocales.DEFAULT,AppLocales.getLocale("key bla bla bla"));
	}
}
