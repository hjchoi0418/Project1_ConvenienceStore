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

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}