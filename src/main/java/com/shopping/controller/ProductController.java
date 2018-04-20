package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.ProductDao;
import com.shopping.domain.Product;
import com.shopping.util.FileUtil;

@Controller
public class ProductController {
	// private static final String imageDirectory="ShoppingCartImages";

	@Autowired
	private Product product;
	@Autowired
	private ProductDao productDao;
	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	HttpSession httpSession;
	private static String rootPath ="resources/images/ShoppingCartImages/";


	@PostMapping("/productsave")
	public ModelAndView saveProduct(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") String price,
			@RequestParam("categoryId") String categoryId, @RequestParam("supplierId") String supplierId,
			@RequestParam("file") MultipartFile file) {
		log.debug("starting of saveProduct of ProductController");
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(Integer.parseInt(price));
		product.setCategoryId(categoryId);
		product.setSupplierId(supplierId);

		try {
			productDao.save(product);
			mv.addObject("success", "Product added");
			if (FileUtil.copyFile(file, id + ".PNG")) {
				mv.addObject("uploadphoto", "upload image successfull");
			} else {
				mv.addObject("uploadphoto", "upload image not possible");
			}
			log.debug("ending of saveProduct of ProductController");
			return mv;
		} catch (Exception e) {
			mv.addObject("error1", "Product not added");
			return mv;
		}

	}

	@GetMapping("/productupdate{id}")
	public ModelAndView updateProduct(@RequestParam("id") String id) {
		log.debug("starting of updateProduct of ProductController");
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		product = productDao.select(id);
		httpSession.setAttribute("selectedproduct", product);
		log.debug("ending of updateProduct of ProductController");
		return mv;

	}

	@GetMapping("/productselect{id}")
	public ModelAndView selectProduct(@RequestParam("id") String id) {
		log.debug("starting of selectProduct of ProductController");
		ModelAndView mv = new ModelAndView("home");
		product = productDao.select(id);
	/*	 List<Product> products= productDao.getAll();

		  httpSession.setAttribute("products", products);*/
		mv.addObject("clickedselecteditem", true);
		mv.addObject("selectedproduct", product);
		

		mv.addObject("uploadPhotoPath", rootPath );
		log.debug("ending of selectProduct of ProductController");
		return mv;
	}

	@GetMapping("/productdelete{id}")
	public ModelAndView deleteProduct(@RequestParam("id") String id) {
		log.debug("starting of deleteProduct of ProductController");
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		if (productDao.delete(id) == true) {
			mv.addObject(" success", "Product deleted");
			log.debug("ending of deleteProduct of ProductController");
			return mv;
		}

		else {
			mv.addObject("error1", "Product not deleted");
			return mv;
		}
	}

	@GetMapping("/productgetall")
	public ModelAndView getAllProduct(@RequestParam("id") String id) {
		log.debug("starting of getAllProduct of ProductController");
		ModelAndView mv = new ModelAndView("home");
		List<Product> c = productDao.getAll();
		if (c == null) {
			mv.addObject("error1", "Error");
			return mv;

		} else {
			log.debug("ending of getAllProduct of ProductController");
			mv.addObject("success", c);
			return mv;
		}

	}

}