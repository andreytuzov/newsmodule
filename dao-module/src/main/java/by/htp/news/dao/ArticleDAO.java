package by.htp.news.dao;

import java.util.List;

import by.htp.news.domain.model.Article;

public interface ArticleDAO {
	Article read(int id);

	List<Article> readAll();

	void modify(Article article);
	
	void delete(int id);
	
	void deleteList(String stringIDs);
}
