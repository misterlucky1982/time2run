package by.irun.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.irun.locale.AppLocales;

/**
 * test class for EnController
 * @author A.Dubovik
 */
public class EnControllerTest {
	
	@Test
	public void getLocaleTest(){
		ApplicationController en = new EnController();
		assertEquals(AppLocales.EN,en.getLocale());
	}

}
