package AnyPlace.controller.lookup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import AnyPlace.controller.DBConnector;
import AnyPlace.model.All_products;
import AnyPlace.model.Product;

public class Lookup_method {
	
	public void selectMethod() {
		
		String sql = "SELECT "
				+ "product_no, "
				+ "category_no, "
				+ "product_name, "
				+ "product_price, "
				+ "expiration_date "
				+ "FROM "
				+ "product INNER JOIN all_products USING ( product_no ) "
				+ "ORDER BY expiration_date";
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		    ){
			ResultSet rs = pstmt.executeQuery();				
			List <Product> productList = new ArrayList <Product>();
			List <All_products> expiration_list = new ArrayList <All_products>();
			while (rs.next()) {
				Product products = new Product();
				All_products all_products = new All_products();
				products.setProduct_no(rs.getString(1));
				products.setCategory_no(rs.getString(2));
				products.setProduct_name(rs.getString(3));
				products.setProduct_price(rs.getString(4));
				all_products.setExpiration_date(rs.getString(5));

				productList.add(products);		
				expiration_list.add(all_products);
			}
			int count = 0;
			for(int i = 0; i < productList.size(); ++i) {
				++count;
				System.out.print(count + "\t" + productList.get(i).getProduct_no() + "\t\t" );
				System.out.print(productList.get(i).getCategory_no() + "\t");
				System.out.print(productList.get(i).getProduct_name()+ "\t\t");
				System.out.print(productList.get(i).getProduct_price()+ "\t\t");
				System.out.print(expiration_list.get(i).getExpiration_date() + "\n");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void select_stock() {

		String sql = "SELECT product_name FROM product";
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		    ){
			ResultSet rs = pstmt.executeQuery();				
			List <String> productList = new ArrayList <String>();			
			while (rs.next()) {
				productList.add(rs.getString(1));		
			}
			Set<String> set = new HashSet<String>(productList);
			int count = 0;
			for (String str : set) {
				++count;
				System.out.println(count + "." + str + "\t\t 재고수량: " + Collections.frequency(productList, str));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	public void search(String name) {
		String sql = "SELECT product_name FROM product where product_name LIKE '%" + name +"%'";
		
		try (Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		    ){
			ResultSet rs = pstmt.executeQuery();				
			List <String> productList = new ArrayList <String>();			
			while (rs.next()) {
				productList.add(rs.getString(1));		
			}
			Set<String> set = new HashSet<String>(productList);
			int count = 0;
			for (String str : set) {
				++count;
				System.out.println(count + "." + str + "\t\t 재고수량: " + Collections.frequency(productList, str));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}



