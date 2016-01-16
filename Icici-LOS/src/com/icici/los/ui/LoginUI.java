package com.icici.los.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.icici.los.dto.UserDTO;
import com.icici.los.helper.LoginHelper;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {
	private JTextField userTxt;
	private JTextField pwdTxt;
	JLabel lblLogin = new JLabel("Login ");
	
	public static void main(String[] args) {
		
			
			
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 253);
		getContentPane().setLayout(null);
		
		
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(29, 22, 205, 34);
		getContentPane().add(lblLogin);
		
		JLabel lblUserid = new JLabel("Userid");
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserid.setBounds(29, 82, 57, 14);
		getContentPane().add(lblUserid);
		
		userTxt = new JTextField();
		userTxt.setBounds(112, 76, 110, 20);
		getContentPane().add(userTxt);
		userTxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(29, 129, 75, 14);
		getContentPane().add(lblPassword);
		
		pwdTxt = new JTextField();
		pwdTxt.setBounds(112, 128, 110, 20);
		getContentPane().add(pwdTxt);
		pwdTxt.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callHelper();
			}
		});
		btnLogin.setBounds(29, 178, 89, 23);
		getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(133, 178, 89, 23);
		getContentPane().add(btnReset);
	}
	private void callHelper(){
		LoginHelper helper = new LoginHelper();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userTxt.getText());
		userDTO.setPassword(pwdTxt.getText());
		String message = helper.validateUser(userDTO);
		lblLogin.setText(message);
	}
}
