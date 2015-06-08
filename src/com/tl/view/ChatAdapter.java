package com.tl.view;

import java.util.List;

import com.example.tl_client.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatAdapter extends BaseAdapter{
	private Context context;
	private List<ChatEntity> list;
	LayoutInflater inflater;
	
	private int[] imgs = { R.drawable.f1, R.drawable.f2,
			R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6,
			R.drawable.f7, R.drawable.f8, R.drawable.f9 };
	public ChatAdapter(Context context,List<ChatEntity> list){
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	public View getView(int position, View convertView, ViewGroup root) {
		ImageView avatar;
		TextView content;
		
		TextView time;
		ChatEntity ce=list.get(position);
		if(ce.isLeft()){
			convertView = inflater.inflate(R.layout.chat_listview_item_left, null);
			
			avatar=(ImageView) convertView.findViewById(R.id.avatar_chat_left);
			content=(TextView) convertView.findViewById(R.id.message_chat_left);
			time=(TextView) convertView.findViewById(R.id.sendtime_chat_left);
			int id=ce.getId();
			avatar.setImageResource(imgs[id%9]);
			content.setText(ce.getContent());
			time.setText(ce.getTime());
		}else{
			convertView=inflater.inflate(R.layout.chat_listview_item_right, null);
			
			avatar=(ImageView) convertView.findViewById(R.id.avatar_chat_right);
			content=(TextView) convertView.findViewById(R.id.message_chat_right);
			time=(TextView) convertView.findViewById(R.id.sendtime_chat_right);
			int id=ce.getId();
			avatar.setImageResource(imgs[id%9]);
			content.setText(ce.getContent());
			time.setText(ce.getTime());
		}

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
