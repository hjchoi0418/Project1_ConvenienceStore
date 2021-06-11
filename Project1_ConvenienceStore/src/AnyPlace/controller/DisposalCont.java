package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import AnyPlace.DBConnector;
import AnyPlace.model.Product;

public class DisposalCont {
	/*
	 * ���ó��
	 */
	public static void main(String[] args) {

		ArrayList<String> del_list = new ArrayList<>();
		// ������� 30�� ���� ��ǰ�� ���
		String sql = "SELECT\r\n"
				+ "AP.SERIAL_NO,P.PRODUCT_NO,P.PRODUCT_NAME,TO_CHAR(EXPIRATION_DATE,'YYYYMMDD HH24:MI:SS')\r\n"
				+ "FROM\r\n" + "ALL_PRODUCTS AP, PRODUCT P\r\n" + "WHERE\r\n"
				+ "TO_CHAR(EXPIRATION_DATE,'yyyymmdd hh24:mi:ss') < TO_CHAR(SYSDATE -30/(24*60),'yyyymmdd hh24:mi:ss')\r\n"
				+ "AND AP.PRODUCT_NO = P.PRODUCT_NO";

		// ��� ó��
		String delete_sql = "DELETE ALL_PRODUCTS WHERE SERIAL_NO = ?";
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement delete_pstmt = conn.prepareStatement(delete_sql);
				ResultSet rs = pstmt.executeQuery();) {

			ResultSetMetaData rsmd = rs.getMetaData();

			int col_cnt = rsmd.getColumnCount();
			System.out.println(col_cnt);
			System.out.println("-- ��� 30���� ��ǰ ��� --");
			while (rs.next()) {
				for (int i = 1; i <= col_cnt; i++) {
					System.out.print(rs.getString(i) + " | ");
				}
				System.out.println();
			}

			// ����� ��ǰ s_no ������ del_list�� �߰��ǰ� size ��ŭ �ݺ��ؼ� del
			del_list.add("9");
			del_list.add("10");
			del_list.add("11");
			
			for(int i=0; i<del_list.size();i++) {
				delete_pstmt.setString(1, del_list.get(i));
				delete_pstmt.execute();
			}

//			ResultSetMetaData rsmd = rs.getMetaData();

//			int col_cnt = rsmd.getColumnCount();
//			System.out.println("�÷� ���� : " + col_cnt);
//			for (int i = 1; i <= col_cnt; i++) {
//				System.out.println("-----------------------------------");
//				System.out.println(i + "��° �÷� �̸� : " + rsmd.getColumnLabel(i));
//				System.out.println(i + "��° �÷� Ÿ�� : " + rsmd.getColumnTypeName(i));
//				System.out.println(i + "��° �÷� ũ�� : " + rsmd.getPrecision(i));
//			}
//			while(rs.next()) {
//				for(int i=1; i<=col_cnt; i++) 
//					System.out.print(rs.getString(i) + " | ");
//				System.out.println(); 
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
