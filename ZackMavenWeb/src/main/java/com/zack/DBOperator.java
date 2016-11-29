package com.zack;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class DBOperator {

	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/asdf";
	private static String uname = "root";
	private static String pass = "bigwhite";

	private static void connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url, uname, pass);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void disconnect() throws SQLException {
		connection.close();
	}

	public static void addRecord(String name, String phone, String address) {
		try {
			connect();
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO `stafflist` (name,phone,address) VALUE(?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.executeUpdate();
			disconnect();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Staff> searchRecord(String input1) {

		List<Staff> staffs = new ArrayList<Staff>();
		
		try {
			connect();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM stafflist WHERE id = ? OR name = ? OR phone = ? OR address = ?");
			pstmt.setString(1, input1);
			pstmt.setString(2, input1);
			pstmt.setString(3, input1);
			pstmt.setString(4, input1);
			ResultSet resultSet = (ResultSet) pstmt.executeQuery();

			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				
				staffs.add(new Staff(id, name, phone, address));
			}

			disconnect();
			pstmt.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return staffs;
	}

	public static List<Staff> deleteRecord1() {
		
		List<Staff> staffs = new ArrayList<Staff>();
		
		try {
			connect();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM stafflist");
			ResultSet resultSet = (ResultSet) pstmt.executeQuery();

			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				
				staffs.add(new Staff(id, name, phone, address));
			}
			
			disconnect();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return staffs;
	}

	public static void deleteRecord2(int id) {
		try {
			connect();
			String deleteSQL = "DELETE FROM stafflist WHERE id = ?";
			PreparedStatement pstmt = connection.prepareStatement(deleteSQL);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Record is deleted!");
			disconnect();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
