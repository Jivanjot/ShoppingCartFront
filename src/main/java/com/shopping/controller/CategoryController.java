package com.shopping.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CategoryDao;
import com.shopping.domain.Category;

@Controller
public class CategoryController {
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	HttpSession httpSession;
	Logger log = LoggerFactory.getLogger(CategoryController.class);

	@PostMapping("/categorysave")
	public ModelAndView saveCategory(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description)
	{

		log.debug("starting of saveCategory of CategoryController");
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		try {
			categoryDao.save(category);
			mv.addObject("success", "Category added");
			log.debug("ending of saveCategory of CategoryController");
			return mv;
		} catch (Exception e) {
			mv.addObject("error1", "Category not added");
			return mv;
		}
	}

	@GetMapping("/categoryupdate{id}")
	public ModelAndView updateCategory(@RequestParam("id") String id)
	{
		log.debug("starting of updateCategory of CategoryController");
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		Category selectedcategory = categoryDao.select(id);
		httpSession.setAttribute("selectedcategory", selectedcategory);
		log.debug("ending of updateCategory of CategoryController");
		return mv;

	}

	@GetMapping("/categoryselect")
	public ModelAndView selectCategory(@RequestParam("id") String id) 
	{
		log.debug("starting of selectCategory of CategoryController");
		ModelAndView mv = new ModelAndView("home");
		category = categoryDao.select(id);
		mv.addObject("category", category);
		log.debug("ending of selectCategory of CategoryController");
		return mv;
	}

	@GetMapping("/categorydelete{id}")
	public ModelAndView deleteCategory(@RequestParam("id") String id) 
	{
		log.debug("starting of deleteCategory of CategoryController");
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		if (categoryDao.delete(id) == true) {
			mv.addObject("success", "Category deleted");
			log.debug("ending of deleteCategory of CategoryController");
			return mv;
		}

		else {
			mv.addObject("error1", "Category not deleted");
			return mv;
		}
	}

}