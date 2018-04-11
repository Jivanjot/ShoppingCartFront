package com.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.UserDao;
import com.shopping.domain.User;
import com.shopping.mail.Mailer;

@Controller
public class ForgetPassword {

	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;

	Logger log = LoggerFactory.getLogger(ForgetPassword.class);

	@RequestMapping("/forgotpassword")
	public ModelAndView forgetPassword() {
		log.debug("starting of forgetPassword of ForgetController");
		ModelAndView mv = new ModelAndView("forgotpassword");
		log.debug("ending of forgetPassword of ForgetController");
		return mv;
	}

	@GetMapping("/sendmail")
	public ModelAndView sendmail(@RequestParam("to") String to) {
		log.debug("starting of sendmail of ForgetController");
		ModelAndView mv = new ModelAndView("home");
		user = userDao.select(to);
		if (user != null) {
			Mailer.send("mailfromshoppingcart@gmail.com", "P@5sword", to, "hello " + user.getName(),
					"How r u? .Your password is " + user.getPassword());
			mv.addObject("mail", "password send to your email");
		} else {

			mv.addObject("mail", "No such found email");
		}

		log.debug("ending of sendmail of ForgetController");
		return mv;
	}

}
