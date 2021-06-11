package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import AnyPlace.DBConnector;

public class DeliveryCont {

	// ��� ǰ�� ����
	static String sql = "SELECT P.PRODUCT_NAME,COUNT(*) \r\n" + "    FROM PRODUCT P, ALL_PRODUCTS AP \r\n"
			+ "    WHERE P.PRODUCT_NO = AP.PRODUCT_NO\r\n" + "    GROUP BY P.PRODUCT_NAME";

	// ī�װ� �� ǰ�� ����
	static String sql2 = "SELECT P.PRODUCT_NAME,COUNT(*) \r\n" + "    FROM PRODUCT P, ALL_PRODUCTS AP, CATEGORY C\r\n"
			+ "    WHERE P.PRODUCT_NO = AP.PRODUCT_NO\r\n" + "    AND P.CATEGORY_NO = C.CATEGORY_NO\r\n"
			+ "    AND C.CATEGORY_NO = (SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME = ?)\r\n"
			+ "    GROUP BY P.PRODUCT_NAME";

	// ��� �ֹ���ǰ �߰�
	static String insert_sql = "INSERT INTO ALL_PRODUCTS VALUES(\r\n"
			+ "(SELECT MAX(SERIAL_NO)+1 FROM ALL_PRODUCTS),\r\n"
			+ "(SELECT PRODUCT_NO FROM PRODUCT WHERE PRODUCT_NAME = ?),\r\n" + "SYSDATE - 3,\r\n" + "SYSDATE + 1,\r\n"
			+ "'�ӽ�',\r\n" + "SYSDATE - 2,\r\n" + "1)";

	// ��� �ֹ� ����(����)
	static String sql3 = "SELECT PRODUCT_COST FROM PRODUCT WHERE PRODUCT_NO = (SELECT PRODUCT_NO FROM PRODUCT WHERE PRODUCT_NAME = ?)";

	// ��� ��ǰ ����
	public static void allProductsCount(PreparedStatement pstmt, ResultSet rs) {
		System.out.println("(���ǰ��)��ǰ�� ����");

		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.println("  " + rs.getInt(2) + "��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ī�װ��� ��ǰ ����
	public static void cateProductsCount(PreparedStatement pstmt, ResultSet rs, String category) {
		System.out.println("(" + category + ")��ǰ�� ����");
		try {
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.println("  " + rs.getInt(2) + "��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ����ֹ�
	public static void deliveryOrder(PreparedStatement pstmt, PreparedStatement pstmt_insert, ResultSet rs,HashMap<String, Integer> order_map) {
		System.out.println("��ǰ�ֹ�");
		int cnt = 0;
		 
		HashMap<String, Integer> product_map = new HashMap(); // �ֹ��� ��ǰ�� map(�Ŷ��, 3��)
		String product_name = "���Ͽ���250ML"; 
		int product_cnt = 3;
		order_map.put("���Ͽ���250ML",3);
		order_map.put("�Ŷ��",2);

		int product_cost;
		int total_cost = 0;
		product_map.put(product_name, product_cnt);
		try {
			for (String pro_name : order_map.keySet()) {
//				System.out.println(pro_name);
				int pro_cnt = order_map.get(pro_name);
				System.out.println(pro_name);
				System.out.println(pro_cnt);
				pstmt.setString(1, pro_name);
				rs = pstmt.executeQuery();
				rs.next();
				product_cost = rs.getInt(1);
				total_cost = total_cost + (product_cost * pro_cnt);
				for (int j = 0; j < pro_cnt; j++) {
					pstmt_insert.setString(1, pro_name);
					pstmt_insert.execute();
				}
			}
//
//			System.out.println(total_cost);
//			for (String key : product_map.keySet()) {
//				int value = product_map.get(key);
//				for (int j = 0; j < value; j++) {
//					pstmt_insert.setString(1, key);
//					pstmt_insert.execute();
//				}
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		HashMap<String, Integer> order_map = new HashMap<>();
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);
				PreparedStatement pstmt_insert = conn.prepareStatement(insert_sql);
				ResultSet rs = pstmt.executeQuery();
				) {
			
			allProductsCount(pstmt, rs);

			String category = "����ǰ";
			cateProductsCount(pstmt2, rs, category);
			deliveryOrder(pstmt3, pstmt_insert, rs, order_map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
