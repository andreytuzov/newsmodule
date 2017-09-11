package by.htp.news.controller.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.htp.news.domain.model.Article;


public class ArticleFormConvertDomain {
	
	private static final String DATE_FORMAT = "MM/dd/yyyy";

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

	public static Article toArticle(ArticleForm articleForm) {
		Article article = new Article();
		article.setId(articleForm.getId());
		article.setTitle(articleForm.getTitle());
		article.setBrief(articleForm.getBrief());
		article.setContent(articleForm.getContent());

		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		Date date = null;
		try {
			date = format.parse(articleForm.getDate());
		} catch (ParseException e) {
			System.err.println("Error parsing date: " + e);
		}
		article.setDate(date);

		return article;
	}
}
