package by.irun.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import by.irun.locale.AppLocales;
import by.irun.persistance.daoimpl.DataProvider;
import by.irun.service.impl.DataService;
import by.irun.viz.to.ClubInfoTO;
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
		List<RaceInfoTO>list = data.getFullRaceList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("results", data.getRaceResult(list.get(0).getRaceId()));
		mav.addObject("races",list);
	    mav.setViewName("raceresult");
	    return mav;
	}
	
	@GetMapping("/runner")
	public ModelAndView getRunnerPage(@RequestParam (value = "id", required = true) long id){
		ModelAndView mav = new ModelAndView();
		RunnerInfoTO to = dataService.getRunnerInfoTO(id);
		mav.addObject("runner",to);
	    mav.setViewName("runnerInfo");
	    return mav;
	}
	
	@GetMapping("/clubs")
	public ModelAndView getClubPage(@RequestParam (value = "id", required = true) long id){
		ModelAndView mav = new ModelAndView();
		ClubInfoTO to = dataService.getClubInfoTO(26, AppLocales.RU);
		mav.addObject("runner",to);
	    mav.setViewName("runnerInfo");
	    return mav;
	}

}
