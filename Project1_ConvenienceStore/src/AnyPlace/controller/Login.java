package AnyPlace.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// SANAGO

public class Login {

	public static void main(String[] args) {

		HikariConfig config = new HikariConfig();

		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		config.setUsername("gs25");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);

		System.out.println("ID를 입력하세요 >");

		Scanner sc = new Scanner(System.in);
		String id_input = sc.next();
		String sql = "SELECT * FROM employee WHERE employee_id" + " LIKE ?";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			pstmt.setString(1, id_input);
			ResultSet rs = pstmt.executeQuery();

			if (!rs.next()) {
				System.out.println("로그인 실패");

			} else {
				System.out.println("회원 ID : " + id_input);
				rs.getString("employee_id");
				System.out.println("로그인 성공");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static String getID(String inputStr) {
		String id = null;
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		config.setUsername("gs25");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		HikariDataSource ds = new HikariDataSource(config);

		String sql = "SELECT * FROM employee WHERE employee_id" + " LIKE ?";

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, inputStr);
			ResultSet rs = pstmt.executeQuery();

			if (!rs.next()) {
				System.out.println("로그인 실패");
			} else {
				id = rs.getString("employee_id");
				System.out.println("로그인 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}