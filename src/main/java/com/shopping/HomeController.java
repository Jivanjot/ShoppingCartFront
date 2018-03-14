package com.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//http://localhost:8080/ShoppingCartFrontEnd/
	@GetMapping("/")
	public ModelAndView  home()
	{
		
		ModelAndView mv = new ModelAndView("home");
		//add the data to mv
	
		
		return mv;
		
	}
	
	@GetMapping("/login")
	public ModelAndView  login()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		return mv;
		
	}
	
	@GetMapping("/register")
	public ModelAndView  registration()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		return mv;
		
	}

	
	
}
