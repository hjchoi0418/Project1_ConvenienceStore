package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class Join {
	
	static boolean success;
	static String new_employee_id;
	static String new_employee_name;
	
	public static String getNew_employee_id() {
		return new_employee_id;
	}

	public static boolean isSuccess() {
		return success;
	}

	public static void setSuccess(boolean success) {
		Join.success = success;
	}

	public static void setNew_employee_id(String new_employee_id) {
		Join.new_employee_id = new_employee_id;
	}

	public static String getNew_employee_name() {
		return new_employee_name;
	}

	public static void setNew_employee_name(String new_employee_name) {
		Join.new_employee_name = new_employee_name;
	}

	public static void main(String[] args) {
		success=false;
		AnyPlace.model.Employee employee = new AnyPlace.model.Employee(); // employee 객체 생성
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		try {		
			Connection con = ds.getConnection();
			System.out.println("연결 생성됨");
			String select_sql = "SELECT * FROM employee ORDER BY employee_no";
			PreparedStatement pstmt = con.prepareStatement(select_sql);
			ResultSet rs = pstmt.executeQuery();
		 
			while(rs.next()) {
				employee.setEmployee_no(rs.getString(1));
				employee.setEmployee_id(rs.getString(2));		
				employee.setEmployee_name(rs.getString(3));			
				employee.setHire_date(rs.getString(4));
				employee.setEmployee_wage(rs.getString(5));
				employee.setLast_date(rs.getString(6));
			} 
				
			SimpleDateFormat date_format = new SimpleDateFormat("yy/MM/dd"); 
			Calendar time = Calendar.getInstance();
			String hire_time = date_format.format(time.getTime());

			//no, id, name, hire_date, wage, last_date
			pstmt = con.prepareStatement("INSERT INTO employee VALUES(employee_seq.nextval, ?, ?, ?, '8350', NULL)");
			pstmt.setString(1, new_employee_id);
			pstmt.setString(2, new_employee_name);
			pstmt.setString(3, hire_time);
			pstmt.executeUpdate();

			System.out.println("회원 가입 성공");
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}