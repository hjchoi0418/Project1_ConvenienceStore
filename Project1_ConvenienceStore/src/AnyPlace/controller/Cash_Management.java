package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AnyPlace.DBConnector;

public class Cash_Management {

	private static int db_cash = 0;
	
	public static void main(String[] args) {
		
	}
	
	public static int getDbCash() {
		String sql = "SELECT amount FROM cash";

		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			
			while (rs.next()) 
				db_cash = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return db_cash;
	}
}
