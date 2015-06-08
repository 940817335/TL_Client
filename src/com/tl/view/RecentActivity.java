package com.tl.view;




import java.util.LinkedList;

import com.example.tl_client.R;
import com.tl.common.MyDate;
import com.tl.common.TranObject;




import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
public class RecentActivity extends MyActivity {
	private ListView mRecentListView;
	private RecentChatAdapter mRecentAdapter;
	private static LinkedList<RecentChatEntity> mRecentList;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recent);
		initView();
	 }
	public void initView()
	{
		mRecentListView=(ListView) findViewById(R.id.tab1_listView);
		
		if(MyStaticVariable.getmRecentList()!=null)
		{
			mRecentAdapter=new RecentChatAdapter(this,MyStaticVariable.getmRecentList());
			mRecentListView.setAdapter(mRecentAdapter);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recent, menu);
		return true;
	}

	@Override
	public void getMessgae(TranObject<?> msg) {
		// TODO Auto-generated method stub
		
	}
}
