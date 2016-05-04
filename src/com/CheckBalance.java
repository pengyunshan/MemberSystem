package com;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.xvolks.jnative.exceptions.NativeException;

import database.Card_Operate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBalance extends JFrame {

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
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTextField textField_6;
	String CARDNUMBER;


	/**
	 * Create the frame.
	 */
	public CheckBalance(String s) {
		super(s);
		setTitle("\u67E5\u8BE2\u5361\u4E0A\u4F59\u989D");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F1A\u5458\u5361");
		label.setBounds(10, 24, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(75, 21, 106, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BBE\u5BA2\u59D3\u540D");
		label_1.setBounds(10, 67, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 64, 182, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BC1\u4EF6\u53F7");
		label_2.setBounds(10, 109, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(75, 106, 182, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4F5C\u5E9F\u65E5\u671F");
		label_3.setBounds(10, 150, 54, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 147, 182, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5361\u4E0A\u4F59\u989D");
		label_4.setBounds(10, 188, 54, 15);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(75, 185, 182, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u8BFB\u5361");
		button.setBounds(191, 20, 66, 23);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("这是读卡按钮吗？");
				AePlayWave q = new AePlayWave("src/com/请刷卡.wav");
				q.start();
				JFrame jframe = null;
				DialogSwipe dialogswipe = new DialogSwipe(jframe,"提示");
				dialogswipe.setVisible(true);
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
		});
		contentPane.add(button);
		
		JLabel label_5 = new JLabel("\u5BC6\u7801");
		label_5.setBounds(287, 24, 54, 15);
		contentPane.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(333, 64, 182, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("\u7535\u8BDD");
		label_6.setBounds(287, 109, 54, 15);
		contentPane.add(label_6);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(287, 67, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(345, 237, 54, 15);
		contentPane.add(label_7);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.exit(0); 
				} 
		});
		button_1.setBounds(449, 229, 66, 23);
		contentPane.add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(333, 21, 90, 21);
		contentPane.add(passwordField);
		
		textField_6 = new JTextField();
		textField_6.setBounds(333, 106, 182, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent arg0) {
					Card_Operate card_operate = new Card_Operate();
					System.out.println(textField.getText());
					System.out.println(passwordField.getText());
					if(card_operate.getState(textField.getText()) == 1)
					{
						if(card_operate.verfyPassword(textField.getText(), passwordField.getText()))
						{
							JOptionPane.showMessageDialog(null,"密码正确");
							textField_1.setText(card_operate.username);
							textField_2.setText(card_operate.id);
							textField_3.setText(card_operate.validity);
							textField_4.setText(String.valueOf(card_operate.balance));
							textField_5.setText(card_operate.name);
							textField_6.setText(card_operate.tel);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"密码错误");
							passwordField.setText(null);
						} 
					}
					else if(card_operate.getState(textField.getText()) == 0)
					{
						JOptionPane.showMessageDialog(null,"该卡已停用");
						textField.setText(null);
						passwordField.setText(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"该卡已挂失，请解挂");
						textField.setText(null);
						passwordField.setText(null);
					}
		}
	});
		btnNewButton.setBounds(438, 20, 77, 23);
		contentPane.add(btnNewButton);
	}
}