package tools;

import android.content.Context;
import android.content.SharedPreferences;



public class SharedpreferencesTool {
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	

	public SharedpreferencesTool(Context context, String file) {
		sp = context.getSharedPreferences(file, context.MODE_PRIVATE);
		editor = sp.edit();
	}

	// 用户的密码
	public void setPasswd(String passwd) {
		editor.putString("passwd", passwd);
		editor.commit();
	}

	public String getPasswd() {
		return sp.getString("passwd", "");
	}

	// 用户的id，即QQ号
	public void setId(int i) {
		editor.putInt("id", i);
		editor.commit();
	}

	public int getId() {
		return sp.getInt("id", 0);
	}

	// 用户的昵称
	public String getName() {
		return sp.getString("name", "");
	}

	public void setName(String name) {
		editor.putString("name", name);
		editor.commit();
	}

	// 用户的邮箱
	public String getEmail() {
		return sp.getString("email", "");
	}

	public void setEmail(String email) {
		editor.putString("email", email);
		editor.commit();
	}

	// 用户自己的头像
	public Integer getImg() {
		return sp.getInt("img", 0);
	}

	public void setImg(int i) {
		editor.putInt("img", i);
		editor.commit();
	}

	// ip
	public void setIp(String ip) {
		editor.putString("ip", ip);
		editor.commit();
	}



	// 端口
	public void setPort(int port) {
		editor.putInt("port", port);
		editor.commit();
	}

	

	// 是否在后台运行标记
	public void setIsStart(boolean isStart) {
		editor.putBoolean("isStart", isStart);
		editor.commit();
	}

	public boolean getIsStart() {
		return sp.getBoolean("isStart", false);
	}

	// 是否第一次运行本应用
	public void setIsFirst(boolean isFirst) {
		editor.putBoolean("isFirst", isFirst);
		editor.commit();
	}

	public boolean getisFirst() {
		return sp.getBoolean("isFirst", true);
	}
}
