package by.irun.controller;

import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.irun.locale.AppLocales;

@RequestMapping("/ru/")
@RestController
public class RuController extends ApplicationController{

	/*
	 * (non-Javadoc)
	 * 
	 * @by.irun.controller.ApplicationController#getLocale()
	 */
	@Override
	protected Locale getLocale() {
		return AppLocales.RU;
	}

}
