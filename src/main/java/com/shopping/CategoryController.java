package com.shopping;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/categorysave/")
	public ModelAndView saveCategory(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("description") String description) {
		ModelAndView mv = new ModelAndView("home");
		     category.setId(id);
		     category.setName(name);
		     category.setDescription(description);
		
		if (categoryDao.save(category) == true) {
			mv.addObject("success", "Category added");
			List<Category> categories=categoryDao.getAll();
			httpSession.setAttribute("categories",categories);
			
			return mv;
		} else {
			mv.addObject("error1", "Category not added");
			return mv;
		}

	}

	@PostMapping("/categoryupdate")
	public ModelAndView updateCategory(@RequestBody Category category) {
		ModelAndView mv = new ModelAndView("home");
		if (categoryDao.update(category) == true) {
			mv.addObject("success", "Category updated");
			return mv;
		} else {
			mv.addObject("error", "Category not updated");
			return mv;
		}

	}

	@GetMapping("/categoryselect")
	public ModelAndView selectCategory(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		category = categoryDao.select(id);
		mv.addObject("category", category);
		return mv;
	}

	@GetMapping("/categorydelete")
	public ModelAndView deleteCategory(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		if (categoryDao.delete(id) == true) {
			mv.addObject("success", "Category deleted");
			return mv;
		}

		else {
			mv.addObject("error1", "Category not deleted");
			return mv;
		}
	}

	@GetMapping("/categorygetall")
	public ModelAndView getAllCategory(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		List<Category> c = categoryDao.getAll();
		if (c == null) {
			mv.addObject("error1", "Error");
			return mv;

		} else {
			mv.addObject("success", c);
			return mv;
		}

	}

}