// @Author: Bala Sourvendra
package com.feePayment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;

public class DashBoard {

	JFrame frmDashBoard;
	JTextField txtSearch;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DashBoard window = new DashBoard();
				window.frmDashBoard.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public DashBoard() {
		initialize();
	}

	private void initialize() {
		frmDashBoard = new JFrame();
		frmDashBoard.setTitle("HOME");
		frmDashBoard.setBounds(100, 100, 950, 398);
		frmDashBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashBoard.getContentPane().setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Monospaced", Font.PLAIN, 15));  // font type = 'Monospaced' style = plain, size = 15
		txtSearch.setBounds(10, 93, 346, 38);               // first two value as position in (x,y) co-ordinate and rest two are width and height of jtextfield
		frmDashBoard.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel search_out = new JLabel("");
		search_out.setFont(new Font("Monospaced", Font.BOLD, 12));
		search_out.setBounds(18, 224, 950, 79);
		frmDashBoard.getContentPane().add(search_out);
		
		JButton click_search = new JButton("SEARCH");
		// Search operation
		click_search.addActionListener(e -> {
			String jdbcURL = "jdbc:postgresql://localhost:5432/collegeDB";      //url to localhost database collegeDB
			String username = "postgres";                      // username to login into database
			String password = "2541";                          // password

			try {
				String Input = txtSearch.getText();
				String[] parts = Input.split(" ", 2);
				String fname = parts[0];
				String lname = parts[1];

				Connection connection = DriverManager.getConnection(jdbcURL, username, password);

				String search = "select * from Data where first_name= ? and last_name = ? "; //Row selected on the basis of first and last name provided in search box
				PreparedStatement statement = connection.prepareStatement(search);
				statement.setString(1, fname);
				statement.setString(2, lname);

				ResultSet rs = statement.executeQuery();    // get table
				while(rs.next()) {                       // get table until next table
                        // Concatenate output of single row inside '[]' using column separator as ',' and space
						String psl = ("["+ rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getString(5) + ", " + rs.getString(6) + ", " + rs.getString(7) + ", " + rs.getString(8) + ", " + rs.getString(9) + ", " + rs.getString(10) + ", " + rs.getString(11) + ", " + rs.getString(12) + ", " + rs.getString(13) + ", " + rs.getString(14) + "]") ;
						search_out.setText(psl);  //set row as a string inside a jlabel search_out
				}
				statement.executeUpdate();
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		click_search.setFont(new Font("Monospaced", Font.BOLD, 17));
		click_search.setBounds(363, 93, 164, 38);
		frmDashBoard.getContentPane().add(click_search);
		
		JButton click_add = new JButton("ADD");
		click_add.addActionListener(e -> {
			Add add = new Add();                           // Call Add Class to perform Create operation
			add.frmAdd.setVisible(true);
		});
		click_add.setFont(new Font("Monospaced", Font.BOLD, 17));
		click_add.setBounds(18, 176, 164, 38);
		frmDashBoard.getContentPane().add(click_add);
		
		JButton click_update = new JButton("UPDATE");
		click_update.addActionListener(e -> {
			String str = txtSearch.getText();
			Update update = new Update();                      // call update class to perform update operation
			update.setSearch_in(str);                          // Set value of search box into search_in variable of update class using setter method
			update.frmUpdate.setVisible(true);
		});
		click_update.setFont(new Font("Monospaced", Font.BOLD, 17));
		click_update.setBounds(192, 176, 164, 38);
		frmDashBoard.getContentPane().add(click_update);
		
		JButton click_del = new JButton("DELETE");                     // Delete operation
		click_del.addActionListener(e -> {
			String jdbcURL = "jdbc:postgresql://localhost:5432/collegeDB";
			String username = "postgres";
			String password = "2541";
			try {

				String Input = txtSearch.getText();
				String[] parts = Input.split(" ", 2);
				String fname = parts[0];
				String lname = parts[1];

				Connection connection = DriverManager.getConnection(jdbcURL, username, password);   // initialize SQL connection

				String delete = "delete from Data where first_name= ? and last_name = ? ";       //sql query to delete row of provided student entry
				PreparedStatement statement = connection.prepareStatement(delete);
				statement.setString(1, fname);
				statement.setString(2, lname);
				String cmd = (Input + " Deleted!");
				search_out.setText(cmd);                                                   // print string cmd on jlabel search_out
				statement.executeUpdate();
				connection.close();
			} catch (SQLException ez){
				ez.printStackTrace();
			}
		});
		click_del.setFont(new Font("Monospaced", Font.BOLD, 17));
		click_del.setBounds(363, 176, 164, 38);
		frmDashBoard.getContentPane().add(click_del);
		
		JButton click_view = new JButton("VIEW");
		click_view.addActionListener(e -> {
			View view = new View();                             // call view
			view.frmView.setVisible(true);
		});
		click_view.setFont(new Font("Monospaced", Font.BOLD, 17));
		click_view.setBounds(539, 176, 164, 38);
		frmDashBoard.getContentPane().add(click_view);
		
		JLabel title = new JLabel("Payment Dash Board");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Monospaced", Font.BOLD, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);             // text-aligned in center
		title.setBounds(192, 10, 340, 38);
		frmDashBoard.getContentPane().add(title);
	}
}
