package tools;

import java.util.ArrayList;
import java.util.List;

import com.tl.common.Constants;
import com.tl.view.ChatEntity;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MessagesDB{
	SQLiteDatabase db;
	public MessagesDB(Context context)
	{
		db=context.openOrCreateDatabase(Constants.DB_NAME, Context.MODE_PRIVATE, null);
	}
	public void saveMessages(int id,ChatEntity chatEntity)
	{
		db.execSQL("create table if not exist _"+id+
				"(_id integer primary key autoincrement,name text," +
				"img txt,date text,isCome text,content text)");
		int isCome=0;
		if(chatEntity.isLeft())
		{
			isCome=1;
		}
		
		db.execSQL("insert into _"+id+"(name,img,date,isCome,content)values(?,?,?,?,?)",
				new Object[]{chatEntity.getName(),chatEntity.getId(),
				isCome,chatEntity.getContent()});
	}
	public List<ChatEntity> getMessages(int id)
	{
		List<ChatEntity> list=new ArrayList<ChatEntity>();
		db.execSQL("create table if not exist _"+id+
				"(_id integer primary key autoincrement,name text," +
				"img txt,date text,isCome text,content text)");
		Cursor c=db.rawQuery("select * from _"+id+"order by _id desc limit 5", null);
		while(c.moveToNext())
		{
			String name = c.getString(c.getColumnIndex("name"));
			int img = c.getInt(c.getColumnIndex("img"));
			String date = c.getString(c.getColumnIndex("date"));
			int isCome = c.getInt(c.getColumnIndex("isCome"));
			String content = c.getString(c.getColumnIndex("content"));
			boolean isLeft=false;
			if(isCome==1)
			{
				isLeft=true;
			}
			ChatEntity chatEntity=new ChatEntity(img,content,date,isLeft,name);
			list.add(chatEntity);
		}
		return list;
	}
	public void close() {
		if (db != null)
			db.close();
	}
	
}
