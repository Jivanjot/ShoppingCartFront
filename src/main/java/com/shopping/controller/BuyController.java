package com.shopping.controller;

import java.sql.Timestamp;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.InvoiceDao;
import com.shopping.dao.ProductDao;
import com.shopping.dao.UserDao;
import com.shopping.domain.Invoice;
import com.shopping.domain.Product;
import com.shopping.domain.User;

@Controller
public class BuyController {

	@Autowired
	HttpSession httpSession;
	@Autowired
	private Product product;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;
	@Autowired
	private Invoice invoice;
	@Autowired
	private InvoiceDao invoiceDao;

	@GetMapping("/buynow")
	public ModelAndView buynow(@RequestParam("id") String productId) {
		ModelAndView mv = new ModelAndView("payment");
		String email = (String) httpSession.getAttribute("loggedInUser");
	
			user = userDao.select(email);
			String address = user.getAddress();
			mv.addObject("address", address);
			product = productDao.select(productId);
			httpSession.setAttribute("productId", productId);
			int price = product.getPrice();
			mv.addObject("total", price);
			mv.addObject("payment", true);
			mv.addObject("name", (String) httpSession.getAttribute("name"));
			return mv;
		}

	

	@RequestMapping("/editaddress")
	public ModelAndView editAdress(@RequestParam("address1") String address1) {
		ModelAndView mv = new ModelAndView("payment");
		String email = (String) httpSession.getAttribute("loggedInUser");

		boolean a = userDao.update1(email, address1);

		if (a == true) {
			user = userDao.select(email);
			String address = user.getAddress();
			mv.addObject("address", address);
			
			
			mv.addObject("name", (String) httpSession.getAttribute("name"));

			return mv;
		}
		return mv;
	}

	@GetMapping("/paysuccess")
	public ModelAndView paysuccess() {

     ModelAndView mv=new ModelAndView("paysuccess");
     Random random=new Random();
     String name=(String)httpSession.getAttribute("name");
       String email=(String)httpSession.getAttribute("loggedInUser");     
     user=userDao.select(email);
       String address=user.getAddress();  
       mv.addObject("address",address);
      
       invoice.setProducts((String) httpSession.getAttribute("productId"));
      invoice.setOrderDate();
       invoice.setOrderId(random.nextInt(200));
       invoice.setInvoiceId(Math.abs(random.nextInt()));
       invoiceDao.save(invoice);
    long invoiceId=   invoice.getInvoiceId();
    mv.addObject("invoiceId",invoiceId);   
    int orderNo=invoice.getOrderId();
       mv.addObject("orderNo",orderNo);
       Timestamp date=  invoice.getOrderDate();
     mv.addObject("date",date);
   
       return mv;
	
	
	}

}
