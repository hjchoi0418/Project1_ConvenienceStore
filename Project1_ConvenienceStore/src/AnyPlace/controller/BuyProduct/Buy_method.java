package AnyPlace.controller.BuyProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import AnyPlace.DBConnector;

public class Buy_method {
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##gs25";
			String pass = "1234";
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		}catch(Exception e) {
			return null;
		}
	}
	
	// 1.임시로 order_ 만듬
	public static int Temporary_order() {
		int result = 0;
		String sql = "INSERT INTO order_ (order_no, order_date, payment_method, order_amount)"
				+ "VALUES((SELECT MAX(order_no)+1 FROM order_), "
				+ "SYSDATE, "
				+ "1, "
				+ "2)";
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){	
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		return result;
	}
	
	// 2. 상제주문 작성
	public static int detail_order(String product_name) {
		int result = 0;
		
		String sql_insert = "INSERT INTO order_detail"
				+ "(order_detail_no, order_no, serial_no, order_detail_price)"
				+ "VALUES((SELECT MAX(order_detail_no)+1 FROM ORDER_DETAIL),"
				+ "(SELECT MAX(order_no)FROM order_),"
				+ "?,"
				+ "?)";
		
		String sql_update = "UPDATE all_products SET product_state = 0 "
				+ "WHERE serial_no = ?";
		
		String sql = "SELECT "
				+ "serial_no, product_price "
				+ "FROM "
				+ "all_products INNER JOIN product USING ( product_no ) "
				+ "where product_name = '" + product_name + "' AND product_state = 1 AND rownum <= 1";
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt_insert = conn.prepareStatement(sql_insert);
				PreparedStatement pstmt_update = conn.prepareStatement(sql_update);
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
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
		return result; 		
	}	
	// 3.임시로 만든 order_ 수정
	public static int update_order() {
		int result = 0;
		String sql_update = "UPDATE order_ SET order_amount = ? "
				+ "WHERE order_no = (SELECT MAX(order_no)FROM order_)";
		
		String sql = "SELECT order_detail_price "
				+ "FROM order_detail "
				+ "WHERE order_no = (SELECT MAX(order_no)FROM ORDER_detail)";
		
		try (Connection conn = getConnection();
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
		return result; 		
	}
	
	public static ArrayList<String> getorder(String order, String count){
		String sql = "SELECT "
				+ "product_name, "
				+ "product_price "
				+ "FROM "
				+ "product WHERE product_no = "+ order +"";	
	
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		        ){	
			ResultSet rs = pstmt.executeQuery();		
			ArrayList<String> product = new ArrayList<String>();
			while (rs.next()) {
				product.add(rs.getString(1));
				product.add(Integer.toString((Integer.parseInt(rs.getString(2)) * Integer.parseInt(count))));
				product.add(count);
			}
			return product;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}	
	public static int search(String name) {
		String sql = "SELECT "
				+ "product_name "
				+ "FROM "
				+ "All_products INNER JOIN product USING (product_no) "
				+ "where product_name LIKE '%" + name +"%' "
						+ "AND product_state = 1";	
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		    ){
			ResultSet rs = pstmt.executeQuery();				
			List <String> productList = new ArrayList <String>();			
			while (rs.next()) {
				productList.add(rs.getString(1));		
			}
			int name_count = Collections.frequency(productList, name);
			return name_count;
	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
}
