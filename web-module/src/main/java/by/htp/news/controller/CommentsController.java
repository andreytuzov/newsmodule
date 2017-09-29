package by.htp.news.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.news.domain.model.Comment;
import by.htp.news.service.ArticleService;
import by.htp.news.service.CommentService;
import by.htp.news.service.UserService;

/**
 * Контроллер для обработки запросов работы с комментариями
 *
 */
@Controller
@RequestMapping("/view")
public class CommentsController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * Обработка запросов на добавление комментария
	 * 
	 * @param text текст комментария
	 * @param articleId идентификатор статьи
	 * @return представление
	 */
	@PostMapping("/comments/create")
	public String create(@RequestParam("text") String text, @RequestParam("articleId") int articleId) {
		Comment comment = new Comment();
		comment.setText(text);
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
	 * @param id идентификатор комментария
	 * @param articleId идентификатор статьи
	 * @return представление
	 */
	@PostMapping("/comments/delete")
	public String delete(@RequestParam("id") int id, @RequestParam("articleId") int articleId) {
		commentService.delete(id);
		return "redirect:/view/" + articleId;
	}	
}
