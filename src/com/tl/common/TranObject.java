package com.tl.common;

import java.io.Serializable;





public class TranObject<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TranObjectType type;// ���͵���Ϣ����

	private int fromUser;// �����ĸ��û�
	private int toUser;// �����ĸ��û�

	private T object;// ����Ķ���

	public TranObject(TranObjectType type) {
		this.type = type;
	}
	
	public TranObjectType getType() {
		return type;
	}

	public void setType(TranObjectType type) {
		this.type = type;
	}

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

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "TranObject [type=" + type + ", fromUser=" + fromUser
				+ ", toUser=" + toUser + ", object=" + object + "]";
	}

	
	
	
	
}
