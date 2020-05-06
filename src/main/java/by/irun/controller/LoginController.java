package by.irun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/login")
@RestController
public class LoginController {

	@GetMapping(value="/")
	public ModelAndView loginPage(HttpServletRequest request,
			HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
}
