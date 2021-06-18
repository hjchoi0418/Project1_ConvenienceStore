package AnyPlace.model;

public class Product{

    private String product_no;
    private String category_no;
    private String product_name;
    private String product_price;
    private String product_image_path;
    
	private String serial_no;
	private String build_date;
	private String expiration_date;
	private String supplier;
	private String delivery_date;
	private String product_state;
	
	private String product_count;
	
	private String medium_category; // 중분류
	private String barcode;	// 상품코드
	
	
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
    
    public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
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
	public String getProduct_count() {
		return product_count;
	}
	public void setProduct_count(String product_count) {
		this.product_count = product_count;
	}
	
	public String getMedium_category() {
		return medium_category;
	}
	public void setMedium_category(String medium_category) {
		this.medium_category = medium_category;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	@Override
	public String toString() {
		return "Product [product_no=" + product_no + ", category_no=" + category_no + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", product_image_path=" + product_image_path + ", serial_no="
				+ serial_no + ", build_date=" + build_date + ", expiration_date=" + expiration_date + ", supplier="
				+ supplier + ", delivery_date=" + delivery_date + ", product_state=" + product_state + "]";
	}
	
}
