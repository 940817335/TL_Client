package com.tl.client;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.net.Socket;

import com.tl.common.TranObject;


public class OutputThread extends Thread{
	 ObjectOutputStream oos;
	 Socket socket;
	 TranObject<?> obj=null;
	 //FileOutputStream fos;
	 public OutputThread(Socket socket) throws IOException
	 {
		 this.socket=socket;
		 oos=new  ObjectOutputStream(socket.getOutputStream());
		// fos=new FileOutputStream(null);
	 }
		public void setMsg(TranObject<?> obj) {
			this.obj = obj;
			synchronized (this) {
				notify();
			}
		}
	public void run()
	 {
	    try {
			 while(true)
				{  
				  if(obj!=null)
					oos.writeObject(obj);
					
					synchronized (this) {
						wait();// 发送完消息后，线程进入等待状态
					}
				}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
}
