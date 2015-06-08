package com.tl.view;

import com.tl.common.TranObject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public abstract class MyActivity extends Activity{
	private BroadcastReceiver msgReciever=new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			TranObject<?> msg=(TranObject<?>)intent.getSerializableExtra("message");
			if(msg!=null)
			{
				System.out.println("已经接受到数据");
				getMessgae(msg);
			}
		}
    };
	public abstract void getMessgae(TranObject<?> msg);//the abstaract metheod for getting message 
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		IntentFilter intentFilter=new IntentFilter();
		intentFilter.addAction("com.tl.message");
		registerReceiver(msgReciever,intentFilter);
	}

	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unregisterReceiver(msgReciever);
	}
	

}
