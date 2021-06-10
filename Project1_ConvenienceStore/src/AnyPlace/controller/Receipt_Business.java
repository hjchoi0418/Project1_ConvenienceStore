package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Receipt_Business {
	
	static HikariConfig config = new HikariConfig("./Hikari_Sehyeon.properties");
	static HikariDataSource ds = new HikariDataSource(config);

	public static void main(String[] args) {

		/*
		매출구분: Sales division ( 매입 매출이 아니면 애매함.)
		거래기간: trading period ( 오더의 주문날짜를 통해서 주문번호를 가져와 영수증을 출력한다)
		결제수단: method of payment (오더의 결재방식을 통해서 주문번호를 가져와 영수증을 출력한다)
		판매금액: sale price ( 오더의 총액을 통해서 주문번호를 가져와 영수증을 출력한다)
		상품코드: Product Code ( 오더 디테일의 prodcut_no 를 이용해서 영수증을 출력한다)
		영수증 번호: receipt number ( 오더 디테일의 order_no 를 이용해서 영수증을 출력한다)
		*/
		ResultSet ors;
		ors = trading_period("21/06/09");

	}
	static public ResultSet receipt_number(String search_Options) { 
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE order_no = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.printf("order_no : %-10s order_date : %-30s payment_method : %-10s order_amount : %-10s \n",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	
			}
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet product_code(String search_Options) { 
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE order_.order_no IN (SELECT order_detail.order_no FROM order_detail WHERE product_no = ?)");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.printf("order_no : %-10s order_date : %-30s payment_method : %-10s order_amount : %-10s \n",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	
			}
			return rs;		
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	static public ResultSet sale_price(String search_Options) { 
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE order_amount = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.printf("order_no : %-10s order_date : %-30s payment_method : %-10s order_amount : %-10s \n",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	
			}
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet method_of_payment(String search_Options) { 
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE payment_method = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.printf("order_no : %-10s order_date : %-30s payment_method : %-10s order_amount : %-10s \n",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	
			}
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public ResultSet trading_period(String search_Options) { 
		ResultSet rs;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM order_ WHERE to_date(order_date, 'yy/mm/dd') = ?");
			pstmt.setString(1, search_Options);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.printf("order_no : %-10s order_date : %-30s payment_method : %-10s order_amount : %-10s \n",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));	
			}
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
