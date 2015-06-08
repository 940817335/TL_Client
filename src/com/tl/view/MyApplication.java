package com.tl.view;
import java.util.LinkedList;





import android.app.Application;

public class MyApplication extends Application
{
	private LinkedList<RecentChatEntity> mRecentList;
	private RecentChatAdapter mRecentAdapter;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mRecentList = new LinkedList<RecentChatEntity>();
		mRecentAdapter = new RecentChatAdapter(getApplicationContext(),
				mRecentList);
		
	}
	public LinkedList<RecentChatEntity> getmRecentList() {
		return mRecentList;
	}
	public void setmRecentList(LinkedList<RecentChatEntity> mRecentList) {
		this.mRecentList = mRecentList;
	}
	public RecentChatAdapter getmRecentAdapter() {
		return mRecentAdapter;
	}
	public void setmRecentAdapter(RecentChatAdapter mRecentAdapter) {
		this.mRecentAdapter = mRecentAdapter;
	}
	
	
	
}
