package by.htp.news.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.news.controller.model.CommentForm;
import by.htp.news.controller.resource.PropManager;
import by.htp.news.domain.model.Article;
import by.htp.news.domain.model.Comment;
import by.htp.news.service.ArticleService;
import by.htp.news.service.CommentService;
import by.htp.news.service.UserService;

/**
 * Контроллер для обработки запросов работы с комментариями
 *
 */
@Controller
public class CommentsController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserService userService;

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
	 * Обработка запросов на добавление комментария
	 * 
	 * @param commentForm
	 *            объект взаимодействия с формой
	 * @param bindingResult
	 *            объект проверки валидации
	 * @param model
	 *            для передачи данных представлению
	 * @return представление
	 */
	@PostMapping("/view/{id}")
	public String create(@Valid @ModelAttribute("commentForm") CommentForm commentForm, BindingResult bindingResult,
			Model model) {
		int articleId = commentForm.getArticleId();
		if (bindingResult.hasErrors()) {
			Article article = articleService.read(articleId);
			model.addAttribute("article", article);
			model.addAttribute("comments", article.getComments());
			return PropManager.getProperty("page.name.view");
		}
		Comment comment = new Comment();
		comment.setText(commentForm.getText());
		comment.setDate(new Date());
		comment.setArticle(articleService.read(articleId));
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		comment.setUser(userService.readByName(name));
		commentService.modify(comment);
		return "redirect:/view/" + articleId;
	}


	/**
	 * Обработка запросов на удаление комментария
	 * 
	 * @param id
	 *            идентификатор комментария
	 * @param articleId
	 *            идентификатор статьи
	 * @return представление
	 */
	@PostMapping("/view/comments/delete")
	public String delete(@RequestParam("id") int id, @RequestParam("articleId") int articleId) {
		commentService.delete(id);
		return "redirect:/view/" + articleId;
	}
}
