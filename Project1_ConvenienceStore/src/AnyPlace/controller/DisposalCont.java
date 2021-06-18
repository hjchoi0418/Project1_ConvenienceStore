package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import AnyPlace.DBConnector;
import AnyPlace.model.Product;

public class DisposalCont {
	/*
	 * ���ó��
	 */
	private ArrayList<String> del_list = new ArrayList<>();
	private ArrayList<Product> pro_list = new ArrayList<>();
	private String[][] data;

	public int waste_count; // �� ������
	public int total_waste_price; // �� �����ǰ����
	
	// ������� 30�� ���� ��ǰ�� ���
	String sql = "SELECT * FROM(SELECT\r\n" + "C.CATEGORY_NO||'.'||C.CATEGORY_NAME �ߺз�,\r\n"
			+ "AP.SERIAL_NO||'A00'||P.PRODUCT_NO ��ǰ�ڵ�,P.PRODUCT_NAME ��ǰ��,\r\n"
			+ "TO_CHAR(EXPIRATION_DATE,'MMDD HH24:MI') \"��� �Ͻ�\"\r\n" + "FROM\r\n"
			+ "ALL_PRODUCTS AP, PRODUCT P, CATEGORY C\r\n" + "WHERE\r\n"
			+ "TO_CHAR(EXPIRATION_DATE,'yyyymmdd hh24:mi:ss') < TO_CHAR(SYSDATE -30/(24*60),'yyyymmdd hh24:mi:ss')\r\n"
			+ "AND AP.PRODUCT_NO = P.PRODUCT_NO\r\n" + "AND C.CATEGORY_NO = P.CATEGORY_NO\r\n"
			+ "ORDER BY AP.EXPIRATION_DATE ASC)";
	// �� ī��Ʈ, �ѿ���
	String sql2 = "SELECT COUNT(*), SUM(P.PRODUCT_COST)\r\n" + "    FROM ALL_PRODUCTS AP, PRODUCT P\r\n"
			+ "    WHERE TO_CHAR(EXPIRATION_DATE,'yyyymmdd hh24:mi:ss') < TO_CHAR(SYSDATE -30/(24*60),'yyyymmdd hh24:mi:ss')\r\n"
			+ "    AND AP.PRODUCT_NO = P.PRODUCT_NO";

	// ��� ó��
	String delete_sql = "DELETE ALL_PRODUCTS WHERE SERIAL_NO = ?";

	// ���̺� ������
	public String[][] getData() {

//		// System.out.println(sql);
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement delete_pstmt = conn.prepareStatement(delete_sql);
				ResultSet rs = pstmt.executeQuery();
				ResultSet rs2 = pstmt2.executeQuery();) {

			ResultSetMetaData rsmd = rs.getMetaData();

			rs2.next();
			data = new String[rs2.getInt(1)][4];

			waste_count = rs2.getInt(1);
			total_waste_price = rs2.getInt(2);

			int j = 0;
			while (rs.next()) {
				data[j][0] = rs.getString(1);
				data[j][1] = rs.getString(2);
				data[j][2] = rs.getString(3);
				data[j][3] = rs.getString(4);

				j++;
			}
			int col_cnt = rsmd.getColumnCount();
			// System.out.println("-- ��� 30���� ��ǰ ��� --");
			while (rs.next()) {
				for (int i = 1; i <= col_cnt; i++) {
					// System.out.print(rs.getString(i) + " | ");
				}
				// System.out.println();
			}

			return data;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void delData(String[] str_arr) {

		try (Connection conn = DBConnector.getConnection();
				PreparedStatement delete_pstmt = conn.prepareStatement(delete_sql);) {

			// System.out.println(Arrays.toString(str_arr));
			try {
				for (int i = 0; i < str_arr.length; i++) {
					delete_pstmt.setString(1, str_arr[i]);
					delete_pstmt.execute();
				}
			} catch (Exception e) {
				// System.out.println("[NULL] DisposalCont");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getCountCost() {
		// System.out.println(sql);
		try (Connection conn = DBConnector.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				ResultSet rs2 = pstmt2.executeQuery();) {

			HashMap<String, String> temp_map = new HashMap<>();

			rs2.next();

			waste_count = rs2.getInt(1);
			total_waste_price = rs2.getInt(2);

			temp_map.put(Integer.toString(waste_count), Integer.toString(total_waste_price));
			
			return temp_map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}