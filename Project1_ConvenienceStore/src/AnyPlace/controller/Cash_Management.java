package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AnyPlace.DBConnector;
import AnyPlace.view.Cash_Management_view;

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
	
	static Cash_Management_view cmView = new Cash_Management_view();

	public static void main(String[] args) {
		
	}
	
	public static int getPosCash() {
		_50000won = cmView.get50000();
		_10000won = cmView.get10000();
		_5000won = cmView.get5000();
		_1000won = cmView.get1000();
		_500won = cmView.get500();
		_100won = cmView.get100();
		_50won = cmView.get50();
		_10won = cmView.get10();
		
		pos_cash = _50000won * 50000 +
				_10000won * 10000 +
				_5000won * 5000 +
				_1000won * 1000 +
				_500won * 500 +
				_100won * 100+
				_50won * 50 +
				_10won * 10;
		
		return pos_cash;
	}
	
	public static int getDbCash() {
		String sql = "SELECT cash FROM cash";

		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			
			rs.next();
			db_cash = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return db_cash;
	}
}
