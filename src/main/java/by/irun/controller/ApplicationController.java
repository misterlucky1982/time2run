package by.irun.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.irun.persistance.daoimpl.DataProvider;

@RequestMapping("/app")
@Controller
public class ApplicationController {
	
	/*
	 * temporary added for front-end dev
	 */
	@Autowired
	private DataProvider data;
	
	@GetMapping("/test")
	public ModelAndView getResultListForRace(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("results", data.getRaceResult(123));
	    mav.setViewName("raceresult");
	    return mav;
	}

}
