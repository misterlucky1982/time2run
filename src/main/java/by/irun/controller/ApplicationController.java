package by.irun.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import by.irun.persistance.daoimpl.DataProvider;
import by.irun.service.impl.DataService;
import by.irun.viz.to.ClubInfoTO;
import by.irun.viz.to.RunnerInfoTO;

@Controller
public abstract class ApplicationController {
	
	@SuppressWarnings("unused")
	@Autowired
	private DataProvider data;
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private LocaleResolver localeResolver;
	
	
	@GetMapping(value = "/clubs")
	public ModelAndView getURLValue(@RequestParam(value = "id", required = true) long id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		localeResolver.setLocale(request, response, getLocale());
		ClubInfoTO to = dataService.getClubInfoTO(id, getLocale());
		mav.addObject("club", to);
		mav.setViewName("clubInfo");
		return mav;
	}

	@GetMapping("/runner")
	public ModelAndView getRunnerPage(@RequestParam(value = "id", required = true) long id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		localeResolver.setLocale(request, response, getLocale());
		RunnerInfoTO to = dataService.getRunnerInfoTO(id, getLocale());
		mav.addObject("runner", to);
		mav.setViewName("runnerInfo");
		return mav;
	}
	
	/**
	 * returns current Locale
	 * @return Locale
	 */
	protected abstract Locale getLocale();

}
