package com.shopping.controller;

import java.util.List;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.CartDao;
import com.shopping.domain.Cart;

@Controller

public class CartController {
@Autowired
private Cart cart;
@Autowired
private CartDao cartDao;
@Autowired
HttpSession httpSession;

    

@PostMapping("/addcart")
	public ModelAndView addcart(@RequestParam("name") String productName,@RequestParam("price") int price,@RequestParam("quantity") int quantity  )
	{
		ModelAndView mv=new ModelAndView("home");
		String email=(String) httpSession.getAttribute("loggedInUser");
		if(email!=null)
		{
			
		cart.setEmail(email);
		cart.setPrice(price);
		cart.setQuantity(quantity);
		cart.setProductname(productName);
		boolean a=cartDao.save(cart);
		if(a==true)
		{
			mv.addObject("addcartmessage","saving to cart successfull");
			httpSession.getAttribute("loggedInUser");  
			List<Cart> size=cartDao.getAll(email);
				httpSession.setAttribute("size",size.size());
		}
		else
		{
			mv.addObject("addcartmessage","not saved to cart");
		}
		}
		else
		{
			mv.addObject("addcartmessage","Firstly login with your id");
		}
		
		return mv;
	}
	
	@PostMapping("/getitems")
	public ModelAndView getitems()
	{
		ModelAndView mv=new  ModelAndView("home");
	String email=(String)	httpSession.getAttribute("loggedInUser");
	if(email!=null)
	{
		List<Cart> items=	cartDao.getAll(email);
mv.addObject("items", items);

	}
	else
	{
		mv.addObject("addcartmessage", "Firstly login with your id");
	}
		return mv;
	}
	
	@GetMapping("/mycart")
	public ModelAndView myCart()
	{
		ModelAndView mv=new ModelAndView("home");
		String email=(String)	httpSession.getAttribute("loggedInUser");
		if(email==null)
		{
			mv.addObject("addcartmessage", "Firstly login with your id");
			return mv;

		}
		List<Cart> carts=cartDao.getAll(email);
		mv.addObject("carts",carts);
		mv.addObject("isUserClickedCart",true);
		return mv;
	}
	
}
