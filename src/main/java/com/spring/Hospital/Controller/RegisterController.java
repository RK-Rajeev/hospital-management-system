package com.spring.Hospital.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.spring.Hospital.entity.User;
import com.spring.Hospital.service.UserService;

@Controller
public class RegisterController {

	// private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserService userService;

	@Autowired
	public RegisterController(
			UserService userService) {
		// this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userService = userService;

	}

	// Return registration form template
	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	// Process form input data
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user,
			BindingResult bindingResult, HttpServletRequest request) {

		// Lookup user in database by e-mail
		User userExists = userService.findByEmail(user.getEmail());

		System.out.println(userExists);

		if (userExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage",
					"Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
		} else { // new user so we create user and send confirmation e-mail

			user.setEnabled(true);
			user.setRole("ROLE_USER");

			userService.saveUser(user);

			modelAndView.addObject("confirmationMessage", "Register Successful " + user.getEmail());
			modelAndView.setViewName("register");
		}

		return modelAndView;
	}

}