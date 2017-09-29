package by.htp.news.service;

import java.util.List;

import by.htp.news.domain.model.Comment;

public interface CommentService {
	List<Comment> readByArticleId(int id);
	
	void modify(Comment comment);
	
	void delete(int id);
}
