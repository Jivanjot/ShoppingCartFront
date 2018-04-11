package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CategoryDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.SupplierDao;
import com.shopping.domain.Category;
import com.shopping.domain.Product;
import com.shopping.domain.Supplier;

@Controller
public class AdminController {
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Product product;
	@Autowired
	private ProductDao productDao;

	@Autowired
	HttpSession httpSession;

	Logger log = LoggerFactory.getLogger(AdminController.class);

	@GetMapping("/managecategories")
	public ModelAndView manageCategory() {
		log.debug("starting of manageCategory function of AdminController");
		ModelAndView mv = new ModelAndView("home");
		String email = (String) httpSession.getAttribute("loggedInUser");
		if (email == null) {
			mv.addObject("addcartmessage", "Firstly login with your id");
			return mv;

		}

		mv.addObject("isAdminClickedCategory", true);
		List<Category> categories = categoryDao.getAll();
		httpSession.setAttribute("categories", categories);
		log.debug("ending of manageCategory of AdminController");
		return mv;

	}

	@GetMapping("/managesuppliers")
	public ModelAndView managesupplier() {
		log.debug("starting of manageSupplier of AdminController");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedSupplier", true);
		List<Supplier> suppliers = supplierDao.getAll();
		httpSession.setAttribute("suppliers", suppliers);
		log.debug("ending of manageSupplier of AdminController");
		return mv;

	}

	@GetMapping("/manageproducts")
	public ModelAndView manageproduct() {
		log.debug("starting of manageproduct of AdminController");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedProduct", true);
		List<Product> products = productDao.getAll();
		List<Supplier> suppliers = supplierDao.getAll();
		List<Category> categories = categoryDao.getAll();
		httpSession.setAttribute("categories", categories);

		httpSession.setAttribute("products", products);
		httpSession.setAttribute("suppliers", suppliers);
		log.debug("ending of manageproduct of AdminController");
		return mv;

	}
}
