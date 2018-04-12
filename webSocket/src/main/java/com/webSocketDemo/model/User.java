package com.webSocketDemo.model;

import java.util.Date;
import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * userBean
 * Author :wei.chen
 */
@Data
@NoArgsConstructor
@ToString
public class User {

	// @Id
	// private String id;

	// 用戶名稱
	// @Indexed(unique = true)
	private String username;

	// 密碼
	private String password;

	// 暱稱
	private String nickname;

	// 大頭照
	private String avatar;

	// 登入時間
	private Date joinTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

//	public User(String username, String password, String nickname) {
//		this.username = username;
//		this.password = password;
//		this.nickname = nickname;
//		this.avatar = "/image/avatar/avatar" + new Random().nextInt(10) + ".jpg";
//		this.joinTime = new Date();
//	}

}
