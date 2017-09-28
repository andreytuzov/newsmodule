package by.htp.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import by.htp.news.controller.resource.PropManager;

@Controller
public class RegistrationController {
	
	@GetMapping("/login") 
	public String signup() {
		return PropManager.getProperty("page.name.login");
	}
}
