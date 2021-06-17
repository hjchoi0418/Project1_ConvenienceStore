package AnyPlace.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import AnyPlace.DBConnector;

=======
>>>>>>> refs/remotes/origin/Wonhyeyoung
public class Cash_Management {
<<<<<<< HEAD

=======
	
	private static int pos_cash = 0;
>>>>>>> refs/remotes/origin/Wonhyeyoung
	private static int db_cash = 0;
	
	public static void main(String[] args) {
<<<<<<< HEAD
		
	}
	
	public static int getDbCash() {
		String sql = "SELECT amount FROM cash";

		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
=======
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver가 존재함.");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "gs25", "1234");
			System.out.println("연결 생성됨");
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT cash FROM cash");
			ResultSet rs = pstmt.executeQuery();
>>>>>>> refs/remotes/origin/Wonhyeyoung
			
<<<<<<< HEAD
			while (rs.next()) 
				db_cash = rs.getInt(1);
=======
			rs.next();
			db_cash = rs.getInt(1);
			
			pos_cash = _50000won * 50000 +
					_10000won * 10000 +
					_5000won * 5000 +
					_1000won * 1000 +
					_500won * 500 +
					_100won * 100 +
					_50won * 50 +
					_10won * 10;
			
			difference = pos_cash - db_cash;
			
			System.out.println("차이 : " + difference);
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
>>>>>>> refs/remotes/origin/Wonhyeyoung
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
