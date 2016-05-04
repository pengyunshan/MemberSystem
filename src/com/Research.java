package com;

import database.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.xvolks.jnative.exceptions.NativeException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Research extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JLabel label_2;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_3;//证件号
	private JLabel label_4;
	private JTextField textField_4;
	private JLabel label_5;
	private JTextField textField_5;
	private JLabel lblNewLabel_1;
	private JLabel label_6;
	private JTextField textField_6;
	private JButton button;//保存按钮
	private JButton button_2;//退出按钮
	String CARDNUMBER;

	/**
	 * Create the frame.
	 */
	public Research() {
		setTitle("\u67E5\u8BE2\u8D26\u6237\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(135, 16, 0, 0);
		panel.add(table_1);
		
		JButton btnNewButton = new JButton("\u8BFB\u5361");
		btnNewButton.addActionListener(new ActionListener() {
			private JFrame JFrame;
			public void actionPerformed(ActionEvent e)  {
				String s = null;
				if (e.getActionCommand().equals("\u8BFB\u5361")) {
						AePlayWave q = new AePlayWave("src/com/请刷卡.wav");
						q.start();
						DialogSwipe dialogswipe = new DialogSwipe(JFrame,"刷卡");
						dialogswipe.setVisible(true);
						System.out.println("这里是按钮读卡");
						//s = "2016324122350";
						ReadCard readcard = new ReadCard();
						try {
							readcard.HCE300_Open();
							CARDNUMBER = readcard.HCE300_Read().substring(0, 19);
							textField.setText(CARDNUMBER);
							dialogswipe.dispose();
						} catch (IllegalAccessException | NativeException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			       }  
			}
		});
		btnNewButton.setBounds(207, 16, 77, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(238, 16, 0, 0);
		panel.add(table);
		
		textField = new JTextField();
		textField.setBounds(66, 16, 131, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u5458\u5361");
		lblNewLabel.setBounds(10, 16, 45, 23);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setBounds(294, 16, 39, 23);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u771F\u5B9E\u59D3\u540D");
		label_1.setBounds(10, 62, 57, 23);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 62, 131, 23);
	
		panel.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(329, 16, 107, 21);
		panel.add(passwordField);
		
		label_2 = new JLabel("\u8D26\u53F7");
		label_2.setBounds(294, 62, 39, 23);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(329, 62, 107, 23);
		panel.add(textField_1);
		
		label_3 = new JLabel("\u8BC1\u4EF6\u53F7");
		label_3.setBounds(10, 107, 57, 23);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 107, 131, 23);
		panel.add(textField_3);
		
		label_4 = new JLabel("\u7535\u8BDD");
		label_4.setBounds(294, 107, 39, 23);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(329, 107, 107, 23);
		panel.add(textField_4);
		
		label_5 = new JLabel("\u6709\u6548\u671F");
		label_5.setBounds(10, 153, 57, 23);
		panel.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(66, 153, 131, 23);
		panel.add(textField_5);
		
		lblNewLabel_1 = new JLabel("\u5929");
		lblNewLabel_1.setBounds(202, 153, 25, 23);
		panel.add(lblNewLabel_1);
		
		label_6 = new JLabel("剩余金额");
		label_6.setBounds(276, 153, 57, 23);
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(329, 153, 107, 23);
		panel.add(textField_6);
		
		button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("这里是保存按钮");
				dispose();
			}
		});
		button.setBounds(128, 226, 69, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				//System.out.println("这里是退出按钮");
				} 
		});
		button_1.setBounds(339, 226, 69, 23);
		panel.add(button_1);
		
		button_2 = new JButton("验证");
		button_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				AePlayWave p = new AePlayWave("src/com/请输入密码.wav");
				p.start();
				Card_Operate card_operate = new Card_Operate();
				//这里是提示音按钮
				if(card_operate.getState(textField.getText()) == 1){
				if(card_operate.verfyPassword(textField.getText(), passwordField.getText()))
				{
					JOptionPane.showMessageDialog(null, "密码正确");
					System.out.println(card_operate.username);
					textField_1.setText(card_operate.username);
					textField_2.setText(card_operate.name);
					textField_3.setText(card_operate.tel);
					textField_4.setText(card_operate.id);
					textField_5.setText(card_operate.validity);
					textField_6.setText(String.valueOf(card_operate.balance));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "密码错误");
					passwordField.setText(null);
				}
				}
				else if(card_operate.getState(textField.getText()) == 0){
					JOptionPane.showMessageDialog(null, "该卡已停用");
					passwordField.setText(null);
					textField.setText(null);
				}
				else if(card_operate.getState(textField.getText()) == 2){
					JOptionPane.showMessageDialog(null, "该卡已挂失");
					passwordField.setText(null);
					textField.setText(null);
				}
			}
		});
		button_2.setBounds(446, 16, 82, 23);
		panel.add(button_2);
	}
}
