package AnyPlace.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jdbc.DBConnector;

/* 이렇게 맞을까요.....
 1. 입력을 한다 / 2. db를 읽고, 확인여부 / 3. 확인여부에 따른 로그인/ 실패메시지
 
 SANAGO
*/

public class Login {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AnyPlace.model.Employee employee = new AnyPlace.model.Employee(); // employee 객체 생성
		List<String> employee_id_list = new ArrayList<String>(); // 현재 회원의 id을 저장
		HikariConfig config = new HikariConfig("./Hikari_Hyeyoung.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		
		System.out.println("회원 ID 입력 : ");
		String employee_id = sc.next();
		
		String select_sql = "SELECT employee_id FROM employee";

		try {		
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(select_sql);
			ResultSet rs = pstmt.executeQuery();
		 
			while(rs.next()) {
				rs.getString("employee_id");		

			} 

		
			pstmt = con.prepareStatement("SELECT employee_id FROM employee");
			pstmt.setString(1, employee_id);
			
			if (rs.next()) {
				if (rs.getString(1).contentEquals(employee_id)) {
				System.out.println("로그인 성공");
					return; // 로그인 성공
				}
				else {
					System.out.println("로그인 실패");
					return; // 로그인 실패
				}
			}
			System.out.println("아이디 오류");
			return; // 아이디 오류
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}