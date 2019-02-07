package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	
	public static Connection getConnection() {
		 Connection con=null;  
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate", "root", "");			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;		
	}
	
	public static boolean validate(String username,String password) {
		try {
			Connection con=DAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select  username,password from login where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);			
			ResultSet rs=ps.executeQuery();			
			if(rs.next()) {			
			String usr=rs.getString(1);
			String pas=rs.getString(2);			
			if(usr.equals(username)&& pas.equals(pas))
				return true;
			else
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
}
