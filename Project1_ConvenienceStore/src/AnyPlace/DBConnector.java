package AnyPlace;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	public static Connection getConnection() {

		String url;
		String id;
		String password;

		try {
			BufferedReader in = new BufferedReader(new FileReader("DB.txt"));

			url = in.readLine();
			id = in.readLine();
			password = in.readLine();


			// 2. DriverManager Ŭ������ ���� DB���� ������ �����Ѵ�.
			Connection conn = DriverManager.getConnection(url, id, password);

			return conn;

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}