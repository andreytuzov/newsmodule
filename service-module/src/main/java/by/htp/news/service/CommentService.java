package by.htp.news.service;

import by.htp.news.domain.model.Comment;

public interface CommentService {	
	void modify(Comment comment);
	
	void delete(int id);
}
