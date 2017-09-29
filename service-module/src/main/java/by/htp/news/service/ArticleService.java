package by.htp.news.service;

import java.util.List;

import by.htp.news.domain.model.Article;

public interface ArticleService {
	Article read(int id);

	List<Article> readAll();

	void modify(Article article);

	void delete(int id);
	
	void deleteList(String stringIDs);
}
