package com.shopping.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

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
@Autowired
HttpSession httpSession1;
	
	@GetMapping("/managecategories")
	public ModelAndView  manageCategory()
	{
		ModelAndView mv = new ModelAndView("home");
		String email=(String)httpSession.getAttribute("loggedInUser");
		if(email==null)
		{
			mv.addObject("addcartmessage","Firstly login with your id");
			return mv;
		}
		
		
		mv.addObject("isAdminClickedCategory", true);
		List<Category> categories=  categoryDao.getAll();
		httpSession1.setAttribute("categories",categories);
		
		return mv;
		
	}
	
	@GetMapping("/managesuppliers")
	public ModelAndView  managesupplier()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedSupplier", true);
		List<Supplier> suppliers=	supplierDao.getAll();
		httpSession1.setAttribute("suppliers",suppliers);
		return mv;
		
	}
	
	@GetMapping("/manageproducts")
	public ModelAndView  manageproduct()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedProduct", true);
		List<Product> products=	productDao.getAll();
		List<Supplier> suppliers=	supplierDao.getAll();
		List<Category> categories=  categoryDao.getAll();
		httpSession1.setAttribute("categories",categories);

		httpSession1.setAttribute("products",products);
		httpSession1.setAttribute("suppliers",suppliers);

		return mv;
		
	}
}
