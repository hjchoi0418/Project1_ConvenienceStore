package AnyPlace.model;

public class All_products {
	private String serial_no;
	private String product_no;
	private String build_date;
	private String expiration_date;
	private String supplier;
	private String delivery_date;
	private String product_state;
	
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getBuild_date() {
		return build_date;
	}
	public void setBuild_date(String build_date) {
		this.build_date = build_date;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getProduct_state() {
		return product_state;
	}
	public void setProduct_state(String product_state) {
		this.product_state = product_state;
	}

	@Override
	public String toString() {
		return "All_products [serial_no=" + serial_no + ", product_no=" + product_no + ", build_date=" + build_date
				+ ", expiration_date=" + expiration_date + ", supplier=" + supplier + ", delivery_date=" + delivery_date
				+ ", product_state=" + product_state + "]";
	}
	
}