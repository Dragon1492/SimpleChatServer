package test.dragon.TestChatServer.main;

import java.awt.EventQueue;

import test.dragon.TestChatServer.socket.ChatServerChatManager;
import test.dragon.TestChatServer.socket.ChatServerListenSocket;
import test.dragon.TestChatServer.view.ChatServerView;

public class ChatServerMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//启动窗体
					ChatServerView frame = new ChatServerView();
					frame.setVisible(true);
					
					ChatServerChatManager.getInstance().setChatView(frame);
					//运行监听
					new ChatServerListenSocket().start();
					System.out.println("ChatServerMain begin listen");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
