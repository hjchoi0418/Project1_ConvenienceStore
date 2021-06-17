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
		���ⱸ��: Sales division ( ���� ������ �ƴϸ� �ָ���.)
		�ŷ��Ⱓ: trading period ( ������ �ֹ���¥�� ���ؼ� �ֹ���ȣ�� ������ �������� ����Ѵ�)
		��������: method of payment (������ �������� ���ؼ� �ֹ���ȣ�� ������ �������� ����Ѵ�)
		�Ǹűݾ�: sale price ( ������ �Ѿ��� ���ؼ� �ֹ���ȣ�� ������ �������� ����Ѵ�)
		��ǰ�ڵ�: Product Code ( ���� �������� prodcut_no �� �̿��ؼ� �������� ����Ѵ�)
		������ ��ȣ: receipt number ( ���� �������� order_no �� �̿��ؼ� �������� ����Ѵ�)
		
		������ ���� : receipt issue ( ���� �Ұ� ����. receipt_number ������� �ᵵ��)
		��ǰ ���Ǹ� : Return resale ( ������ ��ȣ�� �������� ã�Ƽ� rs�� ��ȯ�Ѵ��� ��ǰ�Ǹŷ� �ѱ�� �������� ������.)
		��ǰ ���� : Return service ( db�� ���� delete)
		*/
		ResultSet ors;

		return_service("2");
		
		
	}
	static public ResultSet Return_resale(String search_Options) { //��ǰ ���Ǹ� : Return resale ( ������ ��ȣ�� �������� ã�Ƽ� rs�� ��ȯ�Ѵ��� ��ǰ�Ǹŷ� �ѱ�� �������� ������.)
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
	
	static public void return_service (String search_Options) { // ��ǰ �ǸŻ��� 0���� �ٲٰ� ������, �� ������ ����
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
