package com;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.xvolks.jnative.exceptions.NativeException;

import database.Card_Operate;
import database.ConsumptionDetail;
import database.Consumption_Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PayFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPasswordField passwordField;
	String CARDNUMBER;
	JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public PayFrame(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 319);
		setTitle("会员卡支付");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u5458\u5361");
		lblNewLabel.setBounds(21, 24, 54, 15);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BBE\u5BA2\u59D3\u540D");
		lblNewLabel_1.setBounds(21, 62, 54, 15);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BC1\u4EF6\u53F7");
		lblNewLabel_2.setBounds(21, 97, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u5E9F\u65E5\u671F");
		lblNewLabel_3.setBounds(21, 133, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5361\u4E0A\u4F59\u989D");
		lblNewLabel_4.setBounds(21, 165, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(99, 21, 112, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 59, 112, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 94, 112, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 130, 112, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(99, 162, 112, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u5BC6\u7801");
		lblNewLabel_5.setBounds(300, 24, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u8D26\u53F7");
		lblNewLabel_6.setBounds(300, 62, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u7535\u8BDD");
		lblNewLabel_7.setBounds(300, 97, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel label = new JLabel("\u652F\u4ED8\u91D1\u989D");
		label.setBounds(300, 133, 54, 15);
		contentPane.add(label);
		
		textField_6 = new JTextField();
		textField_6.setBounds(353, 59, 113, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(353, 94, 113, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(353, 130, 113, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		btnNewButton = new JButton("下账");
		btnNewButton.setBounds(146, 235, 65, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		JButton button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				} 
		});
		
		button.setBounds(300, 235, 65, 23);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("读卡");
		btnNewButton_1.setBounds(221, 20, 69, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
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
					textField.setText(CARDNUMBER);
				} catch (IllegalAccessException | NativeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}	
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("确定");
		btnNewButton_2.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			Card_Operate card_operate = new Card_Operate();
			int state = card_operate.getState(textField.getText());
			if(state == 1){
				if(card_operate.verfyPassword(textField.getText(), passwordField.getText()))
					{JOptionPane.showMessageDialog(null, "密码正确");
					textField_1.setText(card_operate.username);
					textField_2.setText(card_operate.id);
					textField_3.setText(card_operate.validity);
					textField_4.setText(String.valueOf(card_operate.balance));
					textField_6.setText(card_operate.name);
					textField_7.setText(card_operate.tel);
					}
				else
					{JOptionPane.showMessageDialog(null, "密码错误");
					 textField.setText(null);
					 passwordField.setText(null);
					}
			} 
			else if(state == 0)
			{	JOptionPane.showMessageDialog(null, "该卡已停用");
				
			}
			else 
				JOptionPane.showMessageDialog(null, "该卡已挂失");
			}
		});
		
		btnNewButton_2.setBounds(479, 20, 76, 23);
		contentPane.add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(353, 21, 113, 21);
		contentPane.add(passwordField);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton)
		{
			if(!textField_1.getText().equals("")&&!textField_2.getText().equals("")&&
			   !textField_3.getText().equals("")&&!textField_4.getText().equals("")&&
			   !textField_6.getText().equals("")&&!textField_7.getText().equals("")&&
			   !textField_8.getText().equals(""))
			{
				Date nowTime = new Date();
				SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
				String time = matter1.format(nowTime);
				String s=new String(textField_8.getText());
				JOptionPane.showMessageDialog(null, "已消费：" + s + " 元");
				ConsumptionDetail consumptiondetail = new ConsumptionDetail
						(textField.getText(), Integer.parseInt(textField_8.getText()),time);
				Consumption_Operate consumption_operate = new Consumption_Operate();
				Card_Operate card_operate = new Card_Operate();
				int oldbalance = Integer.parseInt(card_operate.getBalance(textField.getText()));
				System.out.print(oldbalance);
				if (card_operate.consumption(textField.getText(),Integer.parseInt(textField_8.getText()),oldbalance))
					JOptionPane.showMessageDialog(null, "余额更改成功");
				else
					JOptionPane.showMessageDialog(null, "余额更改失败");
				if(consumption_operate.addMessage(consumptiondetail))
					JOptionPane.showMessageDialog(null, "消费记录成功");
				else
					JOptionPane.showMessageDialog(null, "数据记录失败");
				} 
			}
			else{
				JOptionPane.showMessageDialog(null, "检查是否有未填信息");
			}
		}		
	}