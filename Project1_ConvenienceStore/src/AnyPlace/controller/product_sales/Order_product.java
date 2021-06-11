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
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import AnyPlace.controller.DBConnector;
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
				+ "(order_detail_no, order_no, product_no, order_count, order_detail_price)"
				+ "VALUES((SELECT MAX(order_detail_no)+1 FROM ORDER_DETAIL),"
				+ "(SELECT MAX(order_no)FROM order_),"
				+ "?,"
				+ "?,"
				+ "?)";
		
		System.out.print("구매하실 상품의 이름을 입력해주세요\n>>");
		String product_name = sc.next();

		String sql_stock = "SELECT "
				+ "product_name "
				+ "FROM "
				+ "All_products INNER JOIN product USING (product_no) "
				+ "where product_name LIKE '%" + product_name +"%' "
						+ "AND product_state = 1";
		
		String sql = "SELECT "
				+ "product_no, product_price"
				+ " FROM"
				+ " product"
				+ " WHERE product_name LIKE '%" + product_name + "%'";
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt_insert = conn.prepareStatement(sql_insert);
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
			HashMap<String,Integer> inventory_check = new HashMap<>();		
			for (String str : set) {
				stock_count[0] = Collections.frequency(productList, str);			
			}
			//구매할 제품의 재고를 stock_count에 넣어둠
			
			ResultSet rs = pstmt.executeQuery();
			int[] no_price = new int[2];		
			while (rs.next()) {
				no_price[0] = rs.getInt(1);
				no_price[1] = rs.getInt(2);
			}
			// no_price에 제품번호와 제품가격을 넣어둠
			System.out.println("남은재고:" + stock_count[0]);
			System.out.print("구매수량 입력\n>>");
			int count = sc.nextInt();
			if(count > stock_count[0]) {
				System.out.println("재고가 부족합니다");
			}				
			pstmt_insert.setInt(1, no_price[0]);
			pstmt_insert.setInt(2, count);
			pstmt_insert.setInt(3, no_price[1]*count);
			pstmt_insert.executeUpdate();
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
	
	// 4.주문서를 바탕으로 수량에 맞춰 product_state를 0으로 변경
	public void stock_minus() {		
		String sql_update = "UPDATE all_products SET product_state = 0 "
				+ "WHERE serial_no = ?";
		
		String sql = "SELECT"
				+ " product_no, order_count"
				+ " FROM"
				+ " order_detail"
				+ " WHERE order_no = (SELECT MAX(order_no) FROM ORDER_)";
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt_update = conn.prepareStatement(sql_update);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			ResultSet rs = pstmt.executeQuery();
			HashMap<Integer , Integer> product_check = new LinkedHashMap<>();	  
			if (rs.next()) {
				do {
					product_check.put(rs.getInt("product_no"),rs.getInt("order_count"));
				}while (rs.next());	
			}
			// 구매한 제품번호(product_no), 주문 수량(order_count) 담아둠
			List <Integer> product_no = new ArrayList <Integer>();
			for (Map.Entry<Integer, Integer> entry : product_check.entrySet() ) {
				product_no.add(entry.getKey());
			}
			// 구매한 제품번호(product_no)만 따로 빼둠
			for(int i = 0; i < product_no.size(); ++i) {
				String sql2 = "SELECT serial_no "
						+ "FROM all_products "
						+ "WHERE product_no = "+ product_no.get(i) +" AND product_state = 1";	
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				ResultSet rs2 = pstmt2.executeQuery();
				List <Integer> serial_no = new ArrayList <Integer>();		
				if (rs2.next()) {
					do {
						serial_no.add(rs2.getInt("serial_no"));
					}while (rs2.next());
				}
				System.out.println("상품번호<" + product_no.get(i) + ">인 serial_no:"+serial_no);
				// 해쉬맵에서 수량을 파악후 수량만큼 product_state를 0으로 변경
				for(int j = 0; j < product_check.get(product_no.get(i)); ++j) {
					System.out.println("판매된 상품 serial_no:" + serial_no.get(j));
					pstmt_update.setInt(1, serial_no.get(j));	
					pstmt_update.executeUpdate();
				}
			} 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}