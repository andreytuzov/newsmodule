package by.htp.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.news.dao.ArticleDAO;
import by.htp.news.domain.model.Article;
import by.htp.news.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDAO;

	@Override
	@Transactional
	public Article read(int id) {
		return articleDAO.read(id);
	}

	@Override
	@Transactional
	public List<Article> readAll() {
		return articleDAO.readAll();
	}

	@Override
	@Transactional
	public void delete(int id) {
		articleDAO.delete(id);
	}

	@Override
	@Transactional
	public void deleteList(String stringIDs) {
		articleDAO.deleteList(stringIDs);
	}

	@Override
	@Transactional
	public void modify(Article article) {
		articleDAO.modify(article);
	}

}
