package AnyPlace.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.DBConnector;

/* 이렇게 맞을까요.....
 1. 입력을 한다 / 2. db를 읽고, 확인여부 / 3. 확인여부에 따른 로그인/ 실패메시지
 
 SANAGO
*/

public class Login {

	public static void main(String[] args) {



		final private Connection conn;
		private PreparedStatement pstmt;
		private ResultSet rs;
		
		public int login(String EMPLOYEE_ID) {
			String keyword = "SANAGO"
			String SQL = "SELECT EMPLOYEE_ID FROM EMPLOYEE = ?";
			
			try (
					Connection conn = DBConnector.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
						
				) {
					pstmt.setString(1, String.format("%%%s%%", keyword));
//					 pstmt.setString(1, "5" + keyword + "%");

					ResultSet rs = pstmt.executeQuery();
					
					while (rs.next()) {
						System.out.printf("%-10d%-15s%-15s%-10d\n",
							rs.getString("employee_id"),
					}
					
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
						
				}
			}
		
		if () {
			
			// --------------------------
		}
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1,  EMPLOYEE_ID);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if (rs.getString(1).contentEquals(EMPLOYEE_ID)) {
					System.out.println("로그인 성공");
						return 1; // 로그인 성공
					}
					else {
						System.out.println("로그인 실패");
						return 0; // 로그인 실패
					}
				}
				System.out.println("아이디 오류");
				return -1; // 아이디 오류
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("입력되지 않은 ID");
			return -2; // DB 오류 
		}
	
		
		System.out.println("ID 입력 > ");
		Scanner sc = new Scanner(System.in);
		String user_ID = sc.nextLine();
}

