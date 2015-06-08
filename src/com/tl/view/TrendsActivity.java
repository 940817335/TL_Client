package com.tl.view;

import java.util.LinkedList;

import tools.SharedpreferencesTool;
import tools.UserDB;

import com.example.tl_client.R;
import com.tl.common.Constants;
import com.tl.common.Messages;
import com.tl.common.MessagesType;
import com.tl.common.MyDate;
import com.tl.common.TranObject;
import com.tl.common.TranObjectType;
import com.tl.common.User;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TrendsActivity extends MyActivity implements OnClickListener{
	private LinkedList<TrendsEntity> list;
	private ListView mTrendsListView;
	private Button trends_send;
	private EditText trends_edit;
	private SharedpreferencesTool tool;
	private UserDB userDB;
	int myAccount;
	int toAcconut;
	private TranObject<Messages> o;
	private Messages mes;
	private TrendsAdapter ta;
	private TrendsEntity trendsEntity;
	private TranObject<User> ou;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trends);
		initUI();
		initData();
		getOffTrends();
	}
	public void initData()
	{
		tool=new SharedpreferencesTool(this,Constants.SAVE_USER);
		myAccount=tool.getId();	
		mes=new Messages();
		o = new TranObject<Messages>(TranObjectType.MESSAGE);
		list=new LinkedList<TrendsEntity>();
	}
	public void initUI()
	{
		trends_send=(Button)findViewById(R.id.trends_send);
		trends_send.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("clicked!");
				send_trends();
			}
			
		}
				);
		trends_edit=(EditText)findViewById(R.id.trends_editmessage);
		mTrendsListView=(ListView)findViewById(R.id.trends_listView);
		
	}
	
	public void getOffTrends()
	{
		ou= new TranObject<User>(
				TranObjectType.GETOFFTRENDS);
		ou.setFromUser(myAccount);
		User u=new User();
		u.setId(myAccount);
		ou.setObject(u);
		LoginActivity.out.setMsg(ou);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trends_acitivy, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.trends_send:
			System.out.println("clicked!");
			send_trends();
			break;
			default:
				break;
		}
	}
	public void send_trends()
	{
		String trends=trends_edit.getText().toString();
		mes.setContent(trends);
		mes.setType(MessagesType.Trends);
		mes.setSendTime(MyDate.getDateEN());
		trendsEntity=new TrendsEntity
				 (1,mes.getContent(),"ÌðÌð",mes.getSendTime());
				 list.add(trendsEntity);
				 ta=new TrendsAdapter(this,list);
				 mTrendsListView.setAdapter(ta);
		o.setFromUser(myAccount);
		o.setType(TranObjectType.TRENDS);
		o.setObject(mes);
		LoginActivity.out.setMsg(o);
		System.out.println("aready send trends!");
	}
	@Override
	public void getMessgae(TranObject<?> msg) {
		// TODO Auto-generated method stub
		
		switch(msg.getType())
		{
		case TRENDS:
			System.out.println(msg.toString());
			Messages mes=(Messages) msg.getObject();
			System.out.println("aready get trends!");
			if(mes.getType()==MessagesType.Trends)
			{
			 int fromUser=msg.getFromUser();
			 trendsEntity=new TrendsEntity
			 (5,mes.getContent(),"ÌðÌð",mes.getSendTime());
			 list.add(trendsEntity);
			  ta=new TrendsAdapter(this,list);
			 mTrendsListView.setAdapter(ta);
			}
			break;
			default:
				break;
			}
		}
	}
