import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	static String driverName;
	static String url;
	static String id ;
	static String password;

	
	static {
		try (BufferedReader in = new BufferedReader(new FileReader("./HR2.txt"))) {
			url = in.readLine();
			id = in.readLine();
			password = in.readLine();
			System.out.println("[INFO] Initialize static variables");
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
			e.printStackTrace();
			return null;
		}
	}
}