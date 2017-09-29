package by.htp.news.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.news.dao.ArticleDAO;
import by.htp.news.domain.model.Article;
import by.htp.news.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public Article read(int id) {
		return articleDAO.read(id);
	}

	@Override
	public List<Article> readAll() {
		return articleDAO.readAll();
	}

	@Override
	public void delete(int id) {
		articleDAO.delete(id);
	}

	@Override
	public void deleteList(String stringIDs) {
		articleDAO.deleteList(stringIDs);
	}

	@Override
	public void modify(Article article) {
		articleDAO.modify(article);
	}

}
