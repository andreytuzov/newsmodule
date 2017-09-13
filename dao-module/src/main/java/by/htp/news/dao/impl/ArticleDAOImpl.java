package by.htp.news.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.news.dao.ArticleDAO;
import by.htp.news.domain.model.Article;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	@Autowired
	private SessionFactory factory;

	public Article read(int id) {
		Session session = factory.getCurrentSession();
		Article article = session.get(Article.class, id);
		return article;
	}

	public List<Article> readAll() {
		Session session = factory.getCurrentSession();
		List<Article> articles = session.createQuery("FROM Article a ORDER BY a.date DESC", Article.class).list();
		return articles;
	}

	public void delete(int id) {
		Session session = factory.getCurrentSession();
		Article article = session.get(Article.class, id);
		session.delete(article);
	}

	@Override
	public void deleteList(String stringIDs) {
		Session session = factory.getCurrentSession();
		session.createQuery("DELETE FROM Article a WHERE a.id IN (" + stringIDs + ")").executeUpdate();
	}

	@Override
	public void modify(Article article) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(article);
		
	}

}
