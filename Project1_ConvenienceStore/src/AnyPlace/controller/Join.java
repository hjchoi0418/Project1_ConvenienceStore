package AnyPlace.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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

import AnyPlace.model.Employee;


public class Join {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AnyPlace.model.Employee employee = new AnyPlace.model.Employee(); // employee ��ü ����
		List<String> employee_id_list = new ArrayList<String>(); // ���� ȸ���� id�� ����
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		try {		
			Connection con = ds.getConnection();
			System.out.println("���� ������");
			String select_sql = "SELECT * FROM employee ORDER BY employee_no";
			PreparedStatement pstmt = con.prepareStatement(select_sql);
			ResultSet rs = pstmt.executeQuery();
		 
			while(rs.next()) {
				employee.setEmployee_no(rs.getString(1));
				employee.setEmployee_id(rs.getString(2));		
				employee_id_list.add(employee.getEmployee_id());
				employee.setEmployee_name(rs.getString(3));			
				employee.setHire_date(rs.getString(4));
				employee.setEmployee_wage(rs.getString(5));
				employee.setLast_date(rs.getString(6));
			} 
			
			System.out.print("���ο� ȸ�� �̸� �Է� : ");
			String new_employee_name = sc.next();
			System.out.print("���ο� ID �Է� : ");
			String new_employee_id = sc.next();
				
			new_employee_id = redundancy_Check(new_employee_id, employee_id_list); // �ߺ��˻�
			
			SimpleDateFormat date_format = new SimpleDateFormat("yy/MM/dd"); 
			Calendar time = Calendar.getInstance();
			String hire_time = date_format.format(time.getTime());
			
			//no, id, name, hire_date, wage, last_date
			pstmt = con.prepareStatement("INSERT INTO employee VALUES(employee_seq.nextval, ?, ?, ?, '8350', NULL)");
			pstmt.setString(1, new_employee_id);
			pstmt.setString(2, new_employee_name);
			pstmt.setString(3, hire_time);
			pstmt.executeUpdate();
			
			System.out.println("ȸ�� ���� ����");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String redundancy_Check(String new_employee_id, List<String> employee_id_list) {// �ߺ��� ������..
		boolean _switch = false;
		Scanner sc = new Scanner(System.in);
		while(true) {
			if (_switch) {
				System.out.print("���ο� ID �Է� : ");
				new_employee_id = sc.next();}
			for(String id : employee_id_list) {
				if(new_employee_id == id) {
					System.out.println("������ ID ����");
					_switch = true;
				}
				else 
					_switch = false;
			}
			if (_switch) continue;
			else break;
		}
		return new_employee_id;
	}
}
