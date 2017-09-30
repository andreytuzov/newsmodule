package by.htp.news.dao;


import by.htp.news.domain.model.Comment;

public interface CommentDAO {	
	void modify(Comment comment);
	
	void delete(int id);
}
