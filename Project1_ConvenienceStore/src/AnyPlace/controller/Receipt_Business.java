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
		���ⱸ��: Sales division ( ���� ������ �ƴϸ� �ָ���.)
		�ŷ��Ⱓ: trading period ( ������ �ֹ���¥�� ���ؼ� �ֹ���ȣ�� ������ �������� ����Ѵ�)
		��������: method of payment (������ �������� ���ؼ� �ֹ���ȣ�� ������ �������� ����Ѵ�)
		�Ǹűݾ�: sale price ( ������ �Ѿ��� ���ؼ� �ֹ���ȣ�� ������ �������� ����Ѵ�)
		��ǰ�ڵ�: Product Code ( ���� �������� prodcut_no �� �̿��ؼ� �������� ����Ѵ�)
		������ ��ȣ: receipt number ( ���� �������� order_no �� �̿��ؼ� �������� ����Ѵ�)
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
