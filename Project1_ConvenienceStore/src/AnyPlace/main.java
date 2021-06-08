package AnyPlace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OrcleDriver 가 존재함");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XE", "c##gs25", "1234");
			System.out.println("연결 생성됨");
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("employee_name"));
			}
			rs.close();
			pstmt.close();
			con.close();
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
