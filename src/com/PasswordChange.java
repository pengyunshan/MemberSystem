package com;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.xvolks.jnative.exceptions.NativeException;

import database.Card_Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasswordChange extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s,account,password;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	ChangePassword changepassword;
	String CARDNUMBER;
	/**
	 * Create the frame.
	 */
	public PasswordChange() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 501, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F1A\u5458\u5361");
		label.setBounds(58, 86, 81, 47);
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(58, 143, 60, 41);
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//这里是第一个空格；
				
			}
		});
		
		textField.setText(s);
		
		textField.setBounds(128, 98, 172, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u8BFB\u5361");
		button_1.addActionListener(new ActionListener() {			 
			public void actionPerformed(ActionEvent e)  { 
				JFrame jframe = null;
				System.out.println("这里是读卡按钮");
				if (e.getActionCommand().equals("\u8BFB\u5361")) {
						AePlayWave q = new AePlayWave("src/com/请刷卡.wav");
						q.start();
						DialogSwipe dialogswipe = new DialogSwipe(jframe,"请刷卡");
						dialogswipe.setVisible(true);
						ReadCard readcard = new ReadCard();
						
						try {
							readcard.HCE300_Open();
							CARDNUMBER = readcard.HCE300_Read().substring(0, 19);
							dialogswipe.dispose();
							textField.setText(CARDNUMBER);
						} catch (IllegalAccessException | NativeException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}  
			}
		});

		button_1.setBounds(330, 98, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("确定");
		button_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("这里是确定按钮");
				AePlayWave p = new AePlayWave("src/com/请输入密码.wav");
				p.start();
				Card_Operate card_operate = new Card_Operate();
				int state = card_operate.getState(textField.getText());
				System.out.println(state);
				if(state == 1){
					if(card_operate.verfyPassword(textField.getText(), passwordField.getText()))
					{	
						changepassword = new ChangePassword(textField.getText());
						changepassword.setVisible(true);
						JOptionPane.showMessageDialog(null, "密码正确");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "密码错误,请重新输入");
						passwordField.setText(null);
					}
				}
				else if(state == 2)
					JOptionPane.showMessageDialog(null, "该卡已挂失");
				else
				{
					JOptionPane.showMessageDialog(null, "该卡已经停用");
					textField.setText(null);
					passwordField.setText(null);
				}
				}
		});

		button_2.setBounds(58, 216, 93, 23);
		contentPane.add(button_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 152, 175, 23);
		contentPane.add(passwordField);
		
		JButton button_3 = new JButton("\u53D6\u6D88");
		button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				} 
				});
		button_3.setBounds(207, 216, 93, 23);
		contentPane.add(button_3);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801");
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 19));
		label_2.setBounds(181, 27, 141, 47);
		contentPane.add(label_2);
	}
}