package AnyPlace.model;

public class Order_ {
	private String order_no;
	private String order_date;
	private String payment_method;
	private String order_amount;
	
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
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
		return "Order_ [order_no=" + order_no + ", order_name=" + order_date + ", payment_method=" + payment_method
				+ ", order_amount=" + order_amount + "]";
	}

}
