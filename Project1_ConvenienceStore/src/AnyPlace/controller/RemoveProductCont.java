package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AnyPlace.JPool;

public class RemoveProductCont {
/*
 * 	수불관리
 * 		- 제품 판매 중지 (product_on_sale 컬럼 값을 0 으로 변경)
 */
	public static void main(String[] args) {
		
		String sql = "SELECT PRODUCT_NAME FROM PRODUCT";
		String update_sql = "UPDATE PRODUCT SET PRODUCT_ON_SALE = 0 WHERE PRODUCT_NAME = ?";

		try (Connection conn = JPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement update_pstmt = conn.prepareStatement(update_sql);
				ResultSet rs = pstmt.executeQuery();) {

			System.out.println("-- 제품 목록 --");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		
			String product_name = "부산우유250ML";
			
			update_pstmt.setString(1, product_name);
			update_pstmt.executeUpdate();
			
//			ResultSetMetaData rsmd = rs.getMetaData();
			
//			int col_cnt = rsmd.getColumnCount();
//			System.out.println("컬럼 갯수 : " + col_cnt);
//			for (int i = 1; i <= col_cnt; i++) {
//				System.out.println("-----------------------------------");
//				System.out.println(i + "번째 컬럼 이름 : " + rsmd.getColumnLabel(i));
//				System.out.println(i + "번째 컬럼 타입 : " + rsmd.getColumnTypeName(i));
//				System.out.println(i + "번째 컬럼 크기 : " + rsmd.getPrecision(i));
//			}
//			while(rs.next()) {
//				for(int i=1; i<=col_cnt; i++) 
//					System.out.print(rs.getString(i) + " | ");
//				System.out.println();
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}