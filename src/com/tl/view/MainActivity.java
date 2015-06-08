package com.tl.view;



import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.example.tl_client.R;
import com.tl.common.Constants;
import com.tl.common.TranObject;
;

public class MainActivity extends TabActivity {
	public static String myInfo;
	public TabHost tabHost;
	public RadioGroup radioGroup;
	private static final String RECENT = "会话";
	private static final String BUDDY = "好友";
	private static final String GROUP = "群组";
	private static final String TRENDS = "动态";
	//private static final String MORE= "更多";
	public Intent recentIntent;
	public Intent buddyIntent;
	public Intent groupIntent;
	public Intent trendsIntent;
	//public Intent moreIntent;
	private TranObject<?> buddyList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		tabHost=this.getTabHost();
		setupIntent();
		 radioGroup=(RadioGroup)findViewById(R.id.main_radiogroup);
		 radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
		 {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int id) {
				// TODO Auto-generated method stub
				switch(id)
				{
				case R.id.tab_buddy:
				     tabHost.setCurrentTabByTag(BUDDY);
					break;
				case R.id.tab_group:
					tabHost.setCurrentTabByTag(GROUP);
					break;
				//case R.id.tab_more:
					//tabHost.setCurrentTabByTag(MORE);
					//break;
				case R.id.tab_recent:
					tabHost.setCurrentTabByTag(RECENT);
					break;
				case R.id.tab_trends:
					tabHost.setCurrentTabByTag(TRENDS);
					break;
				}
			}
			 
		 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void setupIntent()
	{
		buddyList= (TranObject<?>) getIntent().getSerializableExtra(Constants.MSG_KEY);
		recentIntent=new Intent(this,RecentActivity.class);
		buddyIntent= new Intent(this, BuddyActivity.class);
		buddyIntent.putExtra(Constants.MSG_KEY, buddyList);
		System.out.println("mainActivity:"+buddyList.toString());
		groupIntent= new Intent(this, GroupActivity.class);
		trendsIntent= new Intent(this, TrendsActivity.class);
		//moreIntent= new Intent(this, MoreActivity.class);
		TabSpec tabSpec1 = tabHost.newTabSpec(RECENT).setIndicator(RECENT)
				.setContent(recentIntent);
		tabHost.addTab(tabSpec1);
		TabSpec tabSpec2 = tabHost.newTabSpec(BUDDY).setIndicator(BUDDY)
				.setContent(buddyIntent);
		tabHost.addTab(tabSpec2);
		TabSpec tabSpec3 = tabHost.newTabSpec(GROUP).setIndicator(GROUP)
				.setContent(groupIntent);
		tabHost.addTab(tabSpec3);
		TabSpec tabSpec4 = tabHost.newTabSpec(TRENDS).setIndicator(TRENDS)
				.setContent(trendsIntent);
		tabHost.addTab(tabSpec4);
		//TabSpec tabSpec5 = tabHost.newTabSpec(MORE).setIndicator(MORE)
			//	.setContent(moreIntent);
		//tabHost.addTab(tabSpec5);
	}

}
