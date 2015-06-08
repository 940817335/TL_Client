package com.tl.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
public class Client {
	public static Socket socket;
	static String ip1="10.0.2.2";
	static String ip2="192.168.1.105";
	static int port=8092;
	public  Client()
	{
		System.out.println("unConnected");
		 socket=new Socket();
		 try {
			socket.connect(new InetSocketAddress(ip2,port), 2000);
			if(socket.isConnected())
			{
				System.out.println("connected");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		Client.socket = socket;
	}
}
