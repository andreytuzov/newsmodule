package by.htp.news.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;

import by.htp.news.controller.model.ArticleForm;
import by.htp.news.controller.model.CommentForm;
import by.htp.news.controller.resource.PropManager;
import by.htp.news.controller.utils.ArticleFormConvertDomain;
import by.htp.news.domain.model.Article;
import by.htp.news.service.ArticleService;

/**
 * Контроллер обработки запросов для работы с новостями
 * 
 * @author User
 *
 */
@Controller
public class NewsController {

	@Autowired
	private ArticleService articleService;

	/**
	 * Метод предварительной обработки параметров формы при валидации
	 * 
	 * @param binder
	 *            объект для регистрации обработчиков параметров формы
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * Отображение списка новостей
	 * 
	 * @param model
	 *            объект передачи параметров представлению
	 * @return представление
	 */
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("articles", articleService.readAll());
		return PropManager.getProperty("page.name.list");
	}

	
	/**
	 * Форма для редактирование и добавления новости
	 * 
	 * @param id
	 *            идентификатор новости
	 * @param model
	 *            объект передачи параметров представлению
	 * @return представление
	 */
	@GetMapping("/modify/{id}")
	public String createOrUpdate(@PathVariable("id") int id, Model model) {
		ArticleForm articleForm = null;
		if (id == 0) {
			articleForm = new ArticleForm();
			// Set up current date
			SimpleDateFormat format = new SimpleDateFormat(ArticleFormConvertDomain.DATE_FORMAT);
			String currentDate = format.format(new Date());
			articleForm.setDate(currentDate);
		} else {
			Article article = articleService.read(id);
			if (article == null) {
				model.addAttribute("errCode", HttpStatus.NO_CONTENT.value());
				return PropManager.getProperty("page.name.error");
			}
			articleForm = ArticleFormConvertDomain.fromActicle(article);
		}
		model.addAttribute("article", articleForm);
		return PropManager.getProperty("page.name.modify");
	}

	/**
	 * Запрос для добавления новой новости
	 * 
	 * @param articleForm
	 *            модель взаимодействия с формой
	 * @param bindingResult
	 *            содержит результат проверки валидации
	 * @param model
	 *            объект передачи параметров представлению
	 * @return представление
	 */
	@PostMapping("/modify/{id}")
	public String createOrUpdateProcess(@Valid @ModelAttribute("article") ArticleForm articleForm, BindingResult bindingResult,
			Model model, @PathVariable(name = "id", required = false) int id) {
		if (bindingResult.hasErrors()) {
			return "modifynews";
		}
		Article article = ArticleFormConvertDomain.toArticle(articleForm);
		articleService.modify(article);
		return "redirect:/view/" + article.getId();
	}

	/**
	 * Подробный просмотр новости
	 * 
	 * @param id
	 *            идентификатор новости
	 * @param model
	 *            объект передачи параметров представлению
	 * @return представление
	 */
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		Article article = articleService.read(id);
		if (article == null) {
			model.addAttribute("errCode", HttpStatus.NO_CONTENT.value());
			return PropManager.getProperty("page.name.error");
		}
		model.addAttribute("article", article);
		model.addAttribute("comments", article.getComments());
		CommentForm commentForm = new CommentForm();
		commentForm.setArticleId(article.getId());
		model.addAttribute("commentForm", commentForm);
		return PropManager.getProperty("page.name.view");
	}

	/**
	 * Удаление одной новости
	 * 
	 * @param id
	 *            идентификатор новости
	 */
	@PostMapping(path = "/delete")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@RequestParam("id") int id) {
		articleService.delete(id);
	}

	/**
	 * Удаление нескольких новостей
	 * 
	 * @param stringIDs
	 *            идентификаторы новостей
	 */
	@PostMapping(path = "/deletelist")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteList(@RequestParam("stringIDs") String stringIDs) {
		articleService.deleteList(stringIDs);
	}

}
