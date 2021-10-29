package net.bit.Login.Service;

import java.util.HashMap;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import net.bit.Login.DAO.*;


public class Login {
	private String id;
	private String password;
	
	public Login() {
		
	}
	
	public Login(String id) {
		this.id = id;
	}
	
	public Login(String id, String password) throws NoSuchAlgorithmException {
		this.id = id;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		this.password = hex;
		
		
	}

	
	public boolean IDTest() throws ClassNotFoundException, SQLException{
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "SELECT ID FROM JOIN WHERE id = ?";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, id);
		ResultSet RS = ST.executeQuery();
		boolean idcheak = RS.next();
		while(idcheak == true) {
			String uid = RS.getString("ID");
			return idcheak;
		}// while end	
		return idcheak;    
}//method end
	
	
	public boolean LoginTest() throws ClassNotFoundException, SQLException{
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "SELECT * FROM JOIN WHERE id = ?";
		PreparedStatement ST = conn.prepareStatement(sql);
		ST.setString(1, id);
		ResultSet RS = ST.executeQuery();
		while(RS.next()) {
			String uid = RS.getString("ID");
			String upwd = RS.getString("PASSWORD");
			boolean pwdcheak = password.equals(upwd);
			return pwdcheak;
		} //while end
		return false;	
}//method end
	
	public HashMap SuccessLogin() {
		HashMap<String, String> map = new HashMap();
		map.put(id, password);
		return map;
	}
	

}// class end
	
	
	

