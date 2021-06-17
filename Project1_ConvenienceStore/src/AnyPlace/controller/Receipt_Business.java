package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Receipt_Business {
	


	public static void main(String[] args) {

		/*
		매출구분: Sales division ( 매입 매출이 아니면 애매함.)
		거래기간: trading period ( 오더의 주문날짜를 통해서 주문번호를 가져와 영수증을 출력한다)
		결제수단: method of payment (오더의 결재방식을 통해서 주문번호를 가져와 영수증을 출력한다)
		판매금액: sale price ( 오더의 총액을 통해서 주문번호를 가져와 영수증을 출력한다)
		상품코드: Product Code ( 오더 디테일의 prodcut_no 를 이용해서 영수증을 출력한다)
		영수증 번호: receipt number ( 오더 디테일의 order_no 를 이용해서 영수증을 출력한다)
		
		영수증 발행 : receipt issue ( 딱히 할게 없다. receipt_number 기능으로 써도됨)
		반품 재판매 : Return resale ( 영수증 번호로 영수증을 찾아서 rs를 반환한다음 상품판매로 넘기고 영수증을 삭제함.)
		반품 업무 : Return service ( db에 들어가서 delete)
		*/
		ResultSet ors;

		return_service("2");
		
		
	}
	static public ResultSet Return_resale(String search_Options) { //반품 재판매 : Return resale ( 영수증 번호로 영수증을 찾아서 rs를 반환한다음 상품판매로 넘기고 영수증을 삭제함.)
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT order_detail_no, o.order_no, serial_no, order_detail_price,"
					+ " payment_method, order_amount FROM order_detail od INNER JOIN  order_ o ON od.order_no = o.order_no");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();

			pstmt = con.prepareStatement("DELETE FROM order_detail WHERE order_no = ?");
			pstmt.setString(1, search_Options);
			pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public void return_service (String search_Options) { // 제품 판매상태 0으로 바꾸고 영수증, 상세 영수증 삭제
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		Connection con;
		try {
			con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("UPDATE all_products SET product_state = 1 WHERE serial_no IN"
					+ "(SELECT serial_no FROM order_detail WHERE order_no = ?)");
			pstmt.setString(1, search_Options);
			pstmt.executeUpdate();
			pstmt = con.prepareStatement("DELETE FROM order_detail WHERE order_no = ?");
			pstmt.setString(1, search_Options);
			pstmt = con.prepareStatement("DELETE FROM order_ WHERE order_no = ?");
			pstmt.setString(1, search_Options);
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	static public ResultSet receipt_number(String search_Options) { 
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE order_no = ?");
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
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE order_.order_no IN (SELECT order_detail.order_no FROM order_detail WHERE product_no = ?)");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			

			return rs;		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	static public ResultSet sale_price(String search_Options) { 
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE order_amount = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet method_of_payment(String search_Options) { 
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE payment_method = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet trading_period(String search_Options) { 
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE to_date(order_date, 'yy/mm/dd') = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet all_Receipt() { 
		HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
		HikariDataSource ds = new HikariDataSource(config);
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_");
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
