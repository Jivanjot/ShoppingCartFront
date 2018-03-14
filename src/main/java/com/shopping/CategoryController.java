package com.shopping;

import java.util.List;

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

	@PostMapping("/category/save")
	public ModelAndView saveCategory(@RequestBody Category category) {
		ModelAndView mv = new ModelAndView("home");
		if (categoryDao.save(category) == true) {
			mv.addObject("success", "Category added");
			return mv;
		} else {
			mv.addObject("error", "Category not added");
			return mv;
		}

	}

	@PostMapping("/category/update")
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

	@GetMapping("/category/select")
	public ModelAndView selectCategory(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		category = categoryDao.select(id);
		mv.addObject("category", category);
		return mv;
	}

	@GetMapping("/category/delete")
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

	@GetMapping("/category/getall")
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