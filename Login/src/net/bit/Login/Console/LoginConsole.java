package net.bit.Login.Console;

import java.sql.SQLException;
import java.util.Scanner;

import net.bit.Login.Service.*;
import net.bit.Login.DAO.*;

public class LoginConsole {
	private Join join;
	private Login login;
	private DBConnection dbconn;
	private LoginDB db;
	Scanner sc = new Scanner(System.in);
	
	
	public LoginConsole() {
		join = new Join();
		login = new Login();
		db = new LoginDB();
	}
	
	
	public void ID() throws ClassNotFoundException, SQLException {
		while(true) {
			System.out.print("아이디: ");
			String id = sc.next();
			boolean idcheak = new Login(id).IDTest();
			if (idcheak == false) {
			System.out.println("아이디를 찾을 수 없습니다. \n다시입력해주세요. ");
				continue;
			}else{
			System.out.print("비밀번호: ");
			String password = sc.next();
			boolean pwdcheak = new Login(id, password).LoginTest();
			if(pwdcheak){
				System.out.println("로그인 성공!");
			}else {
				System.out.println("비밀번호가 틀렸습니다. 다시입력해주세요! ");
				continue;
			}
			break;}
			}
		
	}// ID() end
		

	
	public void Join() throws ClassNotFoundException {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		try {
			String idcheak = new Join(id).IDTest();
		} catch (SQLException e) {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		}
		System.out.print("비밀번호: ");
		String pwd1 = sc.nextLine();
		System.out.print("비밀번호 확인: ");
		String pwd2 = sc.nextLine();
		System.out.print("이메일: ");
		String email = sc.nextLine();
		System.out.print("폰번호: ");
		String phone = sc.nextLine();
		
		
	}
		
		
	}
	

