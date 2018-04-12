package com.webSocketDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.webSocketDemo.model.User;
import com.webSocketDemo.model.UserPrincipal;
import com.webSocketDemo.service.RelationService;

/**
 * 登入相關controller
 * Author :wei.chen
 */
@Controller
public class PageController {

	@Autowired
	private RelationService relationService;

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/chat")
	public String chat(@AuthenticationPrincipal UserPrincipal userPrincipal, Model model) {
		model.addAttribute("user", userPrincipal);
		String username = userPrincipal.getUsername();
		List<User> friends = relationService.listFriends(username);
		model.addAttribute("friends", friends);
		return "chat";
	}

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}

}
