package by.irun.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.irun.locale.AppLocales;
import by.irun.persistance.daoimpl.DataProvider;
import by.irun.service.impl.DataService;
import by.irun.viz.to.RaceInfoTO;
import by.irun.viz.to.RunnerInfoTO;

@RequestMapping("/app")
@Controller
public class ApplicationController {
	
	/*
	 * temporary added for front-end dev
	 */
	@Autowired
	private DataProvider data;
	
	@Autowired
	private DataService dataService;
	
	@GetMapping("/test")
	public ModelAndView getResultListForRace() throws Exception{
		RunnerInfoTO to = dataService.getRunnerInfoTO(89, AppLocales.BY);
		List<RaceInfoTO>list = data.getFullRaceList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("results", data.getRaceResult(list.get(0).getRaceId()));
		mav.addObject("races",list);
	    mav.setViewName("raceresult");
	    return mav;
	}

}
