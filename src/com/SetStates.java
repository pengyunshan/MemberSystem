package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.xvolks.jnative.exceptions.NativeException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class SetStates extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5556505124385307818L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	String CARDNUMBER;
	JButton btnQ;
	JButton btnNewButton;
	JButton button_1;
	/**
	 * Create the frame.
	 */
	public SetStates() {
		setTitle("\u5361\u7247\u72B6\u6001");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u5458\u5361");
		lblNewLabel.setBounds(21, 24, 54, 15);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 21, 112, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u5BC6\u7801");
		lblNewLabel_5.setBounds(300, 24, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		JButton button = new JButton("\u9000\u51FA");
		button.setBounds(457, 89, 98, 33);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("\u8BFB\u5361");
		//这是刷卡按钮
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u8BFB\u5361")) {
						AePlayWave q = new AePlayWave("src/com/请刷卡.wav");
						q.start();
						JFrame jframe = null;
						DialogSwipe dialogswipe = new DialogSwipe(jframe,"提示");
						dialogswipe.setVisible(true);
						//textField.setText("2016324122350");
						ReadCard readcard = new ReadCard();
						
						try {
							readcard.HCE300_Open();
							CARDNUMBER = readcard.HCE300_Read().substring(0, 19);
							dialogswipe.dispose();
						} catch (IllegalAccessException | NativeException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textField.setText(CARDNUMBER);
			       }  
			}
		});
		btnNewButton_1.setBounds(221, 20, 69, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u63D0\u793A\u97F3");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				AePlayWave p = new AePlayWave("src/com/请输入密码.wav");
				p.start();
				Card_Operate card_operate = new Card_Operate();
				if(card_operate.verfyPassword(textField.getText(), passwordField.getText()))
				{
					JOptionPane.showMessageDialog(null, "密码正确");
					button_1.setEnabled(true);
					btnNewButton.setEnabled(true);
					btnQ.setEnabled(true);
				}
			else
				{	JOptionPane.showMessageDialog(null, "密码错误");
				passwordField.setText(null);
				}
			} 	
			}
		);
		btnNewButton_2.setBounds(479, 20, 76, 23);
		contentPane.add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(353, 21, 113, 21);
		contentPane.add(passwordField);
		
		btnQ = new JButton("\u542F\u7528");
		btnQ.setIcon(new ImageIcon(SetStates.class.getResource("/com/\u542F\u7528\u56FE\u6807.png")));
		btnQ.setBounds(29, 89, 95, 33);
		btnQ.setEnabled(false);
		btnQ.addActionListener(new ActionListener() {
			//启用
			public void actionPerformed(ActionEvent e) {
			//	if()
				Card_Operate card_operate = new Card_Operate();
				card_operate.stateControl(textField.getText(),"1");
				JOptionPane.showMessageDialog(null, "该卡已启用");
			}
		});
		contentPane.add(btnQ);
		
		btnNewButton = new JButton("\u505C\u7528");
		btnNewButton.setIcon(new ImageIcon(SetStates.class.getResource("/com/\u505C\u6B62\u56FE\u6807.png")));
		btnNewButton.setBounds(176, 89, 95, 33);
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			//停用
			public void actionPerformed(ActionEvent e) {
				Card_Operate card_operate = new Card_Operate();
				card_operate.stateControl(textField.getText(),"0");
				JOptionPane.showMessageDialog(null, "该卡已停用");
			}
		});
		contentPane.add(btnNewButton);
		
		button_1 = new JButton("\u6302\u5931");
		button_1.setIcon(new ImageIcon(SetStates.class.getResource("/com/\u6302\u5931\u56FE\u6807.png")));
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			//挂失
			public void actionPerformed(ActionEvent e) {
				Card_Operate card_operate = new Card_Operate();
				card_operate.stateControl(textField.getText(),"2");
				JOptionPane.showMessageDialog(null, "该卡已挂失");
			}
		});
		button_1.setBounds(317, 89, 95, 33);
		contentPane.add(button_1);
	}
}
