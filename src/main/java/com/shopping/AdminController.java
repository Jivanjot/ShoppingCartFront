package com.shopping;

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
	
	@GetMapping("/managecategories")
	public ModelAndView  manageCategory()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedCategory", true);
		List<Category> categories=  categoryDao.getAll();
		httpSession.setAttribute("categories",categories);
		
		return mv;
		
	}
	
	@GetMapping("/managesuppliers")
	public ModelAndView  managesupplier()
	{
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedSupplier", true);
		List<Supplier> suppliers=	supplierDao.getAll();
		httpSession.setAttribute("suppliers",suppliers);
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
		httpSession.setAttribute("categories",categories);

		httpSession.setAttribute("products",products);
		httpSession.setAttribute("suppliers",suppliers);

		return mv;
		
	}
}
