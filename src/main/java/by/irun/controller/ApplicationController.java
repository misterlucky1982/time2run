package by.irun.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.irun.persistance.daoimpl.DataProvider;
import by.irun.viz.to.RaceInfoTO;

@RequestMapping("/app")
@Controller
public class ApplicationController {
	
	/*
	 * temporary added for front-end dev
	 */
	@Autowired
	private DataProvider data;
	
	@GetMapping("/test")
	public ModelAndView getResultListForRace() throws Exception{
		List<RaceInfoTO>list = data.getFullRaceList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("results", data.getRaceResult(list.get(0).getRaceId()));
		mav.addObject("races",list);
	    mav.setViewName("raceresult");
	    return mav;
	}

}
