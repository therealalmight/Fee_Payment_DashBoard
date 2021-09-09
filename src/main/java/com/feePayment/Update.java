// @Author: Bala Sourvendra
package com.feePayment;

import java.awt.EventQueue;
import java.awt.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Update {

	JFrame frmUpdate;

	public void setSearch_in(String search_in) {
		this.search_in = search_in;
	}
	public String getSearch_in() {
		return search_in;
	}
	private String search_in;


	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Update window = new Update();
				window.frmUpdate.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Update() {
		initialize();
	}

	private void initialize() {
		frmUpdate = new JFrame();
		frmUpdate.setTitle("Update");
		frmUpdate.setBounds(100, 100, 403, 262);
		frmUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUpdate.getContentPane().setLayout(null);

		String[] boxOptions = {"Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
		JComboBox<String> comboBox =  new JComboBox<>(boxOptions);
		comboBox.setFont(new Font("Monospaced", Font.BOLD, 17));
		comboBox.setBounds(81, 10, 176, 35);
		frmUpdate.getContentPane().add(comboBox);

		JLabel output = new JLabel("");
		output.setFont(new Font("Tahoma", Font.PLAIN, 14));
		output.setBounds(10, 156, 335, 35);
		frmUpdate.getContentPane().add(output);

		JButton update = new JButton("Update");
		update.addActionListener(e -> {
			String jdbcURL = "jdbc:postgresql://localhost:5432/collegeDB";
			String username = "postgres";
			String password = "2541";

			String[] parts = getSearch_in().split(" ", 2);
			String fname = parts[0];
			String lname = parts[1];
			String cbox = Objects.requireNonNull(comboBox.getSelectedItem()).toString(); // convert selectedItem of comboBox int string and assign it to variable cbox

			try {
				Connection connection = DriverManager.getConnection(jdbcURL, username, password);
				String sql;
				switch (cbox) {                                        // check for multiple value of cbox
					case "Semester 2" -> {
						sql = "update Data set sem2 = 'Paid' where first_name = ? and last_name = ?";
						PreparedStatement pst = connection.prepareStatement(sql);
						pst.setString(1, fname);
						pst.setString(2, lname);
						pst.executeUpdate();
					}
					case "Semester 3" -> {
						sql = "update Data set sem3 = 'Paid' where first_name = ? and last_name = ?";
						PreparedStatement pst1 = connection.prepareStatement(sql);
						pst1.setString(1, fname);
						pst1.setString(2, lname);
						pst1.executeUpdate();
					}
					case "Semester 4" -> {
						sql = "update Data set sem4 = 'Paid' where first_name = ? and last_name = ?";
						PreparedStatement pst2 = connection.prepareStatement(sql);
						pst2.setString(1, fname);
						pst2.setString(2, lname);
						pst2.executeUpdate();
					}
					case "Semester 5" -> {
						sql = "update Data set sem5 = 'Paid' where first_name = ? and last_name = ?";
						PreparedStatement pst3 = connection.prepareStatement(sql);
						pst3.setString(1, fname);
						pst3.setString(2, lname);
						pst3.executeUpdate();
					}
					case "Semester 6" -> {
						sql = "update Data set sem6 = 'Paid' where first_name = ? and last_name = ?";
						PreparedStatement pst4 = connection.prepareStatement(sql);
						pst4.setString(1, fname);
						pst4.setString(2, lname);
						pst4.executeUpdate();
					}
					case "Semester 7" -> {
						sql = "update Data set sem7 = 'Paid' where first_name = ? and last_name = ?";
						PreparedStatement pst5 = connection.prepareStatement(sql);
						pst5.setString(1, fname);
						pst5.setString(2, lname);
						pst5.executeUpdate();
					}
					case "Semester 8" -> {
						sql = "update Data set sem8 = 'Paid' where first_name = ? and last_name = ?";
						PreparedStatement pst6 = connection.prepareStatement(sql);
						pst6.setString(1, fname);
						pst6.setString(2, lname);
						pst6.executeUpdate();
					}
					default -> {
					}
				}
				JOptionPane.showMessageDialog(null, "Updated!");
				connection.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		update.setFont(new Font("Monospaced", Font.BOLD, 18));
		update.setBounds(101, 87, 130, 35);
		frmUpdate.getContentPane().add(update);
	}
}