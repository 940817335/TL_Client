package com.tl.common;

import java.io.Serializable;

import android.widget.ImageView;



public class Messages implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	String content;
	String sendTime;
	ImageView imageView;
	//Image image;
	MessagesType type;
	int fromUser;
	int toUser;
	
	public int getFromUser() {
		return fromUser;
	}
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	public int getToUser() {
		return toUser;
	}
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	
	

	public MessagesType getType() {
		return type;
	}
	public void setType(MessagesType type) {
		this.type = type;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setMessage(String content2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "Messages [content=" + content + ", sendTime=" + sendTime
				+ ", imageView=" + imageView + ", type=" + type + ", fromUser="
				+ fromUser + ", toUser=" + toUser + "]";
	}
	

}
