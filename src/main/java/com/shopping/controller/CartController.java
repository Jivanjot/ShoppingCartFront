package com.shopping.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CartDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.SupplierDao;
import com.shopping.domain.Cart;
import com.shopping.domain.Product;
import com.shopping.domain.Supplier;
import com.shopping.mail.Mailer;

@Controller
public class CartController {
	@Autowired
	private Cart cart;
	@Autowired
	private CartDao cartDao;
	@Autowired
	HttpSession httpSession;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private Product product;
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierDao;

	private static String rootPath = "resources" + File.separator + "images" + File.separator + "ShoppingCartImages"
			+ File.separator;

	Logger log = LoggerFactory.getLogger(CartController.class);

	@PostMapping("/addcart")
	public ModelAndView addcart(@RequestParam("name") String productName, @RequestParam("price") int price,
			@RequestParam("quantity") int quantity, @RequestParam("id") String productId) {
		log.debug("starting of addcart of CartController");
		ModelAndView mv = new ModelAndView("home");
		String email = (String) httpSession.getAttribute("loggedInUser");
		if (email != null) {

			cart.setEmail(email);
			cart.setPrice(price);
			cart.setQuantity(quantity);
			cart.setProductname(productName);
			cart.setProductId(productId);
			Product product = productDao.select(productId);
			String supplierId = product.getSupplierId();
			cart.setSupplierId(supplierId);
			cart.setStatus();
			boolean a = cartDao.save(cart);
			if (a == true) {
				mv.addObject("addcartmessage", "saving to cart successfull");
				httpSession.getAttribute("loggedInUser");
				List<Cart> size = cartDao.getAll1(email, 'N');
				httpSession.setAttribute("size", size.size());
			} else {
				mv.addObject("addcartmessage", "not saved to cart");
			}
		} else {
			mv.addObject("addcartmessage", "Firstly login with your id");
		}
		log.debug("ending of addcart of CartController");
		return mv;
	}

	@GetMapping("/mycart")
	public ModelAndView myCart() {
		log.debug("starting of myCart of CartController");
		ModelAndView mv = new ModelAndView("home");
		String email = (String) httpSession.getAttribute("loggedInUser");
		if (email == null) {
			mv.addObject("addcartmessage", "Firstly login with your id");
			return mv;

		}
		mv.addObject("uploadPhotoPath", rootPath);
		List<Cart> carts = cartDao.getAll1(email, 'N');
		mv.addObject("carts", carts);
		mv.addObject("isUserClickedCart", true);
		log.debug("ending of mycart of CartController");
		return mv;
	}

	@GetMapping("/orderplaced")
	public ModelAndView orderPlaced() {
		log.debug("starting of orderPlaced of CartController");
		ModelAndView mv = new ModelAndView("home");
		String email = (String) httpSession.getAttribute("loggedInUser");
		if (email == null) {
			mv.addObject("addcartmessage", "Firstly login with your id");
			return mv;

		}
		mv.addObject("uploadPhotoPath", rootPath);
		List<Cart> carts = cartDao.getAll1(email, 'O');
		mv.addObject("carts", carts);
		mv.addObject("isUserClickedOrderPlaced", true);
		log.debug("ending of orderPlaced of CartController");
		return mv;
	}

	@GetMapping("/deleteitem{item}{email}")
	public ModelAndView deleteitem(@RequestParam("item") int id, @RequestParam("email") String email) {
		log.debug("starting of deleteitem of CartController");
		ModelAndView mv = new ModelAndView("redirect:/mycart");
		boolean a = cartDao.delete(id);
		List<Cart> size = cartDao.getAll1(email, 'N');
		httpSession.setAttribute("size", size.size());
		log.debug("ending of deleteitem of CartController");
		return mv;
	}

	@PostMapping("/placeorder")
	public ModelAndView placeorder() {
		log.debug("starting of placeorder of CartController");
		List<String> b = new ArrayList();
		String first = "";
		String productName = "";
		String address = (String) httpSession.getAttribute("loggedInUserAddress");

		ModelAndView mv = new ModelAndView("home");
		String email = (String) httpSession.getAttribute("loggedInUser");
		String name = (String) httpSession.getAttribute("name");
		List<Supplier> suppliers = supplierDao.getAll();
		for (int i = 0; i < suppliers.size(); i++) {
			b.add(suppliers.get(i).getId().toString());

		}

		for (int j = 0; j < b.size(); j++) {
			String supplierId = b.get(j);
			List<Cart> orders = cartDao.getAll2(email, 'N', supplierId);

			for (int k = 0; k < orders.size(); k++) {
				productName = orders.get(k).getProductname().toString();
				first = first + "" + productName + ",";

			}
			Supplier supplier = supplierDao.select(b.get(j));
			String to = supplier.getEmail();
			Mailer.send("singh.jivan0390@gmail.com", "9872172827", to, "Order", "Hello!! " + supplier.getName()
					+ ", You have to deliver products " + first + " to " + name + "  and address is " + address);
			first = "";
			productName = "";

		}

		boolean a = cartDao.update1(email);
		if (a == true) {

			List<Cart> size = cartDao.getAll1(email, 'N');
			httpSession.setAttribute("size", size.size());
			List<Cart> size1 = cartDao.getAll1(email, 'O');
			httpSession.setAttribute("size1", size1.size());
			mv.addObject("enablemodal", true);

		} else {
			mv.addObject("error1", "Sorry something went wrong");
		}
		log.debug("ending of placeorder of CartController");
		return mv;
	}

}
