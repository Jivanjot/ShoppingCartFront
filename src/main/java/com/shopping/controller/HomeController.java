package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CategoryDao;
import com.shopping.domain.Category;

@Controller
public class HomeController {
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private HttpSession httpSession1;
	
		//http://localhost:8080/ShoppingCartFrontEnd/
	@GetMapping("/")
	public ModelAndView  home()
	{
		
		ModelAndView mv = new ModelAndView("home");
		List<Category> categories=categoryDao.getAll();
		httpSession1.setAttribute("categories",categories);
		
		
	
		
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
@RequestMapping("/logout")
public ModelAndView logout()
{
	ModelAndView mv=new ModelAndView("home");
    httpSession.invalidate();
	return mv;
}
	
	
}
