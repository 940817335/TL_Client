package com.tl.view;

import java.util.ArrayList;
import java.util.List;

import tools.MessagesDB;
import tools.SharedpreferencesTool;
import tools.UserDB;

import com.example.tl_client.R;
import com.tl.common.Constants;
import com.tl.common.TranObject;
import com.tl.common.User;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;

public class BuddyActivity extends MyActivity {
    ListView listView;
    UserDB buddyDB;
    MessagesDB messagesDB;
    TranObject<?> obj;
    List<User> list;
    SharedpreferencesTool sharedpreferencesTool;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buddy);
		initData();
		initView();
	}
	@SuppressWarnings("unchecked")
	public void initData()
	{
		buddyDB=new UserDB(this);
		messagesDB=new MessagesDB(this);
		sharedpreferencesTool=new SharedpreferencesTool(this,Constants.SAVE_USER);
		obj=(TranObject<?>)getIntent().getSerializableExtra(Constants.MSG_KEY);
		
		if(obj!=null)//从登陆界面切换过来的
		{
			list=(List<User>)obj.getObject();
			buddyDB.updateUser(list);
		}
		else
		{
			list=buddyDB.getUser();
		}
	}
	public void initView()
	{
		listView=(ListView)findViewById(R.id.listview);
		listView.setFocusable(true);
		BuddyAdapter ba=new BuddyAdapter(BuddyActivity.this,list);
		listView.setAdapter(ba);
		listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				
				User temp=(User)listView.getItemAtPosition(position);
				Intent intent=new Intent(BuddyActivity.this,ChatActivity.class);
				intent.putExtra("account",temp.getId());
				intent.putExtra("type","friend_chat");
				startActivity(intent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buddy, menu);
		return true;
	}
	public List<BuddyBody> paraSax(String s)
	{
		String ss[]=s.split(" ");
		List<BuddyBody> list=new ArrayList<BuddyBody>();
		for(int i=0;i<ss.length;i++)
		{
			String[]  a=ss[i].split("_");
			if(a!=null) 
			{
				list.add(new BuddyBody(Integer.parseInt(a[0]),Integer.parseInt(a[1]),a[2]));
			}
		}
		return list;
	}
	@Override
	public void getMessgae(TranObject<?> msg) {
		// TODO Auto-generated method stub
		
		}

}
