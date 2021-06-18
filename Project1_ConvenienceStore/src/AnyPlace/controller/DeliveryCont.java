package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import AnyPlace.DBConnector;

public class DeliveryCont {

	static int total_cost = 0;

	// 乞窮 念鯉 呪勲
	String sql = "SELECT C.CATEGORY_NO||'.'||C.CATEGORY_NAME 掻歳嫌,p.product_no||'.'||p.product_name 薦念, COUNT(ap.serial_no) 呪勲\r\n"
			+ "  FROM product p\r\n" + "  LEFT JOIN all_products ap ON p.product_no = ap.product_no\r\n"
			+ "  LEFT JOIN CATEGORY C ON C.CATEGORY_no = P.CATEGORY_NO\r\n"
			+ " GROUP BY p.product_no, p.product_name, C.CATEGORY_NO,C.CATEGORY_NAME\r\n" + " order by C.CATEGORY_NO, P.PRODUCT_NO";

	// 朝砺壱軒 紺 念鯉 呪勲
	String sql2 = "SELECT P.PRODUCT_NAME,COUNT(*) \r\n" + "    FROM PRODUCT P, ALL_PRODUCTS AP, CATEGORY C\r\n"
			+ "    WHERE P.PRODUCT_NO = AP.PRODUCT_NO\r\n" + "    AND P.CATEGORY_NO = C.CATEGORY_NO\r\n"
			+ "    AND C.CATEGORY_NO = (SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME = ?)\r\n"
			+ "    GROUP BY P.PRODUCT_NAME";

	// 壕勺 爽庚雌念 蓄亜
//	String insert_sql = "INSERT INTO ALL_PRODUCTS VALUES(\r\n" + "(SELECT MAX(SERIAL_NO)+1 FROM ALL_PRODUCTS),\r\n"
//			+ "(SELECT PRODUCT_NO FROM PRODUCT WHERE PRODUCT_NAME = ?),\r\n" + "SYSDATE - 3,\r\n" + "SYSDATE + 1,\r\n"
//			+ "'績獣',\r\n" + "SYSDATE - 2,\r\n" + "1)";

	String insert_sql = "INSERT INTO ALL_PRODUCTS VALUES((SELECT MAX(SERIAL_NO)+1 FROM ALL_PRODUCTS),\r\n"
			+ "			?,SYSDATE - 3,SYSDATE + 1,\r\n" + "        '績獣',SYSDATE - 2,1)";

	// 壕勺 爽庚 亜維(据亜)
	static String sql3 = "SELECT PRODUCT_COST FROM PRODUCT WHERE PRODUCT_NO = ?"; // (SELECT PRODUCT_NO FROM PRODUCT
																					// WHERE PRODUCT_NAME = ?)";

	// 乞窮 念鯉 朝錘闘
	String sql4 = "SELECT COUNT(*) FROM PRODUCT";

	// 乞窮 薦念 呪勲
	public String[][] allProductsCount() {
		System.out.println("(乞窮念鯉)薦念紺 呪勲");

		String[][] str_arr;
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt4 = conn.prepareStatement(sql4);
				ResultSet rs = pstmt.executeQuery();
				ResultSet rs4 = pstmt4.executeQuery();) {

			rs4.next();
			System.out.println("cnt : " + rs4.getInt(1));
			str_arr = new String[rs4.getInt(1)][4];

			int i = 0;
			while (rs.next()) {
//				System.out.print(rs.getString(1));
//				System.out.print("  " + rs.getString(2));
//				System.out.println("  " + rs.getString(3));
				str_arr[i][0] = rs.getString(1);
				str_arr[i][1] = rs.getString(2);
				str_arr[i][2] = rs.getString(3);
				str_arr[i++][3] = "0";
			}

			return str_arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 朝砺壱軒紺 薦念 呪勲
	public static void cateProductsCount(PreparedStatement pstmt, ResultSet rs, String category) {
		System.out.println("(" + category + ")薦念紺 呪勲");
		try {
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.println("  " + rs.getInt(2) + "鯵");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 壕勺爽庚
	public void deliveryOrder(HashMap<Integer, Integer> order_map) {
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt_insert = conn.prepareStatement(insert_sql);) {
			
			System.out.println("しししししし");
			System.out.println(order_map);
			for (Integer pno : order_map.keySet()) {
				pstmt_insert.setInt(1, pno);
				
				System.out.println("pno " + pno + order_map.get(pno) + "鯵 爽庚");
				for(int i=0; i<order_map.get(pno); i++) {
					pstmt_insert.execute();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//		System.out.println("雌念爽庚");
//		int cnt = 0;
//
//		HashMap<String, Integer> product_map = new HashMap(); // 爽庚廃 雌念級 map(重虞檎, 3鯵)
//		String product_name = "古析酔政250ML";
//		int product_cnt = 3;
//		order_map.put("古析酔政250ML", 3);
//		order_map.put("重虞檎", 2);
//
//		int product_cost;
//		int total_cost = 0;
//		product_map.put(product_name, product_cnt);
//		try {
//			for (String pro_name : order_map.keySet()) {
////				System.out.println(pro_name);
//				int pro_cnt = order_map.get(pro_name);
//				System.out.println(pro_name);
//				System.out.println(pro_cnt);
//				pstmt.setString(1, pro_name);
//				rs = pstmt.executeQuery();
//				rs.next();
//				product_cost = rs.getInt(1);
//				total_cost = total_cost + (product_cost * pro_cnt);
//				for (int j = 0; j < pro_cnt; j++) {
//					pstmt_insert.setString(1, pro_name);
//					pstmt_insert.execute();
//				}
//			}
//
//			System.out.println(total_cost);
//			for (String key : product_map.keySet()) {
//				int value = product_map.get(key);
//				for (int j = 0; j < value; j++) {
//					pstmt_insert.setString(1, key);
//					pstmt_insert.execute();
//				}
//			}
//	}catch(
//
//	SQLException e)
//	{
//		e.printStackTrace();
//	}

	// 爽庚 雌念級 据亜
	public static int getTotalCost(HashMap<Integer, Integer> product_map) {
		try (Connection conn = DBConnector.getConnection(); PreparedStatement pstmt3 = conn.prepareStatement(sql3);

		) {
			// SELECT PRODUCT_COST FROM PRODUCT WHERE PRODUCT_NO = ?)
			// key : product_no
			// val : 呪勲
			int total_cost = 0;
			for (Integer pno : product_map.keySet()) {
				pstmt3.setInt(1, pno);
				ResultSet rs3 = pstmt3.executeQuery();
				rs3.next();

				total_cost = total_cost + (rs3.getInt(1) * product_map.get(pno));
			}
			return total_cost;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

//	public static void main(String[] args) {
////		HashMap<String, Integer> order_map = new HashMap<>();
////		
////		try (Connection conn = DBConnector.getConnection();
////				PreparedStatement pstmt = conn.prepareStatement(sql);
////				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
////				PreparedStatement pstmt3 = conn.prepareStatement(sql3);
////				PreparedStatement pstmt_insert = conn.prepareStatement(insert_sql);
////				ResultSet rs = pstmt.executeQuery();
////				) {
////			
////			allProductsCount(pstmt, rs);
////
////			String category = "政薦念";
////			cateProductsCount(pstmt2, rs, category);
////			deliveryOrder(pstmt3, pstmt_insert, rs, order_map);
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
//	}
}
