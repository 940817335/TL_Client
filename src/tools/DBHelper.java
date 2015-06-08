package tools;



import com.tl.common.Constants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context) {
		super(context, Constants.DB_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE table IF NOT EXISTS user"
				+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT, name TEXT, img TEXT, isOnline TEXT, _group TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE user2 ADD COLUMN other TEXT");
	}
}
