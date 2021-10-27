package net.bit.Login.Service;

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
	
	public Join(String id, String password) {
		this.id = id;
		this.password = password;
		
	}
	
	public Join(String id, String password, String email, String phone, String gender) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}
	
	public String IDTest() throws ClassNotFoundException, SQLException {
		DBConnection con = new DBConnection();
		Connection conn = con.getConnect();
		String sql = "INSERT INTO JOIN(ID) VALUES (?)";
		
		return id;
	}
	
//	INSERT INTO products (name, age) VALUES (?, ?);
	
	

} //class end 
