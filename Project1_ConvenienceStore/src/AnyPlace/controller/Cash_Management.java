package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AnyPlace.JPool;

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
		String sql = "SELECT cash FROM cash";

		try (Connection conn = JPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			
			rs.next();
			db_cash = rs.getInt(1);

			pos_cash = _50000won * 50000 +
					_10000won * 10000 +
					_5000won * 5000 +
					_1000won * 1000 +
					_500won * 500 +
					_100won * 100+
					_50won * 50 +
					_10won * 10;

			difference = pos_cash - db_cash;

			System.out.println("점검계 : " + db_cash);
			System.out.println("pos 현금 : " + pos_cash);
			System.out.println("차이 : " + difference);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
