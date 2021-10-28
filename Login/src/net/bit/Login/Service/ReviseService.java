package net.bit.Login.Service;

import java.sql.*;

public class ReviseService {
	private String id;
	private String password;
	private String passwordcheak;
	private String email;
	private String phone;
	private String gender;
	
	
	public ReviseService() {
		
	}
	public ReviseService(String id, String password, String passwordcheak) {
		this.id = id;
		this.password = password;
		this.passwordcheak = passwordcheak;
	}
	
	public ReviseService(String id, String x) {
		this.id = id;
		this.email = x;
		this.phone = x;
		this.gender = x;
	}
	
	public void RevisePWD() throws ClassNotFoundException, SQLException {
			DBConnection con = new DBConnection();
			Connection conn = con.getConnect();
			String sql = "UPDATE JOIN SET PASSWORD = ? WHERE id = ?";
			PreparedStatement ST = conn.prepareStatement(sql);
			ST.setString(1, password);
			ST.setString(2, id);
			ResultSet RS = ST.executeQuery();
	}
	
	public void ReviseEmail() throws ClassNotFoundException, SQLException {
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "UPDATE JOIN SET EMAIL = ? WHERE id = ?";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, email);
		ST.setString(2, id);
		ResultSet RS = ST.executeQuery();
	}

	
	public void RevisePhone() throws ClassNotFoundException, SQLException {
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "UPDATE JOIN SET Phone = ? WHERE id = ?";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, phone);
		ST.setString(2, id);
		ResultSet RS = ST.executeQuery();
	}
}
