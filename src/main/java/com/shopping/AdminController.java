package com.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@GetMapping("/managecategories")
	public ModelAndView  manageCategory()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedCategory", true);
		return mv;
		
	}
	
	@GetMapping("/managesuppliers")
	public ModelAndView  managesupplier()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedSupplier", true);
		return mv;
		
	}
	
	@GetMapping("/manageproducts")
	public ModelAndView  manageproduct()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedProduct", true);
		return mv;
		
	}
}
