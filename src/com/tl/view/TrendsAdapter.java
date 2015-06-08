package com.tl.view;

import java.util.LinkedList;

import com.example.tl_client.R;
import com.tl.common.User;
import com.tl.view.RecentChatAdapter.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TrendsAdapter  extends BaseAdapter{
	private Context context;
	private LinkedList<TrendsEntity> list;
	//private MyApplication application;
	private LayoutInflater inflater;
	private int[] imgs = { R.drawable.f1, R.drawable.f2,
			R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6,
			R.drawable.f7, R.drawable.f8, R.drawable.f9 };
	public  TrendsAdapter(Context context, LinkedList<TrendsEntity> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		//application = (MyApplication) context.getApplicationContext();
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	// 
	public void remove(RecentChatEntity entity) {
		list.remove(entity);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.trends_item, null);
			holder = new ViewHolder();
			holder.icon = (ImageView) convertView
					.findViewById(R.id.imageView_item);
			holder.name = (TextView) convertView.findViewById(R.id.name_item);
			holder.date = (TextView) convertView.findViewById(R.id.time_item);
			holder.trends = (TextView) convertView.findViewById(R.id.trends_item);
			//holder.count = (TextView) convertView
					//.findViewById(R.id.recent_new_num);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		final  TrendsEntity entity = list.get(position);
		holder.icon.setImageResource(imgs[entity.getImg()]);
		holder.date.setText(entity.getTime());
		holder.date.setTextColor(Color.BLACK);
		holder.trends.setText(entity.getTrends());
		holder.trends.setTextColor(Color.BLACK);
	    holder.name.setText(entity.getName());
		convertView.setFocusable(true);
		convertView.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// 下面是切换到聊天界面处理
				User u = new User();
				
				u.setId(entity.getId());
				u.setImg(entity.getImg());
				Intent intent = new Intent(context, ChatActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("user", u);
				intent.putExtra("type", "friend_chat");
				//context.startActivity(intent);
				

			}
		});
		return convertView;
	}
	static class ViewHolder {
		public ImageView icon;
		public TextView date;
		public TextView trends;
		public TextView count;
		public TextView name;
	}
}
