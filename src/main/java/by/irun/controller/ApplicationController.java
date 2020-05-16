package by.irun.controller;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import by.irun.locale.AppLocales;
import by.irun.persistance.daoimpl.DataProvider;
import by.irun.service.impl.DataService;
import by.irun.util.Link;
import by.irun.viz.to.ClubInfoTO;
import by.irun.viz.to.racepage.RaceResultInfoTO;
import by.irun.viz.to.raceselectpage.RaceSelectPageViewTO;
import by.irun.viz.to.runnerpage.RunnerInfoTO;

@Controller
public class ApplicationController {
	
	@SuppressWarnings("unused")
	@Autowired
	private DataProvider data;
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private LocaleResolver localeResolver;
	
	
	@GetMapping(value = "/clubs")
	public ModelAndView getClubInfo(@RequestParam(value = "id", required = true) long id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		ClubInfoTO to = dataService.getClubInfoTO(id, localeResolver.resolveLocale(request));
		mav.addObject("club", to);
		mav.setViewName("clubInfo");
		return mav;
	}

	@GetMapping("/runner")
	public ModelAndView getRunnerPage(@RequestParam(value = "id", required = true) long id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		RunnerInfoTO to = dataService.getRunnerInfoTO(id, localeResolver.resolveLocale(request));
		mav.addObject("runner", to);
		mav.setViewName("runnerInfo");
		return mav;
	}
	
	@GetMapping("/race")
	public ModelAndView getRacePage(@RequestParam(value = "id", required = true) long raceId, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		RaceResultInfoTO to = dataService.getRaceResultInfoTO(raceId, localeResolver.resolveLocale(request));
		mav.addObject("race", to);
		mav.setViewName("race");
		return mav;
	}
	
	@GetMapping("/events")
	public ModelAndView getLastEventPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		RaceSelectPageViewTO viewTO = dataService.getRaceSelectPageViewTOForLastRace(localeResolver.resolveLocale(request));
		mav.addObject("event", viewTO);
		mav.setViewName("events");
		return mav;
	}
	
	@GetMapping("events/races")
	public ModelAndView getRaceList(@RequestParam(name = "park",required = false) Long parkId, @RequestParam(name = "from", required = false) String date1, @RequestParam(name = "to", required = false) String date2, HttpServletRequest request,
			HttpServletResponse response) {
		Date from = null;
		Date to = null;
		if (date1 != null) {
			try {
				from = Date.valueOf(date1);
			} catch (RuntimeException e) {
			}
		}
		if (date2 != null) {
			try {
				to = Date.valueOf(date2);
			} catch (RuntimeException e) {
			}
		}
		if (from != null && to != null && from.after(to)) {
			return getWarningMessageForRaceList(ControllerConstants.BOTH_FROM_FOR_DATE_WARNING_REQEST_PARAMVALUE,
					request, response);
		}
		java.util.List<Link>races = dataService.getRaceLinkList(from, to, parkId, localeResolver.resolveLocale(request));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fragments/raceselectpage/racelist");
		mav.addObject("racelist", races);
		return mav;
	}
	
	@GetMapping("events/races/info")
	public ModelAndView getRaceInfo(@RequestParam(name = "id", required = true) Long id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();RaceSelectPageViewTO viewTO = new RaceSelectPageViewTO();
		viewTO.setRaceInfoVizTO(dataService.getRaceInfoVizTO(id, localeResolver.resolveLocale(request)));
		mav.setViewName("fragments/raceselectpage/raceinfo");
		mav.addObject("event", viewTO);
		return mav;
	}
	
	@GetMapping("events/warning")
	public ModelAndView getWarningMessageForRaceList(@RequestParam(name = "message",required = true) String paramValue, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", TemplateUtils.resolveMapForRaceListWarningMessage(paramValue, localeResolver.resolveLocale(request)));
		mav.setViewName(TemplateConstants.RESULT_MESSAGE);
		return mav;
	}
	

}
