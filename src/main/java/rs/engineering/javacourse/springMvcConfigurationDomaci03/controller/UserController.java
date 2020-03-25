package rs.engineering.javacourse.springMvcConfigurationDomaci03.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;

@Controller
@RequestMapping(value = "/users")
public class UserController{

	@ModelAttribute(name = "user")
	public User User() {
		return new User("-", "-", "-", "-");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView home(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView("user/users");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	protected ModelAndView add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView("user/addUser");
		request.setAttribute("info", "info preko atributa");
		return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	protected ModelAndView save(@ModelAttribute(name = "user") User user) {
		ModelAndView modelAndView = new ModelAndView("user/addUser");
		modelAndView.addObject("info", "info preko objekta");
		System.out.println(user);
//		return "redirect:/user/add"
		return modelAndView;
	}
	
	
	
	
}
