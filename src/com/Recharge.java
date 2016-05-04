package com;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.xvolks.jnative.exceptions.NativeException;

import database.Card_Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recharge extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;//
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	JButton btnNewButton;
	String CARDNUMBER;
	/**
	 * Create the frame.
	 */
	public Recharge() {
		setTitle("\u5145\u503C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 354);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u5458\u5361");
		lblNewLabel.setBounds(10, 42, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel passwordlabel = new JLabel("密码");
		passwordlabel.setBounds(254, 42, 54, 15);
		contentPane.add(passwordlabel);
		
		JLabel label = new JLabel("\u8BC1\u4EF6\u53F7");
		label.setBounds(10, 140, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BBE\u5BA2\u59D3\u540D");
		label_1.setBounds(10, 98, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("\u5361\u4E0A\u4F59\u989D");
		label_3.setBounds(10, 190, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("\u8D26\u53F7");
		label_5.setBounds(254, 98, 54, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u7535\u8BDD");
		label_6.setBounds(254, 140, 54, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5145\u503C\u91D1\u989D");
		label_7.setBounds(254, 190, 54, 15);
		contentPane.add(label_7);
		
		textField = new JTextField();
		textField.setBounds(52, 39, 114, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JPasswordField();
		textField_3.setBounds(280, 39, 93, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 95, 130, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 137, 130, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(74, 187, 130, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(307, 98, 144, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(307, 136, 144, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(307, 187, 144, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton button = new JButton("\u8BFB\u5361");
		button.addActionListener(new ActionListener() {
			private JFrame JFrame;
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u8BFB\u5361")) {
						AePlayWave q = new AePlayWave("src/com/请刷卡.wav");
						q.start();
			         DialogSwipe dialogswipe = new DialogSwipe(JFrame,"请刷卡");
			         dialogswipe.setVisible(true);
			       //textField.setText("2016324122350");
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
		button.setBounds(176, 40, 72, 19);
		contentPane.add(button);
		
		JButton showMessage = new JButton("显示信息");
		showMessage.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ReadCard readcard = new ReadCard();
				Card_Operate card_operate = new Card_Operate();
				if(card_operate.getState(textField.getText()) == 1){
					if(card_operate.verfyPassword(textField.getText(), textField_3.getText()))
					{	

						btnNewButton.setEnabled(true);
						JOptionPane.showMessageDialog(null, "密码正确");
						textField_1.setText(card_operate.username);
						textField_2.setText(card_operate.id);
						textField_4.setText(String.valueOf(card_operate.balance));
						textField_6.setText(card_operate.name);
						textField_7.setText(card_operate.tel);
					}
					else
					{	
						JOptionPane.showMessageDialog(null, "密码错误");
						textField_3.setText(null);
					}
				}
				else if(card_operate.getState(textField.getText()) == 0)
				{
					JOptionPane.showMessageDialog(null, "该卡已停用");
					textField.setText(null);
					textField_3.setText(null);
				}
				else if(card_operate.getState(textField.getText()) == 2)
				{
					JOptionPane.showMessageDialog(null, "该卡已挂失");
					textField.setText(null);
					textField_3.setText(null);
				}
					
			}
			
		});
		showMessage.setBounds(383, 40, 92, 19);
		contentPane.add(showMessage);
		
		btnNewButton = new JButton("确定");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textField_8.getText().equals("")&&!textField.getText().equals(""))
				{
					int charge = Integer.parseInt(textField_8.getText());
					System.out.println(charge);
					Card_Operate card_operate = new Card_Operate();
					card_operate.recharge(textField.getText(),charge);	
					JOptionPane.showMessageDialog(null, "充值成功");
				}
				else
					JOptionPane.showMessageDialog(null, "检查是否有未填信息");
			}
		});
		btnNewButton.setBounds(104, 260, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				
				} 
		});
		button_2.setBounds(264, 260, 93, 23);
		contentPane.add(button_2);
	}
}