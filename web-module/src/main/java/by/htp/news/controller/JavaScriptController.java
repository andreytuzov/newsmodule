package by.htp.news.controller;

import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.news.controller.resource.PropManager;

@Controller
public class JavaScriptController {
	
	@RequestMapping("/jsl10n.js") 
	public String properties(Model model) {
		ResourceBundle bundle = ResourceBundle.getBundle("l10n.script");
		model.addAttribute("keys", bundle.getKeys());
		return PropManager.getProperty("page.name.script");
	}
	
}
