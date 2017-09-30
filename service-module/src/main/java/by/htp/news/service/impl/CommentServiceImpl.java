package by.htp.news.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.news.dao.CommentDAO;
import by.htp.news.domain.model.Comment;
import by.htp.news.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	public void modify(Comment comment) {
		commentDAO.modify(comment);
	}

	@Override
	public void delete(int id) {
		commentDAO.delete(id);
	}

}
