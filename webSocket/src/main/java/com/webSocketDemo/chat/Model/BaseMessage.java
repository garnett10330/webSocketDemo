package com.webSocketDemo.chat.Model;

import java.util.Date;

import lombok.Data;

/**
 * 基本消息類型
 * Author :wei.chen
 */
@Data
public class BaseMessage {

	// 消息ID
	// @Id
	// private String id;

	// 消息類型
	private String type;

	// 消息内容
	private String content;

	// 發送者
	private String sender;

	// 接收者 类類型
	private String toType;

	// 接收者
	private String receiver;

	// 發送時間
	private Date date;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getToType() {
		return toType;
	}

	public void setToType(String toType) {
		this.toType = toType;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
