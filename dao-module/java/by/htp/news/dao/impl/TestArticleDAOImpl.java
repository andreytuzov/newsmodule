package by.htp.news.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.news.dao.ArticleDAO;
import by.htp.news.domain.model.Article;

public class TestArticleDAOImpl {

	private static final Logger logger = Logger.getLogger(TestArticleDAOImpl.class);
	
	private static ArticleDAO articleDAO;
	
	@BeforeClass
	public static void createSessionFactory() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:news-spring-context.xml");
		articleDAO = context.getBean(ArticleDAO.class);
		context.close();
	}
	
	@Test
	public void createT001() {
		
	}
	
	@Test
	public void readT002() {
		int id = 1;
		
		String expectedTitle = "Уровень воды во Флориде поднялся на два метра";
		String expectedBrief = "Уровень воды на юго-западе американского штата Флорида поднялся на 2,1 метра за 90 минут. Об этом говорится в заявлении Национального центра по слежению за ураганами США.";
		String expectedContent = "Уровень воды на юго-западе американского штата Флорида поднялся на 2,1 метра за 90 минут. Об этом говорится в заявлении Национального центра по слежению за ураганами США. \\\"В районе города Нейплс уровень воды поднялся на 7 футов (2,1 метра) за последние 90 минут\\\", –отмечается в сообщении. Напомним, утром 10 сентября ураган Ирма, который признан самым мощным за последнее десятилетие, достиг территории Флориды. В настоящее время ураган ослаб до второй категории. Он движется на север со скоростью 6,7 метра в секунду.";
		Date expectedDate = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy.mm.dd");
		try {
			expectedDate = format.parse("2017.09.11");
		} catch (ParseException e) {
			logger.error("Error parsing date");
		}
		
		Article article = articleDAO.read(id);
		
		Assert.assertEquals(expectedTitle, article.getTitle());
		Assert.assertEquals(expectedBrief, article.getBrief());
		Assert.assertEquals(expectedContent, article.getContent());
		Assert.assertEquals(expectedDate, article.getDate());
	}
	
	@Test
	public void updateT003() {
		
	}
	
	@Test
	public void deleteT004() {
		
	}
	
}
