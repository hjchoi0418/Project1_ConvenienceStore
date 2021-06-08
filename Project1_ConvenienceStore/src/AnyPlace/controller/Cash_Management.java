package AnyPlace.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cash_Management {
	
	private static int pos_cash = 0;
	private static int db_cash = 0;
	private static int difference = 0;
	private static int _50000won = 0;
	private static int _10000won = 0;
	private static int _5000won = 0;
	private static int _1000won = 0;
	private static int _500won = 0;
	private static int _100won = 0;
	private static int _50won = 0;
	private static int _10won = 0;
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver가 존재함.");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "gs25", "1234");
			System.out.println("연결 생성됨");
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT cash FROM cash");
			ResultSet rs = pstmt.executeQuery();
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
