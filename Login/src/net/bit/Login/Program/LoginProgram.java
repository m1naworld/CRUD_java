package net.bit.Login.Program;

import java.sql.*;
import java.util.Scanner;
import net.bit.Login.Console.*;

public class LoginProgram {
	private static LoginConsole console;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		console = new LoginConsole();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1.로그인 2.회원가입 3.회원정보수정: ");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			console.ID();
		case 2:
			console.Join();
			break;
		case 3:
			break;
		default: break;
			
		
		}
		
		
		


	}
}

