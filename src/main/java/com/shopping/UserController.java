package com.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.UserDao;
import com.shopping.domain.User;

@Controller
public class UserController {

	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;
	
	
	@PostMapping("/validate")
	public ModelAndView user(@RequestParam("email") String name,@RequestParam("password") String pass)
{
 ModelAndView mv=new ModelAndView("home");
 
  user=userDao.validate(name, pass);
   if(user==null)
   {
	   mv.addObject("Error","No such found User");
   }
   else
   {
	   mv.addObject("name","Welcome  "+user.getName());
   }
 
 return mv;
}
}
