package com;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class HelloPay extends JFrame {
    SetStates s=new SetStates();
	private static final long serialVersionUID = 5556505124385307818L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloPay frame = new HelloPay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HelloPay() {
		setTitle("\u4F1A\u5458\u5361\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//achieve the full screen
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		double width=Toolkit.getDefaultToolkit().getScreenSize().width;
		double height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize((int)width,(int)height);
		this.setLocation(0,0);
		setLayout(new FlowLayout());
		this.setResizable(false);	
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("\u521B\u5EFA");
		menuBar.add(mnNewMenu);
		//实现跳转
		JMenuItem mntmNewMenuItem = new JMenuItem("\u53D1\u5361");//发卡button
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u53D1\u5361")) {
				    IssueCard l=new IssueCard();
				    l.setVisible(true);
				}  
			}
		});
		//实现跳转功能
		//实现查询信息
		mnNewMenu.add(mntmNewMenuItem);		
		JMenu mnNewMenu_1 = new JMenu("\u57FA\u672C\u4FE1\u606F");
		menuBar.add(mnNewMenu_1);		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u67E5\u8BE2\u4FE1\u606F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u67E5\u8BE2\u4FE1\u606F")) {
			           Research r=new Research();
			           r.setVisible(true);			       
			       }  		
			}		
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u4FEE\u6539\u5BC6\u7801")) {
			           PasswordChange p=new PasswordChange();
			           p.setVisible(true);
			       }  
				}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u72B6\u6001\u63A7\u5236");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u72B6\u6001\u63A7\u5236")) {
			           SetStates p=new SetStates();
			           p.setVisible(true);
			       
			       }  		
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		JMenu mnNewMenu_2 = new JMenu("\u6D88\u8D39\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5145\u503C");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u5145\u503C")) {
			           Recharge p=new Recharge();
			           p.setVisible(true);
			       }  
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u6D88\u8D39");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u6D88\u8D39")) {
			           PayFrame p=new PayFrame("");
			           p.setVisible(true);
			       }  
			}
		}
		);
		mnNewMenu_2.add(mntmNewMenuItem_5);
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u6D88\u8D39\u660E\u7EC6");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				if (e.getActionCommand().equals("\u6D88\u8D39\u660E\u7EC6")) {
					ConsumerDetails p=new ConsumerDetails();
			           p.setVisible(true);
			       }  
			}
		}
		);
		mnNewMenu_2.add(mntmNewMenuItem_6);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
		//getContentPane().add(lblNewJgoodiesTitle, BorderLayout.NORTH);
	}	
}