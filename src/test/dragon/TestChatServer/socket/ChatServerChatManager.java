package test.dragon.TestChatServer.socket;

import java.net.Socket;
import java.util.Vector;

import test.dragon.TestChatServer.view.ChatServerView;

public class ChatServerChatManager {
	private static ChatServerChatManager instance = new ChatServerChatManager();
	public static ChatServerChatManager getInstance() {
		return instance;
	}
	Vector<ChatServerChatSocket> socketVector = new Vector<ChatServerChatSocket>();
	
	private ChatServerView  theView;
	
	public void setChatView(ChatServerView newView) {
		theView = newView;
	}
	
	//添加新socket管理
	public void addNewSocket(ChatServerChatSocket newChatSocket) {
		System.out.println("addNewSocket");
		socketVector.add(newChatSocket);
		//更新显示数目
		theView.setUserNum(socketVector.size());
		
		theView.appendContent((socketVector.size() - 1) + " has connected");
	}
	
	//推送消息
	public void publishMessage (ChatServerChatSocket chatServerChatSocket, String talkStirng) {
		System.out.println("publishMessage begin");
		int tempNum = -1;
		for (int i = 0; i < socketVector.size(); i++) {
			ChatServerChatSocket currentSocket = socketVector.get(i);
			if (!currentSocket.equals(chatServerChatSocket)) {
//				System.out.println("publishMessage push to " + i);
				currentSocket.writeMessage(talkStirng + "\n");
			}else {
				tempNum = i;
			}
		}
		//同时更新显示说话内容
		if (tempNum != -1) {
			theView.appendContent(tempNum + ":" + talkStirng);
		}
	}
}
