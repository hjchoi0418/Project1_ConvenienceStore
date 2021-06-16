package AnyPlace.controller.product_sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import AnyPlace.DBConnector;

public class Order_product {
	
	Scanner sc;

	// 1.임시로 order_ 만듬
	public void Temporary_order() {
		this.sc = new Scanner(System.in);
		String sql = "INSERT INTO order_ (order_no, order_date, payment_method, order_amount)"
				+ "VALUES((SELECT MAX(order_no)+1 FROM order_), "
				+ "SYSDATE, "
				+ "?, "
				+ "2)";
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.print("결제 방식을 선택해주세요 (카드 : 1 현금 : 2)\n>>");			
			int payment_method = sc.nextInt();
			pstmt.setInt(1, payment_method);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}
	
	// 2.order_detail 만듬
	public void detail_order() {
		this.sc = new Scanner(System.in);
		String sql_insert = "INSERT INTO order_detail"
				+ "(order_detail_no, order_no, serial_no, order_detail_price)"
				+ "VALUES((SELECT MAX(order_detail_no)+1 FROM ORDER_DETAIL),"
				+ "(SELECT MAX(order_no)FROM order_),"
				+ "?,"
				+ "?)";
		
		String sql_update = "UPDATE all_products SET product_state = 0 "
				+ "WHERE serial_no = ?";
		
		System.out.print("구매하실 상품의 이름을 입력해주세요\n>>");
		String product_name = sc.next();

		String sql_stock = "SELECT "
				+ "product_name "
				+ "FROM "
				+ "All_products INNER JOIN product USING (product_no) "
				+ "where product_name LIKE '" + product_name +"' "
						+ "AND product_state = 1";
		
		String sql = "SELECT "
				+ "serial_no, product_price "
				+ "FROM "
				+ "all_products INNER JOIN product USING ( product_no ) "
				+ "where product_name LIKE '" + product_name +"' "
						+ "AND product_state = 1 AND rownum <= 1";
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt_insert = conn.prepareStatement(sql_insert);
				PreparedStatement pstmt_update = conn.prepareStatement(sql_update);
				PreparedStatement pstmt_stock = conn.prepareStatement(sql_stock);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			ResultSet rs_stock = pstmt_stock.executeQuery();
			
			List <String> productList = new ArrayList <String>();			
			while (rs_stock.next()) {
				productList.add(rs_stock.getString(1));		
			}
			Set<String> set = new HashSet<String>(productList);
			int[] stock_count = new int[1];		
			for (String str : set) {
				stock_count[0] = Collections.frequency(productList, str);			
			}
			if(stock_count[0] == 0) {
				System.out.println(product_name + " 재고가 없습니다");
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			// no_price에 serial_no와 order_detail_price 넣어둠
			int[] no_price = new int[2];		
			while (rs.next()) {
				no_price[0] = rs.getInt("serial_no");
				no_price[1] = rs.getInt("product_price");
			}
			
			// order_detail 에 serial_no와 order_detail_price입력
			pstmt_insert.setInt(1, no_price[0]);
			pstmt_insert.setInt(2, no_price[1]);
			pstmt_insert.executeUpdate();
			
			//product_state 0으로 변경
			pstmt_update.setInt(1, no_price[0]);	
			pstmt_update.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}	
	// 3.임시로 만든 order_ 수정
	public void update_order() {
		String sql_update = "UPDATE order_ SET order_amount = ? "
				+ "WHERE order_no = (SELECT MAX(order_no)FROM order_)";
		
		String sql = "SELECT order_detail_price "
				+ "FROM order_detail "
				+ "WHERE order_no = (SELECT MAX(order_no)FROM ORDER_detail)";
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt_update = conn.prepareStatement(sql_update);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			ResultSet rs = pstmt.executeQuery();
			List <Integer> amount = new ArrayList <Integer>();	
			if (rs.next()) {
				do {
					amount.add(rs.getInt("order_detail_price"));
				}while (rs.next());	
			}
			int sum = amount.stream().mapToInt(Integer::intValue).sum();
			pstmt_update.setInt(1, sum);
			pstmt_update.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}
}