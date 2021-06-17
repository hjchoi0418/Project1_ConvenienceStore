package AnyPlace.controller.BuyProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import AnyPlace.DBConnector;
import AnyPlace.model.Product;

public class Lookup_method {
   
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
	
		try (Connection conn = DBConnector.getConnection();
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
			for(int i = 1; i < productcount.size() + 1; ++i) {
				Statement statement = new Statement();
				statement.setProduct_no(Integer.toString(i));
				statement.setStatement(Integer.toString(Collections.frequency(stateList, Integer.toString(i))));
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