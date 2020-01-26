package by.irun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/app")
@Controller
public class ApplicationController {
	
	@GetMapping("/test")
	public String getOrderList(){
		return "raceresult";
	}

}
