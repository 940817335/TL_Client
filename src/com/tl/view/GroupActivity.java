package com.tl.view;

import java.util.ArrayList;
import java.util.List;

import com.example.tl_client.R;
import com.tl.common.TranObject;
import com.tl.common.User;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class GroupActivity extends MyActivity {

	ListView mGroupListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group);
		initUI();
	}
	
	public void initDate()
	{
		List<GroupEntity> groupList=new ArrayList<GroupEntity>();
	}
	public void initUI()
	{
		mGroupListView=(ListView)findViewById(R.id.group_listView);
		List<GroupEntity> groupList=new ArrayList<GroupEntity>();
		GroupEntity entity = new GroupEntity(0,1, "H345", "怀念高中生活...");
		GroupEntity entity2 = new GroupEntity(0, 2,"Android开发",
				"爱生活...爱Android...");
		groupList.add(entity);
		groupList.add(entity2);
		GroupAdapter adapter = new GroupAdapter(this, groupList);
		mGroupListView.setAdapter(adapter);
		mGroupListView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				GroupEntity temp=(GroupEntity)mGroupListView.getItemAtPosition(position);
				Intent intent=new Intent(GroupActivity.this,ChatActivity.class);
				intent.putExtra("type","group_chat");
				intent.putExtra("group",temp.getGroup());
				startActivity(intent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.group_acitivity, menu);
		return true;
	}
	@Override
	public void getMessgae(TranObject<?> msg) {
		// TODO Auto-generated method stub
		
	}
	

}
