package com.saran.spring.restful.restfulweb201.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.saran.spring.restful.restfulweb201.entity.User;

@Service
public class UserService {

	private static int idCounter = 4;

	private static List<User> users = new ArrayList<User>();

	static {
		users.add(new User(1, "Saran", new Date()));
		users.add(new User(2, "Rajee", new Date()));
		users.add(new User(3, "Nikitha", new Date()));
		users.add(new User(4, "Mithran", new Date()));
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUser(int id) {
		for (User user : users) {
			if (id == user.getId()) {
				return user;
			}
		}
		return null;
	}

	public User save(User user) {
		user.setId(++idCounter);
		users.add(user);
		return user;
	}

	public User deleteUser(int id) {
		ListIterator<User> iterator = users.listIterator();

		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}

		return null;
	}

}
