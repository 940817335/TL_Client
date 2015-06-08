package com.tl.view;

public class ChatEntity {
	private int id;//头像
	private String content;
	private String time;
	private String name;
	private boolean isLeft;//是否为收到的消息，在左边
	
  public ChatEntity(int avatar,String content,String time,boolean isLeft,String name){
		this.id = avatar;//化身，昵称
		this.content = content;
		this.time = time;
		this.isLeft = isLeft;
		this.name=name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setAvatar(int id) {
		this.id= id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public boolean isLeft() {
		return isLeft;
	}
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

}
