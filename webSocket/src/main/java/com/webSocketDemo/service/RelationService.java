package com.webSocketDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.webSocketDemo.model.User;
import lombok.extern.log4j.Log4j;

/**
 * 添加好友相關邏輯
 * Author :wei.chen
 */
@Service

public class RelationService {
	private static final Logger log = LoggerFactory.getLogger(RelationService.class);
	private final ConcurrentHashMap<String, List<String>> relations;

	public RelationService() {
		relations = new ConcurrentHashMap<>();
	}

	@Autowired
	private UserService userService;

	// 添加好友
	public boolean addFriend(String username, String friendName) {
		User user = userService.getByUsername(friendName);
		if (user == null) {
			log.info("用戶不存在：" + friendName);
			return false;
		}
		if (username.equals(friendName)) {
			log.info("不能加自己為好友：" + friendName);
			return false;
		}
		this.establishRelation(username, friendName);
		this.establishRelation(friendName, username);
		return true;

	}

	private void establishRelation(String username, String friendName) {
		List<String> friends = relations.get(username);
		if (friends == null) {
			friends = new ArrayList<>();
		}
		friends.add(friendName);
		relations.put(username, friends);
	}

	// 好友列表
	public List<User> listFriends(String username) {
		List<User> users = new ArrayList<>();
		List<String> friends = relations.get(username);
		if (friends != null) {
			for (String friend : friends) {
				User user = userService.getByUsername(friend);
				users.add(user);
			}
		}
		return users;
	}

}
