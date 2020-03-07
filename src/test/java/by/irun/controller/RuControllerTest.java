package by.irun.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.irun.locale.AppLocales;

/**
 * test class for RuControllerTest
 * @author A.Dubovik
 */
public class RuControllerTest {

	@Test
	public void getLocaleTest(){
		ApplicationController ru = new RuController();
		assertEquals(AppLocales.RU,ru.getLocale());
	}
}
