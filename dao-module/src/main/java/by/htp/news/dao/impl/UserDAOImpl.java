package by.htp.news.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.news.dao.UserDAO;
import by.htp.news.domain.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User readByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNamedQuery("User.findByName", User.class)
				.setParameter("name", name).getSingleResult();
	}
	
}
