package AnyPlace.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.DBConnector;

/* �̷��� �������.....
 1. �Է��� �Ѵ� / 2. db�� �а�, Ȯ�ο��� / 3. Ȯ�ο��ο� ���� �α���/ ���и޽���
 
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
					System.out.println("�α��� ����");
						return 1; // �α��� ����
					}
					else {
						System.out.println("�α��� ����");
						return 0; // �α��� ����
					}
				}
				System.out.println("���̵� ����");
				return -1; // ���̵� ����
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("�Էµ��� ���� ID");
			return -2; // DB ���� 
		}
	
		
		System.out.println("ID �Է� > ");
		Scanner sc = new Scanner(System.in);
		String user_ID = sc.nextLine();
}

