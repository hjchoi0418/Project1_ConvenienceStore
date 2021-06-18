package AnyPlace.model;

public class Order_Detail {
    private String order_detail_no;
    private String order_no;
    private String product_no;
    private String order_count;
    private String order_detail_price;

    public String getOrder_detail_no() {
        return order_detail_no;
    }
    public void setOrder_detail_no(String order_detail_no) {
        this.order_detail_no = order_detail_no;
    }
    public String getOrder_no() {
        return order_no;
    }
    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }
    public String getProduct_no() {
        return product_no;
    }
    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }
    public String getOrder_count() {
        return order_count;
    }
    public void setOrder_count(String order_count) {
        this.order_count = order_count;
    }
    public String getOrder_detail_price() {
        return order_detail_price;
    }
    public void setOrder_detail_price(String order_detail_price) {
        this.order_detail_price = order_detail_price;
    }
    @Override
    public String toString() {
        return "Order_Detail [order_detail_no=" + order_detail_no + ", order_no=" + order_no + ", product_no="
                + product_no + ", order_count=" + order_count + ", order_detail_price=" + order_detail_price + "]";
    }
}
