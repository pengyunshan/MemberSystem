package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DialogSwipe extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	JButton cancel = new JButton("È¡Ïû");
	JTextField time = new JTextField();
	public void setDefaultCloseOperation(int operation) {};
	DialogSwipe(JFrame f,String s){
		super(f,s,true);
		setTitle("\u5237\u5361");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		lblNewLabel = new JLabel("\u6B63\u5728\u5237\u5361\uFF0C\u8BF7\u7A0D\u540E.....");
		lblNewLabel.setIgnoreRepaint(true);
		lblNewLabel.setIconTextGap(1);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon icon=new ImageIcon("src/com/Ë¢¿¨±³¾°Í¼.jpg");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.GREEN);
		contentPane.add(lblNewLabel, BorderLayout.WEST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        {
        }
        dispose();
	}
}