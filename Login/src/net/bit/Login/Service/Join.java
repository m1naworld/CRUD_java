package net.bit.Login.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;


public class Join {
	private String id;
	private String password;
	private String email;
	private String phone;
	private String gender;

	
	public Join() {
		
	};
	
	public Join(String id) {
		this.id = id;
	}
	
	public Join(String id, String password) throws NoSuchAlgorithmException {
		this.id = id;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		this.password = hex;
		
	}
	
	public Join(String id, String password, String email, String phone, String gender) throws NoSuchAlgorithmException {
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		this.password = hex;
	}
	
	
	public boolean IDCheak() throws ClassNotFoundException, SQLException {
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "SELECT ID FROM JOIN WHERE id = ?";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, id);
		ResultSet RS = ST.executeQuery();
	    boolean idcheak = RS.next();
	    while(RS.next()) {
	    	return true;
	    }
	    return idcheak;
} //idcheak end
	
	
	public void IDInsert() throws ClassNotFoundException, SQLException {
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "INSERT INTO JOIN (ID) VALUES (?)";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, id);
		ResultSet RS = ST.executeQuery();
		
	}// idinsert end 
	
	public void PwdCheak() throws ClassNotFoundException, SQLException {
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "UPDATE JOIN SET password = ? WHERE ID = ?";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, password);
		ST.setString(2, id);	
		ResultSet RS = ST.executeQuery();
	}
	
	public void AllInsert() throws ClassNotFoundException, SQLException {
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "UPDATE JOIN SET email = ?,PHONE = ?, GENDER = ? WHERE ID = ?";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, email);
		ST.setString(2, phone);
		ST.setString(3, gender);
		ST.setString(4, id);
		ResultSet RS = ST.executeQuery();
	}

	

} //class end 
