package com.webSocketDemo.chat.controller;

import com.webSocketDemo.chat.Model.BaseMessage;
import com.webSocketDemo.chat.Model.ChatMessage;
import com.webSocketDemo.mongo.model.User;
import com.webSocketDemo.mongo.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 聊天controller
 * Author :wei.chen
 */
@Controller
public class ChatController {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	private UserService userService;
    //群組聊天
	@MessageMapping("/all")
	public void all(Principal principal, String message) {
		ChatMessage chatMessage = createMessage(principal.getName(), message);
		template.convertAndSend("/topic/notice", JSON.toJSONString(chatMessage));
	}
    //1對1聊天
	@MessageMapping("/chat")
	public void chat(Principal principal, String message) {
		BaseMessage baseMessage = JSON.parseObject(message, BaseMessage.class);
		baseMessage.setSender(principal.getName());
		this.send(baseMessage);
	}

	private void send(BaseMessage message) {
		message.setDate(new Date());
		ChatMessage chatMessage = createMessage(message.getSender(), message.getContent());
		template.convertAndSendToUser(message.getReceiver(), "/topic/chat", JSON.toJSONString(chatMessage));
	}

	private ChatMessage createMessage(String username, String message) {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setUsername(username);
		User user = userService.getByUsername(username);
		chatMessage.setAvatar(user.getAvatar());
		chatMessage.setNickname(user.getNickname());
		chatMessage.setContent(message);
		chatMessage.setSendTime(simpleDateFormat.format(new Date()));
		return chatMessage;
	}

}
