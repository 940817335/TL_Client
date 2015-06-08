package com.tl.view;

import com.example.tl_client.R;
import com.tl.common.TranObject;
import com.tl.common.TranObjectType;
import com.tl.common.User;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends MyActivity implements OnClickListener{
	private Button mBtnRegister;
	private Button mRegBack;
	private EditText mEmailEt, mNameEt, mPasswdEt, mPasswdEt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		initView();
	}
	public void initView() {
		mBtnRegister = (Button) findViewById(R.id.register_btn);
		mRegBack = (Button) findViewById(R.id.reg_back_btn);
		mBtnRegister.setOnClickListener(this);
		mRegBack.setOnClickListener(this);

		mEmailEt = (EditText) findViewById(R.id.reg_email);
		mNameEt = (EditText) findViewById(R.id.reg_name);
		mPasswdEt = (EditText) findViewById(R.id.reg_password);
		mPasswdEt2 = (EditText) findViewById(R.id.reg_password2);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		switch(arg0.getId())
		{
		case R.id.register_btn:
			Register();
			break;
		case R.id.reg_back_btn:
			finish();
			break;
			default:
				break;
		}
	}
  public void Register()
  {
	    String email = mEmailEt.getText().toString();
		String name = mNameEt.getText().toString();
		String passwd = mPasswdEt.getText().toString();
		String passwd2 = mPasswdEt2.getText().toString();
		if(email==""||name==""||passwd==""||passwd2=="")
		{
			
		}
		else
		{
			if (passwd.equals(passwd2))
			{
				TranObject<User> o = new TranObject<User>(TranObjectType.REGISTER);
				User u = new User();
				u.setPassword(passwd);
				u.setEmail(email);
				u.setName(name);
				o.setObject(u);
				LoginActivity.out.setMsg(o);
			}
		}
 }
@Override
public void getMessgae(TranObject<?> msg) {
	// TODO Auto-generated method stub
	if(msg.getType()==TranObjectType.REGISTER)
	{
		User u=(User) msg.getObject();
		Toast.makeText(RegisterActivity.this, "renmenber you id"+u.getId(),0).show();
		finish();
	}
}
  

}
