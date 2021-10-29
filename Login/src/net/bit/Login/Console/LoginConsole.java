package net.bit.Login.Console;

import java.util.Map.Entry;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import net.bit.Login.Service.*;
import net.bit.Login.DAO.*;

public class LoginConsole {
	Scanner sc = new Scanner(System.in);
	private String id;
	private String password;
	private HashMap user;
	
	public LoginConsole() {

	}
	
	public void ID() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
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
				user = new Login(id, password).SuccessLogin();
				break;
			}else {
				System.out.println("비밀번호가 틀렸습니다. 다시입력해주세요! ");
				continue;
			}
		}
	} // while
		
    }// ID() end


	
	public void Join() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
		while(true) {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		boolean idcheak = new Join(id).IDCheak();
		if(idcheak) {
			System.out.println("아이디가 중복되었습니다.");
			continue;
		}else {
			System.out.println("사용하실 수 있는 아이디입니다.");
			System.out.print("사용하시겠습니까?(Y/N): ");
			String cheak = sc.nextLine();
			if (cheak.equalsIgnoreCase("y")) {
				new Join(id).IDInsert();
			}else if(cheak.equalsIgnoreCase("n")){
				System.out.println("아이디를 다시 입력해주세요! ");
				continue;
			}else {
				System.out.println("Y/N 혹은 y/n으로만 입력해주세요! ");
				continue;
			}
		} //id
			
		while(true) {
			System.out.print("비밀번호: ");
			String pwd1 = sc.nextLine();
			System.out.print("비밀번호 확인: ");
			String pwd2 = sc.nextLine();
			if(pwd1.equals(pwd2)) {
				new Join(id, pwd1).PwdCheak();
				System.out.print("이메일: ");
				String email = sc.nextLine();
				System.out.print("폰번호: ");
				String phone = sc.nextLine();
				System.out.print("성별(F/M): ");
				String gender = sc.nextLine();
				if(gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("M")) {
					new Join(id, pwd1, email, phone, gender).AllInsert();
					System.out.println("회원가입에 성공하였습니다! ");
					break;
				}else{
					System.out.println("성별을 F/M 혹은"
							+ " f/m으로만 입력해주세요! ");
					System.out.print("성별(F/M): ");
					gender = sc.nextLine();
					new Join(id, pwd1, email, phone, gender).AllInsert();
					System.out.println("회원가입에 성공하였습니다! ");
					break;
				}
			}else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시입력해주세요! ");
				continue;
			}
		} // end 
		break;
	} // cheak end
} // join method end
	
	public void Revise() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		try {
		String id;
		String password;
		Set set = user.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			Entry<String,String> entry = (Entry)iterator.next();
			id = (String)entry.getKey();
			password = (String)entry.getValue();
			if(id == null) {
				System.out.println("로그인부터 해주세요!");
				ID();
			}
			while(true) {if(user.containsKey(id)) {
				System.out.println("개인정보를 수정하려면 아이디와 비밀번호를 한번 더 입력해주세요. ");
				System.out.print("아이디: ");
				String rid = sc.next();
				System.out.print("비밀번호: ");
				String rpwd = sc.next();
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(rpwd.getBytes());
				String hex = String.format("%064x", new BigInteger(1, md.digest()));
				if(user.containsKey(rid) && user.containsValue(hex)) {
					System.out.print("1.비밀번호수정 2.이메일수정 3.폰번호수정 4.취소: ");
					int num = sc.nextInt();
					switch(num) {
					case 1:
						while(true) {
						System.out.print("비밀번호: ");
						String pwd1 = sc.next();
						System.out.print("비밀번호 확인: ");
						String pwd2 = sc.next();
						if(pwd1.equals(pwd2)) {
							new ReviseService(rid, pwd1, pwd2).RevisePWD();
							System.out.println("비밀번호가 변경되었습니다! ");
							break;
						}else {
							System.out.println("비밀번호가 일치하지 않습니다. 다시입력해주세요. ");
							continue;
						}
						}break;
					case 2:
						System.out.print("이메일: ");
						String email = sc.next();
						new ReviseService(rid, email).ReviseEmail();
						System.out.println("이메일이 변경되었습니다! ");
						break;
					case 3:
						System.out.print("폰번호: ");
						String phone = sc.next();
						new ReviseService(rid, phone).RevisePhone();
						System.out.println("인증번호를 입력해주세요!");
						break;
					case 4:
						break;
					}
				}else {
					System.out.println("아이디와 비밀번호가 일치하지 않습니다. 다시 입력해주세요! ");
					continue;
				}
				}break; //while
			}
		}
			
		}catch(Exception ex) {
			System.out.println("로그인부터 해주세요!");
			ID();
		} 
	
	} //revise end
	

	public void LogOut() {
		user.clear();
		user.put(null, null);
		System.out.println("로그아웃 되셨습니다!");
	}
	

		
		
} // console end
	

