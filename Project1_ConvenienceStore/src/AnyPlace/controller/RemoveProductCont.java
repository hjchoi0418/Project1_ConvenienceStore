package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AnyPlace.JPool;

public class RemoveProductCont {
/*
 * 	���Ұ���
 * 		- ��ǰ �Ǹ� ���� (product_on_sale �÷� ���� 0 ���� ����)
 */
	public static void main(String[] args) {
		
		String sql = "SELECT PRODUCT_NAME FROM PRODUCT";
		String update_sql = "UPDATE PRODUCT SET PRODUCT_ON_SALE = 0 WHERE PRODUCT_NAME = ?";

		try (Connection conn = JPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement update_pstmt = conn.prepareStatement(update_sql);
				ResultSet rs = pstmt.executeQuery();) {

			System.out.println("-- ��ǰ ��� --");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		
			String product_name = "�λ����250ML";
			
			update_pstmt.setString(1, product_name);
			update_pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}