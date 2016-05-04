package com;

import database.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class IssueCard extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	private JTable table;	private JTable table_1;
	private JTextField textField;	private JTextField textField_2;	private JPasswordField passwordField;
	private JLabel label_2;	private JTextField textField_1;	private JLabel label_3;
	private JTextField textField_3;	private JLabel label_4;	private JTextField textField_4;
	private JLabel label_5;	private JTextField textField_5;	private JLabel lblNewLabel_1;
	private JLabel label_6;	private JTextField textField_6;	private JButton btnNewButton_1;
	private JButton button;
	private Calendar calendar;
	JButton btnNewButton ;	
	DialogSwipe dialogSwipe;
	private JPasswordField passwordField_1;
	private JButton btnNewButton_3 ;
	
	/**
	 * Create the frame.
	 */
	public IssueCard() {
		setTitle("\u53D1\u5361");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 354);
		setResizable(false);
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
		
		btnNewButton = new JButton("生成卡号");
		btnNewButton.addActionListener(this);
		
		btnNewButton.setBounds(207, 176, 95, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(238, 16, 0, 0);
		panel.add(table);
		
		textField = new JTextField();
		textField.setBounds(66, 176, 131, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4F1A\u5458\u5361");
		lblNewLabel.setBounds(10, 176, 45, 23);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setBounds(312, 176, 39, 23);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u771F\u5B9E\u59D3\u540D");
		label_1.setBounds(10, 12, 57, 23);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 12, 131, 23);
		panel.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(361, 177, 95, 21);
		panel.add(passwordField);
		
		label_2 = new JLabel("\u8D26\u53F7");
		label_2.setBounds(312, 12, 39, 23);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(361, 12, 107, 23);
		panel.add(textField_1);
		
		label_3 = new JLabel("\u8BC1\u4EF6\u53F7");
		label_3.setBounds(11, 64, 57, 23);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 64, 131, 23);
		panel.add(textField_3);
		
		label_4 = new JLabel("\u7535\u8BDD");
		label_4.setBounds(312, 64, 39, 23);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(361, 64, 107, 23);
		panel.add(textField_4);
		
		label_5 = new JLabel("\u6709\u6548\u671F");
		label_5.setBounds(10, 117, 57, 23);
		panel.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(66, 117, 131, 23);
		textField_5.setText("365");
		panel.add(textField_5);
		
		lblNewLabel_1 = new JLabel("\u5929");
		lblNewLabel_1.setBounds(213, 117, 25, 23);
		panel.add(lblNewLabel_1);
		
		label_6 = new JLabel("\u5145\u503C\u91D1\u989D");
		label_6.setBounds(312, 117, 57, 23);
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(361, 117, 83, 23);
		textField_6.setText("1000");
		panel.add(textField_6);
		
		btnNewButton_1 = new JButton("\u65B0\u5EFA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("这里是新建");
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_1.setBounds(66, 253, 69, 23);
		panel.add(btnNewButton_1);
		
		button = new JButton("\u4FDD\u5B58");
		button.setEnabled(false);
		calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(calendar.DATE);
		String activatedate = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date);
		String validity = String.valueOf(year+1)+"-"+String.valueOf(month)+"-"+String.valueOf(date);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("这是是保存");
				String a = "1";
				@SuppressWarnings("deprecation")
				CardDetail carddetail = new CardDetail(textField.getText(),
						passwordField.getText(),textField_2.getText(), 
						textField_1.getText(),textField_3.getText(), 
						textField_4.getText(),a,Integer.parseInt(textField_5.getText()),
						activatedate, validity);
				Card_Operate card_operate = new Card_Operate();
				card_operate.issuecard(carddetail);
				JOptionPane.showMessageDialog(null, "用户已创建");
			}
		});
		button.setBounds(215, 253, 69, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				} 
		});
		button_1.setBounds(367, 253, 69, 23);
		panel.add(button_1);
		
		JButton btnNewButton_2 = new JButton("确定");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//提示音，请再次输入您的密码
				passwordField_1.setVisible(true);
				btnNewButton_3.setVisible(true);		
			}
		});
		btnNewButton_2.setBounds(465, 176, 83, 23);
		panel.add(btnNewButton_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(361, 208, 95, 21);
		passwordField_1.setVisible(false);
		panel.add(passwordField_1);
		
		btnNewButton_3 = new JButton("写卡");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(passwordField_1.getText().equals(passwordField.getText())&&!passwordField_1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "密码正确");
					button.setEnabled(true);
					JFrame jframe = null;
					AePlayWave p = new AePlayWave("src/com/请刷卡.wav");
					p.start();
					DialogSwipe dialogswipe = new DialogSwipe(jframe,"请刷卡");
					dialogswipe.setVisible(true);
					/*
					ReadCard readcard = new ReadCard();
					try {
						readcard.HCE300_Open();
						readcard.HCE300_Write(textField.getText());
						dialogswipe.dispose();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NativeException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					*/
				}
				else{
					JOptionPane.showMessageDialog(null, "输入有误");
					passwordField.setText(null);
					passwordField_1.setText(null);
				}
			
			}
		});
		btnNewButton_3.setVisible(false);
		btnNewButton_3.setBounds(465, 207, 83, 23);
		
		panel.add(btnNewButton_3);
		textField_2.setText("王宝强");
		textField_1.setText("许三多");
		textField_3.setText("4535198510091234");
		textField_4.setText("13787881828");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("生成卡号")) {
			if(!textField_1.getText().equals("")&&!textField_2.getText().equals("")&&
			   !textField_3.getText().equals("")&&!textField_4.getText().equals("")&&
			   !textField_5.getText().equals("")&&!textField_5.getText().equals(""))
			{
				CardnumberGene cardgenr = new CardnumberGene();
				char c[] = new char[8];
				textField_3.getText().getChars(4, 12, c, 0);
				int[] q = new int[8];
				for(int i = 0;i<c.length;i++)
					{
					q[i] = Integer.parseInt(String.valueOf(c[i]));
					}
				
				String birthday = "";
				for(int i = 0; i<q.length; i++)
				{
					birthday = birthday+String.valueOf(q[i]);
				}
				System.out.println("birthday"+birthday);
				String xx = cardgenr.geneCard(birthday);
				System.out.println("卡号1："+xx);
				String xxx = cardgenr.getCheck(xx);
				System.out.println("卡号2："+xxx);
				textField.setText(xxx); 
				AePlayWave p = new AePlayWave("src/com/请输入密码.wav");
				p.start();
			}
			else{
				JOptionPane.showMessageDialog(null, "检查是否有未填信息");
				}
			}
	} 
}