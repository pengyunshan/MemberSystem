package com;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

class Detail extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public TextArea textArea;

	/**
	 * Create the frame.
	 */
	public Detail() 
	{
		setTitle("\u660E\u7EC6");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 200, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			} 
		});
		button.setBounds(148, 320, 93, 23);
		contentPane.add(button);
		
		textArea = new TextArea();
		textArea.setBounds(39, 30, 320, 280);
		contentPane.add(textArea);
		
	}
}