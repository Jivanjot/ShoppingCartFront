package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.UserDao;
import com.shopping.domain.User;
import com.shopping.mail.*;


@Controller
public class ForgetPassword {

	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/forgotpassword")
	public ModelAndView forgetPassword()
	{
		ModelAndView mv=new ModelAndView("forgotpassword");
		return mv;
	}
	
	
	
 @GetMapping("/sendmail")
     public ModelAndView sendmail(@RequestParam("to") String to)
     {
	ModelAndView mv=new ModelAndView("home");
   user= userDao.select(to); 
	if(user!=null)
	{
		Mailer.send("singh.jivan0390@gmail.com","9872172827",to,"hello "+user.getName(),"How r u? .Your password is "+user.getPassword());  
       mv.addObject("mail","password send to your email");
	}
	else
	{

		mv.addObject("mail","No such found email");
	}
	
    
	return mv;
     }
     
}
