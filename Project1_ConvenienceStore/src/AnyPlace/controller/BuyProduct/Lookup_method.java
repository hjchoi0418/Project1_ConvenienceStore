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
            + "product_name "
            + "FROM "
            + "All_products INNER JOIN product USING (product_no) "
            + "WHERE product_state = 1";   
   
      try (Connection conn = DBConnector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement state_pstmt = conn.prepareStatement(state_sql);
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
         Set<String> set = new HashSet<String>(stateList);
         HashMap<String,Integer> inventory_check = new HashMap<>();      
         for (String str : set) {
            Collections.frequency(stateList, str);
            inventory_check.put(str,Collections.frequency(stateList, str));            
         }         
         List <Statement> statementList = new ArrayList <Statement>();
         for( Entry<String, Integer> element : inventory_check.entrySet() ){
            Statement statement = new Statement();
            statement.setProduct_name(element.getKey());
            statement.setStatement(String.valueOf(element.getValue()));
            statementList.add(statement);
         }
         
         ArrayList<String[]> product = new ArrayList<String[]>();
         int count = 0;
         for(int i = 0; i < productList.size(); ++i) {
            if(inventory_check.containsKey(productList.get(i).getProduct_name())) {
               product.add(new String[] {
                     productList.get(i).getProduct_no(),
                     productList.get(i).getCategory_no(),
                     productList.get(i).getProduct_name(),
                     productList.get(i).getProduct_price(),
                     statementList.get(count).getStatement()
               });            
               ++count;   
            }
            else {
               product.add(new String[] {
                     productList.get(i).getProduct_no(),
                     productList.get(i).getCategory_no(),
                     productList.get(i).getProduct_name(),
                     productList.get(i).getProduct_price(),
                     "0"
               });
            }
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
   
   private String product_name;
   private String statement;
   
   public String getProduct_name() {
      return product_name;
   }
   public void setProduct_name(String product_name) {
      this.product_name = product_name;
   }
   public String getStatement() {
      return statement;
   };
   public void setStatement(String statement) {
      this.statement = statement;
   }
   
   @Override
   public String toString() {
      return "statement [product_name=" + product_name + "statement=" + statement + "]";
   }
}