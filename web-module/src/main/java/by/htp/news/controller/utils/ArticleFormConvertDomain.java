package by.htp.news.controller.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import by.htp.news.controller.model.ArticleForm;
import by.htp.news.domain.model.Article;

/**
 * Класс для конвертирования бизнес модели данных в модель формы и наоборот
 *
 */
public class ArticleFormConvertDomain {

	private static Logger logger = Logger.getLogger(ArticleFormConvertDomain.class);

	public static final String DATE_FORMAT = "MM/dd/yyyy";

	/**
	 * Метод для получения модели формы из бизнес модели данных
	 * 
	 * @param article
	 *            бизнес-модель данных
	 * @return модель формы
	 */
	public static ArticleForm fromActicle(Article article) {
		ArticleForm articleForm = new ArticleForm();
		articleForm.setId(article.getId());
		articleForm.setTitle(article.getTitle());
		articleForm.setBrief(article.getBrief());
		articleForm.setContent(article.getContent());

		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		String date = format.format(article.getDate());
		articleForm.setDate(date);

		return articleForm;
	}

	/**
	 * Метод для получения бизнес-модели данных из модели формы
	 * 
	 * @param articleForm
	 *            бизнес-модель данных
	 * @return модель формы
	 */
	public static Article toArticle(ArticleForm articleForm) {
		Article article = new Article();
		if (articleForm.getId() != 0) {
			article.setId(articleForm.getId());
		}
		article.setTitle(articleForm.getTitle());
		article.setBrief(articleForm.getBrief());
		article.setContent(articleForm.getContent());

		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		Date date = null;
		try {
			date = format.parse(articleForm.getDate());
		} catch (ParseException e) {
			logger.error("Error parsing date: " + e);
		}
		article.setDate(date);

		return article;
	}
}
