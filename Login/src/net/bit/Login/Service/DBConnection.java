package net.bit.Login.Service;

import java.sql.*;

public class DBConnection {
	private String url = "jdbc:oracle:thin:@192.168.0.249:1521:XE";
	private String id = "mina";
	private String password = "120408";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	Connection CN = null;
	
	public Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		CN = DriverManager.getConnection(url, id, password);
		
		return CN;
	} //end
	
} //class end


