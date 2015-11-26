package test.dragon.TestChatServer.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatServerChatSocket extends Thread{
	
	Socket mySocket;
	
	public ChatServerChatSocket(Socket newSocket) {
		this.mySocket = newSocket;
	}
	
	//发送消息
	public void writeMessage(String outString) {
		try {
			mySocket.getOutputStream().write(outString.getBytes("UTF-8"));
			System.out.println("writeMessage message " + outString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							mySocket.getInputStream(),"UTF-8"));
			String line = null;
			//循环监听
			while ((line = br.readLine()) != null) {
				ChatServerChatManager.getInstance().publishMessage(this, line);
				System.out.println("pulish new message");
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
