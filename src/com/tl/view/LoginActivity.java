package com.tl.view;

import java.io.IOException;
import java.util.List;

import tools.SharedpreferencesTool;
import tools.UserDB;
import com.example.tl_client.R;


import com.tl.client.Client;
import com.tl.client.InputThread;
import com.tl.client.OutputThread;
import com.tl.common.Constants;
import com.tl.common.TranObject;
import com.tl.common.TranObjectType;
import com.tl.common.User;



import android.content.Intent;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends MyActivity {
    EditText account,password;
    Button  login_bt;
    Button  register_bt;
    public static OutputThread out;
    public static InputThread input;
    SharedpreferencesTool tool;
    UserDB buddyDB;
    List<User> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
        .detectDiskReads().detectDiskWrites().detectNetwork()
        .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
        .detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
        .build());
        MyStaticVariable.creatLinkList();
      
		initIO();
		initUI();
        
       
	}
	public void initUI()
	{
		account=(EditText)findViewById(R.id.lgoin_accounts);
		password=(EditText)findViewById(R.id.login_password);
		login_bt=(Button)findViewById(R.id.login_btn);
		register_bt=(Button)findViewById(R.id.regist_btn);
		login_bt.setOnClickListener(new OnClickListener(){
				
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
						new Thread()
						{
							public void run()
							{
								if(account.getText().equals("") || password.getText().equals("")){
									Toast.makeText(LoginActivity.this, "账号或密码不能为空！", Toast.LENGTH_SHORT).show();
								}else{
									try {
										login(Integer.parseInt(account.getText().toString()), password.getText().toString());
									} catch (NumberFormatException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
								
						}.start();
			     }
			});
         register_bt.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				goRegisterActivity();
			}
        });
	}
	void login(int account,String password) throws IOException, ClassNotFoundException
	{
		final User u=new User();
		u.setId(account);
		u.setPassword(password);
		tool=new SharedpreferencesTool(this,Constants.SAVE_USER);
		tool.setId(u.getId());
		tool.setPasswd(u.getPassword());
		TranObject<User> oo=new TranObject<User>(TranObjectType.LOGIN);
		oo.setType(TranObjectType.LOGIN);
		oo.setObject(u);
		LoginActivity.out.setMsg(oo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	public void goRegisterActivity()
	{
		Intent intent=new Intent(this,RegisterActivity.class);
		startActivity(intent);
	}
	public void goMainActivity(TranObject<?> msg)
	{
		Intent intent=new Intent(this,MainActivity.class);
		
		intent.putExtra(Constants.MSG_KEY, msg);
	    startActivity(intent);
	}
	public void goTrendsActivity()
	{
		Intent intent=new Intent(this,TrendsActivity.class);
		
		
	    startActivity(intent);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void getMessgae(TranObject<?> msg) {
		// TODO Auto-generated method stub
		if(msg!=null)
		{
			switch(msg.getType())
			{
			case LOGIN:
				//UserDB db = new UserDB(LoginActivity.this);
				list=(List<User>)msg.getObject();
				System.out.println("list:"+list.toString());
				//db.addUser(list);
				//System.out.println((db.getUser()).toString());
				goMainActivity(msg);
				break;
			}
		}
	}
	
	
	public void initIO()
	{
		Client client=new Client();
		try {
			out = new OutputThread(Client.socket);
			out.start();
			input=new InputThread(Client.socket,this);
			input.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
