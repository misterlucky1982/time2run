package by.irun.controller;

import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.irun.locale.AppLocales;

@RequestMapping("/en/")
@RestController
public class EnController extends ApplicationController{
	
	public static final String MAPPING = "/en/"; 

	/*
	 * (non-Javadoc)
	 * 
	 * @by.irun.controller.ApplicationController#getLocale()
	 */
	@Override
	protected Locale getLocale() {
		return AppLocales.EN;
	}

}
