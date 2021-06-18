package AnyPlace.model;

public class Order_ {
	private String order_no;
	private String order_name;
	private String payment_method;
	private String order_amount;
	
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(String order_amount) {
		this.order_amount = order_amount;
	}
	@Override
	public String toString() {
		return "Order_ [order_no=" + order_no + ", order_name=" + order_name + ", payment_method=" + payment_method
				+ ", order_amount=" + order_amount + "]";
	}

}