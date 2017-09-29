package by.htp.news.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.news.dao.UserDAO;
import by.htp.news.domain.model.User;
import by.htp.news.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User readByName(String name) {
		return userDAO.readByName(name);
	}
	
}
