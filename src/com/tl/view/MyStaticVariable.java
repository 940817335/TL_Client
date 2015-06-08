package com.tl.view;

import java.io.IOException;
import java.util.LinkedList;

import com.tl.client.Client;
import com.tl.client.InputThread;
import com.tl.client.OutputThread;
//保存全局变量
public class MyStaticVariable {
	public static LinkedList<RecentChatEntity> mRecentList;
	public static RecentChatAdapter mRecentAdapter;
	public static Client client;
	public static OutputThread out;
    public static InputThread input;
    public static void initIO()
    {
    	try {
			out=new OutputThread(Client.socket);
			out.start();
			input=new InputThread(Client.socket);
			input.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	public static void creatLinkList()
	{
		mRecentList=new LinkedList<RecentChatEntity>(); 
	}
	public static LinkedList<RecentChatEntity> getmRecentList() {
		return mRecentList;
	}
	public static void setmRecentList(LinkedList<RecentChatEntity> mRecentList) {
		MyStaticVariable.mRecentList = mRecentList;
	}
	public static RecentChatAdapter getmRecentAdapter() {
		return mRecentAdapter;
	}
	public static void setmRecentAdapter(RecentChatAdapter mRecentAdapter) {
		MyStaticVariable.mRecentAdapter = mRecentAdapter;
	}
}
