package by.htp.news.service;

import java.util.List;

import javax.transaction.Transactional;

import by.htp.news.domain.model.Article;

@Transactional
public interface ArticleService {
	Article read(int id);

	List<Article> readAll();

	void modify(Article article);

	void delete(int id);
	
	void deleteList(String stringIDs);
}
