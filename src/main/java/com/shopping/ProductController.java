package com.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.ProductDao;
import com.shopping.domain.Product;

@Controller
public class ProductController {
	@Autowired
	private Product product;
	@Autowired
	private ProductDao productDao;

	@PostMapping("/product/save")
	public ModelAndView saveProduct(@RequestBody Product product) {
		ModelAndView mv = new ModelAndView("home");
		if (productDao.save(product) == true) {
			mv.addObject("success", "Product added");
			return mv;
		} else {
			mv.addObject("error", "Product not added");
			return mv;
		}

	}

	@PostMapping("/product/update")
	public ModelAndView updateProduct(@RequestBody Product product) {
		ModelAndView mv = new ModelAndView("home");
		if (productDao.update(product) == true) {
			mv.addObject("success", "Product updated");
			return mv;
		} else {
			mv.addObject("error", "Product not updated");
			return mv;
		}

	}

	@GetMapping("/product/select")
	public ModelAndView selectProduct(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		product = productDao.select(id);
		mv.addObject("product", product);
		return mv;
	}

	@GetMapping("/product/delete")
	public ModelAndView deleteProduct(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		if (productDao.delete(id) == true) {
			mv.addObject("success", "Product deleted");
			return mv;
		}

		else {
			mv.addObject("error1", "Product not deleted");
			return mv;
		}
	}

	@GetMapping("/product/getall")
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