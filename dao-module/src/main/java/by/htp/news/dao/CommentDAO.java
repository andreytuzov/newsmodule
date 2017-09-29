package by.htp.news.dao;

import java.util.List;

import by.htp.news.domain.model.Comment;

public interface CommentDAO {
	
	List<Comment> readByArticleId(int id);
	
	void modify(Comment comment);
	
	void delete(int id);
}
