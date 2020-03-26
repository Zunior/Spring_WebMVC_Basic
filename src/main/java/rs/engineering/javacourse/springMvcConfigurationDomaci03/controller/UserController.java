package rs.engineering.javacourse.springMvcConfigurationDomaci03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;
import rs.engineering.javacourse.springMvcConfigurationDomaci03.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService userService;

//	@ModelAttribute(name = "user")
//	public User User() {
//		return new User("-", "-", "-", "-");
//	}

//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	protected ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> users = userService.getAll();
		System.out.println("Izvadjeni korisnici");
		ModelAndView modelAndView = new ModelAndView("user/users");
		modelAndView.addObject("users", users);
		return modelAndView;
	}

//	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@GetMapping(value = "/add")
	protected ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("user/addUser");
		modelAndView.addObject("user", new User("-", "-", "-", "-"));
		request.setAttribute("info", "Atribut info: dodajte korisnika");
		return modelAndView;
	}

//	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping(value = "/save")
	protected ModelAndView save(@ModelAttribute(name = "user") User user) {
		userService.save(user);
		ModelAndView modelAndView = new ModelAndView("user/addUser");
		modelAndView.addObject("info", "Objekat info: korisnik je dodat");
		System.out.println(user);
		return modelAndView;
	}
	
	@PostMapping(value = "/delete")
	protected ModelAndView delete(@RequestParam(name = "id") Long id) {
		userService.delete(id);
		List<User> users = userService.getAll();
		ModelAndView modelAndView = new ModelAndView("user/users");
		modelAndView.addObject("info", "Objekat info: korisnik je dodat");
		modelAndView.addObject("users", users);
		return modelAndView;
	}

}
