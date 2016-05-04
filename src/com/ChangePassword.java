package com;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Card_Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ChangePassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	/**
	 * Create the frame.
	 */
	public ChangePassword(String cardnumber) {
		setTitle("设置新密码");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(40, 53, 134, 45);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(40, 119, 174, 45);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(81, 202, 93, 23);
		button.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) { 
				String firstPassword = passwordField.getText();
				String secondPassword = passwordField_1.getText();
				if(firstPassword.equals(secondPassword))
				{
					Card_Operate card_operate = new Card_Operate();
					if(card_operate.modifyPassword(cardnumber, passwordField_1.getText()))
						JOptionPane.showMessageDialog(null,"密码修改成功");
					else
						JOptionPane.showMessageDialog(null,"密码修改失败");
				}
				else
					{JOptionPane.showMessageDialog(null, "两次密码不同");
					passwordField.setText(null);
					passwordField_1.setText(null);
					}
			}
		});
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				} 
		});
		button_1.setBounds(250, 202, 93, 23);
		contentPane.add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 64, 174, 23);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(204, 130, 174, 23);
		contentPane.add(passwordField_1);
}}