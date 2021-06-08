package AnyPlace.controller;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import AnyPlace.JPool;
import AnyPlace.main;
import AnyPlace.model.*;

public class AddProductCont {
/*
 *  수불관리 
 *  	- 새로운 상품 추가
 */
	
	public static void main(String[] args) {
		
		ArrayList<Product> product_list= new ArrayList<>();
		ArrayList<String> category_list= new ArrayList<>();
		
		// String sql = "SELECT P.PRODUCT_NAME, AP.* FROM PRODUCT P, ALL_PRODUCTS AP WHERE P.PRODUCT_NO = AP.PRODUCT_NO";
		String sql = "SELECT CATEGORY_NAME FROM CATEGORY";
		String sql_insert = "INSERT INTO PRODUCT VALUES\r\n" + 
				"    ((SELECT MAX(PRODUCT_NO)+1 FROM PRODUCT),\r\n" + 
				"     (SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME = ?),\r\n" + 
				"     ?,\r\n" + 
				"     ?,\r\n" + 
				"     NULL,\r\n" + 
				"     1)";

		try (Connection conn = JPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt_insert = conn.prepareStatement(sql_insert);
				ResultSet rs = pstmt.executeQuery();) {

			System.out.println("-- 카테고리 목록 --");
			while(rs.next()) {
				category_list.add(rs.getString(1));
				System.out.println(rs.getString(1));
			}
		
			System.out.println(category_list);
			String product_name = "부산우유250ML";
			String category = "유제품";
			String product_price = "2300";
			
			pstmt_insert.setString(1, category);
			pstmt_insert.setString(2, product_name);
			pstmt_insert.setString(3, product_price);
			
			pstmt_insert.executeUpdate();
			
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