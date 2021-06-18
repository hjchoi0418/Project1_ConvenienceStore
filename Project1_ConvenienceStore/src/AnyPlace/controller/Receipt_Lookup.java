package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Receipt_Lookup { //������ ���Ǻ��� �˻� ResultSet�� return 




	public static void main(String[] args) {

		/*
		���ⱸ��: Sales division ( ���� ������ �ƴϸ� �ָ���.)
		�ŷ��Ⱓ: trading period ( ������ �ֹ���¥�� ���ؼ� �ֹ���ȣ�� ������ �� �������� ����Ѵ�)
		��������: method of payment (������ �������� ���ؼ� �ֹ���ȣ�� ������ �� �������� ����Ѵ�)
		�Ǹűݾ�: sale price ( ������ �Ѿ��� ���ؼ� �ֹ���ȣ�� ������ �� �������� ����Ѵ�)
		��ǰ�ڵ�: Product Code ( ���� �������� prodcut_no �� �̿��ؼ� �� �������� ����Ѵ�)
		������ ��ȣ: receipt number ( ���� �������� order_no �� �̿��ؼ� �� �������� ����Ѵ�)
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
	
	static public ResultSet sale_price(String search_Options) { //�Ǹűݾ�: sale price ( ������ �Ѿ��� ���ؼ� �ֹ���ȣ�� ������ �� �������� ����Ѵ�)
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
	
	static public ResultSet method_of_payment(String search_Options) { // method of payment (������ �������� ���ؼ� �ֹ���ȣ�� ������ �� �������� ����Ѵ�)
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
	
	static public ResultSet trading_period(String search_Options) { // trading period ( ������ �ֹ���¥�� ���ؼ� �ֹ���ȣ�� ������ �� �������� ����Ѵ�)
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