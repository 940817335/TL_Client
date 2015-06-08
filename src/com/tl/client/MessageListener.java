package com.tl.client;

import com.tl.common.TranObject;



/**
 * 消息监听接口
 * 
 * @author way
 * 
 */
public interface MessageListener {
	public void Message(TranObject<?> msg);
}
