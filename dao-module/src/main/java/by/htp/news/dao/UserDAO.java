package by.htp.news.dao;

import by.htp.news.domain.model.User;

public interface UserDAO {
	User readByName(String name);
}
