package AnyPlace.controller.BuyProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import AnyPlace.model.Product;

public class Lookup_method {
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##gs25";
			String pass = "1234";
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		}catch(Exception e) {
			return null;
		}
	}
	
	public static String[][] getproduct(){
		String sql = "SELECT "
				+ "product_no, "
				+ "category_name, "
				+ "product_name, "
				+ "product_price "
				+ "FROM "
				+ "product INNER JOIN category USING ( category_no )"
				+ "ORDER BY product_no";
		
		String state_sql = "SELECT "
				+ "product_no "
				+ "FROM "
				+ "All_products INNER JOIN product USING (product_no) "
				+ "WHERE product_state = 1";	
		
		String product_sql = "SELECT "
				+ "product_no "
				+ "FROM "
				+ "product ";
	
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement state_pstmt = conn.prepareStatement(state_sql);
				PreparedStatement product_pstmt = conn.prepareStatement(product_sql);
		        ){	
			
			ResultSet rs = pstmt.executeQuery();		
			List <Product> productList = new ArrayList <Product>();
			while (rs.next()) {
				Product products = new Product();
				products.setProduct_no(rs.getString(1));
				products.setCategory_no(rs.getString(2));
				products.setProduct_name(rs.getString(3));
				products.setProduct_price(rs.getString(4));
				productList.add(products);		
			}
			ResultSet state_rs = state_pstmt.executeQuery();				
			List <String> stateList = new ArrayList <String>();			
			while (state_rs.next()) {
				stateList.add(state_rs.getString(1));	
			}
			ResultSet product_rs = product_pstmt.executeQuery();
			List <String> productcount = new ArrayList <String>();			
			while (product_rs.next()) {
				productcount.add(product_rs.getString(1));
			}
			
			List <Statement> statementList = new ArrayList <Statement>();
			for(int i = 0; i < productcount.size(); ++i) {
				Statement statement = new Statement();
				statement.setProduct_no(productcount.get(i));
				statement.setStatement(Integer.toString(Collections.frequency(stateList, productcount.get(i))));
				statementList.add(statement);
			}
			
			ArrayList<String[]> product = new ArrayList<String[]>();
			for(int i = 0; i < productList.size(); ++i) {
				product.add(new String[] {
						productList.get(i).getProduct_no(),
						productList.get(i).getCategory_no(),
						productList.get(i).getProduct_name(),
						productList.get(i).getProduct_price(),
						statementList.get(i).getStatement()
				});				
			}
			String[][] arr = new String[product.size()][5];
			return product.toArray(arr);	
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	public static String[][] getcategory_name(){
		
		String sql = "SELECT "
				+ "category_name "
				+ "FROM "
				+ "category";
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){	
			ResultSet rs = pstmt.executeQuery();		
			List <String> category_name = new ArrayList <String>();
			while (rs.next()) {
				category_name.add(rs.getString(1));	
			}
			ArrayList<String[]> category_list = new ArrayList<String[]>();
			for(int i = 0; i < category_name.size(); ++i) {
				category_list.add(new String[] {
						category_name.get(i)
				});
			}
			String[][] arr = new String[category_list.size()][1];
			return category_list.toArray(arr);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
				
	}

	public static ArrayList<String> getcategory(String name){
		String sql = "SELECT "
				+ "product_no, "
				+ "category_name, "
				+ "product_name, "
				+ "product_price "
				+ "FROM "
				+ "product INNER JOIN category USING ( category_no )"
				+ "WHERE category_name = '" + name + "' "
		        + "ORDER BY product_no";
		
		String category_sql = "SELECT "
				+ "category_no "
				+ "FROM "
				+ "category WHERE category_name = '" + name + "'";
		
	
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement category_pstmt = conn.prepareStatement(category_sql);
		        ){	
			ResultSet rs = pstmt.executeQuery();		
			List <Product> productList = new ArrayList <Product>();
			while (rs.next()) {
				Product products = new Product();
				products.setProduct_no(rs.getString(1));
				products.setCategory_no(rs.getString(2));
				products.setProduct_name(rs.getString(3));
				products.setProduct_price(rs.getString(4));
				productList.add(products);		
			}
			
			ResultSet category_rs = category_pstmt.executeQuery();
			String[] category_num = new String[1];
			while (category_rs.next()) {
				category_num[0] = category_rs.getString(1);
			}
			
			String state_sql = "SELECT "
					+ "product_no "
					+ "FROM "
					+ "All_products INNER JOIN product USING (product_no) "
					+ "WHERE category_no = " + category_num[0] + " AND product_state = 1";	
			PreparedStatement state_pstmt = conn.prepareStatement(state_sql);

			ResultSet state_rs = state_pstmt.executeQuery();				
			List <String> stateList = new ArrayList <String>();			
			while (state_rs.next()) {
				stateList.add(state_rs.getString(1));	
			}
			
			String product_sql = "SELECT "
					+ "product_no "
					+ "FROM "
					+ "product "
					+ "WHERE category_no = " + category_num[0];	
			
			PreparedStatement product_pstmt = conn.prepareStatement(product_sql);
			
			ResultSet product_rs = product_pstmt.executeQuery();
			List <String> productcount = new ArrayList <String>();			
			while (product_rs.next()) {
				productcount.add(product_rs.getString(1));
			}
			
			List <Statement> statementList = new ArrayList <Statement>();
			for(int i = 0; i < productcount.size(); ++i) {
				Statement statement = new Statement();
				statement.setProduct_no(productcount.get(i));
				statement.setStatement(Integer.toString(Collections.frequency(stateList, productcount.get(i))));
				statementList.add(statement);
			}
			
			ArrayList<String> product = new ArrayList<String>();
			for(int i = 0; i < productList.size(); ++i) {
				product.add(productList.get(i).getProduct_no());
				product.add(productList.get(i).getCategory_no());
				product.add(productList.get(i).getProduct_name());
				product.add(productList.get(i).getProduct_price());
				product.add(statementList.get(i).getStatement());		
			}
			return product;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	public static ArrayList<String> getproduct_list(){
		String sql = "SELECT "
				+ "product_no, "
				+ "category_name, "
				+ "product_name, "
				+ "product_price "
				+ "FROM "
				+ "product INNER JOIN category USING ( category_no )"
				+ "ORDER BY product_no";
		
		String state_sql = "SELECT "
				+ "product_no "
				+ "FROM "
				+ "All_products INNER JOIN product USING (product_no) "
				+ "WHERE product_state = 1";	
		
		String product_sql = "SELECT "
				+ "product_no "
				+ "FROM "
				+ "product ";
	
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement state_pstmt = conn.prepareStatement(state_sql);
				PreparedStatement product_pstmt = conn.prepareStatement(product_sql);
		        ){	
			
			ResultSet rs = pstmt.executeQuery();		
			List <Product> productList = new ArrayList <Product>();
			while (rs.next()) {
				Product products = new Product();
				products.setProduct_no(rs.getString(1));
				products.setCategory_no(rs.getString(2));
				products.setProduct_name(rs.getString(3));
				products.setProduct_price(rs.getString(4));
				productList.add(products);		
			}
			ResultSet state_rs = state_pstmt.executeQuery();				
			List <String> stateList = new ArrayList <String>();			
			while (state_rs.next()) {
				stateList.add(state_rs.getString(1));	
			}
			ResultSet product_rs = product_pstmt.executeQuery();
			List <String> productcount = new ArrayList <String>();			
			while (product_rs.next()) {
				productcount.add(product_rs.getString(1));
			}
			
			List <Statement> statementList = new ArrayList <Statement>();
			for(int i = 0; i < productcount.size(); ++i) {
				Statement statement = new Statement();
				statement.setProduct_no(productcount.get(i));
				statement.setStatement(Integer.toString(Collections.frequency(stateList, productcount.get(i))));
				statementList.add(statement);
			}
			
			ArrayList<String> product = new ArrayList<String>();
			for(int i = 0; i < productList.size(); ++i) {
				product.add(productList.get(i).getProduct_no());
				product.add(productList.get(i).getCategory_no());
				product.add(productList.get(i).getProduct_name());
				product.add(productList.get(i).getProduct_price());
				product.add(statementList.get(i).getStatement());		
			}
			return product;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
}
class Statement{
	
	private String product_no;
	private String statement;
	
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getStatement() {
		return statement;
	};
	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	@Override
	public String toString() {
		return "statement [product_no=" + product_no + "statement=" + statement + "]";
	}
}