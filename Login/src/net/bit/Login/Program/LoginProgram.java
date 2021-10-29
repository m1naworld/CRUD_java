package net.bit.Login.Program;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;
import net.bit.Login.Console.*;

public class LoginProgram {
	private static LoginConsole console;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		console = new LoginConsole();
//		try {
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.print("1.로그인 2.회원가입 3.회원정보수정: 4.로그아웃: ");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			console.ID();
			continue;
		case 2:
			console.Join();
			break;
		case 3:
			console.Revise();
			break;
		case 4:
			console.LogOut();
			break;
		default: 
			console.LogOut();
			break;
		}
		}
//		}catch(Exception ex) {
//			System.out.println("숫자를 입력해주세요! ");
//		}
		
		
		


	}
}

