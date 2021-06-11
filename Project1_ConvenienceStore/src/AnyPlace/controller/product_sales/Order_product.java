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

	// 1.�ӽ÷� order_ ����
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
			System.out.print("���� ����� �������ּ��� (ī�� : 1 ���� : 2)\n>>");			
			int payment_method = sc.nextInt();
			pstmt.setInt(1, payment_method);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}
	
	// 2.order_detail ����
	public void detail_order() {
		this.sc = new Scanner(System.in);
		String sql_insert = "INSERT INTO order_detail"
				+ "(order_detail_no, order_no, product_no, order_count, order_detail_price)"
				+ "VALUES((SELECT MAX(order_detail_no)+1 FROM ORDER_DETAIL),"
				+ "(SELECT MAX(order_no)FROM order_),"
				+ "?,"
				+ "?,"
				+ "?)";
		
		System.out.print("�����Ͻ� ��ǰ�� �̸��� �Է����ּ���\n>>");
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
			//������ ��ǰ�� ��� stock_count�� �־��
			
			ResultSet rs = pstmt.executeQuery();
			int[] no_price = new int[2];		
			while (rs.next()) {
				no_price[0] = rs.getInt(1);
				no_price[1] = rs.getInt(2);
			}
			// no_price�� ��ǰ��ȣ�� ��ǰ������ �־��
			System.out.println("�������:" + stock_count[0]);
			System.out.print("���ż��� �Է�\n>>");
			int count = sc.nextInt();
			if(count > stock_count[0]) {
				System.out.println("��� �����մϴ�");
			}				
			pstmt_insert.setInt(1, no_price[0]);
			pstmt_insert.setInt(2, count);
			pstmt_insert.setInt(3, no_price[1]*count);
			pstmt_insert.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}
	
	// 3.�ӽ÷� ���� order_ ����
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
	
	// 4.�ֹ����� �������� ������ ���� product_state�� 0���� ����
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
			// ������ ��ǰ��ȣ(product_no), �ֹ� ����(order_count) ��Ƶ�
			List <Integer> product_no = new ArrayList <Integer>();
			for (Map.Entry<Integer, Integer> entry : product_check.entrySet() ) {
				product_no.add(entry.getKey());
			}
			// ������ ��ǰ��ȣ(product_no)�� ���� ����
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
				System.out.println("��ǰ��ȣ<" + product_no.get(i) + ">�� serial_no:"+serial_no);
				// �ؽ��ʿ��� ������ �ľ��� ������ŭ product_state�� 0���� ����
				for(int j = 0; j < product_check.get(product_no.get(i)); ++j) {
					System.out.println("�Ǹŵ� ��ǰ serial_no:" + serial_no.get(j));
					pstmt_update.setInt(1, serial_no.get(j));	
					pstmt_update.executeUpdate();
				}
			} 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}