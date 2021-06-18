package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import AnyPlace.JPool;
import AnyPlace.model.Product;

public class AddProductCont {
/*
 *  수불관리 
 *  	- 새로운 상품 추가
 */
	static ArrayList<Product> product_list= new ArrayList<>();
	static ArrayList<String> category_list= new ArrayList<>();
	static String[] category_arr;
	static String sql = "SELECT CATEGORY_NAME FROM CATEGORY";
	
	static String sql_insert = "INSERT INTO PRODUCT VALUES\r\n" + 
			"    ((SELECT MAX(PRODUCT_NO)+1 FROM PRODUCT),\r\n" + 
			"     (SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME = ?),\r\n" + 
			"     ?,\r\n" + 
			"     ?,\r\n" + 
			"     NULL,\r\n" + 
			"     1," + 
			"?)";
	
	// 카테고리 목록
	public static String[] getCategoryList(PreparedStatement pstmt,ResultSet rs) {
//		System.out.println("-- 카테고리 목록 --");
		try {
			while(rs.next()) {
				category_list.add(rs.getString(1));
//				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
//		System.out.println(category_list);
		
		category_arr = new String[category_list.size()];
		for(int i=0; i<category_arr.length; i++) {
			category_arr[i] = category_list.get(i);
		}
		return category_arr;
	}
	// 새로운 상품추가
	public static void addProduct(PreparedStatement pstmt_insert,String[] product_info) {
		// product_info
		// 1.카테고리, 2.제품이름, 3.판매가격, 4.원가
		try {
		for(int i=1; i<=product_info.length; i++) {
		
				pstmt_insert.setString(i, product_info[i-1]);
//				System.out.println(product_info[i-1]);
			
		}
		pstmt_insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		try (Connection conn = JPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt_insert = conn.prepareStatement(sql_insert);
				ResultSet rs = pstmt.executeQuery();) {

			getCategoryList(pstmt,rs);
			// 나중에 이 배열정보를 gui에서 입력한것을 받아서 올 것
			String[] product_info = {"유제품","그냥우유250ML","2700","2300"};
			
			addProduct(pstmt_insert,product_info);


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
