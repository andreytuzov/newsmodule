package by.htp.news.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import by.htp.news.domain.model.Article;
import by.htp.news.service.ArticleService;

public class TestArticleServiceImpl {

	private static final Logger logger = Logger.getLogger(TestArticleServiceImpl.class);
	
	private static ClassPathXmlApplicationContext context;
	private static ArticleService articleService;
	
	@BeforeClass
	public static void createArticleSession() {
		context = new ClassPathXmlApplicationContext("classpath:service-module-context.xml");
		articleService = context.getBean(ArticleServiceImpl.class);
	}
	
	@AfterClass
	public static void closeContext() {
		context.close();
	}
	
	@Test
	public void CRUDTest() {
		int id;
		
		// Create and read
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		try {
			date = format.parse("2017.09.11");
		} catch (ParseException e) {
			logger.error("Error parsing date");
		}
		Article expectedArticle = new Article("test title", "test brief", "test content", date);
		articleService.modify(expectedArticle);
		
		id = expectedArticle.getId();
		Article realArticle = articleService.read(id);
		
		Assert.assertEquals(expectedArticle, realArticle);
		
		// Update
		expectedArticle.setTitle("test update title");
		expectedArticle.setBrief("test update brief");
		expectedArticle.setContent("test update content");
		articleService.modify(expectedArticle);
	
		realArticle = articleService.read(id);
		Assert.assertEquals(expectedArticle, realArticle);
		
		// Delete
		articleService.delete(id);
		
		realArticle = articleService.read(id);
		Assert.assertNull(realArticle);
	}
	
}
