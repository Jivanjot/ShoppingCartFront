package com.shopping.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger log = LoggerFactory.getLogger(HomeController.class);

	private static String rootPath = "resources" + File.separator + "images" + File.separator + "ShoppingCartImages"
			+ File.separator;


	@GetMapping("/")
	public ModelAndView home() {
		log.debug("starting of home of HomeController");
    log.info("starting of home of HomeController");
		ModelAndView mv = new ModelAndView("home");
		List<Category> categories = categoryDao.getAll();
		httpSession.setAttribute("categories", categories);
		httpSession.setAttribute("uploadPhotoPath", rootPath);

		log.debug("ending of home of HomeController");

		return mv;

	}

	@GetMapping("/login")
	public ModelAndView login() {
		log.debug("starting of login of HomeController");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		log.debug(" ending of login of HomeController");
		return mv;

	}

	@GetMapping("/register")
	public ModelAndView registration() {
		log.debug("starting of registration of HomeController");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		log.debug("ending of registration of HomeController");
		return mv;

	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		log.debug("starting of logout of HomeController");
		ModelAndView mv = new ModelAndView("home");
		httpSession.invalidate();
		List<Category> categories = categoryDao.getAll();
		httpSession.setAttribute("categories", categories);
		log.debug("ending of logout of HomeController");
		return mv;
	}

}
