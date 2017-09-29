package by.htp.news.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.news.dao.CommentDAO;
import by.htp.news.domain.model.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void modify(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(comment);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Comment comment = session.get(Comment.class, id);
		session.delete(comment);
	}

	@Override
	public List<Comment> readByArticleId(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Comment> comments = session.createQuery("FROM Comment c WHERE c.article = '" + id + "' ORDER BY c.date DESC", Comment.class).list();
		return comments;
	}

}
