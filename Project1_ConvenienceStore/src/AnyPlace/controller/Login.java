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

/* �̷��� �������.....
 1. �Է��� �Ѵ� / 2. db�� �а�, Ȯ�ο��� / 3. Ȯ�ο��ο� ���� �α���/ ���и޽���
 
 SANAGO
*/

public class Login {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AnyPlace.model.Employee employee = new AnyPlace.model.Employee(); // employee ��ü ����
		List<String> employee_id_list = new ArrayList<String>(); // ���� ȸ���� id�� ����
		HikariConfig config = new HikariConfig("./Hikari_Hyeyoung.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		
		System.out.println("ȸ�� ID �Է� : ");
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
				System.out.println("�α��� ����");
					return; // �α��� ����
				}
				else {
					System.out.println("�α��� ����");
					return; // �α��� ����
				}
			}
			System.out.println("���̵� ����");
			return; // ���̵� ����
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}