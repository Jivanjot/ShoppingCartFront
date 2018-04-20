package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CartDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.UserDao;
import com.shopping.domain.Cart;
import com.shopping.domain.Product;
import com.shopping.domain.User;

@Controller
public class UserController {

	private static String rootPath ="resources/images/ShoppingCartImages/";

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;
	@Autowired
	HttpSession httpSession;
	@Autowired
	private Cart cart;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private Product product;
@Autowired
private ProductDao productDao;
	
@PostMapping("/validate")
	public ModelAndView user(@RequestParam("email") String name, @RequestParam("password") String pass) {
		log.debug("starting of user method in User Controller");
		ModelAndView mv = new ModelAndView("home");

		user = userDao.validate(name, pass);
		if (user == null) {
			mv.addObject("Error", "No such found User");
		} else {
			httpSession.setAttribute("welcomename", "Welcome  " + user.getName());
			httpSession.setAttribute("name", user.getName());
			httpSession.setAttribute("loggedInUser", user.getEmail());
			httpSession.setAttribute("loggedInUserAddress", user.getAddress());
			List<Cart> size = cartDao.getAll1(user.getEmail(), 'N');
			httpSession.setAttribute("size", size.size());
			List<Cart> size1 = cartDao.getAll1(user.getEmail(), 'O');
			httpSession.setAttribute("size1", size1.size());
			if (user.getRole() == 'A') {
				httpSession.setAttribute("isAdmin", true);

			}
			else {
			 List<Product> products= productDao.getAll();
			 httpSession.setAttribute("defaultImages",true);
				
			  httpSession.setAttribute("products", products);
			  
				httpSession.setAttribute("uploadPhotoPath", rootPath);
			}
		} 
		
		log.debug("ending of user of UserController");
		return mv;
	}
}
