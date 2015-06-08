package com.tl.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tools.MessagesDB;
import tools.SharedpreferencesTool;
import tools.UserDB;

import com.example.tl_client.R;
import com.example.tl_client.R.layout;
import com.example.tl_client.R.menu;
import com.tl.common.Constants;
import com.tl.common.Messages;
import com.tl.common.MessagesType;
import com.tl.common.MyDate;
import com.tl.common.TranObject;
import com.tl.common.TranObjectType;
import com.tl.common.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
public class ChatActivity extends MyActivity {
	private ListView chatListView;
	public List<ChatEntity> chatEntityList=new ArrayList<ChatEntity>();//所有聊天内容
	private EditText et_input;
	private Button send;
	private int myAccount;
	private int toAccount;
	private String chatNick;
	private TextView nick_tv;
	private ImageView avatar_iv;
	private SharedpreferencesTool tool;
	private UserDB userDB;
	private int group;
	private MessagesDB messageDB;
	
	public static int[] avatar=new int[]{R.drawable.avatar_default,R.drawable.h001,R.drawable.h002,R.drawable.h003,
			R.drawable.h004,R.drawable.h005,R.drawable.h006};
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		toAccount=getIntent().getIntExtra("account",0);
		tool=new SharedpreferencesTool(this,Constants.SAVE_USER);
		myAccount=tool.getId();
		send=(Button) findViewById(R.id.ib_send);
		et_input=(EditText) findViewById(R.id.et_input);
		
		String type=getIntent().getStringExtra("type");
		
		if("friend_chat".equals(type));
		{
		initialView();
		getOffMessage();
		send.setOnClickListener(new OnClickListener(){
			@Override
		public void onClick(View arg0) {
				send();
		 } });
		}
		if("group_chat".equals(type))
		{
			initGroupView();
			getOffMessage();
			send.setOnClickListener(new OnClickListener(){
				@Override
			public void onClick(View arg0) {
					group_send();
			 } });
		}
	 }
	public void initialView()
	{
		int chatAvatar=getIntent().getIntExtra("avatar", 0);
		avatar_iv=(ImageView) findViewById(R.id.chat_top_avatar);
		avatar_iv.setImageResource(avatar[chatAvatar]);
		nick_tv=(TextView) findViewById(R.id.chat_top_nick);
		nick_tv.setText("我："+myAccount);
	}
	public void initGroupView()
	{
		group=getIntent().getIntExtra("group",0);
		avatar_iv=(ImageView) findViewById(R.id.chat_top_avatar);
		int chatAvatar=getIntent().getIntExtra("avatar", 0);
		avatar_iv.setImageResource(avatar[chatAvatar]);
		nick_tv=(TextView) findViewById(R.id.chat_top_nick);
		nick_tv.setText("群： "+group);
		et_input=(EditText) findViewById(R.id.et_input);
	}
	public void getOffMessage()
	{
		TranObject<User> o = new TranObject<User>(
				TranObjectType.GETOFFMSG);
		o .setFromUser(myAccount);
		o.setToUser(toAccount);
		User u=new User();
		u.setId(myAccount);
		o.setObject(u);
		LoginActivity.out.setMsg(o);
	}
	public void send()
	{
		String content=et_input.getText().toString();
		
		if(content.length()>0)
		{
			TranObject<Messages> o = new TranObject<Messages>(
					TranObjectType.MESSAGE);
			Messages message = new Messages();
			message.setContent(content);
			message.setType(MessagesType.MESSAGES);
			message.setSendTime(MyDate.getDateEN());
			o.setType(TranObjectType.MESSAGE);
			o.setObject(message);
			o.setFromUser(myAccount);
			o.setToUser(toAccount);
			//messageDB.saveMessages(myAccount, chatEntity);
			LoginActivity.out.setMsg(o);
			
			//将聊天信息添加到最近聊天列表
			RecentChatEntity recentChatEntity=new RecentChatEntity(myAccount,2,0,"王母亮亮",MyDate.getDateEN(),content);
			//MyStaticVariable.getmRecentList().remove(recentChatEntity);
			MyStaticVariable.getmRecentList().addFirst(recentChatEntity);
			
			//更新聊天界面
			
			updateChatView(new ChatEntity(
					myAccount,
					content,
		    		MyDate.getDateCN(),
		    		true,"天王盖地虎"));
			}
	}
	public void group_send()
	{
		String content=et_input.getText().toString();
		TranObject<Messages> o = new TranObject<Messages>(
				TranObjectType.GROUP_MESSAG);
		Messages message = new Messages();
		message.setType(MessagesType.GROUP_MESSAGES);
		message.setContent(content);
		message.setSendTime(MyDate.getDateCN());
		o.setType(TranObjectType.GROUP_MESSAG);
		o.setObject(message);
		o.setFromUser(myAccount);
		o.setToUser(group);
		LoginActivity.out.setMsg(o);
		
		RecentChatEntity recentChatEntity=new RecentChatEntity(myAccount,2,0,"王母亮亮",MyDate.getDateCN(),content);
		MyStaticVariable.getmRecentList().remove(recentChatEntity);
		MyStaticVariable.getmRecentList().addFirst(recentChatEntity);
		
		updateChatView(new ChatEntity(
				toAccount,
				content,
	    		MyDate.getDateCN(),
	    		false,"天王盖地虎"));
	}
	public void updateChatView(ChatEntity chatEntity){
		chatEntityList.add(chatEntity);
		chatListView=(ListView) findViewById(R.id.lv_chat);
		chatListView.setAdapter(new ChatAdapter(this,chatEntityList));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chat, menu);
		return true;
	}

	@Override
	public void getMessgae(TranObject<?> msg) {
		// TODO Auto-generated method stub
		switch(msg.getType())
		{
		case MESSAGE:
			Messages mes=(Messages) msg.getObject();
			if(mes.getType()==MessagesType.MESSAGES)
			{
			int fromUser=msg.getFromUser();
			updateChatView(new ChatEntity(
					 toAccount,
			    		mes.getContent(),
			    		mes.getSendTime(),
			    		false,"笑话"));
			}
			break;
		case GROUP_MESSAG:
			System.out.println("getgroupMessage:" +
					msg.toString());
			Messages mes1=(Messages) msg.getObject();
			int fromUser1=msg.getFromUser();
			//User u1=userDB.selectInfo(fromUser1);
			//u1.setName("在落单的街角，寻找一份爱");
			updateChatView(
					new ChatEntity(
							fromUser1,
				    		mes1.getContent(),
				    		mes1.getSendTime(),
				    		true,"在落单的街角，寻找一份爱"));
			break;
		case GETOFFMSG:
			Messages mes2=(Messages) msg.getObject();
			System.out.println("get off msg!");
			updateChatView(
					new ChatEntity(
				    		toAccount,
				    		mes2.getContent(),
				    		mes2.getSendTime(),
				    		true,"在落单的街角，寻找一份爱"));
			break;
			default:
				break;
		}
	}
}
