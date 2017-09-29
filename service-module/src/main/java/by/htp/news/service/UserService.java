package by.htp.news.service;

import by.htp.news.domain.model.User;

public interface UserService {
	User readByName(String name);
}
