package by.htp.news.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import by.htp.news.controller.resource.PropManager;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleError404(Model model) {
		model.addAttribute("errCode", HttpStatus.NOT_FOUND.value()); 
		return PropManager.getProperty("page.name.error");
	}
}
