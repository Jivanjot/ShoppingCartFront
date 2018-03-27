package com.shopping;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CategoryDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.SupplierDao;
import com.shopping.domain.Category;
import com.shopping.domain.Product;
import com.shopping.domain.Supplier;

@Controller
public class ProductController {
	@Autowired
	private Product product;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Category category;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierDao;
@Autowired
HttpSession httpSession;
	
	@PostMapping("/productsave")
	public ModelAndView saveProduct(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("price") String price,@RequestParam("categoryId") String categoryId,@RequestParam("supplierId") String supplierId) {
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(Integer.parseInt(price));
	    product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);
		
		if (productDao.save(product) == true) {
			mv.addObject("success", "Product added");
			return mv;
		} else {
			mv.addObject("error1", "Product not added");
			return mv;
		}

	}

	@GetMapping("/productupdate{id}")
	public ModelAndView updateProduct(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		product=productDao.select(id);	
		httpSession.setAttribute("selectedproduct",product);
		return mv;
		
	}

	@GetMapping("/productselect")
	public ModelAndView selectProduct(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		product = productDao.select(id);
		mv.addObject("product", product);
		return mv;
	}

	@GetMapping("/productdelete{id}")
	public ModelAndView deleteProduct(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		if (productDao.delete(id) == true) {
			mv.addObject("success", "Product deleted");
			return mv;
		}

		else {
			mv.addObject("error1", "Product not deleted");
			return mv;
		}
	}

	@GetMapping("/productgetall")
	public ModelAndView getAllProduct(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		List<Product> c = productDao.getAll();
		if (c == null) {
			mv.addObject("error1", "Error");
			return mv;

		} else {
			mv.addObject("success", c);
			return mv;
		}

	}

}