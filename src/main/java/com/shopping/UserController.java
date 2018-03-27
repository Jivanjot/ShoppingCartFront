package com.shopping;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.UserDao;
import com.shopping.domain.User;

@Controller
public class UserController {
	
	private static final Logger log=LoggerFactory.getLogger(UserController.class);

	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;
	@Autowired
	HttpSession httpSession;
	
	
	@PostMapping("/validate")
	public ModelAndView user(@RequestParam("email") String name,@RequestParam("password") String pass)
{
    log.debug("starting of validate method in User Controller");
		ModelAndView mv=new ModelAndView("home");
 
  user=userDao.validate(name, pass);
   if(user==null)
   {
	   mv.addObject("Error","No such found User");
   }
   else
   {
	  mv.addObject("name","Welcome  "+user.getName());
	   if(user.getRole()=='A')
	   {
		   httpSession.setAttribute("isAdmin",true);
		  
	   }
	   
   }
 
 return mv;
}
}
