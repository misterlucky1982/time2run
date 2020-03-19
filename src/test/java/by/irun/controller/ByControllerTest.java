package by.irun.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.irun.locale.AppLocales;

/**
 * test class for ByController
 * @author A.Dubovik
 */
public class ByControllerTest {
	
	@Test
	public void getLocaleTest(){
		ApplicationController by = new ByController();
		assertEquals(AppLocales.BY,by.getLocale());
	}

}
