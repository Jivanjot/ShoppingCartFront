package com.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.UserDao;
import com.shopping.domain.User;
import com.shopping.mail.Mailer;
import com.shopping.mail.Validate;



@Controller
public class RegisterController {
	@Autowired
	private  User user;
	@Autowired
	private UserDao userDao;
	
	Logger log=LoggerFactory.getLogger(RegisterController.class);

	
	

	@PostMapping("/register")
	public ModelAndView register(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("mobile") String mobile,@RequestParam("pass") String pass,@RequestParam("address") String address)   

	{
		log.debug("starting of register of RegisterController");
	  	try {
			ModelAndView mv=new ModelAndView("home");
			user.setEmail(email);
			user.setName(name);
			user.setMobile(mobile);
			user.setPassword(pass);
			user.setRole('C');
			user.setRegisterdate();
			user.setAddress(address);
     boolean validate=  Validate.validateMail(email);

     if(validate==true)
			{
	 
	    if(Mailer.send("mailfromshoppingcart@gmail.com", "P@5sword", email, "Registration", "Welcome to Shopping Cart, your registration is successfull in shopping cart site")==true)
	    {
			boolean a=userDao.save(user);
			
			if(a==true)
			{
				mv.addObject("success","User saved successfull");
				
			}
			else
			{
				mv.addObject("error1","Not Registered");
			}
			}
			else
			{
				mv.addObject("notExistEmail","true");
			}
	    }
	    else
	    {
	    	mv.addObject("inValidateEmail", "true");
	    }
     log.debug("ending of register of RegisterController");
			return mv;
		} 
			catch (Exception e) {
		       ModelAndView mv=new ModelAndView("home");
		       mv.addObject("error1","Try some different EmailId");
		       return mv;
			
			}
	
	  	
	
	
	}}
