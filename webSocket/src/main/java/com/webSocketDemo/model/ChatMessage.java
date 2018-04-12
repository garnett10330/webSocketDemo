package com.webSocketDemo.model;

import lombok.Data;

/**
 * 聊天類型
 * Author :wei.chen
 */
@Data
public class ChatMessage {

  private String username;

  private String nickname;

  private String avatar;

  private String content;

  private String sendTime;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getAvatar() {
	return avatar;
}

public void setAvatar(String avatar) {
	this.avatar = avatar;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getSendTime() {
	return sendTime;
}

public void setSendTime(String sendTime) {
	this.sendTime = sendTime;
}

}
