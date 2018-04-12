package com.webSocketDemo.api;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webSocketDemo.config.sercurity.UserPrincipal;
import com.webSocketDemo.mongo.model.User;
import com.webSocketDemo.mongo.service.RelationService;
import com.webSocketDemo.mongo.service.UserService;

/**
 * 通用 API
 * Author :wei.chen
 */
@RestController
@RequestMapping("/api/common")
public class APIController {

	@Autowired
	private UserService userService;

	@Autowired
	private RelationService relationService;

	@PostMapping(value = "/register")
	public boolean register(User user) {
		user.setAvatar("/image/avatar/avatar" + new Random().nextInt(10) + ".jpg");
		user.setJoinTime(new Date());
		return userService.addUser(user);
	}

	@PostMapping("/add")
	public boolean add(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestParam String friend) {
		return relationService.addFriend(userPrincipal.getUsername(), friend);
	}

}
