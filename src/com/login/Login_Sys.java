package com.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class Login_Sys {

	private JFrame frame;
	private JFrame exitFrame;
	private JTextField text_username;
	private JPasswordField text_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Sys window = new Login_Sys();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Sys() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 492, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblUsername.setBounds(31, 58, 141, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(31, 109, 141, 23);
		frame.getContentPane().add(lblPassword);
		
		text_username = new JTextField();
		text_username.setBounds(182, 59, 176, 20);
		frame.getContentPane().add(text_username);
		text_username.setColumns(10);
		
		text_password = new JPasswordField();
		text_password.setBounds(182, 110, 176, 20);
		frame.getContentPane().add(text_password);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=text_username.getText();
				String password=text_password.getText();
				
				if(DAO.validate(username,password)) {
					text_username.setText(null);
					text_password.setText(null);
					SuccessFrame sf=new SuccessFrame();
					sf.main(null);
					frame.dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSubmit.setBounds(31, 195, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_username.setText(null);
				text_password.setText(null);
			}
		});
		btnClear.setBounds(167, 195, 89, 23);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				exitFrame=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(exitFrame, "Confirm if you want to exit!","Login Sytem",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
					
			}
		});
		btnExit.setBounds(282, 195, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 157, 425, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 27, 425, 2);
		frame.getContentPane().add(separator_1);
	}
}
