package com.tl.view;
import java.util.List;

import com.example.tl_client.R;
import com.tl.common.User;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BuddyAdapter extends BaseAdapter{
	private Context context;
	private List<User> list;
	LayoutInflater inflater;
	
	public BuddyAdapter(Context context,List<User> list){
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}
	private int[] imgs = { R.drawable.f1, R.drawable.f2,
			R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6,
			R.drawable.f7, R.drawable.f8, R.drawable.f9 };
	public View getView(int position, View convertView, ViewGroup root) {
		convertView = inflater.inflate(R.layout.buddy_list_item, null);
		ImageView avatar=(ImageView) convertView.findViewById(R.id.iv_avatar);
		TextView account=(TextView) convertView.findViewById(R.id.tv_account);
		TextView trends=(TextView) convertView.findViewById(R.id.tv_trends);
		final User u=list.get(position);
		avatar.setImageResource(imgs[u.getId()%9]);
		account.setText(String.valueOf(u.getId()));
		trends.setText(u.getTrends());
		convertView.setFocusable(true);
		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(context,ChatActivity.class);
				intent.putExtra("account",u.getId());
				intent.putExtra("type","friend_chat");
				context.startActivity(intent);
			}
			
		});
		return convertView;
	}
	public int getCount() {
		return list.size();
	}

	public Object getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
}
