package com.webSocketDemo.mongo.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.webSocketDemo.mongo.model.User;

/**
 * UserService使用者邏輯
 * Author :wei.chen
 */
@Service
public class UserService {

	private final ConcurrentHashMap<String, User> users;

	public UserService() {
		users = new ConcurrentHashMap<>();
	}

	public boolean addUser(User user) {
		boolean isExist = users.containsKey(user.getUsername());
		if (isExist) {
			return false;
		}
		users.put(user.getUsername(), user);
		return true;
	}

	public User getByUsername(String username) {
		return users.get(username);
	}

}
