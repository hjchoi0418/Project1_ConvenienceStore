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
 *  ���Ұ��� 
 *  	- ���ο� ��ǰ �߰�
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
	
	// ī�װ� ���
	public static String[] getCategoryList(PreparedStatement pstmt,ResultSet rs) {
//		System.out.println("-- ī�װ� ��� --");
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
	// ���ο� ��ǰ�߰�
	public static void addProduct(PreparedStatement pstmt_insert,String[] product_info) {
		// product_info
		// 1.ī�װ�, 2.��ǰ�̸�, 3.�ǸŰ���, 4.����
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
			// ���߿� �� �迭������ gui���� �Է��Ѱ��� �޾Ƽ� �� ��
			String[] product_info = {"����ǰ","�׳ɿ���250ML","2700","2300"};
			
			addProduct(pstmt_insert,product_info);


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
