package com.tl.view;

public class ChatEntity {
	private int id;//ͷ��
	private String content;
	private String time;
	private String name;
	private boolean isLeft;//�Ƿ�Ϊ�յ�����Ϣ�������
	
  public ChatEntity(int avatar,String content,String time,boolean isLeft,String name){
		this.id = avatar;//�����ǳ�
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
