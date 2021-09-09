// @Author: Bala Sourvendra
package com.feePayment;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {

	JFrame frmAdd;
	private JTextField textFirst;
	private JTextField textLast;
	private JTextField textCourse;
	private JTextField textBranch;
	private JTextField textSem;
	private JTextField textMob;
	private JTextField textEmail;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Add window = new Add();
				window.frmAdd.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	public Add() {
		initialize();
	}

	private void initialize() {
		frmAdd = new JFrame();
		frmAdd.setTitle("Add");
		frmAdd.setBounds(100, 100, 531, 547);
		frmAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdd.getContentPane().setLayout(null);

		JLabel first_name = new JLabel("First Name");
		first_name.setFont(new Font("Monospaced", Font.BOLD, 17));
		first_name.setBounds(25, 78, 107, 19);
		frmAdd.getContentPane().add(first_name);

		textFirst = new JTextField();
		textFirst.setBounds(251, 80, 107, 19);
		frmAdd.getContentPane().add(textFirst);
		textFirst.setColumns(10);

		JLabel last_name = new JLabel("Last Name");
		last_name.setBounds(25, 131, 107, 19);
		last_name.setFont(new Font("Monospaced", Font.BOLD, 17));
		frmAdd.getContentPane().add(last_name);

		textLast = new JTextField();
		textLast.setBounds(251, 134, 107, 19);
		frmAdd.getContentPane().add(textLast);
		textLast.setColumns(10);

		JLabel course_name = new JLabel("Course");
		course_name.setFont(new Font("Monospaced", Font.BOLD, 17));
		course_name.setBounds(25, 186, 107, 19);
		frmAdd.getContentPane().add(course_name);

		textCourse = new JTextField();
		textCourse.setBounds(251, 183, 107, 19);
		frmAdd.getContentPane().add(textCourse);
		textCourse.setColumns(10);

		JLabel branch = new JLabel("Branch");
		branch.setFont(new Font("Monospaced", Font.BOLD, 17));
		branch.setBounds(25, 241, 107, 19);
		frmAdd.getContentPane().add(branch);

		textBranch = new JTextField();
		textBranch.setBounds(251, 238, 107, 19);
		frmAdd.getContentPane().add(textBranch);
		textBranch.setColumns(10);

		JLabel sem = new JLabel("Semester 1");
		sem.setFont(new Font("Monospaced", Font.BOLD, 17));
		sem.setBounds(25, 291, 107, 19);
		frmAdd.getContentPane().add(sem);

		textSem = new JTextField();
		textSem.setBounds(251, 293, 107, 19);
		frmAdd.getContentPane().add(textSem);
		textSem.setColumns(10);

		JLabel mobile = new JLabel("Mobile");
		mobile.setFont(new Font("Monospaced", Font.BOLD, 17));
		mobile.setBounds(25, 345, 107, 19);
		frmAdd.getContentPane().add(mobile);

		textMob = new JTextField();
		textMob.setBounds(251, 342, 107, 19);
		frmAdd.getContentPane().add(textMob);
		textMob.setColumns(10);

		JLabel email = new JLabel("E-Mail");
		email.setFont(new Font("Monospaced", Font.BOLD, 17));
		email.setBounds(25, 388, 107, 19);
		frmAdd.getContentPane().add(email);

		textEmail = new JTextField();
		textEmail.setBounds(251, 385, 107, 19);
		frmAdd.getContentPane().add(textEmail);
		textEmail.setColumns(10);

		JButton save = new JButton("Save");
		save.addActionListener(e -> {
			String jdbcURL = "jdbc:postgresql://localhost:5432/collegeDB";
			String username = "postgres";
			String password = "2541";
			try {
				Connection connection = DriverManager.getConnection(jdbcURL, username, password);
				String sql = "insert into Data values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1, textFirst.getText());
				pst.setString(2, textLast.getText());
				pst.setString(3, textCourse.getText());
				pst.setString(4, textBranch.getText());

				pst.setString(5, textSem.getText());
				pst.setString(6, "null");
				pst.setString(7, "null");
				pst.setString(8, "null");
				pst.setString(9, "null");
				pst.setString(10, "null");
				pst.setString(11, "null");
				pst.setString(12, "null");



				pst.setDouble(13, Double.parseDouble(textMob.getText()));
				pst.setString(14, textEmail.getText());

				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Added!");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		});
		save.setFont(new Font("Monospaced",Font.BOLD, 18));
		save.setBounds(251,439,107,33);
		frmAdd.getContentPane().add(save);
	}
}
