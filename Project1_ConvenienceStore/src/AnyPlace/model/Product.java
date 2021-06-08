package AnyPlace.model;

public class Product{

    private String product_no;
    private String category_no;
    private String product_name;
    private String product_price;
    private String product_image_path;
    
    public String getProduct_no() {
        return product_no;
    }
    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }
    public String getCategory_no() {
        return category_no;
    }
    public void setCategory_no(String category_no) {
        this.category_no = category_no;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getProduct_price() {
        return product_price;
    }
    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
    public String getProduct_image_path() {
        return product_image_path;
    }
    public void setProduct_image_path(String product_image_path) {
        this.product_image_path = product_image_path;
    }
    @Override
    public String toString() {
        return "product [product_no=" + product_no + ", category_no=" + category_no + ", product_name=" + product_name
                + ", product_price=" + product_price + ", product_image_path=" + product_image_path + "]";
    }
}