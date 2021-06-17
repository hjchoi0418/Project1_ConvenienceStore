package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Receipt_Lookup { //영수증 조건별로 검색 ResultSet을 return 




	public static void main(String[] args) {

		/*
		매출구분: Sales division ( 매입 매출이 아니면 애매함.)
		거래기간: trading period ( 오더의 주문날짜를 통해서 주문번호를 가져와 상세 영수증을 출력한다)
		결제수단: method of payment (오더의 결재방식을 통해서 주문번호를 가져와 상세 영수증을 출력한다)
		판매금액: sale price ( 오더의 총액을 통해서 주문번호를 가져와 상세 영수증을 출력한다)
		상품코드: Product Code ( 오더 디테일의 prodcut_no 를 이용해서 상세 영수증을 출력한다)
		영수증 번호: receipt number ( 오더 디테일의 order_no 를 이용해서 상세 영수증을 출력한다)
		*/
		ResultSet odrs;
		odrs = receipt_number("2");
	}
	/*

	 */
	static public ResultSet receipt_number(String search_Options) { 
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT order_detail_no, order_.order_no, order_detail.serial_no, order_detail.order_detail_price, product.product_name "
					+ "FROM order_detail, order_, product, all_products "
					+ "WHERE order_.order_no = ? AND order_.order_no = order_detail.order_no "
					+ "AND order_detail.serial_no = all_products.serial_no AND all_products.product_no = product.product_no");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	static public ResultSet product_code(String search_Options) { 
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_detail WHERE product_no = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();

			return rs;		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet sale_price(String search_Options) { //판매금액: sale price ( 오더의 총액을 통해서 주문번호를 가져와 상세 영수증을 출력한다)
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_detail WHERE order_detail.order_no = "
															+ "(SELECT order_.order_no FROM order_ WHERE order_amount = ?)");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			

			return rs;	
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet method_of_payment(String search_Options) { // method of payment (오더의 결재방식을 통해서 주문번호를 가져와 상세 영수증을 출력한다)
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_detail WHERE order_detail.order_no IN "
															+ "(SELECT order_.order_no FROM order_ WHERE payment_method = ?)");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();

			return rs;	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	static public ResultSet trading_period(String search_Options) { // trading period ( 오더의 주문날짜를 통해서 주문번호를 가져와 상세 영수증을 출력한다)
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_detail WHERE order_detail.order_no IN "
															+ "(SELECT order_.order_no FROM order_ WHERE TO_DATE(order_date, 'yy/mm/dd') = ?)");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			

			return rs;	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}