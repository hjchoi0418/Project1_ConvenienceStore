package AnyPlace;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JPool {
	
	// ���Ͽ� �ִ� ������ �о DB���� ������ �����غ�����.
	static String driverName;
	static String url;
	static String id;
	static String password;
	static String text;
	
	static {
		try (BufferedReader in = new BufferedReader(new FileReader("db.txt"))) {
			url = in.readLine();
			id = in.readLine();
			password = in.readLine();
			System.out.println("[Info] Initialize static variables");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			return null;
		}
	}
}