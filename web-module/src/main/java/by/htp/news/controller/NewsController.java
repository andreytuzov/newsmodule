package by.htp.news.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import by.htp.news.controller.model.ArticleForm;
import by.htp.news.controller.model.ArticleFormConvertDomain;
import by.htp.news.domain.model.Article;
import by.htp.news.service.ArticleService;

@Controller
public class NewsController {

	@Autowired
	private ArticleService articleService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("articles", articleService.readAll());
		return "newslist";
	}
	
	@GetMapping("/modify")
	public String create(Model model) {
		ArticleForm articleForm = new ArticleForm();
		// Set up current date
		SimpleDateFormat format = new SimpleDateFormat(ArticleFormConvertDomain.DATE_FORMAT);
		String currentDate = format.format(new Date());
		articleForm.setDate(currentDate);
		model.addAttribute("article", articleForm);
		return "modifynews";
	}
	
	@GetMapping("/modify/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		System.out.println("id = " + id);
		Article article = articleService.read(id);
		ArticleForm articleForm = ArticleFormConvertDomain.fromActicle(article);
		model.addAttribute("article", articleForm);
		return "modifynews";
	}
	
	@PostMapping("/modify")
	public String modify(@Valid @ModelAttribute("article") ArticleForm articleForm, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "modifynews";
		}
		Article article = ArticleFormConvertDomain.toArticle(articleForm);
		articleService.modify(article);
		return "redirect:view/" + article.getId();
	}
	
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		model.addAttribute("article", articleService.read(id));
		return "newsview";
	}

	@PostMapping(path = "/delete", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String delete(@RequestParam("id") int id) {
		articleService.delete(id);
		return "Статья с id = " + id + " была успешно удалена";
	}

	@PostMapping(path = "/deletelist", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String deleteList(@RequestParam("stringIDs") String stringIDs) {
		articleService.deleteList(stringIDs);
		return "Статьи с id = " + stringIDs + " были успешно удалены";
	}

}
