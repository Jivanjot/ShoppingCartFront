package com.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.UserDao;
import com.shopping.domain.User;



@Controller
public class RegisterController {
	@Autowired
	private  User user;
	@Autowired
	private UserDao userDao;
	
	

	@PostMapping("/register")
	public ModelAndView register(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("mobile") String mobile,@RequestParam("pass") String pass)   

	{
	  	try {
			ModelAndView mv=new ModelAndView("home");
			user.setEmail(email);
			user.setName(name);
			user.setMobile(mobile);
			user.setPassword(pass);
			user.setRole();
			user.setRegisterdate();
			boolean a=userDao.save(user);
			
			if(a==true)
			{
				mv.addObject("success","User saved successfull");
				
			}
			else
			{
				mv.addObject("error1","Not Registered");
			}
			
			return mv;
		} catch (Exception e) {
		       ModelAndView mv=new ModelAndView("home");
		       mv.addObject("error1",e.getCause().toString());
		       return mv;
			
			}
	}
	
	
}
