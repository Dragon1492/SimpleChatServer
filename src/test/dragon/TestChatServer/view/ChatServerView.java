package test.dragon.TestChatServer.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class ChatServerView extends JFrame {

	private JPanel contentPane;
	private JTextArea showTextArea;
	private JLabel currentNumLabel;


	/**
	 * Create the frame.
	 */
	public ChatServerView() {
		setTitle("Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		showTextArea = new JTextArea();
		
		currentNumLabel = new JLabel("0");
		
		JLabel currentTipsLabel = new JLabel("Curent Num:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(149)
					.addComponent(currentTipsLabel, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(currentNumLabel, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(148))
				.addComponent(showTextArea, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(showTextArea, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(currentTipsLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(currentNumLabel))
					.addGap(10))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//新添加说话内容
	public void appendContent(String newContent) {
		showTextArea.append(newContent + "\n");
	}
	
	//设置新数量
	public void setUserNum(int newNum) {
		String newNumString = String.valueOf(newNum);
		currentNumLabel.setText(newNumString);
	}
}
