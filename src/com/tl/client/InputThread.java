package com.tl.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.Socket;

import android.content.Context;
import android.content.Intent;

import com.tl.common.Messages;
import com.tl.common.TranObject;
import com.tl.common.TranObjectType;
import com.tl.common.User;
import com.tl.view.MyApplication;

public class InputThread extends Thread{
     public Socket socket;
     ObjectInputStream ois;
 	 Context context;
     public InputThread(Socket socket,Context context) throws IOException, IOException
     {
    	 this.socket=socket;
    	 this.context=context;
    	 ois=new ObjectInputStream(socket.getInputStream());
     }
     public InputThread(Socket socket) throws IOException, IOException
     {
    	 this.socket=socket;
    	 ois=new ObjectInputStream(socket.getInputStream());
     }
     public void run()
     {
    	try {
 				 while(true)
 		 		{
 				TranObject<?> obj=(TranObject<?> )ois.readObject();
 				dealObject(obj);
 		 		}
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (ClassNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 		
     }
     public void dealObject(TranObject<?> obj) throws IOException
 	{
    	 
    	 System.out.println("start deal object!");
    	 System.out.println(obj.toString());
    	 System.out.println(obj.getObject().toString());
    	 Intent intent=new Intent("com.tl.message");
    	 intent.putExtra("message", obj);
    	 context.sendBroadcast(intent);
    }
}
