// @Author: Bala Sourvendra
package com.feePayment;

import javax.swing.*;
import java.awt.*;

public class SignIn {

	private JFrame frmLogIn;
	private JTextField txtUser;
	private JPasswordField txtPass;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SignIn window = new SignIn();
				window.frmLogIn.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public SignIn() {
		initialize();
	}

	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		frmLogIn.getContentPane().setBackground(Color.WHITE);   // set background color as white for jframe
		frmLogIn.getContentPane().setFont(new Font("Monospaced", Font.BOLD, 10));
		frmLogIn.setBounds(100, 100, 308, 323);
		frmLogIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //dispose running session
		frmLogIn.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Payment DashBoard");
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setFont(new Font("Monospaced", Font.BOLD, 20));
		title.setBackground(Color.LIGHT_GRAY);
		title.setBounds(21, 10, 232, 71);
		frmLogIn.getContentPane().add(title);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		userLabel.setBounds(21, 87, 92, 28);
		frmLogIn.getContentPane().add(userLabel);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		passLabel.setBounds(21, 139, 92, 28);
		frmLogIn.getContentPane().add(passLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(138, 91, 115, 19);
		frmLogIn.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(138, 147, 115, 19);
		frmLogIn.getContentPane().add(txtPass);
		txtPass.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(e -> {
			String user = txtUser.getText();
			String pass = new String(txtPass.getPassword());
			if (user.equals("admin") & pass.equals("admin")) {             //check if username and password both equals to "admin" or not
				DashBoard dashboard = new DashBoard();
				dashboard.frmDashBoard.setVisible(true);
				frmLogIn.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Username or Password Invalid!"); // show message
			}
		});
		submit.setFont(new Font("Monospaced", Font.BOLD, 17));
		submit.setBounds(98, 221, 101, 28);
		frmLogIn.getContentPane().add(submit);
	}
}
