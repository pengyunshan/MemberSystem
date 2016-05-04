package com;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.xvolks.jnative.exceptions.NativeException;

import database.Card_Operate;
import database.Consumption_Operate;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsumerDetails extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton button_2;
	String CARDNUMBER;
	/**
	 * Create the frame.
	 */
	public ConsumerDetails() 
	{
		setTitle("\u6D88\u8D39\u660E\u7EC6");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F1A\u5458\u5361");
		label.setBounds(25, 71, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(23, 144, 29, 15);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u8BFB\u5361");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				JFrame jframe = null;
				if (e.getActionCommand().equals("\u8BFB\u5361")) {
						AePlayWave q = new AePlayWave("src/com/«ÎÀ¢ø®.wav");
						q.start();
						DialogSwipe dialogswipe = new DialogSwipe(jframe,"Ã· æ");
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
			}
		});

		button.setBounds(237, 69, 91, 19);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u63D0\u793A\u97F3");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				AePlayWave p = new AePlayWave("src/com/«Î ‰»Î√‹¬Î.wav");
				p.start();
				Card_Operate card_operate = new Card_Operate();
				if(card_operate.getState(textField.getText()) == 1)
				{
					if(card_operate.verfyPassword(textField.getText(), passwordField.getText()))
						{JOptionPane.showMessageDialog(null, "√‹¬Î’˝»∑");
						button_2.setEnabled(true);
						}
					else
					{	JOptionPane.showMessageDialog(null, "√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î");
						passwordField.setText(null);
					}
				}
				else if(card_operate.getState(textField.getText()) == 0){
					JOptionPane.showMessageDialog(null, "∏√ø®“—Õ£”√");
					passwordField.setText(null);
					textField.setText(null);
				}
				else if(card_operate.getState(textField.getText()) == 0){
					JOptionPane.showMessageDialog(null, "∏√ø®“—π“ ß");
					passwordField.setText(null);
					textField.setText(null);
				}
			}
		});
		button_1.setBounds(237, 142, 93, 19);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(74, 68, 110, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(74, 142, 110, 18);
		contentPane.add(passwordField);
		
		button_2 = new JButton("πÛ∞°");
		button_2.setEnabled(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				ConsumerDetails frame = new ConsumerDetails();
				frame.setVisible(false);
				Consumption_Operate consumption_operate = new Consumption_Operate();
				StringBuffer getmessage = consumption_operate.queryMessagebynumber(textField.getText());
				Detail frame1 = new Detail();
				frame1.setVisible(true);
				String x = String.valueOf(getmessage);
				frame1.textArea.append(x);
				System.out.println(getmessage);
			}
		});
		
		button_2.setBounds(74, 216, 110, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				
				} 
		});
		button_3.setBounds(237, 216, 93, 23);
		contentPane.add(button_3);
		}
}