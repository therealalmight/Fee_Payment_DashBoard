// @Author: Bala Sourvendra
package com.feePayment;

import java.awt.*;

import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class View {
	JFrame frmView;
	JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				View window = new View();
				window.frmView.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public View() {
		initialize();
	}

	private void initialize() {
		frmView = new JFrame();
		frmView.setTitle("Student Data");
		frmView.setBounds(100, 100, 1366, 768);
		frmView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmView.getContentPane().setLayout(null);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
				new Object[][] {{
						"First Name", "Last Name", "Course", "Branch", "Sem 1", "Sem 2", "Sem 3", "Sem 4","Sem 5", "Sem 6","Sem 7", "Sem 8", "Mobile", "Email"
				}},
				new String[] {
						"first_name", "last_name", "course_name", "branch", "sem1", "sem2", "sem3", "sem4", "sem5", "sem6", "sem7", "sem8", "mobile", "email"
				}
		));
		table.setBounds(20, 54, 1286, 667);
		frmView.getContentPane().add(table);

		JButton generate = new JButton("Generate");
		generate.addActionListener(e -> {
			String jdbcURL = "jdbc:postgresql://localhost:5432/collegeDB";
			String username = "postgres";
			String password = "2541";

			try {
				Connection connection = DriverManager.getConnection(jdbcURL, username, password);

				String sql = "select * from Data ";
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql);

				while (rs.next()) {
					String first = String.valueOf(rs.getString(1));
					String last = String.valueOf(rs.getString(2));
					String course = String.valueOf(rs.getString(3));
					String branch = String.valueOf(rs.getString(4));
					String sem1 = String.valueOf(rs.getString(5));
					String sem2 = String.valueOf(rs.getString(6));
					String sem3 = String.valueOf(rs.getString(7));
					String sem4 = String.valueOf(rs.getString(8));
					String sem5 = String.valueOf(rs.getString(9));
					String sem6 = String.valueOf(rs.getString(10));
					String sem7 = String.valueOf(rs.getString(11));
					String sem8 = String.valueOf(rs.getString(12));
					String mobile = String.valueOf(rs.getString(13));
					String email = String.valueOf(rs.getString(14));

					String[] table1 = {first, last, course, branch, sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8, mobile, email};
					 DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					 tableModel.addRow(table1);
				}
				connection.close();
			} catch (SQLException ex) {
				System.out.println("Connection to postgres Sql Failed");
				ex.printStackTrace();
			}
		});
		generate.setFont(new Font("Monospaced", Font.BOLD, 17));
		generate.setBounds(20, 13, 159, 31);
		frmView.getContentPane().add(generate);
	}
}