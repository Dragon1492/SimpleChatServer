package test.dragon.TestChatServer.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ChatServerListenSocket extends Thread{
	@Override
	public void run() {
		//创建ServerSocket监听
		ServerSocket myServerSocket;
		try {
			myServerSocket = new ServerSocket(12345);
			
			//无限循环监听
			while (true) {
				Socket mySocket = myServerSocket.accept();
				

				System.out.println("ChatServerListenSocket new socket");
				
//				JOptionPane.showMessageDialog(null, "Client Connect");
				
				//传递给新线程
				ChatServerChatSocket newChatSocket = new ChatServerChatSocket(mySocket);
				newChatSocket.start();
				ChatServerChatManager.getInstance().addNewSocket(newChatSocket);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
